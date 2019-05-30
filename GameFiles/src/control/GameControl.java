/**
* Source code for the GameControlclass
* The GameControlclass is a member of the controllayer
* Methods in the GameControlclass manage Game objects
* Author: your team name
* Date Last modified: date you wrote this code
*/
// ==============================================================
package control;

import model.*;
import cityofaaron.CityOfAaron;
import java.util.Set;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * @Class CIT260
 * @Brother Wright
 * @author Collin Blake, Jacob Gallegos, Daniel Martin
 */
public class GameControl {
    
    //size of the locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    private static Game theGame;
    protected final static Scanner keyboard = new Scanner(System.in);
    
    
    public static void createNewGame(String pName)
    {                            
        // create the game object
        Game game= new Game();
        
        // create the player object and set the name              
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        // save reference to the player object in the game        
        game.setPlayer(thePlayer);
        
        //Assign game to CityOfAaron
        CityOfAaron.setTheGame(game);
        theGame = CityOfAaron.getTheGame();
                
        //Create Game Objects
        createCropDataObject();
        createMap();
        createAnimalsList();
        createToolsList();
        createProvisionsList();
    }
    
    public static void createCropDataObject()
    {
        //Set starting values
        CropData cropData = new CropData();
        cropData.setYear(0);
        cropData.setPopulation(100);
        cropData.setNewPeople(5);
        cropData.setCropYield(3);
        cropData.setNumberWhoDied(0);
        cropData.setWheatInStore(2700);
        cropData.setAcresOwned(1000);
        cropData.setAcresPlanted(1000);
        cropData.setHarvest(3000);
        cropData.setAcresPlanted(1000);
        theGame.setCropData(cropData);
        // when all is done, save a reference to the Game object
        theGame.setCropData(cropData);
    }
    
    /**
     * the creatMap method
     * Purpose: creates the location objects and the map
     * Parameters: none
     * Returns: none
     */
    public static void createMap()
    {
        /**
         * Corner    0   1   2   3   4
         *      0   ^^^ !!! !!! !!! ~~~
         *      1   ^^^ !!! !!! !!! ~~~
         *      2   ^^^ &&& ØØØ !!! ~~~
         *      3   ^^^ !!! !!! !!! ~~~
         *      4   ^^^ !!! !!! !!! ~~~
         */
        
        
        //Create the map object
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        //Farm land base replace as needed
         String farmland = "You are on the fertile banks of the river.\n" +
        "In the spring, this low farmland floods and is covered with rich\n" +
        "new soil. Wheat is planted as far as you can see.";
         
        Location loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat."); 
        loc.setSymbol("!!!");
        for(int i = 0; i < MAX_ROW; i++)
        {            
            for(int j = 0; j < MAX_COL; j++)
            {
                theMap.setLocation(i,j,loc);
            }
        }
        
        //Create river
        String river = "You are on the River. The river is the source\n" +
                    "of life for our city. The river marks the eastern\n " +
                    "boundary of the city - it is wilderness to the East.\n";

        loc = new Location();
        loc.setDescription(river);
        loc.setSymbol("~~~");
        
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i,4,loc);
        }               
                
        //Create Garnary
        String garnary = "You are standing before a large Garnary located in the\n" +
                "middle of your fields.\n";
                
        loc = new Location();
        loc.setDescription(garnary + "\nCareful the more you tribute the less likely misfortune will overcome you."); 
        loc.setSymbol("ØØØ");
        theMap.setLocation(2,2,loc);
        
        //Create Village
        String village = "You stand among the City of Aaron long streets, full of\n" +
                      "busy people going about their day to day lives.\n";
        loc = new Location();
        loc.setDescription(village + "\nOffering more begets greater benefits later."); 
        loc.setSymbol("&&&");
        theMap.setLocation(2,1,loc);
        
        //Create Mountains
        String mountains = "You are standing on the peaks of mountains overlooking\n" +
                "a valley of farmland, a village, and flowing river.\n";
        loc = new Location();
        loc.setDescription(mountains + "The Mountains protect you... but from what?\n.");
        loc.setSymbol("^^^");
        
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i,0,loc);
        }        
        
        //Save to game
        theGame.setMap(theMap);
    }
    
    public static void displayMap()
    {   
        System.out.println("---------Map----------");
        System.out.println("    1 | 2 | 3 | 4 | 5 ");
        
        for(int i = 0; i < MAX_ROW; i++)
        {
            System.out.print(" " + (i+1) + " ");
            for(int j = 0; j < MAX_COL; j++)
            {
                String temp = theGame.getMap().getLocation(i, j).getSymbol();
                                                
                System.out.print(temp);
                if(j != MAX_COL-1)
                {
                    System.out.print("|");
                }
            }
            if(i != MAX_ROW-1)
            {
                System.out.print("\n   ---+---+---+---+---\n");
            }
            else
            {
                System.out.print("\n");
            }
            
        }
    }
    
     /**
     * The create animals list method
     * Purpose: Create an array of the animals
     * Returns nothing
     * Author: Daniel
     */   
    public static void createAnimalsList()
    {
        ArrayList<ListItem> animals = new ArrayList<>();
        
        animals.add(new ListItem("Horses", 13));
        animals.add(new ListItem("Cows", 12));
        animals.add(new ListItem("goats", 4));
        animals.add(new ListItem("Pigs", 7));
               
        theGame.setAnimals(animals);
        
    }
    /**
     * The create tools method
     * Purpose: Create an array of the tools available.
     * Returns nothing
     * Author: Collin
     */       
    public static void createToolsList()
    {
        ArrayList<ListItem> tools = new ArrayList<>();
        
        tools.add(new ListItem("Hammers", 823));
        tools.add(new ListItem("Shovels", 523));
        tools.add(new ListItem("Hoes", 923));
        tools.add(new ListItem("Pickaxes", 243));
        tools.add(new ListItem("Rakes", 513));
        tools.add(new ListItem("Hand Saws", 323));
        tools.add(new ListItem("SledgeHammers", 623));
        
        theGame.setTools(tools);
    }
    
    /**
    * The createProvisionsList method
    * Purpose: creates an array and assigns provisions to them
    * Returns: none
    * @author: Jacob Gallegos
    */
    public static void createProvisionsList()
    {
        //Create an Array List for the provisions
        ArrayList <ListItem> provisions = new ArrayList<>();
        
        //Add some Provisions
        provisions.add(new ListItem("Water", 12));
        provisions.add(new ListItem("Food", 3));
        provisions.add(new ListItem("Shoes", 1));
        provisions.add(new ListItem("Clothes", 2));
        
        theGame.setProvisions(provisions); 
        
    }
    
    public static void getSavedGame(String filePath)
    {
        Game theGame = null;
        
        try (FileInputStream fips = new FileInputStream(filePath))
        {
            ObjectInputStream input = new ObjectInputStream(fips);
            theGame = (Game) input.readObject();
            CityOfAaron.setTheGame(theGame);
        }
        catch (Exception e)
        {
            System.out.println("There was an error reading the saved game file\n");
        }
        finally
        {
            System.out.println("Your Game has been loaded succesfully!\n");
        }    
    }
    
    public static void saveGame(String filePath)
    {                
        try (FileOutputStream fips = new FileOutputStream(filePath))
        {
            ObjectOutputStream output = new ObjectOutputStream(fips);
            output.writeObject(theGame);            
        }
        catch (Exception e)
        {
            System.out.println("There was an error saving the game file\n");
        }
        finally
        {
            System.out.println("Your game has been saved!\n");
        }    
    }
    
    
    /**
     * Change Location Method
     * returns void
     * Will update the character location and then tell you where you are.
     * Author: Collin Blake
     */
    public static void ChangeLocation()
    {
        int x = -1;
        int y = -1;
        System.out.println("Enter the coordinates of the location you want to move to.");
        //For loop to do the task twice once for x and once for y
        for(int i = 0; i < 2; i++)
        {
            boolean paramWorked = true;
            //While loop to continue asking for values until the user inputs a valid coordiates.
            do
            {
                try
                {
                    paramWorked = false;
                    if(i == 0)
                    {
                        x = getLocationInput("x");                         
                    }
                    else if (i == 1)
                    {
                        y = getLocationInput("y");
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Sorry my lord, we don't own that land. (Please select a number between 1 and 5)");
                    paramWorked = true;
                }

            } while (paramWorked);
        }
        
        //Set player values.
        theGame.getPlayer().setRow(x);
        theGame.getPlayer().setColumn(y);
        
        //Get the discription for the location in question.
        System.out.println(theGame.getMap().getLocation(theGame.getPlayer().getRow(), theGame.getPlayer().getColumn()).getDescription());
    }
    
    /**
     * getLocationInput Method
     * Will ask the user for input and throw exceptions if the user gives an invalid choice.
     * @param location
     * @return
     * @throws Exception 
     * Author Collin Blake
     */
    public static int getLocationInput(String location) throws Exception
    {
        System.out.print("Enter the " + location + "-coordinate: ");
        keyboard.reset();
        int temp = keyboard.nextInt();
        
        if (temp > 5 || temp < 1)
        {
            throw new Exception();
        }        
        return (temp-1);
    }
}
