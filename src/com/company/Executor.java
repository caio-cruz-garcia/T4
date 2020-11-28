package com.company;


import com.company.model.Personagem;

import java.util.Scanner;

/**
 * The class where most of the code is ran.
 *
 * @version 0.11
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

Update 0.11.:
- Added newChar

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

    /**
     * Creates a new character/personagem
     */
    private void newChar(){
        // Here we go
        System.out.println("Welcome to the character creation screen. Hope you're ready!");

        System.out.println("What shall be thy name?");
        String name = scanner.nextLine();

        System.out.println("What is your race?"); // Todo: Reject elves
        String race = scanner.nextLine();

        System.out.println("What is your class/career?");
        String career = scanner.nextLine();

        System.out.println("Your mana points?");
        int mana = Integer.parseInt(scanner.nextLine());

        System.out.println("Your attack power?");
        int atack = Integer.parseInt(scanner.nextLine());

        System.out.println("Your magical attack?");
        int mag_attack = Integer.parseInt(scanner.nextLine());

        System.out.println("Your defense points?");
        int defense = Integer.parseInt(scanner.nextLine());

        System.out.println("Your magical armour?");
        int mag_defense = Integer.parseInt(scanner.nextLine());

        System.out.println("Your total speed?");
        int velocity = Integer.parseInt(scanner.nextLine());

        System.out.println("Dexterity?");
        int dext = Integer.parseInt(scanner.nextLine());

        System.out.println("Your current exp?");
        int exp = Integer.parseInt(scanner.nextLine());

        System.out.println("Your level?");
        int level = Integer.parseInt(scanner.nextLine());

    }

}
