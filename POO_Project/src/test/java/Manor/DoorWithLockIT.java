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
public class DoorWithLockIT {
    
    public DoorWithLockIT() {
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
     * Test of unlock method, of class DoorWithLock.
     */
    @Test
    public void testUnlock() {
        System.out.println("unlock");
        DoorWithLock instance = null;
        instance.unlock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lock method, of class DoorWithLock.
     */
    @Test
    public void testLock() {
        System.out.println("lock");
        DoorWithLock instance = null;
        instance.lock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of open method, of class DoorWithLock.
     */
    @Test
    public void testOpen() {
        System.out.println("open");
        DoorWithLock instance = null;
        instance.open();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DoorWithLock.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        DoorWithLock instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsLocked method, of class DoorWithLock.
     */
    @Test
    public void testGetIsLocked() {
        System.out.println("getIsLocked");
        DoorWithLock instance = null;
        boolean expResult = false;
        boolean result = instance.getIsLocked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class DoorWithLock.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        DoorWithLock instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
