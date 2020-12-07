
package Manor;

import java.util.ArrayList;

public class Floor{

    // Attributs
    private ArrayList<Room> rooms = new ArrayList<>();
    private final String name;
    
    // constrcuteurs 
    public Floor(String name){
        this.name = name;
    }
    
    public boolean isOnRooms(Room r ){
        boolean ret = false;
        for(Room current : this.rooms){
            if(current == r){
                ret =true;
                break;
            }
        }
        return ret;
    }
    
    public void addRoom(Room r){
        if(!this.isOnRooms(r)){
            this.rooms.add(r);
        }
    }
    
    
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
}