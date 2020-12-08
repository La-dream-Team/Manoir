
package Manor;


import java.util.ArrayList;

public class Map{
    
    public static ArrayList<Floor> initMap(){
        ArrayList<Floor> ret = new ArrayList<>();
        ret.add(initBasement());
        ret.add(initFirstFloor(ret.get(0)));
        
        return ret;
    }
    
    public static Floor initBasement(){
        Floor ret = new Floor("BASEMENT");
        
        // initialisation des salles 
        Room corridor0 = new Room("CORRIDOR0");
        ret.addRoom(corridor0);
        
        Room prison0 = new Room("PRISON0");
        ret.addRoom(prison0);
        Door priCorri = new Door();
        prison0.addDoor(priCorri);
        corridor0.addDoor(priCorri);
        Corpse watchMan = new Corpse("WHATCHMAN","YOU KILLED THIS MAN BY STRANGULATION !");
        prison0.addCorpse(watchMan);
        
        Room securityRoom0 = new Room("SECURTY-ROOM0");
        ret.addRoom(securityRoom0);
        Door secCorri = new Door();
        securityRoom0.addDoor(secCorri);
        corridor0.addDoor(secCorri);
        
        Room coffeeRoom0 = new Room("COFFEE-ROOM0");
        ret.addRoom(coffeeRoom0);
        Door cofCorri = new Door();
        coffeeRoom0.addDoor(cofCorri);
        corridor0.addDoor(cofCorri);
        
        Room stairs0 = new Room("STAIRS0");
        ret.addRoom(stairs0);
        Door staiCorri = new Door();
        stairs0.addDoor(staiCorri);
        corridor0.addDoor(staiCorri);
        
        return ret;
    }
    
    public static Floor initFirstFloor(Floor basement){
        Floor ret = new Floor("FIRST-FLOOR");
        
        // initialisation des salles 
        Room stairs0 = basement.getRoom("STAIRS0");
        ret.addRoom(stairs0);
        
        Room corridor1 = new Room("CORRIDOR1");
        ret.addRoom(corridor1);
        
        Room livingRoom1 = new Room("LIVINGROOM1");
        ret.addRoom(livingRoom1);
        Door livCorri = new Door();
        livingRoom1.addDoor(livCorri);
        corridor1.addDoor(livCorri);
        
        Room wc1 = new Room("WC1");
        ret.addRoom(wc1);
        Door wcCorri = new Door();
        wc1.addDoor(wcCorri);
        corridor1.addDoor(wcCorri);
        
        Room shop1 = new Room("SHOP1");
        ret.addRoom(shop1);
        Door shoCorri = new Door();
        shop1.addDoor(shoCorri);
        corridor1.addDoor(shoCorri);
        
        Room kitchen1 = new Room("KITCHEN1");
        ret.addRoom(kitchen1);
        Door kitCorri = new Door();
        kitchen1.addDoor(kitCorri);
        corridor1.addDoor(kitCorri);
        
        Room stairs1 = new Room("STAIRS1");
        ret.addRoom(stairs1);
        Door staiCorri = new Door();
        stairs1.addDoor(staiCorri);
        corridor1.addDoor(staiCorri);
        
        return ret;
    }
}