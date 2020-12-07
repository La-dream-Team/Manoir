
package Manor;

import Manor.Room;

public class DoorLockedOut extends Door{
    
    //constructeur(s)
    public DoorLockedOut(Room r) 
    {
        super(r);
    }
    
    public DoorLockedOut() 
    {
        super();
    }
    
    // methodes
    @Override
    public void open() 
    {
        
    }
}
