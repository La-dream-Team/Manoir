
package person;

import manor.Room;


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
            case 3: 
                this.type = NpcType.FINAL_BOSS;
                this.shield = Health;
                this.aggressive = true;
                break;
            default: this.type = NpcType.SOLDIER;
                break;          
        }//fin sw
        
        
    }
    
    public boolean getAggressive(){
        return this.aggressive;
    }
    
    public void switchMode()
    {
        this.aggressive = true;
    }
    
    public void talk(String Message)
    {
         System.out.println(Message);
    }
    
    @Override
    public void hurt(int receivedDamage)
    {   
        if(this.shield == 0)
        {
            if((this.getCurrentHp() - receivedDamage) <= 0)
            {
                this.setCurrentHp(0);
                System.out.println("YOU KILLED ME !");
                this.dropObjects();
                Corpse corpse = new Corpse(this.getName(), "HE DIED BECAUSE OF YOU, MAYBE IT WAS FOR SELF DEFENSE OR MAYBE YOUR MURDEROUS INSTINCT SHOWED UP");
                this.getRoom().addCorpse(corpse); 
                this.getRoom().removePerson(this.getName());
 
            } 
            else
            {
                int CurrentHealth = this.getCurrentHp();
                CurrentHealth -= receivedDamage;
                this.setCurrentHp(CurrentHealth);
                System.out.println("YOU ATTACKED ME, I'M GONNA KILL YOU !");
            }
        }
        else
        {
            if((this.shield - receivedDamage) > 0)
            {
                this.shield -= receivedDamage;
            }
            else if((this.shield - receivedDamage) < 0)
            {
                int restOfDamage = (this.shield - receivedDamage);
                this.shield = 0;
                this.hurt(-restOfDamage);
            }
        }
    } 
    
    public void attak(Player p){
        if(this.aggressive){
            if(this.getEquippedItem() != null){
                if(this.coefficient >= 1f)
                {
                    this.getEquippedItem().setWeaponDamage(this.coefficient);
                }
                System.out.println(this.getName() + " ATTACKED YOU !");
                super.useObject(this.getEquippedItem().getName(), p.getName());
            }
        }
    }
}
