package manorTest;

import manor.Room;
import object.Consumable;
import person.Npc;
import person.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConsumableIT {
    
    private Player testSubject1;
    private Npc testSubject2;
    private Room room;
    private Consumable healingPotion = new Consumable("GRANDMA'S COOKIES", "THOSE COOKIES WERE MADE WITH LOVE BY ONE OF THE MANOR RESIDENTS GRANDMA", 20);
    private Consumable hurtingPotion = new Consumable("MOLOTOV COCKTAIL", "THIS IS NOT VERY SAFE TO DRINK, I RECOMMEND YOU TO USE IT AGAINST YOUR ENEMIES", -35);
    
    
    @Before
    public void setUp() {
        room = new Room("couloir");
        testSubject1 = new Player("FREDY", 100, room);
        testSubject2 = new Npc("REMY", 50, room, 47, 0f, 2);
        room.addPerson(testSubject1);
        room.addPerson(testSubject2);
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
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(hurtingPotion.getName(), testSubject2.getName());
        assertFalse(hurtingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(testSubject1.hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject2.getCurrentHp(), 15); //On verifie le changement de vie de l'objectif
    }
    
    @Test
    public void testUse3() { //Cas pour donner de la vie a une personne 
        //On fait des degats a la personne avant de pouvoir le heal
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(hurtingPotion.getName(), testSubject2.getName());
        //------------------------------------------------------------
        testSubject1.addObject(healingPotion);
        assertTrue(healingPotion.hasOwner());  //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(healingPotion.getName(), testSubject2.getName());
        assertFalse(healingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(testSubject1.hasObject(healingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject2.getCurrentHp(), 35); //On verifie qui n'a pas eu de changement de vie sur l'objectif  
    }
 
    @Test 
    public void testUse4() { //Cas pour enlever de la vie au propietaire du consomable
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(hurtingPotion.getName(), null);
        assertFalse(hurtingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(testSubject1.hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject1.getCurrentHp(), 65); //On verifie le changement de vie de l'objectif
    }
    
    @Test 
    public void testUse5() { //Cas pour donner de la vie au propietaire du consomable
        testSubject1.addObject(healingPotion);
        assertTrue(healingPotion.hasOwner());  //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(healingPotion.getName(), null);
        assertFalse(healingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(testSubject1.hasObject(healingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject1.getCurrentHp(), 100); //On verifie qui n'a pas eu de changement de vie sur l'objectif 
    }
    
    @Test 
    public void testUse6() { //Cas pour utiliser l'object en rentrant comme objective le propietaire
        testSubject1.addObject(hurtingPotion);
        assertTrue(hurtingPotion.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(hurtingPotion.getName(), testSubject1.getName());
        assertTrue(hurtingPotion.canUse()); //On teste si on ne peut pas la reutiliser
        assertTrue(testSubject1.hasObject(hurtingPotion.getName())); //On teste si le propietaire il n'a plus l'object
        assertEquals(testSubject1.getCurrentHp(), 100); //On verifie le changement de vie de l'objectif
    }
}
