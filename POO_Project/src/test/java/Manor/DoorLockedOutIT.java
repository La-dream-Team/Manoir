
package Manor;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


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
