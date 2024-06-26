package com.example;
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
 * 
 * Can be called statically from other classes and run normally but I use GuessingGame.java to
 * choose from the other modes.
 */
public class DifficultyGuessing {

    static private int guessAmount; // amount of attempts the user has to guess the correct answer.
    static private int range;       // the maximum number that the random number could be (i.e 1-range)
    static private int answer;      // the correct answer/number the user has to guess.
    static private Scanner reader;  // console input reader.

    // setDifficulty() asks the user via console to choose a difficulty.
    // Number 1 is associated with easy difficulty, 2 with medium,
    // and 3 with hard. Each difficulty has their unique values for
    // amount of guesses allowed and the range of possible values.
    static private Boolean setDifficulty() {

        // Explain difficulty differences to user.
        System.out.println("Set your difficulty from Easy to Hard.");
        System.out.println("Easy ranges from 1-50 with 30 guesses.");
        System.out.println("Medium ranges from 1-100 with 25 guesses.");
        System.out.println("Hard ranges from 1-500 with 10 guesses.");
        System.out.println("(For Easy type 1, Medium 2, Hard 3, Exit 0)");

        while(true) {

            System.out.print("> ");

            // Gather response from user.
            String response = "";
            if(reader.hasNext())
                response = reader.nextLine();
            else
                return false;
            
            // Catch exception if user types a string.
            int difficulty;
            try {
                difficulty = Integer.parseInt(response);
            } catch(NumberFormatException ex) {
                System.out.println("Invalid Response. Please enter a number from 0-3.");
                continue;
            }
            
            // Exiting early.
            if(difficulty == 0) {
                System.out.println("Goodbye!");
                return false;
            }
            // Set easy settings
            else if(difficulty == 1) {
                guessAmount = 30;
                range = 50;
                return true;
            }
            // Set medium settings
            else if (difficulty == 2) {
                guessAmount = 25;
                range = 100;
                return true;
            }
            // Set hard settings
            else if (difficulty == 3) {
                guessAmount = 10;
                range = 500;
                return true;
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
        while(guessAmount > 0) {

            System.out.print("> ");
        
            // Gather user response.
            String response = reader.nextLine();

            // Catch exception if user types a string.
            int value;
            try {
                value = Integer.parseInt(response);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid guess. Please enter a number.");
                continue;
            }

            attempts++;
            
            // If user guessed correct value.
            if(value == answer)
            {
                System.out.println("Guessed correct value! Good job! Attempts: " + attempts);
                return;
            }
            // If user was incorrect, let them know and hint higher or lower.
            else if(value > answer)
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: lower!)");
            else 
                System.out.println("Incorrect. " + --guessAmount + " guesses left. (Hint: higher!)");

        }

        // User has run out of guesses. Close program with a message
        System.out.println("Sorry you ran out of guesses! The answer was " + answer + " and there was " + attempts + " attempts.");
    }

    // run() will begin the execution of the guessing game. This method
    // will call setDifficulty() to initialize difficulty settings, gather
    // a random number to set as the correct answer, and call userGuessing()
    // to allow the user to begin guessing.
    public static void run() {

        System.out.println("\nWelcome to the guessing game!");
        reader = new Scanner(System.in);

        if(!setDifficulty())
            return;
    
        System.out.println("Settings have been confirmed. Lets begin!");
    
        // Choose a random number
        answer = (int) (Math.random() * range) + 1;
        System.out.println("A number has been chosen. Start Guessing!");
        
        userGuessing();
        
    }

    // run() will begin the execution of the guessing game. This method
    // will call setDifficulty() to initialize difficulty settings, gather
    // a random number to set as the correct answer, and call userGuessing()
    // to allow the user to begin guessing. This version of run() is meant for
    // testing purposes. 
    public static int run(String testInput) {

        System.out.println("Welcome to the guessing game!");
        reader = new Scanner(testInput);

        if(!setDifficulty())
            return answer;
        
        // Choose a random number
        answer = (int) (Math.random() * range) + 1;
        System.out.println("A number has been chosen. Start Guessing!");
        
        userGuessing();
        return answer;
    }

}