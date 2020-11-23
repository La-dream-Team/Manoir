
package Manor;

public class Weapon extends Object{
    
    // Attributs
    private boolean needBullets; //Pour differencier des armes avec munition et sans
    private int weaponDamage;
    private int currentBullets;
    private final int DELFAULT_AMMOCAPACITY;

    //Constructor
    public Weapon(String WeaponName, int ID, int RemainingUses, Room CurrentRoom, int WeaponDamage) //Pour creer une arme qui n'a pas besoin de munition
    {
        super(WeaponName, ID, RemainingUses,  CurrentRoom);
        this.needBullets = false;
        this.weaponDamage = WeaponDamage;
        this.currentBullets = 0;
        this.DELFAULT_AMMOCAPACITY = 0;
    }   

    public Weapon(String WeaponName, int ID, int RemainingUses, Room CurrentRoom, int WeaponDamage, int CurrentBullets) //Pour creer une arme qui a besoin de munition
    {
        super(WeaponName, ID, RemainingUses,  CurrentRoom);
        this.needBullets = true;
        this.weaponDamage = WeaponDamage;
        this.currentBullets = CurrentBullets;
        this.DELFAULT_AMMOCAPACITY = CurrentBullets;
    } 

    //Methods
    @Override
    public void useObject(Person Objective)
    {
        if(this.needBullets == false)
        {
            if(Objective.isAlive() == true)
            {
                Objective.hurt(this.weaponDamage);
                this.use();
            }
        }
        else
        {
            if(this.currentBullets == 0)
            {
                System.out.println("YOU HAVE TO RELOAD");
            }
            else
            {
                while(Objective.isAlive() == true && this.currentBullets > 0) //Pendant que notre objectif est vivant et on a des balles dans le chargeur
                {
                    Objective.hurt(this.weaponDamage); 
                    this.currentBullets -= 1;
                }
                this.use();
            }
        }
    }

    public void reload()
    {   if(this.needBullets == true)
        {
            this.currentBullets = this.DELFAULT_AMMOCAPACITY;
        }
    }
}