package com.rb.scoreboard;

import com.rb.player.Player;

/**
 * A score board.
 */
public interface ScoreBoard {
    /**
     * Updates the board.
     * @param p player
     */
    void updateBoard(Player p);

    /**
     * Prints the current state of board.
     */
    void printBoard();
}
