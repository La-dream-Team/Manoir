package Manor;

public class Consumable extends Object{

    //Il y aura des objects qui donnent de la vie et d'autres qui la prennent

    //Attributs
    private final int givenOrTakenHealth;

    //Constructors
    public Consumable(String ConsumableName, int RemainingUses, String Description, int GivenOrTakenHealth) 
    {
        super(ConsumableName, RemainingUses, Description);
        this.givenOrTakenHealth = GivenOrTakenHealth; 
    } 

    //Method
    @Override
    public void use(Person Objective)
    {   
        if(this.canUse() == true)
        {
            if(Objective != null){
                if(this.givenOrTakenHealth != 0)
                {
                    if(this.givenOrTakenHealth > 0)
                    {
                        Objective.heal(this.givenOrTakenHealth);
                        this.setRemainingUses();
                    }
                    else
                    {
                        Objective.hurt(-(this.givenOrTakenHealth));
                        this.setRemainingUses();
                    } 
                }
            }
            else
            {
                System.out.println("YOU NEED A TARGET TO USE THIS OBJECT AGAINST");
            }
        }
        else
        {
            System.out.println("YOU HAVE ALREADY USED THIS CONSOMABLE TOO MANY TIMES");
        }
    }
}