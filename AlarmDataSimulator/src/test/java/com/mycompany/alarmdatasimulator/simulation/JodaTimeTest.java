/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.simulation;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tiago
 */
public class JodaTimeTest {
    
    public JodaTimeTest() {
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
     * Test of simulate method, of class SimulationCore.
     */
    @Test
    public void testIncrementTime() {
        String format = "dd-MM-yyyy HH:mm:ss.SSS";
        DateTime date = new DateTime(2010, 05, 05, 23, 59, 50);
        DateTime plused = date.plusSeconds(20);
        System.out.println(date.toString(format));
        System.out.println(plused.toString(format));
    }


    
}
