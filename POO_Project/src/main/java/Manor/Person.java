
package Manor;

import java.util.ArrayList;

public abstract class Person{
    
    // Attributes
    private final String name;
    private int hp; 
    private final int total_hp;
    private int bagSize = 0;
    private ArrayList<Object> bag = new ArrayList<>();
    private Object equippedItem;
    private Room currentRoom;
    

    //Constructors
    public Person(Room CurrentRoom) //Par defaut on creera un deadBody
    {
        this.name = "Corpse";
        this.hp = 0;
        this.total_hp = 0;
        this.bag = null;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
    }

    public Person(Person new_corpse) //Pour ceer un deadBody a partir d'une personne
    {
        this.name = new_corpse.name;
        this.hp = 0;
        this.total_hp = 0;
        this.bagSize = new_corpse.bagSize;
        this.bag = new_corpse.bag;
        this.equippedItem = null;
        this.currentRoom = new_corpse.currentRoom;
    }

    public Person(String Name, int Health, Room CurrentRoom) //Pour creer un personnage, par defaut il n'aura pas d'objet equipe
    {
        this.name = Name;
        this.hp = Health;
        this.total_hp = Health;
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
    
    public void setRoom(Room Room) 
    {
        this.currentRoom = Room;
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

    public void removeObject(int Id)
    {
        this.bag.remove(Id);
        this.bagSize -= 1;
    }

    public boolean hasObject(String name)
    {
        for(Object object : this.bag)
        {
            if(object.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    public int findIdObject(String name)
    {
        for(Object object : this.bag)
        {
            if(object.getName().equals(name))
            {
                return object.getId();
            }
        }
        return -1;
    }

    public void equipObject(String name)
    {
        if(this.hasObject(name) == true)
        {
            int item_id = this.findIdObject(name);
            if(this.bag.get(item_id) instanceof Weapon)
            {
                this.equippedItem = this.bag.get(item_id);
            }
            else
            {
                System.out.println("ERROR, ERROR, YOU CAN ONLY HAVE EQUIPPED WEAPONS");
            }
        }
    }

    public void unequipObject()
    {
        this.equippedItem = null; 
    }

    public void useObject(String Item, String Objective)
    {
        int ItemId = this.findIdObject(Item);
        if(Objective == null || Objective.equals(""))
        {
            if(this.bag.get(ItemId) instanceof Charger)
            {   
                if(this.equippedItem instanceof Gun){
                    this.equippedItem.reload();
                }
                else
                {
                    System.out.println("NONE OF YOUR WEAPONS CAN BE RECHARGED WITH THIS CHARGER");
                }
            }
            else
            {
                this.bag.get(ItemId).use(null);
            } 
        }
            //Object Element = this.bag.get(ItemId);
        else
        {
            if(this.currentRoom.isOnPersons(Objective) == true)
            {   
                Person Target = this.currentRoom.getPerson(Objective);
                if(this.bag.get(ItemId) instanceof Weapon)
                {
                    this.equippedItem.use(Target);
                }
                else
                {
                        
                    this.bag.get(ItemId).use(Target);
                }
            }
        }
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
            if(this.hp + receivedHealth >= this.total_hp)
            {
                this.hp = this.total_hp;
            }
            else
            {
                this.hp += receivedHealth;
            }
        }
    }
}