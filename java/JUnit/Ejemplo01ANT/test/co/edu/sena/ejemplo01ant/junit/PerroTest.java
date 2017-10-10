/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplo01ant.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Enrique
 */
public class PerroTest {
    
    public PerroTest() {
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
     * Test of getColor method, of class Perro.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Perro instance = new Perro();
        String expResult = null;
        String result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Perro.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "";
        Perro instance = new Perro();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        //        fail("The test case is a prototype.");
    }
    
}
