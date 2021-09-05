package com.rb.dice;

import java.util.Optional;

/**
 * A factory class to create dice.
 */
public class DiceFactory {

    /**
     * Creates an instance of Dice.
     * @param diceType type of dice to be created
     * @return Optional object of Dice
     */
    public static Optional<Dice> getDice(DiceType diceType) {
        switch (diceType) {
            case STANDARD:
                return Optional.of(StandardDice.getInstance());
            default:
                return Optional.empty();
        }
    }
}
