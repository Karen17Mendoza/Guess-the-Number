import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberGameTest {

    private GuessTheNumberGame game;
    private HumanPlayer humanPlayer;

    @BeforeEach
    void setUp() {
        game = new GuessTheNumberGame();
        humanPlayer = new HumanPlayer("Humano");
    }

    @Test
    void testHumanGuessGreaterThanTarget() {
        game.setTargetNumber(50); // Número objetivo
        humanPlayer.addGuess(60); // Suposición mayor al número objetivo
        boolean result = game.checkGuess(60, humanPlayer);
        assertFalse(result); // Asegura que no se adivinó el número
    }

    @Test
    void testHumanGuessLessThanTarget() {
        game.setTargetNumber(50); // Número objetivo
        humanPlayer.addGuess(40); // Suposición menor al número objetivo
        boolean result = game.checkGuess(40, humanPlayer);
        assertFalse(result); // Asegura que no se adivinó el número
    }

    @Test
    void testHumanGuessEqualsTarget() {
        int targetNumber = 50; // Número objetivo
        game.setTargetNumber(targetNumber);
        humanPlayer.addGuess(targetNumber); // Suposición igual al número objetivo
        boolean result = game.checkGuess(targetNumber, humanPlayer);
        assertTrue(result); // Asegura que se adivinó el número
    }

}
