package org.example.GamesBoard;

import java.util.HashMap;

public class GamesBoard {
    private final HashMap<String, GameParameters> startedGames = new HashMap<>();
    private final HashMap<String, GameParameters> finishedGames = new HashMap<>();

    public void startGame(String gameName) {
        if (startedGames.containsKey(gameName) || finishedGames.containsKey(gameName)) {
            throw new IllegalStateException("Game already started: " + gameName);
        } else {
            startedGames.put(gameName, new GameParameters(0));
        }
    }

    public String finishGame(String gameName) {
        if (startedGames.containsKey(gameName)) {
            finishedGames.put(gameName, new GameParameters(startedGames.get(gameName).getScore()));
            startedGames.remove(gameName);
            return finishedGames.entrySet().stream().filter(entry -> entry.getKey().equals(gameName)).findFirst().get().getKey();
        } else {
            throw new IllegalStateException("Game " + gameName + " not started");
        }
    }

    public void updateGameScore(String gameName, int score) {
        if (startedGames.containsKey(gameName)) {
            startedGames.put(gameName, new GameParameters(startedGames.get(gameName).getScore() + score));
        } else if (finishedGames.containsKey(gameName)) {
            throw new IllegalStateException("Game " + gameName + " already finished with score: " + finishedGames.get(gameName).getScore());
        } else {
            throw new IllegalStateException("Game " + gameName + " not started");
        }

    }

    public HashMap<String, GameParameters> getStartedGames() {
        return startedGames;
    }

    public HashMap<String, GameParameters> getFinishedGames() {
        return finishedGames;
    }
}
