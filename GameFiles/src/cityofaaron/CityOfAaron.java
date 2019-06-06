/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Collin Blake, Jacob Gallegos, Daniel Martin
 */
package cityofaaron;

import model.*;
import view.*;
import java.math.*;


public class CityOfAaron {

    //Class Variables
    private static Game theGame = null;
    
    public static void main(String[] args) {
        
        //Variables        
        MainMenuView mmv = new MainMenuView();
              
        //Funcitons        
        mmv.displayMenu();                
    }    

    public static Game getTheGame() {
        return theGame;
    }

    public static void setTheGame(Game theGame) {
        CityOfAaron.theGame = theGame;
    }
        
}
