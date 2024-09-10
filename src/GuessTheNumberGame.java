import java.util.Random;
import java.util.Scanner;

//Clase principal que gestionara el flujo del juego
public class GuessTheNumberGame {
    //Nombramos los atributos de la clase
    private int targetNumer;
    private Player humanPlayer;
    private Player computerPlayer;

    //Agregamos el constructor de la clase GuessTheNumer
    public GuessTheNumberGame() {
        //Mensaje de bienvenida
        showWelcomeMessage();
        //Creamos un objeto scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        //Pedimos el nombre del jugador humano
        System.out.println("Porfavor, ingrresa tu nombre: ");
        String playerName = scanner.nextLine();
        //Inicializamos el numero objetivo
        Random random = new Random();
        //Que sea un numero del 1 al 100
        this.targetNumer = random.nextInt(100) + 1;;
        //Creamos a los jugadores
        this.humanPlayer = new HumanPlayer(playerName, scanner);
        this.computerPlayer = new ComputerPlayer("Computadora");
    }
    //Creamos el metodo del juego
    public void  play(){
        //Inicializamos la suposicion para saber si alguien adivino el numero
        boolean guessed = false;

        //Creamos el bucle del juego
        while (!guessed){
            //Turno del jugador humano
            int humanGuess = humanPlayer.makeGuess();// hace la suposicion
            guessed = checkGuess(humanGuess,humanPlayer);//Verifica si la suposicion es correcta

            //Condicion si adivina la suposicion termina el juego
            if(guessed) break;

            //Turno de la computadora
            int computerGuess = computerPlayer.makeGuess();//Suposicion de la computadora
            guessed = checkGuess(computerGuess,computerPlayer);//Verifica si es correcta

        }
        //Mostramos el historial de suposicion de ambos jugadores
        displayGuesses(humanPlayer);
        displayGuesses(computerPlayer);

        //Mostramos el mensaje de despedida
        showEndMessage();
    }
    //Metodo para el mensaje de bienvenida
    public void showWelcomeMessage() {
        System.out.println("Bienvenido al juego de adivinar el número!");
        System.out.println("El objetivo del juego es adivinar un número entre el 1 y 100");
        System.out.println("Competiras contra la computadora para ver quien lo adivina primero");
        System.out.println("!BUENA SUERTE!\n");
    }
    //Metodo para verificar la suposicion es correcta
    private boolean checkGuess(int guess, Player player) {
        //Creamos la condicional
        if (guess == targetNumer) {
            System.out.println("¡" + player.getName() + " ha adivinado correctamente el número! \uD83D\uDE0A ");
            return true;
        } else if (guess < targetNumer) {
            System.out.println(player.getName() + ", el número es mayor. ↑");
        } else {
            System.out.println(player.getName() + ", el número es menor. ↓");
        }
        //Retornafalse si no adivino correctamente
        return false;
    }
    //Metodo para mostrar los intentos
    private void displayGuesses(Player player) {
        System.out.println(player.getName() + " hizo " + player.getGuesses().size() + " intentos. ");
        System.out.println("Intentos: " + player.getGuesses());
    }
    //Metodo que muestra el mensaje de despedida
    private void showEndMessage() {
        System.out.println("!Gracias por jugar!");
    }
    //Metodo principal que inicia el juego
    public static void main(String[] args) {
        //Creamos el juego
        GuessTheNumberGame game =new GuessTheNumberGame();
        //Comenzar a jugar
        game.play();
    }
}