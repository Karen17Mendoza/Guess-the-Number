import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        int guess = new Random().nextInt(100) + 1;
        System.out.println(name + " adivina: " + guess);
        addGuess(guess); // Guardar suposición en la lista
        return guess;
    }
}