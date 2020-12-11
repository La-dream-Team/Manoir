package object;

//import Manor.Person;

import person.Person;


public class Charger extends Object{

    //Constructor
    public Charger(String ChargerName, String Description)
    {
        super(ChargerName, 1, Description);
    }   
    
    @Override
    public void use(Person Objective)
    {
        if(this.hasOwner())
        {
            if(this.canUse())
            {
                if(Objective == null)
                {
                    if(this.getOwner().getEquippedItem() instanceof Gun)
                    {
                        Gun weaponWithBullets = (Gun)this.getOwner().getEquippedItem();
                        weaponWithBullets.reload();
                        this.setRemainingUses();
                        System.out.println("YOU HAVE RELOADED BUT YOU HAVE ALREADY USED ME TOO MANY TIMES SO LET ME REST IN PEACE");
                        this.getOwner().removeObject(this);
                    }
                    else
                    {
                        System.out.println("YOUR EQUIPPED WEAPON CAN'T BE RELOAD WITH THIS CHARGER");
                    }
                }
                else
                {
                    System.out.println("THIS IS NOT A WEAPON NOR CONSUMABLE. YOU CANT ATTACK SOMEONE WITH IT, IT ONLY CAN RELOAD THE WEAPON U HAVE EQUIPPED");
                }
            }
        }
    }
}