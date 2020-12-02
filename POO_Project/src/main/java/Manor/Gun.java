/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

/**
 *
 * @author R3V0LUTI0N
 */
public class Gun extends Weapon{
    
    //Attributs
    private int currentBullets;
    private final int CHARGERCAPACITY;
    
    public Gun(String GunName, int RemainingUses, int GunDamage, String Description, int CurrentBullets)
    {
        super(GunName, RemainingUses, Description, GunDamage);
        this.currentBullets = CurrentBullets; //Quand on cree une arme elle est deja charge
        this.CHARGERCAPACITY = CurrentBullets;
    } 

    //Methods
    @Override
    public void use(Person Objective) //Si je mets string comment savoir la personne
    {
        if(this.canUse() == true){
            if(Objective != null)
            {          
                while(Objective.isAlive() == true && this.currentBullets > 0) //Pendant que notre objectif est vivant et on a des balles dans le chargeur, on tire
                {
                    Objective.hurt(this.getWeaponDamage()); 
                    this.currentBullets -= 1;
                }
                this.setRemainingUses();
            }
            else
            {
                System.out.println("YOU DONT HAVE A TARGET TO SHOOT, AT LEAST ... IS THERE A PHANTTOM IN THE ROOM?");
            }
        }
        else
        {
            System.out.println("YOUR" + this.getName() + "IT'S BROKEN");
        }
    }
    
    public void reload()
    {
        this.currentBullets = this.CHARGERCAPACITY;
        System.out.println("YOU HAVE RELOADED");
    }
}

