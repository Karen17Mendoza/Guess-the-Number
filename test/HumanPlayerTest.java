import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HumanPlayerTest {

    private HumanPlayer humanPlayer;
    private Scanner scannerMock;

    @BeforeEach
    void setUp() {
        // Crear un mock del Scanner
        scannerMock = mock(Scanner.class);

        // Crear una instancia de HumanPlayer con el Scanner mock
        humanPlayer = new HumanPlayer("Jugador Humano", scannerMock);
    }

    @Test
    void testMakeGuess() {
        // Simular la entrada del usuario
        when(scannerMock.nextInt()).thenReturn(42);

        // Llamar al método MakeGuess
        int guess = humanPlayer.makeGuess();

        // Verificar que el valor retornado es el esperado
        assertEquals(42, guess);

        // Verificar que el método addGuess fue llamado con el valor correcto
        ArrayList<Integer> guesses = (ArrayList<Integer>) humanPlayer.getGuesses();
        assertEquals(1, guesses.size());
        assertEquals(42, guesses.get(0));

        // Verificar que se llamó al método nextInt() del Scanner mock
        verify(scannerMock, times(1)).nextInt();
    }

}
