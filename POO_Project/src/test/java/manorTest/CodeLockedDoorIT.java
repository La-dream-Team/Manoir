package manorTest;





import door.CodeLockedDoor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CodeLockedDoorIT {

    private CodeLockedDoor door1= new CodeLockedDoor(1234);
    private CodeLockedDoor door2= new CodeLockedDoor(1234);
    private CodeLockedDoor door3= new CodeLockedDoor(1234);

    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDownClass() {
    }
    
    @Test
    public void testunlock1(){
        door1.lock();
        door1.unlock(-1);
        assertTrue(door1.getIsLocked());
    }
    
    @Test
    public void testunlock2(){
        door1.lock();
        door1.unlock(0000);
        assertTrue(door1.getIsLocked());
    }
    
    @Test
    public void testunlock3(){
        door1.lock();
        door1.unlock(1234);
        assertFalse(door1.getIsLocked());
    }
    
    @Test
    public void testunlock4(){
        door1.lock();
        door1.unlock(1234);
        assertFalse(door1.getIsLocked());
    }
}
