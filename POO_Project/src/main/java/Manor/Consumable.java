package Manor;

//import Manor.Person;

public class Consumable extends Object{

    //Il y aura des objects qui donnent de la vie et d'autres qui la prennent

    //Attributs
    private final int givenOrTakenHealth;

    //Constructors
    public Consumable(String ConsumableName, String Description, 
            int GivenOrTakenHealth) 
    {
        super(ConsumableName, 1, Description);
        this.givenOrTakenHealth = GivenOrTakenHealth; 
    }  
    
    //Method
    @Override
    public void use(Person Objective)
    {   
        if(this.hasOwner())
        {
            if(this.canUse())
            {
                if(Objective != null)
                {
                    if(Objective.isAlive())
                    {
                        if(Objective != this.getOwner())
                        {
                            if(this.givenOrTakenHealth != 0)
                            {
                                if(this.givenOrTakenHealth > 0)
                                {
                                    Objective.heal(this.givenOrTakenHealth);
                                    this.setRemainingUses();
                                    System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                                    this.getOwner().removeObject(this);
                                }
                                else
                                {
                                    Objective.hurt(-(this.givenOrTakenHealth));
                                    this.setRemainingUses();
                                    System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                                    this.getOwner().removeObject(this);
                                }
                            }
                        }
                        else
                        {
                            System.out.println("IF YOU WANT TO USE THIS OBJECT ON YOURSELF THEN DONT SPECIFY AN OBJECTIVE");
                        }
                    }
                    else
                    {
                        System.out.println("YOUR TARGET IS DEAD, IM SORRY");
                    }
                }
                else
                {
                    if(this.givenOrTakenHealth != 0)
                    {
                        if(this.givenOrTakenHealth > 0)
                        {
                            this.getOwner().heal(this.givenOrTakenHealth);
                            this.setRemainingUses();
                            System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                            this.getOwner().removeObject(this);
                        }
                        else
                        {
                            this.getOwner().hurt(-(this.givenOrTakenHealth));
                            this.setRemainingUses();
                            System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                            this.getOwner().removeObject(this);
                        } 
                    }
                }
            }
        }
    }
}