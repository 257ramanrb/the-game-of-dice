package com.rb.scoreboard;

import com.rb.player.Player;
import com.rb.util.PlayerComparatorAsc;

import java.util.*;

/**
 * A Leader Board.
 */
public class LeaderBoard implements ScoreBoard {

    private List<Player> players;

    public LeaderBoard(List<Player> players) {
        this.players = new ArrayList<>();
        for (Player p : players)
            this.players.add(p);
    }

    /**
     * {@inheritDoc}
     * It removes the player from the leader board when he/she has completed the game.
     * @param p player to remove
     */
    @Override
    public void updateBoard(Player p) {
        players.remove(p);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printBoard() {
        Collections.sort(players, new PlayerComparatorAsc());

        int rank = 1;
        System.out.println();
        System.out.println("Leader's Board: ");
        for(Player p : players) {
            p.setRank(rank++);
            System.out.println(p);
        }
        System.out.println();
    }
}
