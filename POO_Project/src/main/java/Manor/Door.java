
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
    public Door(Room r){
        this.isOpen = this.DEFAULT_ISOPEN;
        this.rooms.add(r);
        this.id = currentid;
        currentid += 1;
    }
    
    public Door(){
        this.isOpen = this.DEFAULT_ISOPEN;
        this.id = currentid;
        currentid += 1;
    }
    
    public Door(Room r, Door d){
        this(r);
        
        this.connected = d; 
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
            System.err.println("erreur de creation de la carte le porte apartient deja a deux salles !");
        else{
            this.rooms.add(r);
            if(!r.isOnDoors(this))
                r.addDoor(this);
        }
    }
    
    public void print(){
        if(this.isOpen)
            System.out.print(getClass().getName()+ " "+ this.id + " is opened ");
        else
            System.out.print(getClass().getName()+ " "+ this.id + " is closed ");
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