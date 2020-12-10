package Manor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KeyLockedDoorIT {
    
    private KeyLockedDoor door1= new KeyLockedDoor();
    
    @Before
    public void setUp() {
        door1.createKey(5);
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testunlock1(){
        door1.unlock(door1.getCurrentKey());
        assertFalse(door1.getIsLocked());
    }
    
    @Test
    public void testunlock2(){
        door1.unlock(null);
        assertTrue(door1.getIsLocked());
    }
   
}
