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
    private Key key;
    private Npc testSubject1;
    
    @Before
    public void setUp() {
         room = new Room("couloir");
         door = new KeyLockedDoor(room, 5);
         key = door.getCurrentKey();
         testSubject1 = new Npc("FREDY", 100, room, 35, 1);
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        key.setOwner(null);
        assertFalse(key.hasOwner()); //On teste si le propietaire de l'objet est nul
    }
    
    public void testUse2() { //Cas où on utilise l'object en rentrant un objectif
        testSubject1.addObject(key);
        assertTrue(key.hasOwner()); //On teste si le propietaire de l'objet est nul
        testSubject1.useObject(key.getName(), testSubject1.getName());
        assertEquals(key.getRemainingUses(), 5);
    }
    
    public void testUse3() { //Cas ou l'object marche parfaitement
        testSubject1.addObject(key);
        assertTrue(key.hasOwner()); //On teste si le propietaire de l'objet est nul
        testSubject1.useObject(key.getName(), null);
        assertEquals(key.getRemainingUses(), 4);
        assertTrue(door.getIsOpen());
    }
    
}
