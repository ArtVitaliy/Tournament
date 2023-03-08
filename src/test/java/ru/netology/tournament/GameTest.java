package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenTheFirstPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Василий", 100);
        Player player2 = new Player(2, "Степан", 50);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Василий", "Степан");
        int expected = 1;


        Assertions.assertEquals(actual, expected);


    }

    @Test
    public void testWhenTheSecondPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Василий", 50);
        Player player2 = new Player(2, "Степан", 100);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Василий", "Степан");
        int expected = 2;

        Assertions.assertEquals(actual, expected);


    }

    @Test
    public void testSmooth() {
        Game game = new Game();
        Player player1 = new Player(1, "Василий", 100);
        Player player2 = new Player(2, "Степан", 100);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Василий", "Степан");
        int expected = 0;


        Assertions.assertEquals(actual, expected);


    }

    @Test
    public void testNotRegisteredFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Василий", 100);
        Player player2 = new Player(2, "Степан", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Степан"));
    }

    @Test
    public void testNotRegisteredSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Василий", 100);
        Player player2 = new Player(2, "Степан", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Василий", "Петр"));
    }


}