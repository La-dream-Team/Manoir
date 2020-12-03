/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

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
public class CollectableIT {
    
    public CollectableIT() {
        private NPC testSubject1;
        private NPC testSubject2;
        private Collectable readingBook = new Collectable("DON QUIXOTE", 863, "TO READ THIS BOOK YOU NEED AT LEAST TWO CENTURIES IRL", "In a village of La Mancha, the name of which I have no desire to call to mind, there lived not long since one of those gentlemen that keep a lance in the lance-rack, an old buckler, a lean hack, and a greyhound for coursing.");
        private Collectable magazine = new Collectable("THE NEW MANOR", 5, "THIS IS A MAGAZINE ABOUT THE NEWEST MANSIONS NEARBY", null);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp(){
        testSubject1 = null;
        testSubject2 = new NPC("FREDY", 100, null);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of useObject method, of class Collectable.
     */
    @Test
    public void testUse() {
        
        readingBook.use(testSubject2);
        assertTrue(magazine.canUse());
        assertEquals(readingBook.getRemainingUses(), 863);
        
        readingBook.use(testSubject1);
        assertTrue(readingBook.canUse());
        assertEquals(readingBook.getRemainingUses(), 862);
        
        magazine.use(testSubject1);
        assertTrue(magazine.canUse());
        assertEquals(magazine.getRemainingUses(), 1);
        
    }
    
}
