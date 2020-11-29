
package Manor;

import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DoorIT {
    
    private Room room1;
    private Room room2; 
    private Room room3; 
    private Door door1;
    private Door door2;
    private Door door3;
    
    @Before
    public static void setUpClass() {
        room1 = new Room("couloir");
        room2 = new Room("cuisine");
        room3 = new Room("salon");
        s
        door1 = new Door();
        door2 = new Door();
        door3 = new Door();
    }
    
    @After
    public void tearDown() {
    }
    
    @test
    public void testgetID() {
        assertSame(door1.getID(), 0);
        assertSame(door2.getID(), 1);
        assertSame(door3.getID(), 2);
    }
    
    
}
