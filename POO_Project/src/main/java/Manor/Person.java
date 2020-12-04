
package Manor;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Person{
    
    // Attributes
    private final String name;
    private int current_hp; 
    private final int total_hp;
    ArrayList<Object> bag = new ArrayList<>();
    private Weapon equippedItem;
    private Room currentRoom;
    //private int balance;
    private final int DEFAULT_BAGSIZE = 6;
    

    //Constructors
    public Person(Room CurrentRoom) //Par defaut on creera un deadBody
    {
        this.name = "Corpse";
        this.current_hp = 0;
        this.total_hp = 0;
        this.bag = null;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
        //this.balance = 0;
    }

    public Person(Person NewCorpse) //Pour ceer un deadBody a partir d'une personne
    {
        this.name = NewCorpse.name;
        this.current_hp = 0;
        this.total_hp = 0;
        this.bag = NewCorpse.bag;
        this.equippedItem = null;
        this.currentRoom = NewCorpse.currentRoom;
        //this.balance = 0;
    }

    public Person(String Name, int Health, Room CurrentRoom) //Pour creer un personnage, par defaut il n'aura pas d'objet equipe
    {
        this.name = Name;
        this.current_hp = Health;
        this.total_hp = Health;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
        //this.balance = 0;
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
    
    public ArrayList getBag()
    {
        return this.bag;
    }
    
    public Weapon getEquippedItem()
    {
        return this.equippedItem;
    }
    
    public void setRoom(String r) 
    {
        if(this.currentRoom != null)
        {
            this.removeRoom();
            this.currentRoom = Room;
            this.currentRoom.addPerson(this);
        }
        else
        {
            this.currentRoom = Room;
            this.currentRoom.addPerson(this);
        }
    }
    
    public void removeRoom() 
    {
        Room CurrentRoom = this.getRoom();
        this.currentRoom = null;
        CurrentRoom.removePerson(this);
    }
    
    public void addObject(Object item)
    {
        if(!this.hasObject(item.getName())){
            if(item.getOwner() == null){
                if(this.bag.size() < this.DEFAULT_BAGSIZE)
                {
                    item.setOwner(this);
                    this.bag.add(item);
                }
                else
                {
                    System.out.println("IM SORRY BUT YOU DON'T HAVE ENOUGH SPACE IN YOUR INVENTORY");
                }
            } 
            else
            {
                System.out.println("THIS" + item.getName() + "HAS ALREADY AN OWNER");
            }
        }
        else
        {
            System.out.println("YOU ALREADY HAVE THIS ITEM");
        }
    }

    public void removeObject(int Id)
    {
        if(this.hasObject(this.bag.get(Id).getName())){
            Object Item = this.bag.get(Id);
            this.bag.remove(Id);
            if(Item.getOwner() != null){
                Item.setOwner(null);
            } 
        }
    }

    public boolean hasObject(String name)//test persone a object
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

    public int findObject(String name)
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

    public boolean isAlive()
    {
        if(this.current_hp > 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public void hurt(int receivedDamage)
    {
        if(this.current_hp - receivedDamage <= 0)
        {
            this.current_hp = 0;
        } 
        else
        {
            this.current_hp -= receivedDamage;
        }
    }

    public void heal(int receivedHealth)
    {
        if(this.isAlive() == true)
        {
            if(this.current_hp + receivedHealth >= this.total_hp)
            {
                this.current_hp = this.total_hp;
            }
            else
            {
                this.current_hp += receivedHealth;
            }
        }
    }
    public void equipObject(String name){
        if(this.hasObject(name))
        {
            int item_id = this.findObject(name);
            if(this.bag.get(item_id) instanceof Weapon)
            {
                this.equippedItem = (Weapon)this.bag.get(item_id);
            }
            else
            {
                System.out.println("ERROR, ERROR, YOU CAN ONLY HAVE EQUIPPED WEAPONS");
            }
        }
    }

    public void unequipObject()
    {   
        if(this.equippedItem != null)
        {
            this.equippedItem = null;
        }
    }

    public void useObject(String Item, String Objective)
    {
        if(Item == null || Item.equals(""))
        {
            System.out.println("IF YOU WANT TO USE AN OBJECT THE PROGRAMMERS HAVE TO KNOW THE NAME OF THE OBJECT");
        }
        else
        {
            if(this.hasObject(Item))
            {
                int ItemId = this.findObject(Item);
                if(Objective == null || Objective.equals(""))
                {
                    this.bag.get(ItemId).use(null);
                }
                else
                {
                    if(this.currentRoom.isOnPersons(Objective))
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
            else
            {
               System.out.println("ERROR, ERROR, YOU DONT HAVE THE ITEM YOU ARE REQUESTING FOR");
            }
        }
    }
    
    public void printInventory(){
        Iterator<Object>reader=bag.iterator();
        while (reader.hasNext()){
            Object rator = reader.next();
            System.out.println(rator+"/");
        }        
    }
}