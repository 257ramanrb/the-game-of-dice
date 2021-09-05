package com.rb.util;

public class Constants {
    private Constants() {}

    public static final String SKIP_TURN_CONSECUTIVE_1s_MSG = ", skipping your turn as you had rolled two 1's consecutively.";
    public static final String ROLL_DICE_MSG = " its your turn (press 'r' to roll the dice)";
    public static final String GAME_WON_MSG = ", you've won the game. (Your turn will be skipped in subsequent rounds)";
    public static final String REWARD_6_MSG = "Congrats !! You've got a 6 & as a reward, you get another chance to roll the dice.";

    public static final String GAME_OF_DICE_WELCOME_MSG = "********** Welcome to 'The Game of Dice' **********";
    public static final String NUM_OF_PLAYERS_MSG = "Number of players: ";
    public static final String TARGET_MSG = "Target score: ";
    public static final String RULES_MSG = "Rules of the game: ";
    public static final String PLAYERS_ORDER_MSG = "Order in which the players will roll the dice: ";
    public static final String ROLLING_DICE_MSG = "Rolling the dice......";
    public static final String NUM_ON_DICE_MSG = "Number on dice: ";
    public static final String INVALID_ROLL_COMMAND_R_MSG = "Invalid roll command. Press 'r' to roll the dice.";

    public static final String RULE_PLAYERS_ORDER = "The order in which the users roll the dice is decided randomly at the start of the game.";
    public static final String RULE_ROLL_6 = "If a player rolls the value '6' then they immediately get another chance to roll again and move ahead in the game.";
    public static final String RULE_ROLL_1 = "If a player rolls the value '1' two consecutive times then they are forced to skip their next turn as a penalty.";
}
