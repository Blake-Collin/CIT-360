package model;

import java.io.Serializable;


/*  
 * CIT-260
 * Fall 2018
 * Team members: Collin Blake, Jacob Gallegos, Daniel Martin
 */
public class CropData implements Serializable {
    
    //Variables
    private int year;
    private int population;
    private int acresOwned;
    private int cropYield;
    private int wheatInStore;
    private int numberWhoDied;
    private int newPeople;
    private int harvest;
    private int harvestAfterOffering;
    private int offering;
    private int offeringBushels;
    private int peopleFed;
    private int acresPlanted;
    private int numStarved;
    private int eatenByRats;
    private int wheatForPeople;
    
    //Constrctor

    public CropData() {
    }
        
    //Functions
    public int getYear() {
        return year;
    }

    public int getPopulation() {
        return population;
    }

    public int getAcresOwned() {
        return acresOwned;
    }

    public int getCropYield() {
        return cropYield;
    }

    public int getWheatInStore() {
        return wheatInStore;
    }

    public int getNumberWhoDied() {
        return numberWhoDied;
    }

    public int getNewPeople() {
        return newPeople;
    }

    public int getHarvest() {
        return harvest;
    }

    public int getHarvestAfterOffering() {
        return harvestAfterOffering;
    }

    public int getOffering() {
        return offering;
    }

    public int getOfferingBushels() {
        return offeringBushels;
    }

    public int getPeopleFed() {
        return peopleFed;
    }

    public int getAcresPlanted() {
        return acresPlanted;
    }

    public int getNumStarved() {
        return numStarved;
    }
    
    public int getEatenByRats() {
        return eatenByRats;
    }

    public int getWheatForPeople() {
        return wheatForPeople;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public void setCropYield(int cropYield) {
        this.cropYield = cropYield;
    }    
    
    public void setWheatInStore(int wheatInStore) {
        this.wheatInStore = wheatInStore;
    }

    public void setNumberWhoDied(int numberWhoDied) {
        this.numberWhoDied = numberWhoDied;
    }

    public void setNewPeople(int newPeople) {
        this.newPeople = newPeople;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public void setHarvestAfterOffering(int harvestAfterOffering) {
        this.harvestAfterOffering = harvestAfterOffering;
    }

    public void setOffering(int offering) {
        this.offering = offering;
    }

    public void setOfferingBushels(int offeringBushels) {
        this.offeringBushels = offeringBushels;
    }

    public void setPeopleFed(int peopleFed) {
        this.peopleFed = peopleFed;
    }

    public void setAcresPlanted(int acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public void setNumStarved(int numStarved) {
        this.numStarved = numStarved;
    }

    public void setEatenByRats(int eatenByRats) {
        this.eatenByRats = eatenByRats;
    }

    public void setWheatForPeople(int wheatForPeople) {
        this.wheatForPeople = wheatForPeople;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.year;
        hash = 67 * hash + this.population;
        hash = 67 * hash + this.acresOwned;
        hash = 67 * hash + this.wheatInStore;
        hash = 67 * hash + this.numberWhoDied;
        hash = 67 * hash + this.newPeople;
        hash = 67 * hash + this.harvest;
        hash = 67 * hash + this.harvestAfterOffering;
        hash = 67 * hash + this.offering;
        hash = 67 * hash + this.offeringBushels;
        hash = 67 * hash + this.peopleFed;
        hash = 67 * hash + this.acresPlanted;
        hash = 67 * hash + this.numStarved;
        hash = 67 * hash + this.eatenByRats;
        hash = 67 * hash + this.wheatForPeople;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CropData other = (CropData) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.population != other.population) {
            return false;
        }
        if (this.acresOwned != other.acresOwned) {
            return false;
        }
        if (this.wheatInStore != other.wheatInStore) {
            return false;
        }
        if (this.numberWhoDied != other.numberWhoDied) {
            return false;
        }
        if (this.newPeople != other.newPeople) {
            return false;
        }
        if (this.harvest != other.harvest) {
            return false;
        }
        if (this.harvestAfterOffering != other.harvestAfterOffering) {
            return false;
        }
        if (this.offering != other.offering) {
            return false;
        }
        if (this.offeringBushels != other.offeringBushels) {
            return false;
        }
        if (this.peopleFed != other.peopleFed) {
            return false;
        }
        if (this.acresPlanted != other.acresPlanted) {
            return false;
        }
        if (this.numStarved != other.numStarved) {
            return false;
        }
        if (this.eatenByRats != other.eatenByRats) {
            return false;
        }
        if (this.wheatForPeople != other.wheatForPeople) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CropData{" + "year=" + year + ", population=" + population + ", acresOwned=" + acresOwned + ", wheatInStore=" + wheatInStore + ", numberWhoDied=" + numberWhoDied + ", newPeople=" + newPeople + ", harvest=" + harvest + ", harvestAfterOffering=" + harvestAfterOffering + ", offering=" + offering + ", offeringBushels=" + offeringBushels + ", peopleFed=" + peopleFed + ", acresPlanted=" + acresPlanted + ", numStarved=" + numStarved + ", eatenByRats=" + eatenByRats + ", wheatForPeople=" + wheatForPeople + '}';
    }
    
}
