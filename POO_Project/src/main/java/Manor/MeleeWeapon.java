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
    
    public MeleeWeapon(String MeleeWeaponName, int RemainingUses, int MeleeWeaponDamage)
    {
        super(MeleeWeaponName, RemainingUses, MeleeWeaponDamage);
    }   
    
    @Override
    public void use(Person Objective)
    {
        if(this.canUse() == true)
        {
            if(Objective == null)
            {
                System.out.println("THERE AREN'T ENEMIES AROUND YOU, DO YOU HAVE VISIONS?");
            }
            else if(Objective.isAlive() == true)
            {
                Objective.hurt(this.getWeaponDamage());
                this.canUse();
            }
        }
        else
        {
            System.out.println("YOUR" + this.getName() + "IT'S BROKEN");
        }
    }
}
