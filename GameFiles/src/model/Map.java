package model;

import java.io.Serializable;

/**
 * @Class CIT260
 * @Brother Wright
 * @author Collin Blake
 */
public class Map implements Serializable{
    
    private int rowCount;
    private int colCount;
    private Location[][] locations;
    
    /**
     * default Map Constructor
     * Purpose: Set Data members to default values
     * Parameters: None
     * Returns: None
     */
    public Map(){};
    
    /**
     * parameterized Map Constructor
     * Purpose: Sets row and column values
     *  and creates an array of Location objects
     * Parameters: row count and column count
     * Returns: none
     */
    public Map(int pRows, int pCols) 
    {
        this.rowCount = pRows;
        this.colCount = pCols;
        
        //create the array of location objects
        this.locations = new Location[pRows][pCols];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }
    
    /**
     * the getLocation Method
     * Purpose: returns the location object  at the given row and column
     * Parameters: a row and column
     * Returns: a location object
     */
    public Location getLocation(int row, int col)
    {
        return this.locations[row][col];
    }
    
    /**
     * the setLocation method
     * Purpose: stores a location object at the row and column
     * Parameters: a row and column, and a reference to location object
     * Returns: void
     */
    public void setLocation(int row, int col, Location pLocation)
    {
        this.locations[row][col] = pLocation;
    }
}
