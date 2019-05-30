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
 * @author Collin Blake
 */
public class SetOfferingTest {
    
    public SetOfferingTest() {
        
    }

    /**
     * valid test for 50%
     * Test 1
     */
    @Test
    public void testSetOfferingCase1() {
        System.out.println("setOfferingCase1");
        int offeringPrecentage = 50;
        CropData cropData = new CropData();
        int expResult = 50;        
        int result = CropControl.setOffering(offeringPrecentage, cropData);
        assertEquals(expResult, result);
        System.out.println("Expceted: " + expResult + " Result: " + result);               
    }
    
    /**
     * Failure case negative number
     * Test 2
     */
    @Test
    public void testSetOfferingCase2() {
        System.out.println("setOfferingCase2");
        int offeringPrecentage = -5;
        CropData cropData = new CropData();
        int expResult = -1;        
        int result = CropControl.setOffering(offeringPrecentage, cropData);
        assertEquals(expResult, result);
        System.out.println("Expceted: " + expResult + " Result: " + result);               
    }
    
    /**
     * Failure case over 100
     * Test 3
     */
    @Test
    public void testSetOfferingCase3() {
        System.out.println("setOfferingCase3");
        int offeringPrecentage = 105;
        CropData cropData = new CropData();
        int expResult = -1;        
        int result = CropControl.setOffering(offeringPrecentage, cropData);
        assertEquals(expResult, result);
        System.out.println("Expceted: " + expResult + " Result: " + result);               
    }
    
    /**
     * Boundary Case: 0 Lowest Value possible
     * Test 4
     */
    @Test
    public void testSetOfferingCase4() {
        System.out.println("setOfferingCase4");
        int offeringPrecentage = 0;
        CropData cropData = new CropData();
        int expResult = 0;        
        int result = CropControl.setOffering(offeringPrecentage, cropData);
        assertEquals(expResult, result);
        System.out.println("Expceted: " + expResult + " Result: " + result);               
    }
    
    /**
     * Boundary Case: 100 Max Value Possible
     * Test 5
     */
    @Test
    public void testSetOfferingCase5() {
        System.out.println("setOfferingCase5");
        int offeringPrecentage = 100;
        CropData cropData = new CropData();
        int expResult = 100;        
        int result = CropControl.setOffering(offeringPrecentage, cropData);
        assertEquals(expResult, result);
        System.out.println("Expceted: " + expResult + " Result: " + result);               
    }
    
}
