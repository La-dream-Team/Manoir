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
    private Npc testSubject1;
    private Charger chargerAK47 = new Charger("AK-47 Charger", "THIS CHARGER ALLOWS YOU TO RELOAD THE GUN NAMED AK-47");
    
    @Before
    public void setUp() {
        room = new Room("couloir");
        testSubject1 = new Npc("FREDY", 100, room, 35, 0f, 1);
        testSubject1.addObject(chargerAK47);
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
    public void testUse2() { //Cas ou l'object n'est pas null
        assertTrue(chargerAK47.hasOwner()); //On teste si le propietaire de l'objet est nul
        chargerAK47.use(testSubject1);
        assertTrue(chargerAK47.canUse()); //On teste si on peut le reutiliser
    }
    
    @Test
    public void testUse3() { //Cas ou on utilise l'object
        assertTrue(chargerAK47.hasOwner()); //On teste si le propietaire de l'objet est nul
        chargerAK47.use(null);
        assertFalse(chargerAK47.canUse()); //On teste si on ne peut pas le reutiliser
        assertFalse(chargerAK47.getOwner().hasObject(chargerAK47.getName())); //On teste si le propietaire il n'a plus l'object
    }
}
