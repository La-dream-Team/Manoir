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
public class RoomIT {
    
    public RoomIT() {
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
     * Test of isOnDoors method, of class Room.
     */
    @Test
    public void testIsOnDoors() {
        System.out.println("isOnDoors");
        Door d = null;
        Room instance = new Room();
        boolean expResult = false;
        boolean result = instance.isOnDoors(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDoor method, of class Room.
     */
    @Test
    public void testAddDoor() {
        System.out.println("addDoor");
        Door d = null;
        Room instance = new Room();
        instance.addDoor(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDoor method, of class Room.
     */
    @Test
    public void testRemoveDoor() {
        System.out.println("removeDoor");
        Door d = null;
        Room instance = new Room();
        instance.removeDoor(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
