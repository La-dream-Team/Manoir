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

public class ConsumableIT {
    
    private Npc testSubject1;
    private Npc testSubject2;
    private Npc testSubject3;
    private Room room;
    private Consumable healingPotion = new Consumable("GRANDMA'S COOKIES", "THOSE COOKIES WERE MADE WITH LOVE BY ONE OF THE MANOR RESIDENTS GRANDMA", 20);
    private Consumable hurtingPotion = new Consumable("MOLOTOV COCKTAIL", "THIS IS NOT VERY SAFE TO DRINK, I RECOMMEND YOU TO USE IT AGAINST YOUR ENEMIES", -35);
    
    
    @Before
    public void setUp() {
        room = new Room("couloir");
        testSubject1 = new Npc("FREDY", 100, room, 35, 0f, 1);
        testSubject2 = new Npc("REMY", 20, room, 47, 0f, 2);
    }
    
    @After
    public void tearDownClass() {
    }

    /**
     * Test of use method, of class Consumable.
     */
        
    @Test 
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        hurtingPotion.setOwner(null);
        assertFalse(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet est nul
    }    
        
    @Test
    public void testUse2() { //Cas pour faire des degats a une personne 
        testSubject2.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(testSubject1);
        assertFalse(hurtingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(hurtingPotion.getOwner().hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject1.getCurrentHp(), 65); //On verifie le changement de vie de l'objectif
    }
    
    @Test
    public void testUse3() { //Cas pour donner de la vie a une personne avec toutes ses hp 
        testSubject2.addObject(healingPotion);
        assertTrue(healingPotion.hasOwner());  //On teste si le propietaire de l'objet n'est pas nul
        healingPotion.use(testSubject1);
        assertFalse(healingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(healingPotion.getOwner().hasObject(healingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject1.getCurrentHp(), 100); //On verifie qui n'a pas eu de changement de vie sur l'objectif  
    }
        
    @Test 
    public void testUse4() { //Cas pour faire des degats a une personne avec moins de hp que le degats qu'on le fait 
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(testSubject2);
        assertFalse(hurtingPotion.canUse()); //On teste si on ne peut pas le reutiliser
        assertFalse(hurtingPotion.getOwner().hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject2.getCurrentHp(), 0); //On verifie le changement de vie de l'objectif
    } 
    
    @Test 
    public void testUse5() {  //Cas pour donner de la vie a une personne  
        testSubject1.addObject(healingPotion);
        assertTrue(healingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        healingPotion.use(testSubject2);
        assertFalse(healingPotion.canUse()); //On teste si on ne peut pas le reutiliser
        assertFalse(healingPotion.getOwner().hasObject(healingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject2.getCurrentHp(), 40); //On verifie le changement de vie de l'objectif 
    }
    
    @Test 
    public void testUse8() { //Cas pour enlever de la vie au propietaire du consomable
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(null);
        assertFalse(hurtingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertFalse(hurtingPotion.getOwner().hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject1.getCurrentHp(), 65); //On verifie le changement de vie de l'objectif
    }
    
    @Test 
    public void testUse9() { //Cas pour donner de la vie au propietaire du consomable
        testSubject2.addObject(healingPotion);
        assertTrue(healingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        healingPotion.use(null);
        assertFalse(healingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertFalse(healingPotion.getOwner().hasObject(healingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject2.getCurrentHp(), 40); //On verifie le changement de vie de l'objectif
    }
    
    public void testUse10() { //Cas pour utiliser l'object en rentrant comme objective le propietaire
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(testSubject1);
        assertTrue(hurtingPotion.canUse()); //On teste si on peut le reutiliser
        assertFalse(hurtingPotion.getOwner().hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
    }
    
}
