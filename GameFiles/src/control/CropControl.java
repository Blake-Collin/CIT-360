package control;

import java.io.Serializable;
import java.util.Random;
import model.CropData;
import java.math.*;
import exceptions.*;

/**
 *The CropControlclass -part of the control layer
 * class contains all of the calculation methods for managing the crops
 * Author: Collin, Jacob & Daniel 
 **/
public class CropControl implements Serializable{

    //Constants
    //
    private static int YIELD_BASE = 1;
    private static int YIELD_RANGE = 4;
    private static int LAND_BASE = 17;
    private static int LAND_RANGE = 10;
    private static int PEOPLE_PER_ACRE = 2;
    private static int ARCES_PER_BUSHEL = 0;

    private static int GROWTH_BASE = 1;
    private static int GROWTH_RANGE = 4;
    
    private static int WHEAT_HARVEST_BASE = 1;
    private static int WHEAT_HARVEST_RANGE = 2;
    private static int WHEAT_HARVEST_BASE_HI = 2;
    private static int WHEAT_HARVEST_RANGE_HI = 3;
       
    private static int OFFERING_LESS_ACTIVE = 8;
    private static int OFFERING_ACTIVE = 12;
    
    private static int WHEAT_EATEN_ODDS_BASE = 1;
    private static int WHEAT_EATEN_ODDS_RANGE = 99;
    private static int WHEAT_EATEN_ODDS_THRESH = 30;
    private static int WHEAT_EATEN_BASE = 3;
    private static int WHEAT_EATEN_RANGE = 4;
    private static int WHEAT_EATEN_BASE_HI = 6;
    private static int WHEAT_EATEN_RANGE_HI = 2;
    
    
    
    //random number Generator
    private static Random random = new Random();
    
    /**
    * sellLandmethod
    * Purpose: Sell land -subtracts from the acres owned
    * Parameters: landPrice, the number of acres to sell, and a
    * reference to a CropDataobject
    * Pre-conditions: acresToSell>= 0 and acresToSell<= acresOwned
    * Returns: the number of acres owned after the sale
    */
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException
    {
            //if acresToSell< 0, return -1
        if (acresToSell< 0)
        {
           throw new CropException("Cannot enter a value less then 0!");
        }

        //if acresToSell> acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();

        if (acresToSell > cropData.getAcresOwned())
        {
            throw new CropException("Cannot sell more than we have!");
        }

        //acresOwned= acresOwned-acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);

        //wheatInStore= wheatInStore+ (acresToBuyx landPrice)
        int wheatInStore= cropData.getWheatInStore();
        wheatInStore += (acresToSell* landPrice);
        cropData.setWheatInStore(wheatInStore);

        //return acresOwned
        return acresOwned;
    }
    
    /**
    *The buyLand Method
    *Purpose: To Buy Land
    *@param the price of land
    *@param the number of acres to buy
    *@param a reference to CropData
    *PreConditions: acresToBuy must be positive
    * and landPrice is between 17-27
    * Author Collin, Jacob, Daniel
    */
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException
    {
        //If acresToBuy < 0, return -1
        if (acresToBuy < 0)
        {
            throw new CropException("A negative value was input.");
        }
                
        //If landPrice < 17 or landPrice > 27, return -1
        if (landPrice < 17 || landPrice > 27)
        {
            throw new CropException("Random price failed.");
        }
        
        //If (acresOwned + acresToBuy) / 10 > population, return -1
        if (((cropData.getAcresOwned() + acresToBuy) / 10) 
            > cropData.getPopulation())
        {
            throw new CropException("Not enough people to work this much land.");
        }
        
        //If wheatInStore < (acresToBuy * landPrice), return -1
        if (cropData.getWheatInStore() < (acresToBuy * landPrice))
        {            
            throw new CropException("There is insufficient wheat to buy this much land.");

        }
        
        //acresOwned = acresOwned + acresToBuy
        cropData.setAcresOwned(cropData.getAcresOwned() + acresToBuy);
        
        //wheatInStore = wheatInStore – (landPrice * acresToBuy)
        cropData.setWheatInStore(cropData.getWheatInStore() 
                - (landPrice * acresToBuy));
        
        //return acresOwned
        return cropData.getAcresOwned();
    }
    
    
    public static int calcLandCost()
    {
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landPrice;
    }
           
    /**
    *The setOffering Method
    *Purpose: To set the Offering %
    *@param integer to be converted to % for offering
    *@param a reference to CropData
    *Pre-Conditions: offeringPrecentage is in the range of 0 to 100
    * Author: Collin Blake
    */
    public static int setOffering(int offeringPrecentage, CropData cropData)
    {
        //If offeringPrecentage < 0 OR offeringPrecentage > 100 , return -1
        if (offeringPrecentage < 0 || offeringPrecentage > 100)
        {
            return -1;
        }
        
        //offering = offeringPrecentage
        cropData.setOffering(offeringPrecentage);
        
        //return offering
        return cropData.getOffering();
    }
    
    /**
    *The plantCrops Method
    *Purpose: To Plant Crops
    *@param acresToPlant
    *@param reference acresOwned
    *@param reference wheatInStore
    *Pre-Conditions: acresToPlant must be positive
    * and acresToPlant is less than or equal to acresOwned, 
    * and wheatInStore is two times or more than acresToPlant 
    * Author: Daniel Martin
    */
    
    public static void plantCrops(int acresToPlant, CropData cropData) throws CropException
    {

        //If acresToPlant < 0, return -1
        if (acresToPlant < 0)
        {
            throw new CropException("A negative value was input");
        }
            
        //If acresToPlant is > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        
        if (acresToPlant > cropData.getAcresOwned())
        {
            throw new CropException("You don't own enough land");
        }
            
        //If wheatInStore < (acresToPlant / 2), return -1
        int wheatInStore = cropData.getWheatInStore();
        
        if (wheatInStore < (int) Math.ceil(acresToPlant / 2))
        {
            throw new CropException("You don't have enough wheat");
        }    
              
        //acresPlanted = acresPlanted + acresToPlant
        int acresPlanted = cropData.getAcresPlanted();
        acresPlanted += acresToPlant;
        cropData.setAcresPlanted(acresPlanted);
       
        //wheatInStore = wheatInStore – (acresToPlant *2)
        wheatInStore -= ((int) Math.ceil((double)acresToPlant / 2.0));
        cropData.setWheatInStore(wheatInStore);
    }
    
    /**
    *The Feed People Method
    * Purpose: To Feed People
    *@param wheatOwned
    *@param bushelsToGive
    *@param cropData
    *@param bushelCost
    *@param bushelsOwned
    *Pre-Conditions: Number of bushels of grain needs to be positive
    *enough wheat in storage to purchase
    *Author: Collin Blake
    */    
    public static int feedThePeople(int bushelsToGive, CropData cropData) throws CropException
    {
        int wheatOwned = cropData.getWheatInStore();
        //If bushelsToGive < 0 return -100i
        //Error checking for both fail conditions that will throw a new exception
        if (bushelsToGive < 0)
        {
            throw new CropException("You entered a negative number.");
        }
        //If bushelsToGive > wheatOwned)
        if (bushelsToGive > wheatOwned)
        {
            throw new CropException("You do not have enough bushels to purchase that much land.");
        }
        //WheatInstorage =– bushelsToGive
        wheatOwned = wheatOwned - bushelsToGive;
        
        //Save back
        cropData.setWheatInStore(wheatOwned);
        
        //return wheatOwned
        return wheatOwned;                  
    }

    /**
     * Grow Population Methodf
     * Purpose: To Grow the population
     * @param cropData
     * @return new population
     * Pre-Conditions: the population is positive
     * Author: Collin Blake
     */
    public static int growPopulation(CropData cropData)
    {
        if(cropData.getPopulation() < 1)
        {
            return -1;
        }
        
        //1. Determine how much to grow the population (a random number between 
        // 1 and 5 %).
        int randomInt = random.nextInt(GROWTH_BASE) + GROWTH_RANGE;                     
                
        //2. Calculate the number of people who moved into the city.
        //3. Save this value.
        cropData.setNewPeople(Math.round(cropData.getPopulation()*randomInt));

        //4. Add this number to the current population
        //5. Save the updated value of the current population.
        cropData.setPopulation(cropData.getPopulation() 
                            + cropData.getNewPeople());
                
        return cropData.getPopulation();
    }
    
    /**
     * Pay the offering in bushels
     * Purpose to assign the amount of bushels paid and 
     * @param cropData
     * @return new current wheat total
     * Pre-Conditions: Offering is positive
     * Author: Collin Blake
     */
    public static int payOffering(CropData cropData)
    {
        //pre-conditions
        if(cropData.getOffering() < 0)
        {
            return -1;
        }
        
        //Convert offering to double
        double offering = ((double)cropData.getOffering()/ 100.0);

        //Get number of bushesl offered round up
        int offeringAmount = (int)(Math.round(cropData.getWheatInStore() 
                                            * offering));

        //save new amount of wheat
        cropData.setOfferingBushels(offeringAmount);
        cropData.setWheatInStore(cropData.getWheatInStore() 
                                        - cropData.getOfferingBushels());

        //Return the amount of wheat in store afterwards        
        return cropData.getWheatInStore();
    }
    
    
    /** Harvest the wheat method
     *  purpose is to harvest the wheat
     * 
     */
    
    public static int wheatHarvested(CropData cropData, int wheatHarvested)
    {
        //variables
        int offerings = cropData.getOffering();
        int acresPlanted = cropData.getAcresPlanted();
    
        //if tithesAndOfferings < 8 randomNum between 1 and 3
         if (offerings < OFFERING_LESS_ACTIVE)
         {
            if (!isWithinRange(wheatHarvested, WHEAT_HARVEST_BASE, WHEAT_HARVEST_RANGE))
            {
                wheatHarvested = random.nextInt(WHEAT_HARVEST_RANGE) + WHEAT_HARVEST_BASE;
            }
         }
         //if tithesAndOfferings >= 8 and tithesAndOfferings <= 12 randomNum between 2 and 4
         else if (offerings <= OFFERING_ACTIVE)
         {
            if (!isWithinRange(wheatHarvested, WHEAT_HARVEST_BASE_HI, WHEAT_HARVEST_RANGE))
            {
                wheatHarvested = random.nextInt(WHEAT_HARVEST_RANGE) + WHEAT_HARVEST_BASE_HI;
            }
         }
         //if tithesAndOffereings > 12 randomNum between 2 and 5
         else 
         {
            if (!isWithinRange(wheatHarvested, WHEAT_HARVEST_BASE_HI, WHEAT_HARVEST_RANGE_HI))
            {
                wheatHarvested = random.nextInt(WHEAT_HARVEST_RANGE_HI) + WHEAT_HARVEST_BASE_HI;
            }
         }
         
        //return wheatHarvested = randomNum * acresPlanted
        wheatHarvested *= acresPlanted;
        cropData.setWheatInStore(wheatHarvested);
        
        //return randomNum   
        return wheatHarvested;
    }
    
    /** Harvest the wheat method
     *  purpose is to harvest the wheat
     * 
     */
    
    public static int eatenByRats(CropData cropData, int randomNum, int eatenByRatsPct)
    {
        //variables
        int eatenByRats = 0;
        int offerings = cropData.getOffering();
        int acresPlanted = cropData.getAcresPlanted();
        int wheatInStore = cropData.getWheatInStore();
        
        // Pick a random number
        if(!isWithinRange(randomNum, WHEAT_EATEN_ODDS_BASE, WHEAT_EATEN_ODDS_RANGE))
        {
            randomNum = random.nextInt(WHEAT_EATEN_ODDS_RANGE) + WHEAT_EATEN_ODDS_BASE;
        }
       
        if (randomNum < WHEAT_EATEN_ODDS_THRESH)
        {
            //If tithesAndOfferings < 8, eatenByRats = randomNum between 6 and 10;
            if (offerings < OFFERING_LESS_ACTIVE)
            {
                if (!isWithinRange(eatenByRatsPct, WHEAT_EATEN_BASE_HI, WHEAT_EATEN_RANGE_HI))
                {
                    eatenByRatsPct = random.nextInt(WHEAT_EATEN_RANGE_HI) + WHEAT_EATEN_BASE_HI;
                }
            }
            //If tithesAndOfferings >=8 and if tithesAndOfferings <=12;
             else if (offerings <= OFFERING_ACTIVE)
            {
                //eatenByRats = radomNum between 3 and 7;
                if (!isWithinRange(eatenByRatsPct, WHEAT_EATEN_BASE, WHEAT_EATEN_RANGE_HI))
                {
                    eatenByRatsPct = random.nextInt(WHEAT_EATEN_RANGE_HI) + WHEAT_EATEN_BASE;
                }
            }
            //If tithesAndOfferings > 12, eatenByRats = randomNum between 3 and 5;
            else 
            {
                if (!isWithinRange(eatenByRatsPct, WHEAT_EATEN_BASE, WHEAT_EATEN_RANGE))
                {
                    eatenByRatsPct = random.nextInt(WHEAT_EATEN_RANGE) + WHEAT_EATEN_BASE;
                }
            }
        }
        
        //set eatenByRats = randomNum * wheatInStore
        eatenByRats = (int) Math.round(wheatInStore * eatenByRatsPct *.01);
        
        //wheatInStore -= (wheatInStore * eatenByRats * .01)
        wheatInStore -= eatenByRats;
        cropData.setWheatInStore(wheatInStore);
        
        //Return eatenByRats;
        return eatenByRats;
        
    }
    
    private static boolean isWithinRange(int value, int base, int range)
    {
        if(value < base || value > base + range)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
         
}
