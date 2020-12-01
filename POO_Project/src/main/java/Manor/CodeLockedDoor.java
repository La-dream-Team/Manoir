
package Manor;

public class CodeLockedDoor extends AutoLockedDoor {
    // attributs
    private int code;
    private int DEFAULT_CODE = 0000; 
    
    private final int genaral_pass = 1686;
    
    // constructeur(s)
    public CodeLockedDoor(int pass, Room r)
    {
        super(r);
        this.code = pass;
    }
    
    public CodeLockedDoor(int pass)
    {
        super();
        this.code = pass;
    }
    
    //methodes 
    
    @Override
    public void unlock(){
        System.out.println("Code Faillure !");
    }

    public void unlock(int pass){
        if((pass == this.code) || (pass == this.genaral_pass)){
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
