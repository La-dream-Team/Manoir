
package Manoir;

public class Door implements Closeable {
    // attributs
    private boolean isOpen;
    
    private final boolean DEFAULT_ISOPEN = false ; 
    
    // constructeur(s)
    public Door()
    {
        this.isOpen = this.DEFAULT_ISOPEN;
    }
    
    // 
    public void open()
    {
        this.isOpen = true;
    }
    
    public void close()
    {
        this.isOpen = false;
    }
    
    public void print()
    {
        System.out.print("is Open = " + this.isOpen);
    }
    
    public boolean getIsOpen() 
    {
        return this.isOpen; 
    }
    
}
