/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itk.chaabouni.dto;

import java.util.ArrayList;
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
public class MenuTest {
    
    private static final String DEFAULT_DAY = "Monday"; 
    private static final Meal DEFAULT_MEAL1 = new Meal() ; 
    private static final Meal DEFAULT_MEAL2 = new Meal(); 
    
    public MenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDay method, of class Menu.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        String expResult = DEFAULT_DAY;
        Menu instance = new Menu(expResult, DEFAULT_MEAL1, DEFAULT_MEAL2);
        String result = instance.getWeekDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDay method, of class Menu.
     */
    @Test
    public void testSetDay() {
        System.out.println("setDay");
        String day = DEFAULT_DAY;
        Menu instance = new Menu();
        instance.setWeekDay(day);
        assertEquals(instance.getWeekDay(), day);
    }

    /**
     * Test of getMeal1 method, of class Menu.
     */
    @Test
    public void testGetMeal1() {
        System.out.println("getMeal1");
        Meal expResult =  DEFAULT_MEAL1;
        Menu instance = new Menu(DEFAULT_DAY, expResult, DEFAULT_MEAL2);
        Meal result = instance.getMeal1();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeal1 method, of class Menu.
     */
    @Test
    public void testSetMeal1() {
        System.out.println("setMeal1");
        Meal meal1 = null;
        Menu instance = new Menu();
        instance.setMeal1(meal1);
        assertEquals(instance.getMeal1(), meal1);
    }

    /**
     * Test of getMeal2 method, of class Menu.
     */
    @Test
    public void testGetMeal2() {
        System.out.println("getMeal2");
        Meal expResult = DEFAULT_MEAL2;
        Menu instance = new Menu(DEFAULT_DAY, DEFAULT_MEAL1, expResult);
        Meal result = instance.getMeal2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeal2 method, of class Menu.
     */
    @Test
    public void testSetMeal2() {
        System.out.println("setMeal2");
        Meal meal2 = null;
        Menu instance = new Menu();
        instance.setMeal2(meal2);
        assertEquals(instance.getMeal2(), meal2);
    }

    /**
     * Test of getMeals method, of class Menu.
     */
    @Test
    public void testGetMeals() {
        System.out.println("getMeals");
        Menu instance = new Menu(DEFAULT_DAY, DEFAULT_MEAL1, DEFAULT_MEAL2);
        ArrayList<Meal> result = instance.getMeals();
        assertFalse(result.isEmpty());
        assertTrue(result.size()==2);
    }
    
}
