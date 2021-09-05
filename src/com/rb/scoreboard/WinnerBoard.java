package com.rb.scoreboard;

import com.rb.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * A Winner Board.
 */
public class WinnerBoard implements ScoreBoard {

    private List<Player> players;
    private static int rank = 1;

    public WinnerBoard() {
        this.players = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     * It adds the player to the winner board when he/she has completed the game.
     * @param p player to add
     */
    @Override
    public void updateBoard(Player p) {
        p.setRank(rank++);
        players.add(p);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printBoard() {
        System.out.println();
        System.out.println("Winner's Board:");
        for(Player p : players) {
            System.out.println(p);
        }
        System.out.println();
    }
}
