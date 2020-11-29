package com.company;


import com.company.dao.PersonagemDAO;
import com.company.model.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class where most of the code is ran.
 *
 * @version 0.12
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

Update 0.12.:
- newChar updated, connected to DAO
- added private PersonagemDAO personagemDAO;
- Added exectueMe inside the constructor

Update 0.13.:
- Consult_all_characters created (caio)
- Delete_a_character created (caio)
- Update_a_character created (caio)
- Documentation added

Update 0.14.:
- Edited Delete_a_character.
- Added scannerAssistant, which verifies the user input and return if valid. Used for Update_a_character
- Added scannerAssistantCreate, which verifies user input for create character
- Updated newChar
 */

public class Executor {
    // Vars
    private List<Personagem> personagems;
    private PersonagemDAO personagemDAO;
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public Executor() {
        personagems = new ArrayList<>();
        personagemDAO = new PersonagemDAO();
    }

    /**
     * Main method, takes user input and reacts based on it
     */
    public void executeMe(){
        int exit = 0;
        int choice;
        System.out.println("Welcome to the System!");
        while (exit == 0){
            menu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    newChar();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    exit = 1;
                    break;
                case 2:
                    Update_a_character();
                    break;
                case 3:
                    Consult_all_characters();
                    break;
                case 4:
                    Delete_a_character();
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
                "4 - Delete a character\n" +
                "0 - Exit");
    }

    /**
     * Creates a new character/personagem
     */
    private void newChar(){
        // Here we go
        System.out.println("Welcome to the character creation screen. Hope you're ready!");
        Personagem createme = new Personagem(scannerAssistantCreate("What shall be thy name?"));

        createme.setRaca(scannerAssistantCreate("What is your race?")); // Todo: Reject elves
        createme.setProfissao(scannerAssistantCreate("What is your class/career?"));
        createme.setMana(Integer.parseInt(scannerAssistantCreate("Your mana points?")));
        createme.setAtaque(Integer.parseInt(scannerAssistantCreate("Your attack power?")));
        createme.setAtaque_magico(Integer.parseInt(scannerAssistantCreate("Your magical attack?")));
        createme.setDefesa(Integer.parseInt(scannerAssistantCreate("Your defense points?")));
        createme.setDefesa_magica(Integer.parseInt(scannerAssistantCreate("Your magical armour?")));
        createme.setVelocidade(Integer.parseInt(scannerAssistantCreate("Your total speed?")));
        createme.setDestreza(Integer.parseInt(scannerAssistantCreate("Dexterity?")));
        createme.setExp(Integer.parseInt(scannerAssistantCreate("Your current exp?")));
        createme.setNivel(Integer.parseInt(scannerAssistantCreate("Your level?")));

        personagemDAO.create(createme);
    }

    /**
     * Method used to consult all characters inside the database
     */
    private void Consult_all_characters(){
        personagems = personagemDAO.getALL();
        System.out.println("Personagens:");
        personagems.forEach(System.out::println);
    }

    /**
     * Method used to remove a character from the database
     */
    private void Delete_a_character(){
        personagems = personagemDAO.getALL();
        System.out.println("Personagems para deletar.:");
        for (int i=0; i<personagems.size(); i++)
        {
            System.out.println((i+1) + " - " + personagems.get(i).getNome());
        }
        System.out.println("Favor escolher um para deletar.\n" +
                "Ou escolha 0 para sair.");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice != 0) {
            System.out.println("Removing...");
            personagemDAO.delete(personagems.get(choice+1));
        }
        System.out.println("Returning to main screen...");
    }

    /**
     * Method used to update a character
     */
    private void Update_a_character(){

        personagems = personagemDAO.getALL();
        System.out.println("Personagems.:");
        for (int i=0; i<personagems.size(); i++)
        {
            System.out.println((i+1) + " - " + personagems.get(i).getNome());
        }
        System.out.println("Favor escolher um para atualizar.\n" +
                "Ou escolha 0 para sair.");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice != 0) {
            System.out.println("Bringing edit screen...");
            System.out.println("Press enter to maintain previous value");
            Personagem updateme = personagems.get(choice+1);

            updateme.setNome(scannerAssistantUpdate("Name - " + updateme.getNome() + ". Update?",updateme.getNome()));
            updateme.setRaca(scannerAssistantUpdate("Race - " + updateme.getRaca() + ". Update?",updateme.getRaca()));
            updateme.setProfissao(scannerAssistantUpdate("Class/career - " + updateme.getProfissao() + ". Update?",updateme.getProfissao()));

            updateme.setMana(Integer.parseInt(scannerAssistantUpdate("Mana - " + updateme.getMana() + ". Update?",
                    Integer.toString(updateme.getMana()))));

            updateme.setAtaque(Integer.parseInt(scannerAssistantUpdate("Attack - " + updateme.getAtaque() + ". Update?",
                    Integer.toString(updateme.getAtaque()))));

            updateme.setAtaque_magico(Integer.parseInt(scannerAssistantUpdate("Magic attack - " + updateme.getAtaque_magico() + ". Update?",
                    Integer.toString(updateme.getAtaque_magico()))));

            updateme.setDefesa(Integer.parseInt(scannerAssistantUpdate("Defense - " + updateme.getDefesa() + ". Update?",
                    Integer.toString(updateme.getDefesa()))));

            updateme.setDefesa_magica(Integer.parseInt(scannerAssistantUpdate("Magic defense - " + updateme.getAtaque() + ". Update?",
                    Integer.toString(updateme.getDefesa_magica()))));

            updateme.setVelocidade(Integer.parseInt(scannerAssistantUpdate("Velocity - " + updateme.getVelocidade() + ". Update?",
                    Integer.toString(updateme.getVelocidade()))));

            updateme.setDestreza(Integer.parseInt(scannerAssistantUpdate("Dexterity - " + updateme.getDestreza() + ". Update?",
                    Integer.toString(updateme.getDestreza()))));

            updateme.setExp(Integer.parseInt(scannerAssistantUpdate("Experience - " + updateme.getExp() + ". Update?",
                    Integer.toString(updateme.getExp()))));

            updateme.setNivel(Integer.parseInt(scannerAssistantUpdate("Level - " + updateme.getNivel() + ". Update?",
                    Integer.toString(updateme.getNivel()))));

            personagemDAO.update(updateme);
        }
    }

    /**
     * Method used for Update_a_character. If user presses enter, skip this and move to the next.
     * @param text The text asking the user for the input
     * @param previous The previous value
     * @return The new value
     */
    String scannerAssistantUpdate(String text, String previous){
        String input;
        System.out.println(text);
        input = scanner.nextLine();
        if (input.equals("")){
            return previous;
        } else {
            return input;
        }
    }

    /**
     * Method used for Create. If user presses enter, ask again for input
     * @param text The text asking the user for the input
     * @return The new value
     */
    String scannerAssistantCreate(String text){
        int exit = 0;
        String input = new String();
        while (exit == 0){
            System.out.println(text);
            input = scanner.nextLine();
            if (input.equals("")){
                System.out.println("Please input a real value.");
            } else {
                exit = 1;
            }
        }
        return input;
    }

}
