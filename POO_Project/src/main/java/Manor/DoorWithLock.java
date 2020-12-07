
package Manor;

import Manor.Room;

public class DoorWithLock extends Door implements Lockable {
    // attributs 
    private boolean isLocked ; 
    
    private final boolean DEFAULT_ISLOCKED = false;
    // constructeur(s) 
    public DoorWithLock(Room r)
    {
        super(r); 
        this.isLocked = DEFAULT_ISLOCKED;
    }
    
    public DoorWithLock()
    {
        super(); 
        this.isLocked = DEFAULT_ISLOCKED;
    }
    
    // méthodes
    public boolean getIsLocked()
    {
        return this.isLocked;
    }
    
    public void unlock()
    {
       this.isLocked = false; 
    }
    
    public void lock()
    {
       this.isLocked = true; 
    }
    
    @Override
    public void open()
    {
        if(!this.isLocked)
            super.open();
    }
    
    @Override
    public void close()
    {
        if(!this.isLocked)
            super.close();
    }
    
    
    
    @Override
    public void print()
    {
        super.print();
        System.out.println( "IS LOCKED = " + this.isLocked);
    }
    
    
    
}
