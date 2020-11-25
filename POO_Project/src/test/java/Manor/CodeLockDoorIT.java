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
public class CodeLockDoorIT {
    
    public CodeLockDoorIT() {
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
     * Test of unlock method, of class CodeLockDoor.
     */
    @Test
    public void testUnlock_0args() {
        System.out.println("unlock");
        CodeLockDoor instance = null;
        instance.unlock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unlock method, of class CodeLockDoor.
     */
    @Test
    public void testUnlock_int() {
        System.out.println("unlock");
        int pass = 0;
        CodeLockDoor instance = null;
        instance.unlock(pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class CodeLockDoor.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        CodeLockDoor instance = null;
        int expResult = 0;
        int result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class CodeLockDoor.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        CodeLockDoor instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
