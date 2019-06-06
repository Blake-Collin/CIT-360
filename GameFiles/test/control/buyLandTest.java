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
 * @author Jacob Gallegos, Blake Collin, Daniel Martin
 */
public class buyLandTest {
    
    public buyLandTest() {
    }
    /**
     * Test of buyland should be valid
     * Test 1
     */
    @Test
    public void test1BuyLandCase1() {
        System.out.println("buyLandCase1");
        int landPrice = 20;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = 2010;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Failure due to negative acres to buy
     * Test 2
     */
    @Test
    public void test1BuyLandCase2() {
        System.out.println("buyLandCase2");
        int landPrice = 20;
        int acresToBuy = -5;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Failure due to not enough population
     * Test 3
     */
    @Test
    public void test1BuyLandCase3() {
        System.out.println("buyLandCase3");
        int landPrice = 20;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(200);
        cropData.setWheatInStore(3000);       
        
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Failure due to not a too low a landprice
     * Test 4
     */
    @Test
    public void test1BuyLandCase4() {
        System.out.println("buyLandCase4");
        int landPrice = 15;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Failure to too high a land price
     * Test 5
     */
    @Test
    public void test1BuyLandCase5() {
        System.out.println("buyLandCase5");
        int landPrice = 28;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Not enough wheat failure
     * Test 6
     */
    @Test
    public void test1BuyLandCase6() {
        System.out.println("buyLandCase6");
        int landPrice = 20;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(15);       
        
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Boundary Lowest land price
     * Test 7
     */
    @Test
    public void test1BuyLandCase7() {
        System.out.println("buyLandCase7");
        int landPrice = 17;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = 2010;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Boundary highest value 27
     * Test 8
     */
    @Test
    public void test1BuyLandCase8() {
        System.out.println("buyLandCase8");
        int landPrice = 27;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = 2010;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Boundary acres to buy lowest
     * Test 9
     */
    @Test
    public void test1BuyLandCase9() {
        System.out.println("buyLandCase9");
        int landPrice = 20;
        int acresToBuy = 0;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(3000);       
        
        int expResult = 2000;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
    /**
     * Boundary acres to buy upper wheat in store
     * Test 10
     */
    @Test
    public void test1BuyLandCase10() {
        System.out.println("buyLandCase10");
        int landPrice = 20;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(208);
        cropData.setWheatInStore(200);       
        
        int expResult = 2010;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
    
     /**
     * Boundary total population at closest ratio 
     * Test 11
     */
    @Test
    public void test1BuyLandCase11() {
        System.out.println("buyLandCase11");
        int landPrice = 20;
        int acresToBuy = 10;
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setPopulation(201);
        cropData.setWheatInStore(3000);       
        
        int expResult = 2010;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + " Result: " + result);
    }
}
