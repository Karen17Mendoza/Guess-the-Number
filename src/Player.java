import java.util.ArrayList;
import java.util.List;

abstract class Player {
    protected String name;
    protected List<Integer> guesses; // Lista para almacenar las suposiciones

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(int guess) {
        guesses.add(guess); // Agregar suposición a la lista
    }

    public abstract int makeGuess();
}
