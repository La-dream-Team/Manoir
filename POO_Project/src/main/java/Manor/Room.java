
package Manor;

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
            if(!d.isOnRooms(this))
                d.addRoom(this);
        }
    }

    public void removeDoor(Door d){
        this.doors.remove(d);
    }
    
    public boolean isOnPersons(String n){
        boolean ret = false;
        for(Person current : this.persons){
            if(current.getName() == n ){
                ret = true;
                break;
            }
        }
        return ret;
    }

    public Person getPerson(String n){
        Person ret = null;
        for(Person current : this.persons){
            if(current.getName() == n){
                ret = current;
                break;
            }
        }
        return ret;
    }
    
    
    public void addPerson(Person p){
        this.persons.add(p);
    }
    
    public void removePerson(Person p){
        if(this.isOnPersons(p.getName())){
            this.persons.remove(p);
            if(p.getRoom() != null){
                p.removeRoom();
            } 
        }
        else{
            System.out.println(p.getName() + " isn't on " + this.name + "!");
        }
    }
    
    public void addDoors(ArrayList<Door> ds){
        for(Door current : ds){
            if(!(this.isOnDoors(current))){
                this.doors.add(current);
            }
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
            System.err.print("This object is already present in the room !");
        else{
            this.objects.add(o);
        }
    }
    
    public void removeObject(Object o){
        if(this.isOnObjects(o))
            this.objects.remove(o);
        else
            System.out.println(o.getName() + " isn't on " + this.name + "!");
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
            System.err.print("this corpse is already present in the room !");
        }
        else
            this.corpses.add(c);
    }
    
    public void print(){
        
    }
}