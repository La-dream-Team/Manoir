package Manor;

public class Charger extends Object{

    //Constructor
    public Charger(String ChargerName, String Description)
    {
        super(ChargerName, 1, Description);
    }   
    
    public Charger(String ChargerName, String Description, Person Owner)
    {
        super(ChargerName, 1, Description, Owner);
    }
    
    @Override
    public void use(Person Objective)
    {
        if(this.hasOwner() == true)
        {
            if(this.canUse() == true)
            {
                if(Objective == null)
                {
                    if(this.getOwner().getEquippedItem() instanceof Gun)
                    {
                        Gun weaponWithBullets = (Gun)this.getOwner().getEquippedItem();
                        weaponWithBullets.reload();
                        System.out.println("YOU HAVE RELOADED");
                    }
                    else
                    {
                        System.out.println("NONE OF YOUR WEAPONS CAN BE RECHARGED WITH THIS CHARGER");
                    }
                }
                else
                {
                    System.out.println("THIS IS NOT A WEAPON NOR CONSUMABLE. YOU CANT ATTACK SOMEONE WITH IT, IT ONLY CAN RELOAD THE WEAPON U HAVE EQUIPPED");
                }
            }
            else
            {
                System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                this.getOwner().removeObject(this.getId());
            }
        }
    }
}