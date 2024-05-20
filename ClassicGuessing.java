import java.util.Scanner;
/*
 * This class simulates a Random Number Guessing Game with the following setup.
 * Classic Mode:
 *      The program generates a random number between 1 and 100.                                                                X
 *      The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.    X
 *      Keep track of the number of attempts and display it at the end.                                                         X
 */
public class ClassicGuessing {

    public static void main(String[] args) {
        // Initializing game settings and console input.
        int guessAmount = 30;
        int answer;
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the guessing game!");

        // Gather random number.
        answer = (int) (Math.random() * 100) + 1;
        System.out.println("A number has been chosen. Start Guessing!");

        // While the user has more guesses/attempts, allow them to guess.
        int attempts = 0;
        while(guessAmount > 0) {

            System.out.print("> ");
        
            // Gather user's guess.
            String response = reader.nextLine();
            int value = Integer.parseInt(response);
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

        reader.close();
    }
}
