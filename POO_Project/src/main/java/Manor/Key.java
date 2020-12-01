package Manor;

public class Key extends Object{
    
    //Attribut
    KeyLockedDoor unlockableDoor;
    Person currentOwner;
    //Constructor
    public Key(String KeyName, int RemainingUses, KeyLockedDoor UnlockableDoor)
    {
        super(KeyName, RemainingUses);
        this.unlockableDoor = UnlockableDoor;
        this.currentOwner = null;
    } 

    //Method
    public void setCurrentOwner(Person NewOwner)
    {
        this.currentOwner = NewOwner;
    }
    
    @Override
    public void use(Person Objective)
    {   
        
        if(this.canUse() == true)
        {
            if(Objective == null)
            {
                if(this.currentOwner.getRoom().isOnDoors(this.unlockableDoor) == true)
                {
                   this.unlockableDoor.unlock(this); 
                }
                else
                {
                    System.out.println("NEARBY DOORS CANT BE OPENNED WITH YOUR KEY");
                }
            }
            else
            {
                System.out.println("THIS IS NOT A WEAPON, IT CAN GIVE YOU ACCESS TO NEW ROOMS");
            }
        }
        else
        {
            System.out.println("YOU HAVE ALREADY USED THIS KEY TOO MANY TIMES");
        }
    }
}