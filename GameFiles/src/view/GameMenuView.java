package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 * The GameMenuView Class - Part of the view Layer
 * @Class CIT260
 * @Brother Wright
 * @author Collin Blake
 * Date Last Modified: 11/06/2018
 */
public class GameMenuView extends MenuView {
    
    //Variables
    private static Game theGame= CityOfAaron.getTheGame();
    private static CropData cropData= theGame.getCropData();
    
    
    //Constructor
    public GameMenuView()
    {
        super("\n" +
            "**********************************\n" +
            "**** CITY OF AARON: GAME MENU ****\n" +
            "**********************************\n" +
            " 1 -View Map\n" +
            " 2 -View List\n" +
            " 3 -Move to New Location\n" +
            " 4 -Manage Crops\n" +
            " 5 -Return to Main Menu\n",
            5);
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
            // if the option is 1, call viewMap()
            case 1:
                viewMap();
                break;
            // if the option is 2, call viewList()
            case 2:
                viewList();
                break;
            // if the option is 3, call moveToNewLocation()
            case 3:
                moveToNewLocation();
                break;
            // if the option is 4, call manageCrops()
            case 4:
                manageCrops();
                break;
            // if the option is 5, display a returning message
            case 5:
                System.out.println("Returning to Main Menu");
        }
    }
    
    /**
    *The viewMap
    * Purpose: to show the map
    * Parameters: none
    * Returns: none
    */
    public void viewMap()
    {
        GameControl.displayMap();
    }
    
    /**
    *The viewList Method
    * Purpose: to open the view list menu
    * Parameters: none
    * Returns: none
    */
    public void viewList()
    {
        ListMenuView listMenuView = new ListMenuView();
        listMenuView.displayMenu();
        
        
        
    }
    
    /**
    *The moveToNewLocation method
    * Purpose: Move to new location
    * Parameters: none
    * Returns: none
    */
    public void moveToNewLocation()
    {
        GameControl.ChangeLocation();
    }
    
    /**
    *The manageCrops method
    * Purpose: To give choices for managing the crops
    * Parameters: none
    * Returns: none
    */
    public void manageCrops()
    {       
        CropView cv = new CropView();
        cv.displayMenu();        
    }
}
