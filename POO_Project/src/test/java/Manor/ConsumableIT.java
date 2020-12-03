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
        testSubject1 = new NPC("FREDY", 100, null);
        testSubject2 = new NPC("REMY", 20, null);
        testSubject3 = new NPC("CORPSE", 0, null);
        testSubject3 = null;
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of use method, of class Consumable.
     */
        
    @Test
    public void testUse1() {
        
        hurtingPotion.setOwner(testSubject2);
        assertNotNull(hurtingPotion.canUse());
        hurtingPotion.use(testSubject1);
        assertFalse(hurtingPotion.canUse()); //test on peut pas le reutiliser
        assertEquals(testSubject.getCurrentHp(), 65);
    
    }
    
    @Test
    public void testUse2() {
        
        hurtingPotion.setOwner(testSubject2);
        assertNotNull(hurtingPotion.canUse());
        healingPotion.use(testSubject1);
        assertFalse(healingPotion.canUse());
        assertEquals(testSubject.getCurrentHp(), 100);
        
    }
        
    @Test 
    public void testUse3() {
        
        hurtingPotion.setOwner(testSubject1);
        assertNotNull(hurtingPotion.canUse());
        hurtingPotion.use(testSubject2);
        assertFalse(hurtingPotion.canUse());
        assertEquals(testSubject.getCurrentHp(), 0);
    } 
     
    @Test 
    public void testUse4() {
        hurtingPotion.setOwner(testSubject1);
        assertNotNull(hurtingPotion.canUse());
        hurtingPotion.use(testSubject3);
        assertTrue(hurtingPotion.canUse());
        assertEquals(testSubject.getCurrentHp(), 0);   
    }

    @Test 
    public void testUse5() {
        hurtingPotion.setOwner(testSubject1);
        assertNotNull(hurtingPotion.canUse());
        healingPotion.use(testSubject3);
        assertTrue(healingPotion.canUse());
        assertEquals(testSubject.getCurrentHp(), 0);    
    }

    @Test 
    public void testUse5() {
        hurtingPotion.setOwner(testSubject1);
        assertNotNull(hurtingPotion.canUse());
        healingPotion.use(testSubject3);
        assertTrue(healingPotion.canUse());
        assertEquals(testSubject.getCurrentHp(), 0);    
    }
        
    @Test 
    public void testUse6() {
        hurtingPotion.setOwner(testSubject4);
        assertNull(hurtingPotion.canUse());
    }
}
