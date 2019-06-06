package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 * The HelpMenuView Class - Part of the view Layer
 * @Class CIT260
 * Brother Wright
 * @author Daniel Martin
 * Date Last Modified 11/06/2018
 */
public class HelpMenuView extends MenuView {
    
    //Constructor
    public HelpMenuView()
    {
        super ( "\n" +
            "**********************************\n" +
            "**** CITY OF AARON: HELP MENU ****\n" +
            "**********************************\n" +
            " 1 -What are the goals of the game?\n" +
            " 2 -Where is the city of Aaron?\n" +
            " 3 -How do I view the map?\n" +
            " 4 -How do I move to another location?\n" +
            " 5 -How do I display a list of animals, provisions and tools in the city storehouse?\n" +    
            " 6 -Return to Main Menu\n",
        6);
    }
    
    //Functions
    
       
     /**
    *The doAction method
    * Purpose: performs the selected action
    * Parameters: option selected by user
    * Returns: none
    */
    @Override public void doAction(int option)
    {
        switch (option)
        {
            // if the option is 1, call gameGoals()
            case 1:
                gameGoals();
                break;
            // if the option is 2, call wheresAaron()
            case 2:
                wheresAaron();
                break;
            // if the option is 3, call howViewMap()
            case 3:
                howViewMap();
                break;
            // if the option is 4, call howMove()
            case 4:
                howMove();
                break;
            // if the option is 5, call howDisplayList()
            case 5:
                howDisplayList();
                break;
            // if the option is 6, display a returning message
            case 6:
                System.out.println("Returning to Main Menu");
        }
    }
    
    /**
    *The gameGoals Method
    * Purpose: to tell goals of the game
    * Parameters: none
    * Returns: none
    */
    public void gameGoals()
    {
        System.out.println("What are the goals of the game? option selected");    
    }
    
    /**
    *The wheresAaron Method
    * Purpose: to explain where the city of Aaron is
    * Parameters: none
    * Returns: none
    */
    public void wheresAaron()
    {
        System.out.println("Where is the city of Aaron? option selected");
    }
    
    /**
    *The howViewMap method
    * Purpose: Explain how to view the map
    * Parameters: none
    * Returns: none
    */
    public void howViewMap()
    {
        System.out.println("How do I view the map? option selected.");
    }
    
    /**
    *The howMove method
    * Purpose: To give choices for managing the crops
    * Parameters: none
    * Returns: none
    */
    public void howMove()
    {       
        System.out.println("How do I move to another location? option selected");
    }
    
    /**
    *The howDisplayList method
    * Purpose: explain how to display lists
    * Parameters: none
    * Returns: none
    */
    public void howDisplayList()
    {       
        System.out.println("How do I display a list of animals, provisions and tools in the city storehouse? option selected");
    }
    
    
}
