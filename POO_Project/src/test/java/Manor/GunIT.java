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

public class GunIT {
    private Room room;
    private Npc testSubject1;
    private Npc testSubject2;
    private Charger chargerAK47; 
    private Gun AK47 = new Gun("AK-47", 10, 20, "THIS GUN WILL ALLOW YOU TO KILL YOUR ENEMIES WITHIN A FEW SECONDS", 50);
    private Gun goldGun = new Gun("Gold Gun", 1, 9999, "THIS GUN WILL ALLOW YOU TO ONESHOT ONE ENEMY", 1);
    
    
    @Before
    public void setUp() {
        room = new Room("couloir");
        testSubject1 = new Npc("FREDY", 100, room, 35, 1);
        testSubject2 = new Npc("REMY", 20, room, 47, 2);
        testSubject2.addObject(AK47);
        chargerAK47 = new Charger("AK-47 Charger", "THIS CHARGER ALLOWS YOU TO RELOAD THE GUN NAMED AK-47");
        testSubject2.addObject(chargerAK47);
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        AK47.setOwner(null);
        assertFalse(AK47.hasOwner()); //On teste si le propietaire de l'objet est nul
    }
    
    @Test
    public void testUse2() { //On tente d'utiliser l'arme sur personne
        testSubject1.addObject(AK47);
        testSubject1.addObject(chargerAK47);
        testSubject1.useObject(AK47.getName(), null);
        assertEquals(AK47.getCurrentBullets(), AK47.getChargerCapacity());  
    }
    
    @Test
    public void testUse3() { //On tente d'utiliser l'arme sur le propietaire
        testSubject1.addObject(AK47);
        testSubject1.addObject(chargerAK47);
        testSubject1.useObject(AK47.getName(), testSubject1.getName());
        assertEquals(testSubject1.getCurrentHp(), 100);
        assertEquals(AK47.getCurrentBullets(), 45);  
    }
    
    @Test
    public void testUse4() { //On tente d'utiliser l'arme sur le propietaire et on teste si on peut la reutiliser
        testSubject2.addObject(goldGun);
        testSubject2.useObject(goldGun.getName(), testSubject1.getName());
        assertFalse(testSubject1.isAlive());
        assertEquals(goldGun.getCurrentBullets(), 0);;  
        assertFalse(goldGun.getOwner().hasObject(goldGun.getName())); //On teste si le propietaire il n'a plus l'object
    }
    
    @Test
    public void test5withReload() { //On teste le cas completement fonctionel de l'arme et on la recharge
        testSubject2.addObject(AK47);
        testSubject2.addObject(chargerAK47);
        testSubject2.useObject(AK47.getName(), testSubject1.getName());
        assertFalse(testSubject1.isAlive());
        assertEquals(AK47.getCurrentBullets(), 45);
        testSubject2.useObject(chargerAK47.getName(), null);
        assertEquals(AK47.getCurrentBullets(), AK47.getChargerCapacity());  
    }
}
