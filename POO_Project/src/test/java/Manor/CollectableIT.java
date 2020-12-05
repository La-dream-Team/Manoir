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

/**
 *
 * @author thibault
 */
public class CollectableIT {
    
    private Npc testSubject2;
    private Room room;
    private Collectable readingBook = new Collectable("DON QUIXOTE", 863, "TO READ THIS BOOK YOU NEED AT LEAST TWO CENTURIES IRL", "In a village of La Mancha, the name of which I have no desire to call to mind, there lived not long since one of those gentlemen that keep a lance in the lance-rack, an old buckler, a lean hack, and a greyhound for coursing.");
    private Collectable magazine = new Collectable("THE NEW MANOR", 1, "THIS IS A MAGAZINE ABOUT THE NEWEST MANSIONS NEARBY", "THE NEW MANOR OF THE NEIGHBORHOOD HAS 7 FLOORS WITH 15 ROOMS ON EACH ...");
    private Collectable note = new Collectable("NOTE 1", 1, "THIS IS A NOTE OF ONE OF THE MANOR RESIDENTS", null);
    
    
    @Before
    public void setUp(){
        room = new Room("couloir");
        testSubject2 = new Npc("FREDY", 100, room, 35, 1);
        testSubject2.addObject(readingBook);
        testSubject2.addObject(magazine);
    }
    
    @After
    public void tearDownClass() {
    }

    /**
     * Test of useObject method, of class Collectable.
     */
        
    @Test 
    public void testUse1() { //Cas ou l'object n'a pas de propietaire
        readingBook.setOwner(null);
        assertTrue(readingBook.hasOwner()); //On teste si le propietaire de l'objet est nul
    } 
        
    @Test
    public void testUse2() { //Cas ou l'objet peut etre utilise
        assertNotNull(note.content);
        readingBook.setOwner(testSubject2);
        assertTrue(readingBook.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        readingBook.use(null);
        assertTrue(readingBook.canUse()); //On teste si on peut le reutiliser
        assertEquals(readingBook.getRemainingUses(), 862);
    }
    
    @Test
    public void testUse3() { //Cas ou l'objet peut pas etre utilise car on rentre un personne pas nulle
        readingBook.setOwner(testSubject2);
        assertTrue(readingBook.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        readingBook.use(testSubject2);
        assertTrue(readingBook.canUse()); //On teste si on peut le reutiliser
        assertEquals(readingBook.getRemainingUses(), 863); //On teste si les usages ont pas changé
    }
        
    @Test
    public void testUse4() { //Cas ou l'objet n'a pas d'usages disponibles 
        magazine.setOwner(testSubject2);
        assertTrue(magazine.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        magazine.use(null);
        assertFalse(magazine.canUse()); //On teste si on ne peut pas la reutiliser
    }
    
    @Test
    public void testUse5() { //Cas ou l'objet n'a pas de contenu
        assertNull(note.content);
    }
}
