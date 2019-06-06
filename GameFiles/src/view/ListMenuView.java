package view;

import java.util.Scanner;
import cityofaaron.CityOfAaron;
import control.*;
import model.*;
import java.io.*;
import java.util.ArrayList;
import javafx.print.Printer;

/**
 * The MainMenuView Class - Part of the view Layer
 * @Class CIT260
 * @Brother Wright
 * @author Jacob Gallegos
 * Date Last Modified 10/30/2018
 */

public class ListMenuView extends MenuView 
{
    //Variables
    Scanner keyboard = new Scanner(System.in);
    private int max;
    private String listMenu;
    private Game theGame = CityOfAaron.getTheGame();
    
    
    /**
    * The ListMenuconstructor
    * Purpose: Initialize the list data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public ListMenuView()
    {
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: MAIN GAME MENU *\n" +
            "**********************************\n" +
            " 1 -View animals in the storehouse\n" +
            " 2 -View the tools in the storehouse\n" +
            " 3 -View the provisions in the storehouse\n" +
            " 4 -View the authors of this game\n" +
            " 5 -Quit\n",
             5);
    }  

    /**
    *The doActionmethod
    * Purpose: performs the selected action    
    * Returns: none
     * @param option
    */
    @Override public void doAction(int option)
    {
      int options = option;
      if(options == 1){
          listAnimals();          
      }
      else if(options == 2){
          listTools();
      }
      else if(options == 3){
          listProvisions();
      }
      else if(options == 4){
          listTeam();
      }
      else if(options == 5){
          System.out.println("Returning to game menu view.");
      }
      
      
    }
    
    
    /**
    * The listAnimals method
    * Purpose: List the number of Animals in the storehouse
    * Parameters: none
    * Returns: none
    * Last Modified:11/06/2018
    * @Author: Daniel Martin
    */
    // ===================================
    public void listAnimals()
    {
        int input = saveOrDisplay();           
        if(input == 1)
        {
            // List the number of Animals in the storehouse
            System.out.println("Animals in the City of Aaron");
            for(ListItem item : theGame.getAnimals())
            {           
                 String line = String.format("%1$-20s %2$d", item.getName(), item.getNumber());
                System.out.println(line);
            }
        }    
        else
        {                        
            saveList("Animals in the City of Aaron:","Animals", "Amount", theGame.getAnimals());
        }    
    }
    
    /**
    * The listTools method
    * Purpose: List the number of Tools in the storehouse
    * Parameters: none
    * Returns: none
    * Author: Collin Blake
    */
    // ===================================
    public void listTools()
    {
        int input = saveOrDisplay();           
        if(input == 1)
        {
            System.out.println("Tools in the City of Aaron:");
            for(ListItem item : theGame.getTools())
            {           
                 String line = String.format("%1$-20s %2$d", item.getName(), item.getNumber());
                System.out.println(line);
            }
        }               
        else
        {                        
            saveList("Tools in the City of Aaron:","Tools", "Amount", theGame.getTools());
        }        
    } 
    
        /**
    * The listTools method
    * Purpose: Displays a list of the Provisions
    * Parameters: none
    * Returns: none
    * Author: Jacob Gallegos
    */
    // ===================================
    public void listProvisions()
    {
        int input = saveOrDisplay();
        if(input == 1)
        {
            System.out.println("Provisions in the City of Aaron:");
        
            for(ListItem item : theGame.getProvisions())
            {           
                String line = String.format("%1$-20s %2$d", item.getName(), item.getNumber());
                System.out.println(line);
            }

        }
        else {
            saveList("Provisions in the City of Aaron:","Provisions","Amount", theGame.getProvisions());
        }
        
        
    }
    
        /**
    * The listTeam method
    * Purpose: List the number of Teams
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listTeam()
    {
        //List the number of Teams
        System.out.println("View Teams selected");
    }

    /**
     * Method to get choice to display or save a list.
     * @return selection number 
     * @Author Collin Blake
     */
    private int saveOrDisplay()
    {
        int input;
        //Continue asking until user gives a valid choice
        do
        {
            System.out.println("Would you like to?\n"
                             + "1 - Display\n"
                             + "2 - Save\n");
            input = keyboard.nextInt();
            if(input < 1 || input > 2)
            {
                System.out.println("Please select a either 1 or 2!");
            }
        } while(input < 1 || input > 2);
        return input;
    }
    
    /**General get save path     
     * Returns the filepath/filename for saving
     * @Author Collin Blake
     */     
    private String getSavePath()
    {
        keyboard.reset();
        System.out.println("Enter filepath and filename to savefile: ");
        String filePath = keyboard.next();
        return filePath;
    }
    
    /**
     * saveList Method does all the heavy lifting by simplifying the process taking all the inputs
     * from the user and using one unified output to file method
     * @param header Header for the file
     * @param column1 Column 1 name displayed at top of the list
     * @param column2 Column 2 name displayed at the top of the list
     * @param list ArrayList<ListItem> to output
     * @Author Collin Blake
     */
    private void saveList(String header, String column1, String column2, ArrayList<ListItem> list)
    {
        //Get file path
        String filepath = getSavePath();
        
        //Create output writter
        try(PrintWriter out = new PrintWriter(filepath))
        {                
            //Output data to file
            out.println(header);
            out.println("===============================================");
            out.println(String.format("%1$-20s %2$-10s", column1, column2));
            for(ListItem item : list)
            {           
                out.println(String.format("%1$-20s %2$d", item.getName(), item.getNumber()));
            }
            System.out.println("List of " + column1 + " File Saved!");
        }
        catch (Exception e)
        {
            //Exception output
            System.out.println("Failed to save data file!");
        }

    }
}

