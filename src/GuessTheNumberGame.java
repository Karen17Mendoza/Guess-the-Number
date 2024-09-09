import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    int targetNumber;
    Player humanPlayer;
    Player computerPlayer;

    public GuessTheNumberGame() {
        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre del jugador humano
        System.out.print("Por favor, ingresa tu nombre: ");
        String playerName = scanner.nextLine();

        // Inicializar el número objetivo
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;

        // Crear jugadores con el nombre proporcionado
        this.humanPlayer = new HumanPlayer(playerName, scanner);
        this.computerPlayer = new ComputerPlayer("Computadora");
    }

    public void play() {
        showWelcomeMessage(); // Mostrar mensaje de bienvenida

        boolean guessed = false;

        while (!guessed) {
            int humanGuess = humanPlayer.makeGuess();
            guessed = checkGuess(humanGuess, humanPlayer);

            if (guessed) break;

            int computerGuess = computerPlayer.makeGuess();
            guessed = checkGuess(computerGuess, computerPlayer);
        }

        // Mostrar el historial de suposiciones de cada jugador
        displayGuesses(humanPlayer);
        displayGuesses(computerPlayer);

        //Mostar mensaje de salida
        showEndMessage();
    }

    private void showWelcomeMessage() {
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("El objetivo del juego es adivinar un número entre 1 y 100.");
        System.out.println("Competirás contra la computadora para ver quién lo adivina primero.");
        System.out.println("¡Buena suerte!\n");
    }

    boolean checkGuess(int guess, Player player) {
        if (guess == targetNumber) {
            System.out.println("¡" + player.getName() + " ha adivinado correctamente el número! \uD83D\uDE00"); // 😊
            return true;
        } else if (guess < targetNumber) {
            System.out.println(player.getName() + ", el número es mayor. \u2191"); // ↑
        } else {
            System.out.println(player.getName() + ", el número es menor. \u2193"); // ↓
        }
        return false;
    }

    private void displayGuesses(Player player) {
        System.out.println(player.getName() + " hizo " + player.getGuesses().size() + " intentos.");
        System.out.println("Intentos: " + player.getGuesses());
    }

    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.play();
    }

    private void showEndMessage() {
        System.out.println("¡Gracias por jugar!");
    }
}