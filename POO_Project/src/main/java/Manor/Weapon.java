
package Manor;

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
    
    public void setWeaponDamage(float DmgCoef)
    {
        this.weaponDamage += (int)DmgCoef;
    }
}