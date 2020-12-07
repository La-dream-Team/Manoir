
package Manor;

//import Manor.Person;

public abstract class Object{
    
    // Attributs
    private final String name;
    private final int id;
    private int remainingUses;
    private final String description;
    private Person owner;
    
    private static int currentId = 0;

    //Constructor
    public Object(String Name, int RemainingUses, String Description)
    {
        this.name = Name;
        this.id = currentId;
        this.remainingUses = RemainingUses;
        this.description = Description;
        currentId++;
        this.owner = null;
    }

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
    
    public int getRemainingUses()
    {
        return this.remainingUses;
    }
    
    public void setRemainingUses()
    {
        this.remainingUses -= 1;
    }
    
    public String getDescription()
    {
        return this.description; 
    }
    
    public boolean hasOwner()
    {
        if(this.owner != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public Person getOwner()
    {
        return this.owner;
    }
    
    public void setOwner(Person NewOwner)
    {
        this.owner = NewOwner;
    }
    
    public void use(Person Objective)
    {
     
    }
}