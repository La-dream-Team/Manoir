
package Manor;


public class Npc extends Person{
    // Attributes
    private boolean passiveOrActive; //Attack true or Passive false
    private float coefficient;
    private int shield;
    private NpcType type; //1-soldier, 2-Trader, 3- FinalBoss, 4- corpse
    
    //Constructors
    public Npc(Room CurrentRoom){
        super(CurrentRoom); 
        this.passiveOrActive = true;
        this.coefficient = 0f;
        this.shield = 0;
        this.type = NpcType.CORPSE;
    }
    
    public Npc(Person NewCorpse){
        super(NewCorpse);
        this.passiveOrActive = true;
        this.coefficient = 0f;
        this.shield = 0;
        this.type = NpcType.CORPSE;
    }
    
    public Npc(String Name,int Health, Room CurrentRoom, int Type){
        super(Name, Health, CurrentRoom);
        this.passiveOrActive = true;
        this.coefficient = 0f;
        this.shield = 0;
        /*if(Type > 0 && Type < 5)
        {//Case 4
            this.type = NpcType.CORPSE;
        }*/
        switch(Type){
            case 1: this.type = NpcType.SOLDIER;
                break;
            case 2: this.type = NpcType.TRADER;
                break;
            case 3: this.type = NpcType.FINAL_BOSS;
                break;
            default: this.type = NpcType.CORPSE;
                break;            
        }//fin sw
        
        
    }
    
    //Method
    public void setMode(boolean PassiveOrActive)
    {
        this.passiveOrActive = PassiveOrActive;
    }
    
    public void talk(String Message)
    {
         System.out.println(Message);
    }
}
