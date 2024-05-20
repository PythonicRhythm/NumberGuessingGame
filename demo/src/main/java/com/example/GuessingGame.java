package com.example;
import java.util.Scanner;

/*
 * The GuessingGame class' only purpose is to connect to whichever guessing game mode
 * you want to play. TimedGuessing, ClassicGuessing.java, and DifficultyGuessing.java
 * can be called statically via it's run method and this GuessingGame.java class
 * serves as a gateway to those three modes.
 */
public class GuessingGame {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while(true) {
            System.out.println("\nWelcome to my Guessing Game Collection!");
            System.out.println("For Classic Mode type 1\nFor Difficulty Modes type 2\nFor Timed Mode type 3\nTo Exit type 0");
            System.out.print("> ");

            // Confirm that user input is not a string.
            int choice;
            try {
                choice = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input. Please input a number from 0-3.");
                continue;
            }

            // Exiting
            if(choice == 0) {
                System.out.println("Goodbye!");
                reader.close();
                System.exit(0);
            }
            // Classic Mode
            else if(choice == 1)
            {
                System.out.println("Launching Classic Mode...");
                ClassicGuessing.run();
                
            }
            // Difficulty Modes
            else if(choice == 2)
            {
                System.out.println("Launching Difficulty Modes...");
                DifficultyGuessing.run();
                

            }
            // Timed Mode
            else if(choice == 3)
            {
                System.out.println("Launching Timed Mode...");
                TimedGuessing.run();
                
            }
            // Invalid response
            else {
                System.out.println("Invalid response. Enter a number from 0-3.");
            }
        }

    }

}
