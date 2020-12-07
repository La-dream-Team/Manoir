
package Manor;

import java.util.ArrayList;

public abstract class Person{
    
    // Attributes
    private final String name;
    private int current_hp; 
    private final int total_hp;
    ArrayList<Object> bag = new ArrayList<>();
    private Weapon equippedItem;
    private Room currentRoom;
    private int money;
    private final int DEFAULT_BAGSIZE = 6;
    

    //Constructors
    public Person(Room CurrentRoom) //Par defaut on creera un deadBody
    {
        this.name = "CORPSE";
        this.current_hp = 0;
        this.total_hp = 0;
        this.bag = null;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
        this.money = 0;
    }

    public Person(Person NewCorpse) //Pour ceer un deadBody a partir d'une personne
    {
        this.name = NewCorpse.name;
        this.current_hp = 0;
        this.total_hp = 0;
        this.bag = NewCorpse.bag;
        this.equippedItem = null;
        this.currentRoom = NewCorpse.currentRoom;
        this.money = NewCorpse.money;
    }

    public Person(String Name, int Health, Room CurrentRoom, int Money) //Pour creer un personnage, par defaut il n'aura pas d'objet equipe
    {
        this.name = Name;
        this.current_hp = Health;
        this.total_hp = Health;
        this.equippedItem = null;
        this.currentRoom = CurrentRoom;
        this.money = Money;
    }

    //Methods
    public String getName()
    {
        return this.name;
    }
    
    public int getCurrentHp()
    {
        return this.current_hp;
    }
    
    public void setCurrentHp(int newHp)
    {
        this.current_hp = newHp;
    }
    
    public ArrayList getBag()
    {
        return this.bag;
    }
    
    public int getDefaultBagSize()
    {
        return this.DEFAULT_BAGSIZE;
    }
    
    public Weapon getEquippedItem()
    {
        return this.equippedItem;
    }
    
    public Room getRoom() 
    {
        return this.currentRoom;
    }
    
    public int setRoom(Room r) 
    {
        if(this.currentRoom == null){
            System.err.print("This person haven't current room !");
            // erreur on arrete le jeu 
            return -1; 
        }
        else{
            Door dcurrent = this.currentRoom.isNextRoom(r);
            // si les deux pièces sont proches
            if(dcurrent != null){
                // le joueur ne peux pas passer à travers les portes 
                if(dcurrent.getIsOpen()){
                    // la porte est ouverte donc le joueur peux passer dans l'autre salle
                    this.removeRoom();
                    this.currentRoom = r;
                    r.addPerson(this);
                    
                    // un changement a été fait dans le jeu 
                    return 1;
                }
                else{
                    System.out.println("The " + dcurrent.getClass().getSimpleName() + " isn't opened !");
                    // le jeu n'a pas été mis a jour 
                    return 0;
                }
            }
            else{
                System.out.println("The target door's to far !");
                // le jeu n'a pas été mis a jour 
                return 0;
            }
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
            
            if(this.bag.size() < this.DEFAULT_BAGSIZE)
            {
                if(item.getOwner() == null)
                {
                    this.currentRoom.removeObject(item); //On enleve l'objet de la piece ou il se trouve et on le met dans le sac
                    item.setOwner(this);
                    this.bag.add(item);
                }
                else //Si l'objet possede deja un propietaire on change le propietaire
                {
                    item.getOwner().removeObject(item.getId());
                    item.setOwner(this);
                    this.bag.add(item);
                }
            }
            else
            {
                System.out.println("IM SORRY BUT YOU DON'T HAVE ENOUGH SPACE IN YOUR INVENTORY");
            } 
        }
        else
        {
            System.out.println("YOU ALREADY HAVE THIS ITEM");
        }
    }

    public void removeObject(int Id)
    {
        for(Object object : this.bag)
        {
            if(object.getId() == Id)
            {
                if(object.getOwner() != null)
                {
                    object.setOwner(null);
                } 
                this.bag.remove(object);
            }
        }
    }
    
    public boolean hasObject(String name)//test persone possede object
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
    
    public void dropObject(String name)
    {
        for(Object object : this.bag)
        {
            if(object.getName().equals(name))
            {
                this.currentRoom.addObject(object);
                this.removeObject(object.getId());
            }
        }
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
            System.out.println("IF YOU WANT TO USE AN OBJECT THE PROGRAMMERS HAVE TO KNOW THE NAME OF IT");
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
                            if(ItemId == this.equippedItem.getId())
                            {
                                this.equippedItem.use(Target);
                            }
                            else
                            {
                                System.out.println("YOU HAVE TO HAVE EQUIPPED THE WEAPON YOU WANT TO USE BEFORE USING IT");
                            }
                        }
                        else
                        {   
                            this.bag.get(ItemId).use(Target);
                        }
                    }
                    else
                    {
                        System.out.println("THE PERSON YOU WANT TO ATTACK IS NOT ON THIS ROOM");
                    }
                }
            }
            else
            {
               System.out.println("ERROR, ERROR, YOU DONT HAVE THE ITEM YOU ARE REQUESTING FOR");
            }
        }
    }
    
    public int getMoney()
    {
        return this.money;
    }
    
    public void addMoney(int Money)
    {
        this.money += Money;
    }
    
    public void substractMoney(int Money)
    {
        this.money -= Money;
    }
    
    public void printInventory(){
        for (int i = 0; i < this.bag.size(); i++) 
        {
            System.out.println(i + "-" + this.bag.get(i).getName());
        }       
    }
}