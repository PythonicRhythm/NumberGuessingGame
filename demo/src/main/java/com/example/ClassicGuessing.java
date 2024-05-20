package com.example;
import java.util.Scanner;
/*
 * This class simulates a Random Number Guessing Game with the following setup.
 * Classic Mode:
 *      The program generates a random number between 1 and 100.                                                                X
 *      The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.    X
 *      Keep track of the number of attempts and display it at the end.                                                         X
 * 
 * Can be called statically from other classes and run normally but I use GuessingGame.java to
 * choose from the other modes.
 */
public class ClassicGuessing {
    static private int guessAmount; // amount of attempts the user has to guess the correct answer.
    static private int answer;      // the correct number that the user needs to find.
    static private Scanner reader;  // inputstream reader.

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

            // Catch exception if user types a string.
            int value;
            try {
                value = Integer.parseInt(response);
            } catch(NumberFormatException ex) {
                System.out.println("Invalid response. Please enter a number.");
                continue;
            }
            attempts++;
            
            // If user was correct, let them know and close program.
            if(value == 0) {
                System.out.println("Awww Goodbye!");
                return;
            }
            else if(value == answer) {
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

    // run() will initialize basic settings, prompt the user that
    // the game has begun, and call userGuessing() to being taking
    // guesses from the user.
    public static void run() {

        // Initializing game settings and console input.
        guessAmount = 30;
        answer = (int) (Math.random() * 100) + 1;
        reader = new Scanner(System.in);

        System.out.println("\nWelcome to the guessing game!");
        System.out.println("A random number has already been chosen. Start Guessing!");
        System.out.println("Type 0 to exit. Random numbers start from 1.");

        // Allow user to start guessing.
        userGuessing();

    }

    // run() will initialize basic settings, prompt the user that
    // the game has begun, and call userGuessing() to being taking
    // guesses from the user. This version of run() is meant for
    // testing purposes. 
    public static int run(String testInput) {

        // Initializing game settings and console input.
        guessAmount = 30;
        answer = (int) (Math.random() * 100) + 1;
        reader = new Scanner(testInput);

        System.out.println("Welcome to the guessing game!");
        System.out.println("A random number has already been chosen. Start Guessing!");
        System.out.println("Type 0 to exit! The random number starts from 1.");

        // Allow user to start guessing.
        userGuessing();

        return answer;
    }
}