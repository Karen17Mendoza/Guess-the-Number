import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    private HumanPlayer humanPlayer;

    @BeforeEach
    void setUp() {
        // Usamos "Humano" como nombre para la instancia de HumanPlayer
        humanPlayer = new HumanPlayer("Humano");
    }

    @Test
    void testMakeGuess() {
        // Simulamos la entrada del usuario, por ejemplo, si el usuario ingresa "50"
        String simulatedInput = "50\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int guess = humanPlayer.makeGuess();

        // Verificamos que la suposición sea la que simulamos (en este caso, 50)
        assertEquals(50, guess, "La suposición debería ser 50.");

        // Verificamos que la suposición se haya guardado en el historial
        assertEquals(1, humanPlayer.getGuesses().size(), "El historial debería contener exactamente una suposición.");
        assertEquals(guess, humanPlayer.getGuesses().get(0), "La suposición debería coincidir con la guardada en el historial.");
    }
}