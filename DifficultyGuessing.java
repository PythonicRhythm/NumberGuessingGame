import java.util.Scanner;

/**
 * This class simulates a Random Number Guessing Game with the following setup.
 * Classic Mode:
 *      The program generates a random number between 1 and 100.                                                                X
 *      The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.    X
 *      Keep track of the number of attempts and display it at the end.                                                         X
 * Difficulty Levels:
 *      Implement different difficulty levels (easy, medium, hard) with varying ranges of numbers.                              X
 *      Easy: Number between 1 and 50.                                                                                          X
 *      Medium: Number between 1 and 100.                                                                                       X
 *      Hard: Number between 1 and 500.                                                                                         X
 *      Adjust the number of allowed attempts based on the difficulty level.                                                    X
 * Time Challenge Mode:
 *      Introduce a time limit for the user to guess the number.
 *      Display a countdown timer during the game.
 *      If the user exceeds the time limit, the game ends, and the correct number is revealed.
 */
public class DifficultyGuessing {

    static private int guessAmount;
    static private int range;
    static private int answer;
    static private Scanner reader;

    // setDifficulty() asks the user via console to choose a difficulty.
    // Number 1 is associated with easy difficulty, 2 with medium,
    // and 3 with hard.
    static private void setDifficulty() {

        while(true) {

            // Explain difficulty differences to user.
            System.out.println("Set your difficulty from Easy to Hard.");
            System.out.println("Easy ranges from 1-50 with 30 guesses.");
            System.out.println("Medium ranges from 1-100 with 25 guesses.");
            System.out.println("Hard ranges from 1-500 with 10 guesses.");
            System.out.println("(For Easy type 1, Medium 2, Hard 3, Exit 0)");
            System.out.print("> ");

            // Gather response from user.
            String response = reader.nextLine();
            int difficulty = Integer.parseInt(response);
            
            // Exiting early.
            if(difficulty == 0) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            // Set easy setting
            else if(difficulty == 1) {
                guessAmount = 30;
                range = 50;
                break;
            }
            // Set medium setting
            else if (difficulty == 2) {
                guessAmount = 25;
                range = 100;
                break;
            }
            // Set hard setting
            else if (difficulty == 3) {
                guessAmount = 10;
                range = 500;
                break;
            }
            // Response was invalid.
            else {
                System.out.println("Invalid response. Enter a number 1-3");
            }
        }
    }

    // userGuessing() will gather user guesses and check if they
    // match with the random number chosen. This method will
    // also provide hints to the user such as higher or lower.
    private static void userGuessing() {
        int attempts = 0;
        long start = System.nanoTime();
        while(guessAmount > 0) {

            System.out.print("> ");
        
            String response = reader.nextLine();
            int value = Integer.parseInt(response);
            attempts++;
            
            if(value == answer)
            {
                System.out.println("Guessed correct value! Good job! Attempts: " + attempts);
                System.exit(0);
            }
            else if(value > answer)
            {
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: lower!)");
            }
            else {
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: higher!)");
            }

        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the guessing game!");
        reader = new Scanner(System.in);

        setDifficulty();
        
        // Choose a random number
        answer = (int) (Math.random() * range) + 1;
        System.out.println("A number has been chosen. Start Guessing!");
        
        userGuessing();

        // User has run out of guesses. Close program with a message
        System.out.println("Sorry you ran out of guesses! The answer was " + answer);
        reader.close();
        
    }

}