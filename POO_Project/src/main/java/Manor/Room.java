
package Manor;

import java.util.ArrayList;

public class Room{

    //Attributs
    private String name ;
    private ArrayList<Door> doors = new ArrayList<>();
    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Person> persons = new ArrayList<>(); 
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
    
    public void addDoor(Door d){
        if(!this.isOnDoors(d)){
            this.doors.add(d);
            if(!d.isOnRooms(this))
                d.addRoom(this);
        }
    }
    
    public void addDoor(){
        Door current = new Door();
        this.doors.add(current);
        current.addRoom(this);
    }

    public void removeDoor(Door d){
        this.doors.remove(d);
    }
    

    //Get door on room
}