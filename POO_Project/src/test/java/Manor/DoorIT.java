
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
        room1 = new Room("CORRIDOR");
        room2 = new Room("KITCHEN");
        room3 = new Room("LIVING");
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Test
    public void testgetIsOpen(){
        assertFalse(door1.getIsOpen());
        door2.open();
        assertTrue(door2.getIsOpen());
    }
    
    @Test
    public void testgetConnected(){
        room1.addDoor(door1);
        room2.addDoor(door2);
        assertNull(door1.getconnected());
        assertNull(door2.getconnected());
        door2.connectDoors(door1);
        assertSame(door2.getconnected(), door1);
        assertSame(door1.getconnected(), door2);
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
        room1.addDoor(door1);
        
        assertTrue(room1.isOnDoors(door1));
        assertTrue(door1.isOnRooms(room1));
    }
    
    @Test
    public void testaddRoom2(){
        room1.addDoor(door1);
        room2.addDoor(door1);
        
        assertTrue(room2.isOnDoors(door1));
        assertTrue(door1.isOnRooms(room2));
    }
    
    // avec deux portes differents dans chaque pièce 
    @Test
    public void testisContact1(){
        room1.addDoor(door1);
        room2.addDoor(door2);
        door1.connectDoors(door2);
        
        assertTrue(door1.isContact(room1));
        assertTrue(door1.isContact(room2));
        assertTrue(door1.isContact(room1));
        assertTrue(door1.isContact(room2));
        assertFalse(door1.isContact(room3));
        assertFalse(door2.isContact(room3));
    }
    
    @Test
    public void testisContact2(){
        room1.addDoor(door1);
        room2.addDoor(door1);
        
        assertTrue(door1.isContact(room1));
        assertTrue(door1.isContact(room2));
        assertFalse(door2.isContact(room3));
    }
}
