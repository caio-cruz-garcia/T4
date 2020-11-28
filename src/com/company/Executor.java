package com.company;


import com.company.model.Personagem;

import java.util.Scanner;

/**
 * The class where most of the code is ran.
 *
 * @version 0.1
 * @since 2020-11-28
 */

/*
Update 0.:
- Created class
- Added initial comment
- Added update log

Update 0.1.:
- Added vars
- Added executeMe()

 */

public class Executor {
    // Vars
    private Personagem personagem;
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public Executor() {
    }


    /**
     * Main method, takes user input and reacts based on it
     */
    private void executeMe(){
        int exit = 0;
        int choice;
        System.out.println("Welcome to the System!");
        while (exit == 0){
            menu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 0:
                    System.out.println("Exiting...");
                    exit = 1;
                    break;
                default:
                    System.out.println("Input not recognized.");

            }
        }
    }

    /**
     * Stores possible choices.
     */
    private void menu(){
        System.out.println("Please select one of the following.:\n"+
                "1 - Create a new character\n" +
                "2 - Change an existing character\n" +
                "3 - Consult all characters\n" +
                "4 - Delete a character\n");
    }

}
