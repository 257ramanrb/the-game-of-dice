package com.rb.game;

import com.rb.dice.Dice;
import com.rb.dice.DiceFactory;
import com.rb.dice.DiceType;
import com.rb.exception.InvalidDiceTypeException;
import com.rb.exception.InvalidScoreBoardTypeException;
import com.rb.player.Player;
import com.rb.scoreboard.ScoreBoard;
import com.rb.scoreboard.ScoreBoardFactory;
import com.rb.scoreboard.ScoreBoardType;
import com.rb.util.Constants;
import com.rb.util.ExceptionMessages;

import java.util.*;

/**
 * A dice game.
 */
public class DiceGame implements Game {

    private static int round = 1;
    private static final List<String> RULES = Arrays.asList(Constants.RULE_PLAYERS_ORDER, Constants.RULE_ROLL_6, Constants.RULE_ROLL_1);
    private static final int GOOD_NUM = 6;
    private static final int BAD_NUM = 1;
    private static final char ROLL_COMMAND = 'r';
    private static final Scanner scan = new Scanner(System.in);

    private final int numOfPlayers;
    private final int target;

    private List<Player> players;
    private Dice dice;
    private ScoreBoard leaderBoard;
    private ScoreBoard winnerBoard;

    public DiceGame(int numOfPlayers, int target) {
        this.numOfPlayers = numOfPlayers;
        this.target = target;
    }

    /**
     * {@inheritDoc}
     * <ol>
     *     <li>Create list of players</li>
     *     <li>Shuffle the list of players</li>
     *     <li>Display order of turn of players</li>
     *     <li>Initialize dice</li>
     *     <li>Initialize LeaderBoard</li>
     *     <li>Initialize WinnerBoard</li>
     * </ol>
     * @throws InvalidDiceTypeException when dice type is invalid
     * @throws InvalidScoreBoardTypeException when scoreboard type is invalid
     */
    public void init() throws InvalidDiceTypeException, InvalidScoreBoardTypeException {
        players = new ArrayList<>();
        for(int i = 0; i < numOfPlayers; i++) {
            players.add(new Player());
        }

        Collections.shuffle(players);
        this.displayOrderOfPlayers();
        dice = DiceFactory.getDice(DiceType.STANDARD).orElseThrow(() -> new InvalidDiceTypeException(ExceptionMessages.INVALID_DICE_TYPE));
        leaderBoard = ScoreBoardFactory.getScoreBoard(ScoreBoardType.LEADER, players)
                .orElseThrow(() -> new InvalidScoreBoardTypeException(ExceptionMessages.INVALID_SCORE_BOARD_TYPE));
        winnerBoard = ScoreBoardFactory.getScoreBoard(ScoreBoardType.WINNER, players)
                .orElseThrow(() -> new InvalidScoreBoardTypeException(ExceptionMessages.INVALID_SCORE_BOARD_TYPE));
    }

    /**
     * {@inheritDoc}
     * <ol>
     *     <li>Loop: Play till all players haven't completed the game</li>
     *     <li>If player had got two consecutive 1's, skip his/her turn</li>
     *     <li>Roll the dice</li>
     *     <li>Add points to player's score</li>
     *     <li>Print leader board</li>
     *     <li>If player score greater than or equal to target, add him/her to winner board, remove from leader board and print winner board</li>
     *     <li>If roll shows 6, player gets another turn</li>
     * </ol>
     */
    public void play() {
        while (!players.isEmpty()) {
            System.out.println();
            System.out.println("******** Round " + round++ + " ********" );
            ListIterator<Player> itr = players.listIterator();
            while(itr.hasNext()) {
                Player p = itr.next();

                if(p.getCountOfConsecutive1Rolls() == 2) {
                    p.setCountOfConsecutive1Rolls(0);
                    System.out.println(p.getName() + Constants.SKIP_TURN_CONSECUTIVE_1s_MSG);
                    continue;
                }

                System.out.println(p.getName() + Constants.ROLL_DICE_MSG);

                char ch = scan.next().charAt(0);
                this.validateRollCommand(ch);

                int roll = dice.roll();
                if(roll == BAD_NUM)
                    p.setCountOfConsecutive1Rolls(p.getCountOfConsecutive1Rolls()+1);
                else
                    p.setCountOfConsecutive1Rolls(0);

                System.out.println(Constants.ROLLING_DICE_MSG);
                System.out.println(Constants.NUM_ON_DICE_MSG + roll);
                p.addPoints(roll);

                leaderBoard.printBoard();
                if (p.getScore() >= target) {
                    System.out.println(p.getName() + Constants.GAME_WON_MSG);
                    winnerBoard.updateBoard(p);
                    leaderBoard.updateBoard(p);
                    winnerBoard.printBoard();
                    itr.remove();
                    continue;
                }
                if(roll == GOOD_NUM) {
                    itr.previous();
                    System.out.println(Constants.REWARD_6_MSG);
                    System.out.println();
                }
            }
        }

        System.out.println();
        System.out.println("********* Game completed *********");
        winnerBoard.printBoard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayWelcomeMsg() {
        System.out.println(Constants.GAME_OF_DICE_WELCOME_MSG);
        System.out.println();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayRules() {
        System.out.println(Constants.NUM_OF_PLAYERS_MSG + numOfPlayers);
        System.out.println(Constants.TARGET_MSG + target);
        System.out.println(Constants.RULES_MSG);
        for(int i = 1; i <= RULES.size(); i++)
            System.out.println(i + ". " + RULES.get(i-1));
        System.out.println();
    }

    private void displayOrderOfPlayers() {
        System.out.println(Constants.PLAYERS_ORDER_MSG);
        for (Player p : players)
            System.out.println(p);
        System.out.println();
    }

    private void validateRollCommand(char ch) {
        while (ch != ROLL_COMMAND) {
            System.out.println(Constants.INVALID_ROLL_COMMAND_R_MSG);
            ch = scan.next().charAt(0);
        }
    }
}
