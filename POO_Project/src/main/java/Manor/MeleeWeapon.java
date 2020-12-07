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
public class MeleeWeapon extends Weapon{
    
    public MeleeWeapon(String MeleeWeaponName, int RemainingUses, String Description, int MeleeWeaponDamage)
    {
        super(MeleeWeaponName, RemainingUses, Description, MeleeWeaponDamage);
    }   
    
    @Override
    public void use(Person Objective)
    {
        if(this.hasOwner())
        {
            if((MeleeWeapon)this.getOwner().getEquippedItem() == this)
            {
                if(this.getOwner() != Objective)
                {
                    if(this.canUse())
                    {
                        if(this.getRemainingUses() == 1)
                        {
                            if(Objective == null)
                            {
                                System.out.println("THERE AREN'T ENEMIES AROUND YOU, DO YOU HAVE VISIONS?");
                            }
                            else if(Objective.isAlive())
                            {
                                Objective.hurt(this.getWeaponDamage());
                                this.setRemainingUses();
                                System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                                this.getOwner().removeObject(this.getId());
                            }
                        }
                        else
                        {
                            if(Objective == null)
                            {
                                System.out.println("THERE AREN'T ENEMIES AROUND YOU, DO YOU HAVE VISIONS?");
                            }
                            else if(Objective.isAlive())
                            {
                                Objective.hurt(this.getWeaponDamage());
                                this.setRemainingUses();
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("IM SORRY BUT YOU CAN'T KILL YOURSELF WITH A WEAPON, BUT YOU CAN TRY WITH OTHER OBJECTS ...");
                }
            }
            else
            {
                System.out.println("YOU HAVE TO HAVE EQUIPPED THE WEAPON YOU WANT TO USE BEFORE USING IT");
            }
        }
    }
}
