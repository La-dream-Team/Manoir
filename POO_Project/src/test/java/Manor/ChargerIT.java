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

public class ChargerIT {
    private Room room;
    private Player testSubject1;
    private Npc testSubject2;
    private Gun AK47 = new Gun("AK-47", 10, "THIS GUN WILL ALLOW YOU TO KILL YOUR ENEMIES WITHIN A FEW SECONDS", 20, 50);
    private Charger chargerAK47 = new Charger("AK-47 Charger", "THIS CHARGER ALLOWS YOU TO RELOAD THE GUN NAMED AK-47");
    
    @Before
    public void setUp() {
        room = new Room("couloir");
        testSubject1 = new Player("FREDY", 100, room);
        testSubject2 = new Npc("REMY", 20, room, 47, 0f, 2);
        room.addPerson(testSubject1);
        room.addPerson(testSubject2);
        testSubject1.addObject(AK47);
        testSubject1.addObject(chargerAK47);
        testSubject1.equipObject(AK47.getName());
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        chargerAK47.setOwner(null);
        assertFalse(chargerAK47.hasOwner()); //On teste si le propietaire de l'objet est nul
    }
    
    @Test
    public void testUse2() { //Cas ou l'objectif n'est pas null
        assertTrue(chargerAK47.hasOwner()); //On teste si le propietaire de l'objet est nul
        testSubject1.useObject(chargerAK47.getName(), testSubject2.getName());
        assertTrue(chargerAK47.canUse()); //On teste si on peut le reutiliser
    }
    
    @Test
    public void testUse3() { //Cas ou on utilise l'object
        assertTrue(chargerAK47.hasOwner()); //On teste si le propietaire de l'objet est nul
        testSubject1.useObject(AK47.getName(), testSubject2.getName());
        assertFalse(testSubject2.isAlive());
        assertEquals(AK47.getCurrentBullets(), 49);
        testSubject1.useObject(chargerAK47.getName(), null);
        assertEquals(AK47.getCurrentBullets(), 50);
        assertFalse(chargerAK47.canUse()); //On teste si on ne peut pas le reutiliser
        assertFalse(testSubject1.hasObject(chargerAK47.getName())); //On teste si le propietaire il n'a plus l'object
    }
}
