
package door;


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
        if(super.getIsOpen()){
            super.close();
            super.lock();
        }
    }
    

}
