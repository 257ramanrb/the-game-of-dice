package com.rb.player;

/**
 * A player.
 */
public class Player implements Comparable<Player> {

    private static int numOfPlayersCreated = 0;
    private static final String NAME_PREFIX = "Player-";

    private String name;
    private int score;
    private int rank;
    private int countOfConsecutive1Rolls;

    public Player() {
        this.name = NAME_PREFIX + (++numOfPlayersCreated);
        this.score = 0;
        this.rank = -1;
        this.countOfConsecutive1Rolls = 0;
    }

    /**
     * Gets name of the player.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets score of player.
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Gets rank of player.
     * @return rank
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Gets count of consecutive 1 rolls by player.
     * @return countOfConsecutive1Rolls
     */
    public int getCountOfConsecutive1Rolls() {
        return this.countOfConsecutive1Rolls;
    }

    /**
     * Sets count of consecutive 1 rolls by player.
     * @param count countOfConsecutive1Rolls
     */
    public void setCountOfConsecutive1Rolls(int count) {
        this.countOfConsecutive1Rolls = count;
    }

    /**
     * Adds point to current score of player.
     * @param points points gained
     */
    public void addPoints(int points) {
        this.score += points;
    }

    /**
     * Sets rank of player.
     * @param rank rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Player p2) {
        if(this.rank == p2.rank) {
            if (this.score == p2.score) {
                return this.name.compareTo(p2.name);
            } else {
                return p2.score - this.score;
            }
        } else {
            return this.rank - p2.rank;
        }
    }

    @Override
    public String toString() {
        return "Person[name=" + this.name + ", score=" + this.score + ", rank=" + (this.rank == -1 ? "NA" : this.rank) + "]";
    }
}
