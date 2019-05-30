package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.CropControl;
import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danmartin
 */
public class EatenByRatsTest {
    
    public EatenByRatsTest() {
    }

        /**
     * Test1 of eatenByRats method, of class CropControl.
     */
    @Test
    public void test1EatenByRats() {
        System.out.println("eatenByRats");
        CropData cropData = new CropData();
        cropData.setOffering(1);
        cropData.setWheatInStore(1000);
        int randomNum = 30;
        int eatenByRatsPct = 0;
        int expResult = 1000;
        int result = CropControl.eatenByRats(cropData, randomNum, eatenByRatsPct);
        assertEquals(expResult, cropData.getWheatInStore());
        
        System.out.println("Expected: " + expResult + " Result: " + cropData.getWheatInStore());
          
    }
    
          /**
     * Test2 of eatenByRats method, of class CropControl.
     */
    @Test
    public void test2EatenByRats() {
        System.out.println("eatenByRats");
        CropData cropData = new CropData();
        cropData.setOffering(1);
        cropData.setWheatInStore(1000);
        int randomNum = 29;
        int eatenByRatsPct = 8;
        int expResult = 920;
        int result = CropControl.eatenByRats(cropData, randomNum, eatenByRatsPct);
        assertEquals(expResult, cropData.getWheatInStore());
        
        System.out.println("Expected: " + expResult + " Result: " + cropData.getWheatInStore());
          
    }
    
}
