
package person;

public class Corpse {
    private final String name;
    private final String description;
    
    
    // constructeurs 
    public Corpse(String n, String desc){
        this.name = n;
        this.description = desc;
    }
    
    
    public String getName(){
        return this.name;
    }
    
    public String getDesc(){
        return this.description;
    }
}
