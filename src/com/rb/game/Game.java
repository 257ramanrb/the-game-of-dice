package com.rb.game;

/**
 * A game.
 */
public interface Game {
    /**
     * Displays welcome message of game.
     */
    void displayWelcomeMsg();

    /**
     * Displays rules of game.
     */
    void displayRules();

    /**
     * Initializes the Dice Game.
     * @throws Exception
     */
    void init() throws Exception;

    /**
     * Plays the game.
     */
    void play();
}
