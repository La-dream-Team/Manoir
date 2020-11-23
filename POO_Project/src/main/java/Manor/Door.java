
package Manor;

import java.util.ArrayList;

public class Door implements Closeable {
    // attributs
    private boolean isOpen;
    private ArrayList<Room> rooms = new ArrayList<>();
    private final int number;

    private static int current = 0;
    private final boolean DEFAULT_ISOPEN = false ; 
    
    // constructeur(s)
    public Door(Room r){
        this.isOpen = this.DEFAULT_ISOPEN;
        this.rooms.add(r);
        this.number = current;
        current ++;
    }
    
    // methodes 
    public void addRoom(Room r){
        if(this.rooms.size() > 1)
            System.err.println("erreur de creation de la carte le porte apartient deja a deux salles !");
        else{
            this.rooms.add(r);
            if(!r.isOnDoors(this))
                r.addDoor(this);
        }
    }

    public void open(){
        this.isOpen = true;
    }
    
    public void close(){
        this.isOpen = false;
    }
    
    public void print(){
        if(this.isOpen)
            System.out.print(getClass().getName()+ " "+ this.number + " is opened ");
        else
            System.out.print(getClass().getName()+ " "+ this.number + " is closed ");
    }
    
    public boolean getIsOpen() {
        return this.isOpen; 
    }
    
    public int getNumber(){
        return this.number;
    }

    public boolean isOnRooms(Room r){
        boolean ret = false;
        for(Room current : this.rooms){
            if(current == r){
                ret = true;
                break;
            }
        }
        return ret;
    }
}
