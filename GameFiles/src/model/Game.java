package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/*
 * CIT-260
 * Fall 2018
 * Team members: Collin Blake, Jacob Gallegos, Daniel Martin
 */

public class Game implements Serializable {

    //Variables
    Player player;
    CropData cropData;
    Map map;
    ArrayList<ListItem> animals;
    ArrayList<ListItem> tools;
    ArrayList<ListItem> provisions;

    
    //Functions
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player thePlayer) {
        this.player = thePlayer;
    }

    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map pMap) {
        this.map = pMap;
    }

    public ArrayList<ListItem> getAnimals() {
        return animals;
    }

    public ArrayList<ListItem> getTools() {
        return tools;
    }

    public ArrayList<ListItem> getProvisions() {
        return provisions;
    }

    public void setAnimals(ArrayList<ListItem> animals) {
        this.animals = animals;
    }

    public void setTools(ArrayList<ListItem> tools) {
        this.tools = tools;
    }

    public void setProvisions(ArrayList<ListItem> provisions) {
        this.provisions = provisions;
    }
    
    
    
}
