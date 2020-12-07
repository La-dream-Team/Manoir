
package Manor;

import Manor.Room;


public class AutoLockedDoor extends DoorWithLock{
    
    
    // Constructuers
    public AutoLockedDoor(Room r)
    {
        super(r);
    }
    
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
