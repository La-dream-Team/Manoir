
package Manor;

import Manor.Room;

public class DoorWithLock extends Door {
    // attributs 
    private boolean isLocked ; 
    
    private final boolean DEFAULT_ISLOCKED = true;
    // constructeur(s) 
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
        else
            System.out.println("THIS DOOR IS LOCKED !");
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
        if(this.isLocked)
            System.out.print(" AND LOCKED");
        else
            System.out.print(" AND UNLOCKED");
    }
    
    
    
}
