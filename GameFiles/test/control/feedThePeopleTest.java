/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Jacob Gallegos
 */
public class feedThePeopleTest {
    
    public feedThePeopleTest() {
    }
    /**
     * Test of feedThePeople should be valid
     * Test 1
     */
    @Test
    public void test1feedThePeople() {
        System.out.println("test1feedThePeople");
        int bushelsToGive = 20;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(40);       
               
        
        int expResult = 20;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
        @Test
    public void test2feedThePeople() {
        System.out.println("test2feedThePeople");
        int bushelsToGive = -5;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(40);       
               
        
        int expResult = -1;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
        @Test
    public void test3feedThePeople() {
        System.out.println("test3feedThePeople");
        int bushelsToGive = 20;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(5);       
               
        
        int expResult = -1;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
        @Test
    public void test4feedThePeople() {
        System.out.println("test4feedThePeople");
        int bushelsToGive = 1;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(10);       
               
        
        int expResult = 9;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
        @Test
    public void test5feedThePeople() {
        System.out.println("test5feedThePeople");
        int bushelsToGive = 100;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(200);       
               
        
        int expResult = 100;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
        @Test
    public void test6feedThePeople() {
        System.out.println("test6feedThePeople");
        int bushelsToGive = 1;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(2);       
               
        
        int expResult = 1;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
        @Test
    public void test7feedThePeople() {
        System.out.println("test7feedThePeople");
        int bushelsToGive = 100;        
        CropData cropData = new CropData();
        cropData.setWheatInStore(1000);       
               
        
        int expResult = 900;
        int result = CropControl.feedThePeople(bushelsToGive, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
}
