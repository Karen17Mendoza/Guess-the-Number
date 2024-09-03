import java.util.Scanner;

class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int makeGuess() {
        System.out.print(name + ", ingresa tu suposición: ");
        int guess = scanner.nextInt(); // Leer el número ingresado por el usuario
        addGuess(guess); // Guardar suposición en la lista
        return guess;
    }
}