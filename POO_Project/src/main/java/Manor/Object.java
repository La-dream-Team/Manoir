
package Manor;

public abstract class Object{
    
    // Attributs
    private final String name;
    private final int id;
    private int remainingUses;
    private static int currentId = 0;

    //Constructor
    public Object(String Name, int RemainingUses)
    {
        this.name = Name;
        this.id = currentId;
        this.remainingUses = RemainingUses;
        currentId++;
    }

    //Methods
    public boolean canUse() //Si on peut utiliser un objet, on l'utilise et on retourne vrai, sinon false
    {
        if(this.remainingUses > 0)
        {
            this.remainingUses -= 1;
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
    
    /*public void setCurrentId(int newId)
    {
        currentId = newId;
    }*/
    
    public int getRemainingUses()
    {
        return this.remainingUses;
    }

    public void use(Person Objective)
    {
        if(this.canUse() == true)
        {
            this.canUse();
        }
        else
        {
            System.out.println("YOU HAVE ALREADY USED THIS OBJECT TOO MANY TIMES");
        }
    }
    
    public void show(String Description)
    {
        System.out.println(Description);
    }
}