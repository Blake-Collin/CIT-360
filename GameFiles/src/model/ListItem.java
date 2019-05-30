package model;

import java.io.Serializable;
import java.util.Objects;

/*
 * CIT-260
 * Fall 2018
 * Team members: Collin Blake, Jacob Gallegos, Daniel Martin
 */

public class ListItem implements Serializable{
    
    //Variables
    private String name;
    private Integer number;
    
    //Constructors
    public ListItem() 
    {    
    }
    
    public ListItem(String pName, Integer pNumber) 
    {
        setName(pName);
        setNumber(pNumber);
    }
        
    //Functions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.number);
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
        final ListItem other = (ListItem) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListItem{" + "name=" + name + ", number=" + number + '}';
    }    
    
}
