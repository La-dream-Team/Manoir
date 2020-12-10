
package Manor;

import java.util.ArrayList;

public class Door implements Closeable {
    // attributs
    private boolean isOpen;
    // La ou les pices dont la porte appartient
    private ArrayList<Room> rooms = new ArrayList<>();
    // l'id de la porte 
    private final int id;
    
    // connect permet de trouver dans quelle salle ce situe l'autre coter de la porte
    // car les portes peuvent avoir deux faces differents
    private Door connected;

    private static int currentid = 0;
    private final boolean DEFAULT_ISOPEN = false ; 
    
    // constructeur(s)
    
    public Door(){
        this.isOpen = this.DEFAULT_ISOPEN;
        this.id = currentid;
        currentid += 1;
    }
    
    // methodes 
    public int getID(){
        return this.id;
    }
    
    public boolean getIsOpen() {
        return this.isOpen; 
    }
    
    public Door getconnected(){
        return this.connected;
    }
    
    public void open(){
        this.isOpen = true;
    }
    
    public void close(){
        this.isOpen = false;
    }
    
    public void connectDoors(Door d){
        this.removeConnected();
        
        this.connected = d;
        
        // si la door qu'on ajoute n'est pas connecter a celle-ci 
        if(d.connected != this){
            d.connectDoors(this);
        }
    }
    
    
    // on vide les atributs des deux portes
    public void removeConnected(){ 
        if(this.connected != null){
            Door current = this.connected;
            if(current.connected != null){
                this.connected = null;
                current.removeConnected();
            }   
            else 
                this.connected = null;
        }
    }
    
    public void addRoom(Room r){
        if(this.rooms.size() > 1)
            System.err.println("CREATION ERROR, THE DOOR IS ALREADY ON TWO DIFFERENT ROOMS !");
        else{
            this.rooms.add(r);
            if(!r.isOnDoors(this))
                r.addDoor(this);
        }
    }
    
    public void print(){
        if(this.isOpen)
            System.out.print(" IT'S OPENED");
        else
            System.out.print(" IT'S CLOSED");
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
    
    
    public boolean isContact(Room r){
        if(this.getconnected() != null ){
            Door d2 = this.getconnected();
            return (d2.isOnRooms(r) || this.isOnRooms(r));
        }
        else 
            return this.isOnRooms(r);
    }
    
    public String getNameOtherRoom(Room r){
        String ret = null;
        if(this.connected == null){
            for(Room currentr : this.rooms){
                if(currentr != r)
                    ret = currentr.getName();
            }
        }
        else{
            // revoie le nom de la prochaine salle
            ret = this.connected.rooms.get(0).getName();
        }
        return ret;
    }
}
