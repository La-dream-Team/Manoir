
package Manor;

public class CodeLockedDoor extends AutoLockedDoor {
    // attributs
    private int code;
    
    private final int MASTER_CODE = 1686;
    
    // constructeur(s)
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
           if(((arg == this.code) || (arg == this.MASTER_CODE))){
               ret = super.unlock(-1);
           }
           else{
               System.out.println("CODE FAILLURE !");
           }
       }
       return ret;
    }
    
    
}
