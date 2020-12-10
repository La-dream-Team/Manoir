
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
    private static final int DEFAULT_BAGSIZE = 6;
   
    public Person(String name, int health, Room currentRoom, int money) //Pour creer un personnage, par defaut il n'aura pas d'objet equipe
    {
        this.name = name;
        this.current_hp = health;
        this.total_hp = health;
        this.equippedItem = null;
        this.currentRoom = currentRoom;
        this.money = money;
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
    
    public ArrayList<Object> getBag()
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
    
    public void changeRoom(Room r){
        if(this.currentRoom.isOnPersons(this.getName()))
            this.removeRoom();
        this.currentRoom = r;
    }
    
    public int setRoom(Room r) 
    {
        int ret = 0;
        if(this.currentRoom == null){
            System.err.print("THIS PERSON HAVEN'T CURRENT ROOM !");
            // erreur on arrete le jeu 
            ret = -1;
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
                    ret = 1;
                }
                else{
                    if(dcurrent instanceof DoorLockedOut){
                        System.out.println("THIS DOOR'S FOR EVER CLOSED !");
                    }
                    else{
                        System.out.println("THE " + dcurrent.getClass().getSimpleName().toUpperCase() + " ISN'T OPENED !");
                        
                    }
                    // le jeu n'a pas été mis a jour 
                    ret = 0;
                }
            }
            else{
                System.out.println("THE TARGET DOOR'S TO FAR !");
                // le jeu n'a pas été mis a jour 
                
                ret = 0;
            }
        }
        return ret;
    }
    
    public void removeRoom() 
    {
        if(this.currentRoom != null)
            this.currentRoom.removePerson(this.getName());
        
    }
    
    public void addObject(Object item) //MODIF
    {
        if(item != null)
        {
            if(!this.hasObject(item.getName())){
            
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
                System.out.println("YOU ALREADY HAVE THIS ITEM");
            }
        }
        else
        {
            System.out.println("THE OBJECT YOU WANT TO ADD DON'T EXIST");
        }
    }

    public void removeObject(Object o)
    {
        if((Object)this.equippedItem == o)
        {
            this.unequipObject();
        }
        o.setOwner(null);
        this.bag.remove(o);
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
                this.removeObject(object);
            }
        }
    }
    
    public void dropObjects()
    {
        for(Object current : this.bag)
        {
            this.getRoom().addObject(current);
        }
        this.bag.clear();
    }
    
    public Object stringToObject(String name)
    {
        Object ret = null;
        for(Object object : this.bag)
        {
            if(object.getName().equals(name))
            {
                ret = object;
                break;
            }
        }
        return ret;
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
    
    public int findIndex(String name)
    {
        int index = -1;
        for(int i = 0; i < this.bag.size(); i++)
        {
            if(this.bag.get(i).getName().equals(name))
            {
                index = i;
                break;
            }
        }
        return index;
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
    
    public int equipObject(String name){
        if(this.hasObject(name))
        {
            Object currento = this.stringToObject(name);
            if(currento instanceof Weapon)
            {
                this.equippedItem = (Weapon)currento;
            }
            else
            {
                System.out.println("ERROR, ERROR, YOU CAN ONLY HAVE EQUIPPED WEAPONS");
            }
            return 1;
        }
        else 
            return 0;
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
                int ItemIndex = this.findIndex(Item);
                if(Objective == null || Objective.equals(""))
                {
                    this.bag.get(ItemIndex).use(null);
                }
                else
                {
                    if(this.currentRoom.isOnPersons(Objective))
                    {   
                        Person Target = this.currentRoom.getPerson(Objective);
                        this.bag.get(ItemIndex).use(Target);
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
            System.out.println(i + "-" + this.bag.get(i).getName() + "-" + this.bag.get(i).getDescription());
        }       
        
        if(this.equippedItem != null)
            System.out.println("YOUR EQUIPPED WEAPON IS " + this.equippedItem.getName());
    }
}