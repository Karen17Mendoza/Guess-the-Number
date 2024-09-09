import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ComputerPlayerTest {

    private Random randomMock;
    private ComputerPlayer computerPlayer;

    @BeforeEach
    void setUp() {
        // Crear un mock de Random
        randomMock = mock(Random.class);
        // Crear una instancia de ComputerPlayer con el Random mock
        computerPlayer = new ComputerPlayer("Computadora", randomMock);
    }

    @Test
    void testMakeGuess() {
        // Configurar el mock para devolver un valor específico
        when(randomMock.nextInt(100)).thenReturn(42); // nextInt(100) devuelve 42, lo que resulta en 43 como suposición

        // Llamar al método makeGuess
        int guess = computerPlayer.makeGuess();

        // Verificar que el valor retornado es el esperado
        assertEquals(43, guess, "La suposición debería ser 43");

        // Verificar que el método nextInt del Random mock fue llamado correctamente
        verify(randomMock).nextInt(100);
    }
}