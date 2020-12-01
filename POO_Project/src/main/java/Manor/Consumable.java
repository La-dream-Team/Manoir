package Manor;

public class Consumable extends Object{

    //Il y aura des objects qui donnent de la vie et d'autres qui la prennent

    //Attributs
    private final int givenOrTakenHealth;

    //Constructors
    public Consumable(String ConsumableName, int RemainingUses, int GivenOrTakenHealth) 
    {
        super(ConsumableName, RemainingUses);
        this.givenOrTakenHealth = GivenOrTakenHealth; 
    } 

    //Method
    @Override
    public void use(Person Objective)
    {   
        if(this.canUse() == true)
        {
            if(this.givenOrTakenHealth != 0)
            {
                if(this.givenOrTakenHealth > 0)
                {
                    Objective.heal(this.givenOrTakenHealth);
                    this.canUse();
                }
                else
                {
                    Objective.hurt(-(this.givenOrTakenHealth));
                    this.canUse();
                } 
            }
        }
        else
        {
            System.out.println("YOU HAVE ALREADY USED THIS CONSOMABLE TOO MANY TIMES");
        }
    }
}