package Manoir;

public class Key extends Object{
    
    //Attribut
    Door unlockableDoor;

    //Constructor
    public Key(String KeyName, int ID, int RemainingUses, Room CurrentRoom, Door UnlockableDoor)
    {
        super(KeyName, ID, 1, CurrentRoom); //Une cle on peut l'utiliser qu'une seule fois
        this.unlockableDoor = UnlockableDoor;
    } 

    //Method
    @Override
    public void useObject()
    {   
        if(this.CurrentRoom.isOnDoors(this.unlockableDoor) == true)
        {
            /*this.CurrentRoom.getDoor(this.unlockableDoor).unlock(); //On ouvre la porte de la piece associe a la cle
            this.use();*/
        }
        else
        {
            System.out.println("NEARBY DOORS CANT BE OPENNED WITH YOUR KEY");
        }
    }
}