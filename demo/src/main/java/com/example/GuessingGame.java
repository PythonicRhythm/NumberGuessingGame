package com.example;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        System.out.println("Welcome to my Guessing Game Collection!");
        System.out.println("For Classic Mode type 1\nFor Difficulty Modes type 2\nFor Timed Mode type 3\nTo Exit type 0");
        while(true) {
            System.out.print("> ");
            Scanner reader = new Scanner(System.in);
            int choice = Integer.parseInt(reader.nextLine());

            if(choice == 0) {
                System.out.println("Goodbye!");
                reader.close();
                System.exit(0);
            }
            else if(choice == 1)
            {
                System.out.println("Launching Classic Mode...");
                ClassicGuessing.run();
            }
            else if(choice == 2)
            {
                System.out.println("Launching Difficulty Modes...");
                DifficultyGuessing.run();
            }
            else if(choice == 3)
            {
                System.out.println("Launching Timed Mode...");
                TimedGuessing.run();
            }
            else {
                System.out.println("Invalid response. Enter a number from 0-3.");
            }
        }

    }

}
