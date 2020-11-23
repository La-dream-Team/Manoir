
package Manor;

public abstract class Object{
    
    // Attributs
    private String name;
    private int id;
    private int remainingUses;
    private Room currentRoom;

    //Constructor
    public Object(String Name, int ID, int RemainingUses, Room CurrentRoom)
    {
        this.name = Name;
        this.id = ID;
        this.remainingUses = RemainingUses;
        this.currentRoom = CurrentRoom;
    }

    //Methods
    public boolean use() //Si on peut utiliser un objet, on l'utilise et on retourne vrai, sinon false
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

    public String getId()
    {
        return this.id;
    }

    public void setId(int ID)
    {
        this.id = ID;
    }

    public int getRemainingUses()
    {
        return this.remainingUses;
    }

    public int getCurrentRoom()
    {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room Room) {
        this.currentRoom = Room;
    }

    public void useObject(Person Objective)
    {

    }
}