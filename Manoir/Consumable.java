package Manoir;

public class Consumable extends Object{

    //Il y aura des objects qui donnent de la vie et d'autres qui la prennent

    //Attributs
    private int givenHealth;
    private int takenHealth;

    //Constructors
    public Consumable(String ConsumableName, int ID, int RemainingUses, Room CurrentRoom, int GivenHealth) //Pour creer un objet qui donne de la vie
    {
        super(ConsumableName, ID, RemainingUses, CurrentRoom);
        this.givenHealth = GivenHealth;
        this.takenHealth = 0;
    } 
    
    public Consumable(String ConsumableName, int ID, int RemainingUses, Room CurrentRoom, int TakenHealth) //Pour creer un objet qui enleve de la vie
    {
        super(ConsumableName, ID, RemainingUses, CurrentRoom);
        this.givenHealth = 0;
        this.takenHealth = TakenHealth;
    } 

    //Method
    @Override
    public void useObject(Person Objective)
    {   
        Objective.heal(this.givenHealth);
        Objective.hurt(this.takenHealth);
        this.use();
    }
}