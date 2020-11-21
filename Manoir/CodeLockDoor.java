
package Manoir;

public class CodeLockDoor extends AutoLockedDoor {
    // attributs
    private int code;
    private int DEFAULT_CODE = 0000; 
    
    // constructeur(s)
    public CodeLockDoor()
    {
        super();
        this.code = DEFAULT_CODE;
    }
    
    public CodeLockDoor(int pass)
    {
        super();
        this.code = pass;
    }
    
    //methodes 
    
    // surcharge 
    public void open(int pass)
    {
        if(pass == this.code)
            super.open(); 
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    @Override
    public void print()
    {
        super.print();
        System.out.print("; code = " + this.code);
    }
}
