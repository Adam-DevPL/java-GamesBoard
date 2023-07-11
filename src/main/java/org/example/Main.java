package org.example;

import org.example.GamesBoard.GamesBoard;

public class Main {
    public static void main(String[] args) {
        GamesBoard gamesBoard = new GamesBoard();

        gamesBoard.startGame("game1");
        gamesBoard.updateGameScore("game1", 10);
        gamesBoard.updateGameScore("game1", 20);
        gamesBoard.finishGame("game1");
        gamesBoard.updateGameScore("game1", 30);
    }
}