/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;


import Doors.DoorLockedOut;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thibault
 */
public class DoorLockedOutIT {
    
    
    private DoorLockedOut door1= new DoorLockedOut();

    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Test
    public void testopen(){
        door1.open();
        assertFalse(door1.getIsOpen());
    }

}
