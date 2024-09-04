import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    // Constructor que acepta un Random para pruebas
    public ComputerPlayer(String name, Random random) {
        super(name);
        this.random = random;
    }

    // Constructor para uso normal
    public ComputerPlayer(String name) {
        this(name, new Random()); // Usa un Random real por defecto
    }

    @Override
    public int makeGuess() {
        int guess = random.nextInt(100) + 1;
        System.out.println(name + " adivina: " + guess);
        addGuess(guess); // Guardar suposición en la lista
        return guess;
    }
}
