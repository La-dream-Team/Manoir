
package manorTest;

import manor.Room;
import object.Collectable;
import object.Object;
import person.Npc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectableIT {
    
    private Room room;
    private Npc testSubject1;
    private Collectable readingBook = new Collectable("DON QUIXOTE", 863, "TO READ THIS BOOK YOU NEED AT LEAST TWO CENTURIES IRL", "In a village of La Mancha, the name of which I have no desire to call to mind, there lived not long since one of those gentlemen that keep a lance in the lance-rack, an old buckler, a lean hack, and a greyhound for coursing.");
    private Collectable magazine = new Collectable("THE NEW MANOR", 1, "THIS IS A MAGAZINE ABOUT THE NEWEST MANSIONS NEARBY", "THE NEW MANOR OF THE NEIGHBORHOOD HAS 7 FLOORS WITH 15 ROOMS ON EACH ...");
    private Collectable note = new Collectable("NOTE 1", 1, "THIS IS A NOTE OF ONE OF THE MANOR RESIDENTS", null);
    
    
    @Before
    public void setUp(){
        room = new Room("couloir");
        testSubject1 = new Npc("FREDY", 100, room, 35, 0f, 1);
        room.addPerson(testSubject1);
        testSubject1.addObject(readingBook);
        testSubject1.addObject(magazine);
    }
    
    @After
    public void tearDownClass() {
    }

    /**
     * Test of useObject method, of class Collectable.
     */
    @Test
    public void testUse1() { //Cas ou l'objet n'a pas de contenu
        assertNull(note.getContent());
    }
    
    @Test 
    public void testUse2() { //Cas ou l'object n'a pas de propietaire
        readingBook.setOwner(null);
        assertFalse(readingBook.hasOwner()); //On teste si le propietaire de l'objet est nul
    } 
        
    @Test
    public void testUse3() { //Cas ou l'objet peut etre utilise
        assertNotNull(readingBook.getContent());
        assertTrue(readingBook.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(readingBook.getName(), null);
        assertTrue(readingBook.canUse()); //On teste si on peut le reutiliser
        assertEquals(readingBook.getRemainingUses(), 862);
    }
    
    @Test
    public void testUse4() { //Cas ou l'objet ne peut pas etre utilise car on rentre un personne pas nulle
        assertTrue(readingBook.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(magazine.getName(), testSubject1.getName());
        assertTrue(readingBook.canUse()); //On teste si on peut le reutiliser
        assertEquals(readingBook.getRemainingUses(), 863); //On teste si les usages ont pas changé
    }
        
    @Test
    public void testUse5() { //Cas ou l'objet n'a pas d'usages disponibles 
        assertTrue(magazine.hasOwner()); //On teste si le propietaire de l'objet n'est pas nul
        testSubject1.useObject(magazine.getName(), null);
        assertFalse(magazine.canUse()); //On teste si on ne peut pas la reutiliser
        assertFalse(testSubject1.hasObject(magazine.getName())); //On teste si le propietaire il n'a plus l'object
    }   
}
