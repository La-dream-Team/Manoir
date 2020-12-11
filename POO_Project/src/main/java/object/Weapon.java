
package object;

import person.Person;
import person.Player;

public abstract class Weapon extends Object{
    
    // Attributs
    private int weaponDamage;
    
    //Constructor
    public Weapon (String Name, int RemainingUses, String Description, int WeaponDamage)
    {
        super(Name, RemainingUses, Description);
        this.weaponDamage = WeaponDamage;
    }  
    
    //Method
    public int getWeaponDamage()
    {
        return this.weaponDamage;
    }
    
    public void setWeaponDamage(float Coefficient)
    {
        this.weaponDamage = (int)((float)this.weaponDamage * Coefficient);
    }
    
    @Override
    public void use(Person Objective){
        if(super.getOwner() instanceof Player){
            // si un jouteur attaque un enemie dan une salle tous les npc sont aggressifs
            super.getOwner().getRoom().switchModeForAll();
        }
    }
}