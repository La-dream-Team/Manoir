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

public class MeleeWeaponIT {
    
    private Room room;
    private Player testSubject1;
    private Npc testSubject2;
    private MeleeWeapon excalibur = new MeleeWeapon("EXCALIBUR", 10, "THIS IS THE LEGENDARY SWORD OF THE KING ARTHUR", 50);
    private MeleeWeapon fork = new MeleeWeapon("FORK", 1, "THIS GUN WILL ALLOW YOU TO ONESHOT ONE ENEMY", 4); 
    
    @Before
    public void setUp() {
        room = new Room("couloir");
        testSubject1 = new Player("FREDY", 100, room);
        testSubject2 = new Npc("REMY", 20, room, 47, 0f, 2);
        room.addPerson(testSubject1);
        room.addPerson(testSubject2);
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        fork.setOwner(null);
        assertFalse(fork.hasOwner()); //On teste si le propietaire de l'objet est nul
    }
    
    @Test
    public void testUse2() { //On tente d'utiliser l'arme sur personne
        testSubject1.addObject(fork);
        testSubject1.equipObject(fork.getName());
        testSubject1.useObject(fork.getName(), null);
        assertEquals(fork.getRemainingUses(), 1);  
    }
    
    @Test
    public void testUse3() { //On tente d'utiliser l'arme sur le propietaire
        testSubject1.addObject(excalibur);
        testSubject1.equipObject(excalibur.getName());
        testSubject1.useObject(excalibur.getName(), testSubject1.getName());
        assertEquals(testSubject1.getCurrentHp(), 100);
        assertEquals(excalibur.getRemainingUses(), 10);
    }
    
    @Test
    public void testUse4() { //On utilise une arme qu'on a pas equipée
        testSubject1.addObject(excalibur);
        testSubject1.useObject(excalibur.getName(), testSubject2.getName());
        assertTrue(testSubject2.isAlive());
        assertEquals(excalibur.getRemainingUses(), 10);
    }
    
    @Test
    public void testUse5() { //On utilise l'arme sur l'objectif et on teste si on peut la reutiliser
        testSubject1.addObject(fork);
        testSubject1.equipObject(fork.getName());
        testSubject1.useObject(fork.getName(), testSubject2.getName());
        assertTrue(testSubject2.isAlive());
        assertEquals(testSubject2.getCurrentHp(), 16); //On teste si on a efectue un changement de vie sur l'objectif
        assertFalse(fork.canUse());  
    }
}
