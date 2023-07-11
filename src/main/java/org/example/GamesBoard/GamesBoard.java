package org.example.GamesBoard;

import java.util.HashMap;

public class GamesBoard {
    private final HashMap<String, GameParameters> gamesBoard = new HashMap<>();

    public void startGame(String gameName) {
        if (gamesBoard.containsKey(gameName)) {
            throw new IllegalStateException("Game already started: " + gameName);
        } else {
            gamesBoard.put(gameName, new GameParameters(0, true));
        }
    }

    public void finishGame(String gameName) {
        if (gamesBoard.containsKey(gameName)) {
            gamesBoard.put(gameName, new GameParameters(gamesBoard.get(gameName).getScore(), false));
            System.out.println("Game " + gameName + " finished with score " + gamesBoard.get(gameName).getScore());
        } else {
            throw new IllegalStateException("Game " + gameName + " not started");
        }
    }

    public void updateGameScore(String gameName, int score) {
        if (gamesBoard.containsKey(gameName)) {
            if (gamesBoard.get(gameName).getStatus()) {
                gamesBoard.put(gameName, new GameParameters(gamesBoard.get(gameName).getScore() + score, true));
            } else {
                throw new IllegalStateException("Game " + gameName + " already finished with score: " + gamesBoard.get(gameName).getScore());
            }
        } else {
            throw new IllegalStateException("Game " + gameName + " not started");
        }
    }

    public HashMap<String, GameParameters> getGamesBoard() {
        return gamesBoard;
    }
}
