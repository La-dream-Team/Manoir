/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KeyIT {
    private Room room;
    private KeyLockedDoor door; 
    
    @Before
    public void setUp() {
         room = new Room("couloir");
         door = new KeyLockedDoor(room, 5);    
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testUse() {
        
    }
    
}
