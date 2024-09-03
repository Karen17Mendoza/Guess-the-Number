import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    void setUp() {
        computerPlayer = new ComputerPlayer("Computadora");
    }

    @Test
    void testMakeGuess() {
        int guess = computerPlayer.makeGuess();

        // Verificar que la suposición esté dentro del rango 1-100
        assertTrue(guess >= 1 && guess <= 100, "La suposición debe estar entre 1 y 100.");

        // Verificar que la suposición se haya guardado en el historial
        assertEquals(1, computerPlayer.getGuesses().size(), "El historial debe contener exactamente una suposición.");
        assertEquals(guess, computerPlayer.getGuesses().get(0), "La suposición debe coincidir con la guardada en el historial.");
    }

    @Test
    void testMakeMultipleGuesses() {
        computerPlayer.makeGuess();
        computerPlayer.makeGuess();
        computerPlayer.makeGuess();

        // Verificar que el historial tiene el número correcto de suposiciones
        assertEquals(3, computerPlayer.getGuesses().size(), "El historial debe contener tres suposiciones.");

        // Verificar que cada suposición esté dentro del rango 1-100
        for (int guess : computerPlayer.getGuesses()) {
            assertTrue(guess >= 1 && guess <= 100, "Cada suposición debe estar entre 1 y 100.");
        }
    }
}