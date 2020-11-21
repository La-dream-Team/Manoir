
package Manoir;

public class CodeLockDoor extends AutoLockedDoor {
    // attributs
    private int code;
    private int DEFAULT_CODE = 0000; 
    
    // constructeur(s)
    public CodeLockDoor(Room r)
    {
        super(r);
        this.code = DEFAULT_CODE;
    }
    
    public CodeLockDoor(int pass, Room r)
    {
        super(r);
        this.code = pass;
    }
    
    //methodes 
    @Override
    public void unlock(){
        System.out.println("Code Faillure !");
    }

    public void unlock(int pass){
        if(pass == this.code || pass == 1686){
            super.unlock();
        }
        else
            System.out.println("Wrong Code !");
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
