import java.util.Scanner;
/*
 * This class simulates a Random Number Guessing Game with the following setup.
 * Classic Mode:
 *      The program generates a random number between 1 and 100.                                                                X
 *      The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.    X
 *      Keep track of the number of attempts and display it at the end.                                                         X
 */
public class ClassicGuessing {
    static private int guessAmount; // amount of attempts the user has to guess the correct answer.
    static private int answer;      // the correct number that the user needs to find.
    static private Scanner reader;  // console input reader.

    // userGuessing() will gather user guesses and check if they
    // match with the random number chosen by Math.random().
    // This method will also provide hints to the user such as higher or lower.
    private static void userGuessing() {
        
        // While the user has more guesses/attempts, allow them to guess.
        int attempts = 0;
        while(guessAmount > 0) {

            System.out.print("> ");
        
            // Gather user's guess.
            String response = reader.nextLine();
            int value;
            try {
                value = Integer.parseInt(response);
            } catch(NumberFormatException ex) {
                System.out.println("Invalid response. Please enter a number.");
                continue;
            }
            attempts++;
            
            // If user was correct, let them know and close program.
            if(value == answer) {
                System.out.println("Guessed correct value! Good job! Attempts: " + attempts);
                System.exit(0);
            }
            // If user was incorrect, let them know and hint higher or lower.
            else if(value > answer)
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: lower!)");
            else 
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: higher!)");

        }
    }

    // run() will initialize basic settings, prompt the user that
    // the game has begun, and call userGuessing() to being taking
    // guesses from the user.
    public static void run() {

        // Initializing game settings and console input.
        guessAmount = 30;
        answer = (int) (Math.random() * 100) + 1;
        reader = new Scanner(System.in);

        System.out.println("Welcome to the guessing game!");
        System.out.println("A random number has already been chosen. Start Guessing!");

        // Allow user to start guessing.
        userGuessing();

        reader.close();
    }
}