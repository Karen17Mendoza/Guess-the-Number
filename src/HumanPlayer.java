import java.util.Scanner;

class HumanPlayer extends Player {
    private final Scanner scanner;

    // Constructor que acepta un nombre y un objeto Scanner
    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public int makeGuess() {
        System.out.print(name + ", ingresa tu suposición: ");
        int guess = scanner.nextInt();
        addGuess(guess);
        return guess;
    }
}