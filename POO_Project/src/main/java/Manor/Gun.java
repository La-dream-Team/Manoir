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
    
    public Gun(String GunName, int RemainingUses, String Description, int GunDamage, int CurrentBullets)
    {
        super(GunName, RemainingUses, Description, GunDamage);
        this.currentBullets = CurrentBullets; //Quand on cree une arme elle est deja charge
        this.CHARGERCAPACITY = CurrentBullets;
    } 
    
    //Methods
    public int getCurrentBullets()
    {
        return this.currentBullets;
    }
    
    public int getChargerCapacity()
    {
        return this.CHARGERCAPACITY;
    }
            
    public void reload()
    {
        this.currentBullets = this.CHARGERCAPACITY;
    }
    
    @Override
    public void use(Person Objective) 
    {
        if(this.hasOwner())
        {
            if(this.getOwner() != Objective)
            {
                if(this.canUse())
                {
                    if(this.getRemainingUses() == 1)
                    {
                        if(Objective != null)
                        {          
                            while(Objective.isAlive() && this.currentBullets > 0) //Pendant que notre objectif est vivant et on a des balles dans le chargeur, on tire
                            {
                                Objective.hurt(this.getWeaponDamage()); 
                                this.currentBullets -= 1;
                            }
                            this.setRemainingUses();
                            System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                            this.getOwner().removeObject(this.getId());
                        }
                        else
                        {
                            System.out.println("YOU DONT HAVE A TARGET TO SHOOT, AT LEAST ... IS THERE A PHANTOM IN THE ROOM?");
                        }
                    }   
                    else
                    {
                        if(Objective != null)
                        {          
                            while(Objective.isAlive() && this.currentBullets > 0) //Pendant que notre objectif est vivant et on a des balles dans le chargeur, on tire
                            {
                                Objective.hurt(this.getWeaponDamage()); 
                                this.currentBullets -= 1;
                            }
                            this.setRemainingUses();
                        }
                        else
                        {
                            System.out.println("YOU DONT HAVE A TARGET TO SHOOT, AT LEAST ... IS THERE A PHANTOM IN THE ROOM?");
                        }
                    }
                }
            }
            else
            {
                System.out.println("IM SORRY BUT YOU CAN'T KILL YOURSELF WITH A WEAPON, BUT YOU CAN TRY WITH OTHER OBJECTS ...");
            }
        }
    }
}

