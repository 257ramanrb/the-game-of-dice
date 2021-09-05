package com.rb;

import com.rb.exception.InvalidGameTypeException;
import com.rb.game.Game;
import com.rb.game.GameFactory;
import com.rb.game.GameType;
import com.rb.util.ExceptionMessages;
import com.rb.util.Validator;

/**
 * A class to play board games.
 */
public class BoardGames {

    public static void main(String[] args) throws Exception {
        Validator.validateCommandLineArgs(args);
        Game game = GameFactory.getGame(GameType.DICE, Integer.valueOf(args[0]), Integer.valueOf(args[1]))
                    .orElseThrow(() -> new InvalidGameTypeException(ExceptionMessages.INVALID_GAME_TYPE));
        game.displayWelcomeMsg();
        game.displayRules();
        game.init();
        game.play();
    }
}
