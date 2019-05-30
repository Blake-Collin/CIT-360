package view;

import java.util.Scanner;
import cityofaaron.CityOfAaron;
import control.*;
import java.io.*;

/**
 * The MainMenuView Class - Part of the view Layer
 * @Class CIT260
 * @Brother Wright
 * @author Collin Blake, Jacob Gallegos, Daniel Martin
 * Date Last Modified 11/13/2018
 */

public class MainMenuView extends MenuView
{
       
    /**
    * The MainMenuViewconstructor
    * Purpose: Initialize the menu data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public MainMenuView()
    {
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: MAIN GAME MENU *\n" +
            "**********************************\n" +
            " 1 -Start new game\n" +
            " 2 -Get and start a saved game\n" +
            " 3 -Get help on playing the game\n" +
            " 4 -Save game\n" +
            " 5 -Quit\n",
            5);
    }
    
    
    /**
    *The doActionmethod
    * Purpose: performs the selected action
    * Parameters: none
    * Returns: none
    */
    // ===================================
    @Override public void doAction(int option)
    {
        switch (option)
        {
            // if the option is 1, call startNewGame( )
            case 1:
                startNewGame();
                break;
            // if the option is 2, call startExistingGame( )
            case 2:
                startSavedGame();
                break;
            // if the option is 3, call displayHelpMenu( )
            case 3:
                displayHelpMenuView();
                break;
            // if the option is 4, call displaySaveGame( )
            case 4:
                displaySaveGameView();
                break;
            // if the option is 5, display a goodbye message
            case 5:
                System.out.println("Thanks for playing... goodbye.");
        }
    }
    
    
    /**
    * The startNewGamemethod
    * Purpose: creates game object and starts the game
    * Parameters: none
    * Returns: none
    * Last Modified:11/06/2018
    */
    // ===================================
    public void startNewGame()
    {
        // Display the Banner Page.
        System.out.println("Welcome to the city of Aaron.");
        // Prompt for and get the user’s name.
        String name;
        System.out.println("Please type in your first name: ");
        name = keyboard.next();
        // Call the createNewGame() method in GameControlclass
        // pass the name as a parameter
        GameControl.createNewGame(name);
        
        // Display a welcome message
        System.out.println("Welcome " + name + " have fun!!!");
        // Display the Game menu
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    }
    
    /**
    * The startSavedGame
    * Purpose: creates game object from save file
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void startSavedGame()
    {
        // get rid of \n character left in the stream
        keyboard.reset();
        
        // prompt user and get a file path
        System.out.println("Enter filepath and filename to savefile: ");
        String filePath = keyboard.next();
        
        // call the getSavedGame( ) method in the GameControl class to load the game       
        GameControl.getSavedGame(filePath);
        
        // display the game menu for the loaded game
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    }            
    
        /**
    * The displayHelpMenuView
    * Purpose: Displays help menu
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void displayHelpMenuView()
    {
        System.out.println("Display Help Menu View option selected.");
        // Display the help menu
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayMenu();
        
    }
    
        /**
    * The SaveGameView
    * Purpose: Shows save game files
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void displaySaveGameView()
    {
        // get rid of \n character left in the stream
        keyboard.reset();
        
        // prompt user and get a file path
        System.out.println("Enter filepath and filename: ");
        String filePath = keyboard.next();
        
        // call the getSavedGame( ) method in the GameControl class to load the game       
        GameControl.saveGame(filePath);
    }
}
