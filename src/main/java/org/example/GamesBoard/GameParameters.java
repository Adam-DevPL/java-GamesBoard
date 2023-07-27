package org.example.GamesBoard;

public class GameParameters {
    private int score;

    private Boolean status;

    public GameParameters(int score, Boolean status) {
        this.score = score;
        this.status = status;
    }

    public int getScore() {
        return score;
    }
}
