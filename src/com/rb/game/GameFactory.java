package com.rb.game;

import java.util.Optional;

/**
 * A factory class to generate a game.
 */
public class GameFactory {

    /**
     * Creates an instance of game.
     * @param gameType type of game to be created
     * @param numOfPlayers number of players
     * @param target target to win the game
     * @return Optional object of Game
     */
    public static Optional<Game> getGame(GameType gameType, int numOfPlayers, int target) {
        switch (gameType) {
            case DICE:
                return Optional.of(new DiceGame(numOfPlayers, target));
            default:
                return Optional.empty();
        }
    }
}
