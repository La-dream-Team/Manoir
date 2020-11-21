
package Manoir;


public class AutoLockedDoor extends DoorWithLock{
    
    
    // Constructuers
    public AutoLockedDoor(Room r)
    {
        super(r);
    }
    
    //methodes 
    @Override
    public void close()
    {
        super.close();
        super.lock();
    }
    

}
