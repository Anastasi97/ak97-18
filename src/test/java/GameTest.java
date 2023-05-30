import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player misha = new Player(1, "Миша", 123);
        Player maxsim = new Player(2, "Максим", 14556767);
        Game game = new Game();

        game.register(misha);
        game.register(maxsim);
        int actual = game.round("Максим", "Миша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player misha = new Player(1, "Миша", 234);
        Player maxsim = new Player(2, "Максим", 467);
        Game game = new Game();

        game.register(misha);
        game.register(maxsim);
        int actual = game.round("Миша", "Максим");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player misha = new Player(1, "Миша", 10);
        Player maxsim = new Player(2, "Максим", 10);
        Game game = new Game();

        game.register(misha);
        game.register(maxsim);
        int actual = game.round("Миша", "Максим");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player misha = new Player(1, "Миша", 10);
        Player maxsim = new Player(2, "Максим", 10);
        Game game = new Game();

        game.register(misha);
        game.register(maxsim);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Настя", "Максим")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player misha = new Player(1, "Миша", 10);
        Player maxsim = new Player(2, "Максим", 10);
        Game game = new Game();

        game.register(misha);
        game.register(maxsim);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Глеб")
        );
    }

    @Test
    public void testWhenBothPlayerNotExist() {
        Player misha = new Player(1, "Миша", 10);
        Player maxsim = new Player(2, "Максим", 10);
        Game game = new Game();

        game.register(misha);
        game.register(maxsim);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Настя", "Глеб")
        );
    }
}

