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
    
    public MeleeWeapon(String MeleeWeaponName, int RemainingUses, String Description, Person Owner, int MeleeWeaponDamage)
    {
        super(MeleeWeaponName, RemainingUses, Description, Owner, MeleeWeaponDamage);
    }
    
    @Override
    public void use(Person Objective)
    {
        if(this.hasOwner())
        {
            if(this.canUse())
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
            else
            {
                System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                this.getOwner().removeObject(this.getId());
            }
        }
    }
}
