
package Manor;

public abstract class Weapon extends Object{
    
    // Attributs
    private int weaponDamage;
    
    //Constructor
    public Weapon (String Name, int RemainingUses, int WeaponDamage)
    {
        super(Name, RemainingUses);
        this.weaponDamage = WeaponDamage;
    }  
    
    //Method
    public int getWeaponDamage()
    {
        return this.weaponDamage;
    }
    public void setWeaponDamage(int DmgCoef)
    {
        this.weaponDamage += DmgCoef;
    }
}