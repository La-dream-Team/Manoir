package Manoir;

public class Collectable extends Object{
    
    //Attribut
    String content;

    //Constructor
    public Collectable(String CollectableName, int ID, int RemainingUses, Room CurrentRoom, String Content)
    {
        super(CollectableName, ID, RemainingUses, CurrentRoom);
        this.content = Content;
    } 

    //Method
    @Override
    public void useObject(Person objective)
    {   
        System.out.println(this.content);
        this.use();
    }
}