
package manor;

import person.Person;
import person.Npc;
import person.Trader;
import person.Corpse;
import person.Player;
import object.Object;
import door.Door;
import java.util.ArrayList;

public class Room{

    //Attributs
    private String name ;
    private ArrayList<Door> doors = new ArrayList<>();
    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Person> persons = new ArrayList<>(); 
    private ArrayList<Corpse> corpses = new ArrayList<>();
    // l'id de la porte 
    private final int id;
    
    
    private static int current = 0;
    // constructeurs 
    public Room(String n){
        this.name = n; 
        
        this.id = current; 
        current ++;
    }

    // methodes
    public String getName(){
        return this.name;
    }
    
    public boolean isOnDoors(Door d){
        boolean ret = false;
        for(Door current : this.doors){
            if(current == d ){
                ret = true;
                break;
            }
        }
        return ret;
    }
    
    public ArrayList<Door> getDoors(){
        return this.doors;
    }
    
    public void addDoor(Door d){
        if(!this.isOnDoors(d)){
            this.doors.add(d);
            if(!(d.isOnRooms(this)))
                d.addRoom(this);
        }
    }

    public void removeDoor(Door d){
        this.doors.remove(d);
    }
    
    public boolean isOnPersons(String n){
        boolean ret = false;
        for(Person current : this.persons){
            if(current.getName().equals(n) ){
                ret = true;
                break;
            }
        }
        return ret;
    }

    public Person getPerson(String n){
        Person ret = null;
        for(Person current : this.persons){
            if(current.getName().equals(n)){
                ret = current;
                break;
            }
        }
        return ret;
    }
    
    public ArrayList<Person> getPersons(){
        return this.persons;
    }
    
    
    public void addPerson(Person p){
        this.persons.add(p);
        if(p.getRoom() != this){
            p.changeRoom(this);
        }
    }
    
    public void removePerson(String name){
        if(this.isOnPersons(name)){
            Person current = this.getPerson(name);
            this.persons.remove(current);
            if(current.getRoom() != null){
                current.changeRoom(null);
            } 
        }
        else{
            System.out.println(name + " IS NOT ON " + this.name + "!");
        }
    }
    
    public boolean isOnObjects(Object o){
        boolean ret = false;
        for(Object current : this.objects){
            if(current == o){
                ret = true;
                break;
            }
        }
        return ret;
    }
    
    public void addObject(Object o){
        if(this.isOnObjects(o))
            System.err.print("THE OBJECT IS ALREADY PRESENT ON THIS ROOM!");
        else{
            this.objects.add(o);
        }
    }
    
    public void removeObject(Object o){
        if(this.isOnObjects(o))
            this.objects.remove(o);
        else
            System.out.println(o.getName() + "IS NOT ON" + this.name + "!");
    }
    
    public boolean isOnCorpse(Corpse c){
        boolean ret = false;
        for(Corpse current : this.corpses){
            if(current == c){
                ret = true;
                break;
            }
        }
        return ret;
    }
    
    public void addCorpse(Corpse c){
        if(this.isOnCorpse(c)){
            System.err.print("THE CORPSE IS ALREADY PRESENT ON THIS ROOM!");
        }
        else
            this.corpses.add(c);
    }
    
    public void print(Player p){
        System.out.println("YOU ARE ON THE " + this.name + ".");
        if(this.objects.size() != 0){
            System.out.println("THESE ARE THE DIFERENTS OBJECTS ON THE ROOM :");
            for(Object currento : this.objects){
                System.out.println("   -" + currento.getName() + " : " + currento.getDescription());
            }
        }
        else
            System.out.println("THERE ARE NO OBJECTS ON THIS ROOM !");
        
        if(this.corpses.size() != 0){
            System.out.println("THESE ARE THE DIFERENTS CORPSE ON THE ROOM :");
            for(Corpse currentc : this.corpses){
                System.out.println("   -" + currentc.getName() + " : " + currentc.getDesc());
            }
        }
            
        if(this.persons.size() != 1){
            System.out.println("THESE ARE THE DIFERENTS PERSONS ON THE ROOM :");
            for(Person currentp : this.persons){
                if(currentp != p)
                    System.out.println("   -" + currentp.getName());
            }
        }
        else
            System.out.println("THERE IS NOBODY IN THE ROOM !");
        
        if(this.doors.size() != 0){
            System.out.println("THESE ARE THE ROOMS NEARBY THIS ROOM :");
            for(Door currentd : this.doors){
               System.out.print("   -" + currentd.getNameOtherRoom(this) + "(" 
                       + currentd.getClass().getSimpleName().toUpperCase() + " NUMBER " + currentd.getID() + ")");
               currentd.print();
               System.out.println();
            }
        }
        else{
            System.err.println("THE PLAYER IS BLOCKED !");
        }
    }
    
    
    // renvoie une porte null si les deux salles ne sont pas a cotés 
    public Door isNextRoom(Room r){
        Door ret = null;
        for(Door currentd : this.doors){
            if(currentd.isContact(r)){
                ret = currentd;
                break;
            }
        }
        return ret;
    }
    
    public void printMarkets(){
        ArrayList<Person> traders = new ArrayList<>();
        for(Person current : this.persons){
            if(current instanceof Trader){
                traders.add(current);
            }
        }
        
        int len = traders.size();
        
        if(len != 0){
            if(len > 1){
                System.out.println("HERE ARE THE DIFFERENT TRADERS:");
            }
            else{
                System.out.println("HERE IS THE TRADER :");
            }
            
            for(Person current : traders){
                System.out.println("INVENTORY OF " + current.getName() + ":");
                current.printInventory();
            }
                    
        }
        else{
            System.out.println("THERE IS NOT A TRADER ON THIS ROOM");
        }
    }
    
    public Object stringToObject(String name)
    {
        Object ret = null;
        for(Object object : this.objects)
        {
            if(object.getName().equals(name))
            {
                ret = object;
                break;
            }
        }
        return ret;
    }
    
    public void switchModeForAll()
    {
        for(Person p : this.persons)
        {
            if(p instanceof Npc)
            {
                ((Npc) p).switchMode();
            }
        }
    }
    
   public Person giveMeTrader(String trader){
       Person ret = null;
       for(Person current : this.persons){
           if(trader.equals(current.getName())){
               if(current instanceof Trader){
                   ret = current;
               }
               break;
           }
       }       
       
       return ret;
   }
   
   public Door giveMeDoor(int number ){
       Door ret = null;
       
       for(Door current : this.doors){
           if(number == current.getID()){
               ret = current;
               break;
           }
       }
       
       return ret;
   }
}