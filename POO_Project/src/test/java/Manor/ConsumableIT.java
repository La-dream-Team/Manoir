/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thibault
 */
public class ConsumableIT {
    
    public ConsumableIT() {
        private Npc testSubject1;
        private Npc testSubject2;
        private Npc testSubject3;
        private Npc testSubject4;
        private Consumable healingPotion = new Consumable("GRANDMA'S COOKIES", "THOSE COOKIES WERE MADE WITH LOVE BY ONE OF THE MANOR RESIDENTS GRANDMA", 20);
        private Consumable hurtingPotion = new Consumable("MOLOTOV COCKTAIL", "THIS IS NOT VERY SAFE TO DRINK, I RECOMMEND YOU TO USE IT AGAINST YOUR ENEMIES", -35);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        testSubject1 = new Npc("FREDY", 100, null);
        testSubject2 = new Npc("REMY", 20, null);
        testSubject3 = new Npc("CORPSE", 0, null);
        testSubject3 = null;
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of use method, of class Consumable.
     */
        
    @Test 
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        hurtingPotion.setOwner(testSubject4);
        assertFalse(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet est nul
    }    
        
    @Test
    public void testUse2() { //Cas pour faire des degats a une personne 
        
        hurtingPotion.setOwner(testSubject2);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(testSubject1);
        assertFalse(hurtingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 65); //On verifie le changement de vie de l'objectif
    
    }
    
    @Test
    public void testUse3() { //Cas pour donner de la vie a une personne avec toutes ses hp
        
        hurtingPotion.setOwner(testSubject2);
        assertTrue(healingPotion.hasOwner());  //On teste si le propietaire de l'objet n'est pas nul
        healingPotion.use(testSubject1);
        assertFalse(healingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 100); //On verifie le changement de vie de l'objectif
        
    }
        
    @Test 
    public void testUse4() { //Cas pour faire des degats a une personne avec moins de hp que le degats qu'on le fait
        
        hurtingPotion.setOwner(testSubject1);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(testSubject2);
        assertFalse(hurtingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 0); //On verifie le changement de vie de l'objectif
    } 
    
    @Test 
    public void testUse5() {  //Cas pour donner de la vie a une personne
        hurtingPotion.setOwner(testSubject1);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        healingPotion.use(testSubject3);
        assertTrue(healingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 40); //On verifie le changement de vie de l'objectif 
    }
        
    @Test 
    public void testUse6() { //Cas pour faire des degats a une personne morte
        hurtingPotion.setOwner(testSubject1);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        hurtingPotion.use(testSubject3);
        assertTrue(hurtingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 0); //On verifie le changement de vie de l'objectif
    }

    @Test 
    public void testUse7() { //Cas pour donner de la vie a une personne morte
        hurtingPotion.setOwner(testSubject1);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        healingPotion.use(testSubject3);
        assertTrue(healingPotion.canUse()); //On teste si on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 0); //On verifie le changement de vie de l'objectif
    }
}
