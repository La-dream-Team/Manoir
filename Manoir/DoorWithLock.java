
package Manoir;

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
    
    // méthodes
    public void unlock()
    {
       this.isLocked = false; 
    }
    
    public void lock()
    {
       this.isLocked = false; 
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
    
    public boolean getIsLocked()
    {
        return this.isLocked;
    }
    
    @Override
    public void print()
    {
        super.print();
        System.out.print( "; is Locked = "+this.isLocked);
    }
    
    
    
}
