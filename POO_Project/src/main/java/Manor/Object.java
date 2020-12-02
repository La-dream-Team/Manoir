
package Manor;

public abstract class Object{
    
    // Attributs
    private final String name;
    private final int id;
    private int remainingUses;
    private String description;
    
    private static int currentId = 0;

    
    
    //Constructor
    public Object(String Name, int RemainingUses, String Description)
    {
        this.name = Name;
        this.id = currentId;
        this.remainingUses = RemainingUses;
        this.description = Description;
        currentId++;
    }
    
    /*public Object(String Name, int RemainingUses )
    {
        this.name = Name;
        this.id = currentId;
        this.remainingUses = RemainingUses;
        this.description = null;
        currentId++;
    }*/

    //Methods
    public boolean canUse() //Si on peut utiliser un objet, on l'utilise et on retourne vrai, sinon false
    {
        if(this.remainingUses > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getName()
    {
        return this.name;
    }

    public int getId()
    {
        return this.id;
    }
    
    public int getCurrentId()
    {
        return currentId;
    }
    
    
    public int getRemainingUses()
    {
        return this.remainingUses;
    }
    
    public void setRemainingUses()
    {
        this.remainingUses -= 1;
    }
    
    public void printDescription()
    {
        if( this.description != null)
        {
            System.out.println(this.description);
        }
    }
    
    public void use(Person Objective)
    {
        if(this.canUse() == true)
        {
            this.setRemainingUses();
        }
        else
        {
            System.out.println("YOU HAVE ALREADY USED THIS OBJECT TOO MANY TIMES");
        }
    }
}