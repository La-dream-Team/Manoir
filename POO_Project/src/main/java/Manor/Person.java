
package Manor;

import java.util.ArrayList;

public abstract class Person{
    
    // Attributes
    private String name;
    private int hp; 
    private int bagSize;
    private ArrayList<Object> bag = new ArrayList<>();
    private Object equippedItem;
    private Room currentRoom;
    private final int DEFAULT_HP;

    //Constructors
    public Person(Room CurrentRoom) //Par defaut on creera un deadBody
    {
        this.name = "Corpse";
        this.hp = 0;
        this.DEFAULT_HP = 0;
        this.bagSize = 0;
        this.bag = null;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
    }

    public Person(String Name, Room CurrentRoom) //Pour ceer un deadBody a partir d'une personne
    {
        this.name = Name;
        this.hp = 0;
        this.DEFAULT_HP = 0;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
    }

    public Person(String Name, int Health, Room CurrentRoom) //Pour creer un personnage, par defaut il n'aura pas d'objet equipe
    {
        this.name = Name;
        this.hp = Health;
        this.DEFAULT_HP = Health;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
    }

    //Methods
    public String getName()
    {
        return this.name;
    }

    public Room getRoom() 
    {
        return this.currentRoom;
    }

    public void addObject(Object item)
    {
        this.bag.add(item);
        this.bagSize += 1;
    }

    /*public void removeObject(Object item)
    {
        this.bag.remove(item));
    }*/

    public void removeObject(int ID)
    {
        this.bag.remove(ID);
        this.bagSize -= 1;
    }

    public boolean hasObject(String name)
    {
        for(Object object : this.bag)
        {
            if(object.getName() == name)
            {
                return true;
            }
        }
        return false;
    }

    public Object findObject(String name)
    {
        for(Object object : this.bag)
        {
            if(object.getName() == name)
            {
                return object;
            }
        }
    }

    public void equipObject(String name)
    {
        if(this.hasObject(name))
        {
            this.equippedItem = this.findObject(name);
        }
    }

    public void unequipObject(String name)
    {
        if(this.hasObject(name) == true)
        {
            this.equippedItem = null;
        }
    }

    public void reloadWeapon() {
        if(this.equippedItem instanceof Weapon)
        {
            if(this.findObject(this.equippedItem.getName()) instanceof Ammunition)//Si on a de la munition pour notre arme
            {
                this.equippedItem.reload();
                Ammunition ammo = this.findObject(this.equipedItem.getName());
                this.removeObject(ammo.getId());
            }
            else
            {
                System.out.println("YOU DONT HAVE THE AMMO NEEDED TO RELOAD, IM SORRY");
            }
        }
        else
        {
            System.out.println("YOU CANT RELOAD THIS ITEM, I MEAN YOU CAN TRY BUT I DONT THINK YOU WILL SUCCED");
        }
    }

    public void useObject(Person objective)
    {
        this.equippedItem.useObject(objective);
    }

    public boolean isAlive()
    {
        if(this.hp > 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public void hurt(int weaponDamage)
    {
        if(this.hp - weaponDamage <= 0)
        {
            this.hp = 0;
        } 
        else
        {
            this.hp -= weaponDamage;
        }
    }

    public void heal(int receivedHealth)
    {
        if(this.isAlive() == true)
        {
            if(this.hp + receivedHealth >= this.DEFAULT_HP)
            {
                this.hp = this.DEFAULT_HP;
            }
            else
            {
                this.hp += receivedHealth;
            }
        }
    }
}