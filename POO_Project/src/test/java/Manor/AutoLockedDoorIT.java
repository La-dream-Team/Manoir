package Manor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AutoLockedDoorIT {
    
    private AutoLockedDoor door1= new AutoLockedDoor();
    private AutoLockedDoor door2= new AutoLockedDoor();

    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDownClass() {
    }
    
    // verif du verou automatique lors de la fermeture de la porte 
    @Test
    public void testclose1(){
        door2.unlock(-1);
        door2.open();
        door2.close();
        assertFalse(door2.getIsOpen());
        assertTrue(door2.getIsLocked());
    }
    
    // close ne dois pas affecter une porte fermé
    @Test
    public void testclose2(){
        door2.unlock(-1);
        door2.close();
        assertFalse(door2.getIsOpen());
        assertFalse(door2.getIsLocked());
    }
   
}
