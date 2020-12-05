
package Manor;


public class Npc extends Person{
    
    // Attributes
    private float coefficient;
    private int shield;
    private NpcType type; //1-soldier, 2-Trader, 3- FinalBoss, 4- corpse
    
    //Constructors
    public Npc(Room CurrentRoom){
        super(CurrentRoom); 
        this.coefficient = 0f;
        this.shield = 0;
        this.type = NpcType.CORPSE;
    }
    
    public Npc(Person NewCorpse){
        super(NewCorpse);
        this.coefficient = 0f;
        this.shield = 0;
        this.type = NpcType.CORPSE;
    }
    
    public Npc(String Name,int Health, Room CurrentRoom, int Money, int Type){
        super(Name, Health, CurrentRoom, Money);
        this.coefficient = 0f;
        this.shield = 0;
        /*if(Type > 0 && Type < 5){}*/
        switch(Type){
            case 1: this.type = NpcType.SOLDIER;
                break;
            case 2: this.type = NpcType.TRADER;
                break;
            case 3: this.type = NpcType.FINAL_BOSS;
                break;
            default: this.type = NpcType.SOLDIER;
                break;
            /*default: this.type = NpcType.CORPSE;
                break;*/            
        }//fin sw
        
        
    }
    
    //Method
    @Override
    public void hurt(int receivedDamage)
    {
        if(this.shield == 0)
        {
            if(this.getCurrentHp() - receivedDamage <= 0)
            {
                this.setCurrentHp(0);
            } 
            else
            {
                int CurrentHealth = this.getCurrentHp();
                CurrentHealth -= receivedDamage;
                this.setCurrentHp(CurrentHealth);
            }
        }
        else
        {
            if(this.shield - receivedDamage > 0)
            {
                this.shield -= receivedDamage;
            }
            else if(this.shield - receivedDamage < 0)
            {
                int restOfDamage = this.shield - receivedDamage;
                this.shield = 0;
                this.hurt(-restOfDamage);
            }
        }
    }
    
    public void talk(String Message)
    {
         System.out.println(Message);
    }
}
