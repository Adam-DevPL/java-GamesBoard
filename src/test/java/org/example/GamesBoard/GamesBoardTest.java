package org.example.GamesBoard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamesBoardTest {

    private GamesBoard board;

    @BeforeEach
    public void setUp() {
        board = new GamesBoard();
    }

    @Test
    public void testStartGame() {
        //given
        board.startGame("Chess");

        //then
        Assertions.assertTrue(board.getStartedGames().containsKey("Chess"));
    }

    @Test
    public void testStartGame_AlreadyStarted() {
        //given
        board.startGame("Chess");

        //then
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> board.startGame("Chess"), "Game Chess not started");
    }

    @Test
    public void testFinishGame() {
        //given
        board.startGame("Chess");
        board.finishGame("Chess");

        //then
        Assertions.assertTrue(board.getFinishedGames().containsKey("Chess"));
    }

    @Test
    public void testFinishGame_NotStarted() {


        //then
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> board.finishGame("Football"), "Game Football not started");
    }

    @Test
    public void testUpdateGameScore() {
        //given
        board.startGame("Chess");

        //when
        board.updateGameScore("Chess", 10);

        //then
        Assertions.assertEquals(10, board.getStartedGames().get("Chess").getScore());
    }

    @Test
    public void testUpdateGameScore_GameNotStarted() {
        //then
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> board.updateGameScore("Football", 10), "Game Football not started");
    }

    @Test
    public void testUpdateGameScore_GameFinished() {
        //given
        board.startGame("Football");
        board.finishGame("Football");

        //then
        Assertions.assertThrows(IllegalStateException.class, () -> board.updateGameScore("Football", 10));
    }

}