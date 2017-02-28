/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itk.chaabouni.dto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mchaabouni
 */
public class MealTest {
    private final int DEFAULT_ID = 100;
    private final String DEFAULT_NAME = "Pasta";
    private final String DEFAULT_DESCRIPTION = "food";
    private final String DEFAULT_WEEKDAY = "Monday";
    private final Double DEFAULT_PRICE = 4.5;
    private final boolean DEFAULT_VEGETARIAN = true;
  
    
    
    public MealTest() {
    }
 
    /**
     * Test of getName method, of class Meal.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = DEFAULT_NAME;
        Meal instance = new Meal(expResult,
                DEFAULT_DESCRIPTION, DEFAULT_WEEKDAY, DEFAULT_PRICE , 
                DEFAULT_VEGETARIAN);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Meal.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String Name = DEFAULT_NAME;
        Meal instance = new Meal();
        instance.setName(Name);
        assertEquals(Name, instance.getName());        
    }

    /**
     * Test of getDescription method, of class Meal.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = DEFAULT_DESCRIPTION;        
        Meal instance = new Meal(DEFAULT_NAME,
                expResult, DEFAULT_WEEKDAY, DEFAULT_PRICE , 
                DEFAULT_VEGETARIAN);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Meal.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String Description = DEFAULT_DESCRIPTION;
        Meal instance = new Meal();
        instance.setDescription(Description);
        assertEquals(Description, instance.getDescription());
    }

    /**
     * Test of getPrice method, of class Meal.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Double expResult = null;
        Meal instance = new Meal(DEFAULT_NAME,
                DEFAULT_DESCRIPTION, DEFAULT_WEEKDAY, expResult , 
                DEFAULT_VEGETARIAN);
        Double result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Meal.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        Double price = null;
        Meal instance = new Meal();
        instance.setPrice(price);
        assertEquals(price, instance.getPrice());
    }

    /**
     * Test of isVegetarian method, of class Meal.
     */
    @Test
    public void testIsVegetarian() {
        System.out.println("isVegetarian");
        boolean expResult = false;
        Meal instance = new Meal(DEFAULT_NAME,
                DEFAULT_DESCRIPTION, DEFAULT_WEEKDAY, DEFAULT_PRICE , 
                expResult);
        boolean result = instance.isVegetarian();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVegetarian method, of class Meal.
     */
    @Test
    public void testSetVegetarian() {
        System.out.println("setVegetarian");
        boolean vegetarian = false;
        Meal instance = new Meal();
        instance.setVegetarian(vegetarian);
        assertEquals(vegetarian, instance.isVegetarian());
    }
    
}
