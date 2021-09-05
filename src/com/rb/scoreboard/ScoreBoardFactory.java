package com.rb.scoreboard;

import com.rb.player.Player;

import java.util.List;
import java.util.Optional;

/**
 * A factory class to generate a scoreboard.
 */
public class ScoreBoardFactory {

    /**
     * Creates an instance of scoreboard.
     * @param scoreBoardType type of score board to be created
     * @param players list of players
     * @return Optional object of score board
     */
    public static Optional<ScoreBoard> getScoreBoard(ScoreBoardType scoreBoardType, List<Player> players) {
        switch (scoreBoardType) {
            case LEADER:
                return Optional.of(new LeaderBoard(players));
            case WINNER:
                return Optional.of(new WinnerBoard());
            default:
                return Optional.empty();
        }
    }
}
