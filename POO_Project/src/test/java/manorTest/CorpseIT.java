package manorTest;

import person.Corpse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CorpseIT {
    
    private Corpse corpse;

    
    @Before
    public void setUp() {
        corpse = new Corpse("ROBERT", "IT'S A BODY");
    }
    
    @After
    public void tearDownClass() {
    }

    @Test
    public void testgetName(){
        assertTrue(corpse.getName().equals("ROBERT"));
    }
    
    @Test
    public void testgetDesc(){
        assertTrue(corpse.getDesc().equals("IT'S A BODY"));
    }
   
}
