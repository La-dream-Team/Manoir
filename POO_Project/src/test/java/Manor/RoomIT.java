package Manor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class RoomIT {
    
    private Room room1;
    private Room room2;
    private Room room3;
    private Door door1;
    private Door door2;
    private Player player;
    private Npc npc;
    private Corpse corpse1;
    private Corpse corpse2;
    private Collectable collec1;
    private Collectable collec2;
    
    
    @Before
    public void setUp() {
        door1= new Door();
        door2= new Door();
        room1 = new Room("KITCHEN");
        room2 = new Room("CORRIDOR");
        room3 = new Room("LIVING");
        player = new Player("BOBY", 100, room1);
        npc = new Npc("BAD", 100, room1, 150, 1f, 1);
        corpse1 = new Corpse("P1", "EMPTY");
        corpse2 = new Corpse("P2", "EMPTY");
        collec1 = new Collectable("PAPER1", 10, "THIS IS A PAPER", "HELLO");
        collec2 = new Collectable("PAPER2", 10, "THIS IS A PAPER", "HELLO");
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Test
    public void testGetName(){
        assertSame(room1.getName(), "KITCHEN");
    }
    
    @Test
    public void testisOnDoors(){
        room1.addDoor(door1);
        
        assertTrue(room1.isOnDoors(door1));
        assertFalse(room1.isOnDoors(door2));
    }
    
    
   @Test
    public void testgetDoors1(){
        ArrayList<Door> list = room1.getDoors();
        
        assertSame(list.size(), 0);
    }
    
    @Test
    public void testgetDoors2(){
        room1.addDoor(door1);
        ArrayList<Door> list = room1.getDoors();
        
        assertSame(list.size(), 1);
        assertSame(list.get(0), door1);
    }
    
    @Test
    public void testremoveDoor(){
        room1.addDoor(door1);
        room1.removeDoor(door1);
        
        assertFalse(room1.isOnDoors(door1));
        room1.removeDoor(door1);
        assertFalse(room1.isOnDoors(door1));
    }
    
    @Test
    public void testisOnPersons(){
        room1.addPerson(player);
        
        assertTrue(room1.isOnPersons(player.getName()));
        assertFalse(room1.isOnPersons(npc.getName()));
    }
    
    @Test
    public void testgetPerson(){
        room1.addPerson(player);
        
        assertSame(room1.getPerson(player.getName()).getName(), player.getName());
        assertSame(room1.getPerson(npc.getName()), null);
    }
    
    @Test
    public void testgetPersons1(){
        ArrayList<Door> list = room1.getDoors();
        
        assertSame(list.size(), 0);
    }
    
    @Test
    public void testgetPersons2(){
        room1.addPerson(player);
        ArrayList<Person> list = room1.getPersons();
        
        assertSame(list.size(), 1);
        assertSame(list.get(0).getName(), player.getName());
    }
    
    @Test
    public void testremovePerson(){
        room1.addPerson(player);
        room1.removePerson(player.getName());
        
        assertFalse(room1.isOnPersons(player.getName()));
        assertSame(player.getRoom(), null);
    }
    
    @Test
    public void testaddObjectANDisOnObjects(){
        room1.addObject(collec1);
        
        assertTrue(room1.isOnObjects(collec1));
        assertFalse(room1.isOnObjects(collec2));
    }
    
    
    
    @Test
    public void testremoveObject(){
        room1.addObject(collec1);
        room1.removeObject(collec1);
        
        assertFalse(room1.isOnObjects(collec1));
    }
    
    @Test
    public void testaddCorpseANDisOnCorpse(){
        room1.addCorpse(corpse1);
        
        assertTrue(room1.isOnCorpse(corpse1));
        assertFalse(room1.isOnCorpse(corpse2));
    }
    
    @Test
    public void testisNextRoom(){
        room1.addDoor(door1);
        room2.addDoor(door1);
        
        assertSame(room1.isNextRoom(room2).getID(), door1.getID());
        assertSame(room1.isNextRoom(room3), null);
    }
    
    @Test
    public void teststringToObject(){
        room1.addObject(collec1);
        
        assertSame(room1.stringToObject(collec1.getName()).getName(), collec1.getName());
        assertSame(room1.stringToObject(collec2.getName()), null);
    }
    
    @Test
    public void testswitchModeForAll(){
        room1.addPerson(npc);
        
        assertFalse(((Npc) npc).getAggressive());
        
        room1.switchModeForAll();
        
        assertTrue(((Npc) npc).getAggressive());
    }
    
    @Test
    public void testgiveMeDoor(){
        room1.addDoor(door1);
        
        assertSame(room1.giveMeDoor(door1.getID()).getID(), door1.getID());
        assertSame(room1.giveMeDoor(door2.getID()), null);
    }
}
