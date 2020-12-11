package manorTest;


import door.DoorWithLock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author thibault
 */
public class DoorWithLockIT {
    private DoorWithLock door1= new DoorWithLock();
    private DoorWithLock door2= new DoorWithLock();

    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Test
    public void testlock(){
        door1.lock();
        assertTrue(door1.getIsLocked());
        door1.lock();
        assertTrue(door1.getIsLocked());
    }
    
    @Test
    public void testunlock(){
        door1.unlock(-1);
        assertFalse(door1.getIsLocked());
        door1.unlock(-1);
        assertFalse(door1.getIsLocked());
    }
    
    @Test
    public void testopen1(){
        door1.unlock(-1);
        door1.open();
        assertTrue(door1.getIsOpen());
    }
    
    @Test
    public void testopen2(){
        door1.lock();
        door1.open();
        assertFalse(door1.getIsOpen());
    }
    
    @Test
    public void testclose1(){
        door1.unlock(-1);
        door1.open();
        door1.close();
        assertFalse(door1.getIsOpen());
    }
    
    @Test
    public void testclose2(){
        door1.unlock(-1);
        door1.open();
        door1.lock();
        door1.close();
        assertTrue(door1.getIsOpen());
    }

}
