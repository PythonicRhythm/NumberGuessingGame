import java.util.Scanner;

/**
 * This class simulates a Random Number Guessing Game with the following setup.
 * Classic Mode:
 *      The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.    X
 *      Keep track of the number of attempts and display it at the end.                                                         X
 * Difficulty Levels:
 *      Implement different difficulty levels (easy, medium, hard) with varying ranges of numbers.                              X
 *      Easy: Number between 1 and 50.                                                                                          X
 *      Medium: Number between 1 and 100.                                                                                       X
 *      Hard: Number between 1 and 500.                                                                                         X
 *      Adjust the number of allowed attempts based on the difficulty level.                                                    X
 * Time Challenge Mode:
 *      Introduce a time limit for the user to guess the number.                                                                X
 *      Display a countdown timer during the game.                                                                              X
 *      If the user exceeds the time limit, the game ends, and the correct number is revealed.                                  X
 */

public class TimedGuessing {

    static private int guessAmount;
    static private int range;
    static private int answer;
    static private int timeLimit;
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
                timeLimit = 60;
                break;
            }
            // Set medium setting
            else if (difficulty == 2) {
                guessAmount = 25;
                range = 100;
                timeLimit = 40;
                break;
            }
            // Set hard setting
            else if (difficulty == 3) {
                guessAmount = 10;
                range = 500;
                timeLimit = 20;
                break;
            }
            // Response was invalid.
            else {
                System.out.println("Invalid response. Enter a number 0-3");
            }
        }
    }

    // userGuessing() will gather user guesses and check if they
    // match with the random number chosen. This method will
    // also provide hints to the user such as higher or lower.
    private static void userGuessing() {
        
        // Initialize alternate thread that keeps track of time and time limit.
        TimedMode timer = new TimedMode(timeLimit, answer);
        timer.start();

        // While user has more guesses, allow them to guess while
        // keeping tracks of their amounts of attempts. If the user
        // has exited this while loop, they ran out of guesses.
        int attempts = 0;
        while(guessAmount > 0) {
        
            String response = reader.nextLine();
            
            // Catch exception if user types a string.
            int value;
            try {
                value = Integer.parseInt(response);
            } catch(NumberFormatException ex) {
                System.out.println("Invalid Response. Please enter a number.");
                continue;
            }

            attempts++;
            
            // If user guessed correct value.
            if(value == answer)
            {
                System.out.println("Guessed correct value! Good job! Attempts: " + attempts);
                System.exit(0);
            }
            // If user guessed higher than correct value.
            else if(value > answer)
            {
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: lower!)");
            }
            // If user guessed lower than correct value.
            else {
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: higher!)");
            }

        }
    }

    // run() will begin the execution of the guessing game. This method
    // will call setDifficulty() to initialize difficulty settings, gather
    // a random number to set as the correct answer, and call userGuessing()
    // to allow the user to begin guessing.
    public static void run() {

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
