package model;

import java.io.Serializable;
import java.util.Objects;

/*
 * CIT-260
 * Fall 2018
 * Team members: Collin Blake, Jacob Gallegos, Daniel Martin
 */

public class Player implements Serializable {

    //Variables
    private String name;
    private int row;
    private int column;
    
    //constructor
    public Player(){}
    
    //Functions
    public void setName(String pName)
    {
        name = pName;
    }    
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    
}
