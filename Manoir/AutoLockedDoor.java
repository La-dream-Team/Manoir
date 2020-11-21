
package Manoir;


public class AutoLockedDoor extends DoorWithLock{
    
    
    // Constructuers
    public AutoLockedDoor()
    {
        super();
    }
    
    //methodes 
    @Override
    public void close()
    {
        super.close();
        super.lock();
    }
    
    @Override
    public void print()
    {
        System.out.print("AutoLockedDoor : is open"+ getIsOpen() + "; is locked " + getIsLocked());
    }
}
