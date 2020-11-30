
package Manor;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DoorIT {
    
    private Room room1;
    private Room room2; 
    private Room room3; 
    private Door door1= new Door();
    private Door door2= new Door();
    private Door door3= new Door();

    
    @Before
    public void setUp() {
        room1 = new Room("couloir");
        room2 = new Room("cuisine");
        room3 = new Room("salon");
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Test
    public void testgetIsOpen(){
        assertSame(door1.getIsOpen(), false);
        door2.open();
        assertSame(door2.getIsOpen(), true);
    }
    
    @Test
    public void testopen(){
        door2.open();
        assertTrue(door2.getIsOpen());
        door2.open();
        assertTrue(door2.getIsOpen());
    }
    
    @Test
    public void testclose(){
        door2.close();
        assertFalse(door2.getIsOpen());
        door2.close();
        assertFalse(door2.getIsOpen());
    }
    
    @Test
    public void testconnectDoors1(){
        door2.connectDoors(door1);
        assertSame(door2.getconnected(), door1);
        assertSame(door1.getconnected(), door2);
    }
    
    @Test
    public void testconnectDoors2(){
        door2.connectDoors(door1);
        door2.connectDoors(door3);
        assertSame(door2.getconnected(), door3);
        assertSame(door3.getconnected(), door2);
        assertNull(door1.getconnected());
    }
    
    @Test
    public void testremoveConnected(){
        door2.connectDoors(door1);
        door2.removeConnected();
        assertNull(door2.getconnected());
        assertNull(door1.getconnected());
    }
    
    @Test
    public void testaddRoom1(){
        door1.addRoom(room1);
        
        assertTrue(room1.isOnDoors(door1));
        assertTrue(door1.isOnRooms(room1));
    }
    
    @Test
    public void testaddRoom2(){
        door1.addRoom(room1);
        door1.addRoom(room2);
        
        assertTrue(room2.isOnDoors(door1));
        assertTrue(door1.isOnRooms(room2));
    }
}
