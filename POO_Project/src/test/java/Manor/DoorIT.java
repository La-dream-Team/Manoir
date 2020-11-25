/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thibault
 */
public class DoorIT {
    
    public DoorIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addRoom method, of class Door.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        Room r = null;
        Door instance = null;
        instance.addRoom(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of open method, of class Door.
     */
    @Test
    public void testOpen() {
        System.out.println("open");
        Door instance = null;
        instance.open();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Door.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Door instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Door.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Door instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsOpen method, of class Door.
     */
    @Test
    public void testGetIsOpen() {
        System.out.println("getIsOpen");
        Door instance = null;
        boolean expResult = false;
        boolean result = instance.getIsOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumber method, of class Door.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Door instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOnRooms method, of class Door.
     */
    @Test
    public void testIsOnRooms() {
        System.out.println("isOnRooms");
        Room r = null;
        Door instance = null;
        boolean expResult = false;
        boolean result = instance.isOnRooms(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
