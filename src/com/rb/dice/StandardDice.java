package com.rb.dice;

/**
 * A standard dice.
 */
public class StandardDice implements Dice {

    private static final int MIN = 1;
    private static final int MAX = 6;

    private static StandardDice standardDice;

    private StandardDice() {}

    /**
     * Creates and returns instance of Standard dice.
     * It'll create only one instance of StandardDice.
     * If it already exists, it'll return the same. (Singleton Design Pattern)
     * @return StandardDice instance
     */
    public static StandardDice getInstance() {
        if(standardDice == null) {
            synchronized (StandardDice.class) {
                if(standardDice == null)
                    standardDice = new StandardDice();
            }
        }
        return standardDice;
    }

    /**
     * Generates a random number in [MIN, MAX].
     * @return random number in [MIN, MAX]
     */
    @Override
    public int roll() {
        return generateRandomNum();
    }

    private int generateRandomNum() {
        return (int)(Math.random()*(MAX-MIN+1) + MIN);
    }
}
