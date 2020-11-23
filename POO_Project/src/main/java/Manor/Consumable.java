package Manor;

public class Consumable extends Object{

    //Il y aura des objects qui donnent de la vie et d'autres qui la prennent

    //Attributs
    private final int givenHealth;
    private final int takenHealth;

    //Constructors
    public Consumable(String ConsumableName, int ID, int RemainingUses, Room CurrentRoom, int GivenHealth, int TakenHealth) 
    {
        super(ConsumableName, ID, RemainingUses, CurrentRoom);
        this.givenHealth = GivenHealth; //Pour creer un objet qui donne de la vie on met takenHealth à 0
        this.takenHealth = TakenHealth; //Pour creer un objet qui enleve de la vie on met givenHealth à 0
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