
package Manor;

import Manor.Room;

public class DoorWithLock extends Door {
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
    
    public int unlock(int arg)
    {
       int ret = 0;
       if(arg != -1){
           System.out.println("UNUSABLE ARGUMENT !");
       }
       else{
           this.isLocked = false;
           ret = 1;
       }
       return ret;
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
