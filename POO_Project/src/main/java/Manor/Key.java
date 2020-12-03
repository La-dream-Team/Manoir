package Manor;

public class Key extends Object{
    
    //Attribut
    KeyLockedDoor unlockableDoor;
    Person currentOwner;
    
    //Constructor
    public Key(String KeyName, int RemainingUses, String Description, KeyLockedDoor UnlockableDoor)
    {
        super(KeyName, RemainingUses, Description);
        this.unlockableDoor = UnlockableDoor;
    } 
    
    public Key(String KeyName, int RemainingUses, String Description, Person Owner, KeyLockedDoor UnlockableDoor)
    {
        super(KeyName, RemainingUses, Description, Owner);
        this.unlockableDoor = UnlockableDoor;
    } 

    //Method
    @Override
    public void use(Person Objective)
    {   
        if(this.hasOwner() == true)
        {
            if(this.canUse() == true)
            {
                if(Objective == null)
                {
                    if(this.getOwner().getRoom().isOnDoors(this.unlockableDoor) == true)
                    {
                        this.unlockableDoor.unlock(this);
                        this.setRemainingUses();
                    }
                    else
                    {
                        System.out.println("NEARBY DOORS CANT BE OPENNED WITH YOUR KEY");
                    }
                }
                else
                {
                    System.out.println("THIS IS NOT A WEAPON NOR CONSUMABLE. YOU CANT ATTACK SOMEONE WITH IT, IT ONLY CAN GIVE YOU ACCESS TO NEW ROOMS");
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