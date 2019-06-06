/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danmartin
 */
public class HarvestWheatTest {
    
    public HarvestWheatTest() {
    }

       /**
     * Test of wheatHarvested method, of class CropControl.
     */
    @Test
    public void testWheatHarvested() {
        System.out.println("wheatHarvested");
        CropData cropData = new CropData();
        cropData.setWheatInStore(1000);
        cropData.setOffering(1);
        cropData.setAcresPlanted(5);
        
        
        int expResult = 10;
        int result = CropControl.wheatHarvested(cropData, 2);
        assertEquals(expResult, result);
        
        System.out.println("Expected: " + expResult + " Result: " + result);
      
    }
    
     /**
     * Test 2 of wheatHarvested method, of class CropControl.
     */
    @Test
    public void testWheatHarvestedCase2() {
        System.out.println("wheatHarvested");
        CropData cropData = new CropData();
        cropData.setWheatInStore(1000);
        cropData.setOffering(7);
        cropData.setAcresPlanted(5);        
        
        int expResult = 10;
        int result = CropControl.wheatHarvested(cropData, 2);
        assertEquals(expResult, result);
        
        System.out.println("Expected: " + expResult + " Result: " + result);
      
    }

 
}
