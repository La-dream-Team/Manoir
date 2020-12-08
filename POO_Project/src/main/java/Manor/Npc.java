
package Manor;


public class Npc extends Person{
    
    // Attributes
    private boolean aggressive; //passive -> false / aggressive -> true
    private float coefficient;
    private int shield;
    private NpcType type; //1-soldier, 2-Trader, 3- FinalBoss, 4- corpse
    
    //Constructors

    public Npc(Npc NewNpc, String NewName){ //On cree un Npc par copie sans inventaire
        super(NewName, NewNpc.getCurrentHp(), NewNpc.getRoom(), NewNpc.getMoney());
        this.aggressive = false;
        this.coefficient = 0f;
        this.shield = 0;
        this.type = NewNpc.type;
    }
    
    public Npc(String Name,int Health, Room CurrentRoom, int Money, float Difficulty, int Type){
        super(Name, Health, CurrentRoom, Money);
        this.aggressive = false;
        this.coefficient = Difficulty;
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
    
    public void switchMode()
    {
        if(this.aggressive)
        {
            this.aggressive = true;
        }
    }
    
    public void talk(String Message)
    {
         System.out.println(Message);
    }
    
    @Override
    public void hurt(int receivedDamage)
    {   
        if(this.coefficient > 0f)
        {
            receivedDamage = receivedDamage * (int)this.coefficient;
        }
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
}
