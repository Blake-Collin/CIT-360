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
public class PlantCropsTest {
    
    public PlantCropsTest() {
    }

    
    /**
     * Test of plantCrops should be valid
     * Test 1
     */
    @Test
    public void testPlantCropsCase1() {
        System.out.println("plantCropsCase1");
        int acresToPlant = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(3000);
        int expResult = 2995;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
           
    /**
     * Failure due to negative acres to plant
     * Test 2
     */
    @Test
    public void testPlantCropsCase2() {
        System.out.println("plantCropsCase2");
        int acresToPlant = -2;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(3000);
        int expResult = -1;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
    
    /**
     * Failure due to not enough acres owned
     * Test 3
     */
    @Test
    public void testPlantCropsCase3() {
        System.out.println("plantCropsCase3");
        int acresToPlant = 25;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(3000);
        int expResult = -1;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
    
    /**
     * Failure due to not enough wheat in store
     * Test 4
     */
    @Test
    public void testPlantCropsCase4() {
        System.out.println("plantCropsCase4");
        int acresToPlant = 20;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(5);
        int expResult = -1;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
    
    /**
     * acres to plant vs acres owned lower
     * Test 5
     */
    @Test
    public void testPlantCropsCase5() {
        System.out.println("plantCropsCase5");
        int acresToPlant = 1;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(3000);
        int expResult = 2999;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
    
    /**
     * acres to plant vs acres owned upper
     * Test 
     */
    @Test
    public void testPlantCropsCase6() {
        System.out.println("plantCropsCase6");
        int acresToPlant = 20;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(3000);
        int expResult = 2990;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
    
    /**
     * enough wheat in store
     * Test 5
     */
    @Test
    public void testPlantCropsCase7() {
        System.out.println("plantCropsCase7");
        int acresToPlant = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(20);
        cropData.setWheatInStore(5);
        int expResult = 0;
        int result = CropControl.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
        
    }
    
}
