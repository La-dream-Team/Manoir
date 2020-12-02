package Manor;

public class Collectable extends Object{
    
    //Attribut
    String content;

    //Constructor
    public Collectable(String CollectableName, int RemainingUses, String Description, String Content)
    {
        super(CollectableName, RemainingUses, Description);
        this.content = Content;
    } 

    //Method
    @Override
    public void use(Person Objective)
    {   
        if(this.canUse() == true)
        {
            if(Objective == null)
            {
                System.out.println(this.content);
                this.setRemainingUses();
            }
            else
            {
                System.out.println("THIS IS NOT A WEAPON, IT CAN GIVE KNOWLEDGE ONLY TO YOU SO BE GRATEFUL");
            }
        }
        else
        {
            System.out.println("YOU HAVE ALREADY USED THIS COLLECTABLE TOO MANY TIMES");
        }
    }
}