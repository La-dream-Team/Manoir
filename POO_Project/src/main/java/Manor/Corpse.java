
package Manor;

public class Corpse {
    private final String name;
    private final String description;
    
    
    // constructeurs 
    public Corpse(String n, String desc){
        this.name = n;
        this.description = desc;
    }
    
    
    public void print(){
        if(this.description != null || !"".equals(this.description))
        {
            System.out.println(this.description);
        }
    }
}
