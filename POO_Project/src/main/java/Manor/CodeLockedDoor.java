
package Manor;

import Manor.Room;

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
    public int unlock(int arg)
    {
       int ret = 0;
       if(arg == -1){
           System.out.println("UNUSABLE ARGUMENT !");
       }
       else{
           if(arg == this.code){
               ret = super.unlock(-1);
           }
           else{
               System.out.println("CODE FAILLURE !");
           }
       }
       return ret;
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    @Override
    public void print()
    {
        super.print();
        System.out.print("CODE = " + this.code);
    }
}
