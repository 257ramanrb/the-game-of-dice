package com.rb.util;

import com.rb.exception.InvalidArgumentException;

/**
 * A validator class.
 */
public class Validator {
    private Validator() {}

    /**
     * Validates command line arguments.
     * @param args command line arguments
     * @throws InvalidArgumentException when args are not provided or is/are less than 1
     */
    public static void validateCommandLineArgs(String[] args) throws InvalidArgumentException {
        if(!isValidArgsLength(args))
            throw new InvalidArgumentException("NumberOfPlayers(N) & Target(M) is required.");

        if(!isValidNumOfPlayers(args[0]))
            throw new InvalidArgumentException("NumberOfPlayers(N) must be atleast 1.");

        if(!isValidTarget(args[1]))
            throw new InvalidArgumentException("Target(M) must be atleast 1.");

    }

    private static boolean isValidArgsLength(String[] args) {
        return args.length >= 2;
    }

    private static boolean isValidNumOfPlayers(String n) {
        return Integer.valueOf(n) >= 1;
    }

    private static boolean isValidTarget(String m) {
        return Integer.valueOf(m) >= 1;
    }
}
