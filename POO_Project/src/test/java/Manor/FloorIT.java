package Manor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FloorIT {
    
    private Floor floor1;
    private Floor floor2;
    private Room room1;
    private Room room2;
    
    @Before
    public void setUp() {
        floor1= new Floor("BASEMENT");
        floor2= new Floor("FIRST-FLOOR");
        room1 = new Room("KITCHEN");
        room2 = new Room("CORRIDOR");
        
       
        floor1.addRoom(room1);
        floor2.addRoom(room2);
    }
    
    @After
    public void tearDownClass() {
    }
    
    // verif du verou automatique lors de la fermeture de la porte 
    @Test
    public void testisOnRooms(){
        assertTrue(floor1.isOnRooms(room1));
        assertFalse(floor1.isOnRooms(room2));
    }
    
    // close ne dois pas affecter une porte fermé
    @Test
    public void testisgetRoom(){
        assertSame(floor1.getRoom(room1.getName()).getName(), room1.getName());
        assertSame(floor1.getRoom(room2.getName()), null);
    }
}
