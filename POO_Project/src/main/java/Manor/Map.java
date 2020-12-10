
package Manor;


import java.util.ArrayList;

public class Map{
    
    public static ArrayList<Floor> initMap(float coef){
        ArrayList<Floor> ret = new ArrayList<>();
        ret.add(initBasement(coef));
        ret.add(initFirstFloor(ret.get(0), coef));
        
        return ret;
    }
    
    public static Floor initBasement(float coef){
        Floor ret = new Floor("BASEMENT");
        
        // initialisation des salles 
        Room corridor0 = new Room("CORRIDOR0");
        ret.addRoom(corridor0);
        
        Room prison0 = new Room("PRISON0");
        ret.addRoom(prison0);
        Door priCorri = new Door();
        prison0.addDoor(priCorri);
        DoorLockedOut corriPri = new DoorLockedOut();
        corridor0.addDoor(corriPri);
        
        corriPri.connectDoors(priCorri);
        
        // cadravre dans la prison
        Corpse watchMan = new Corpse("WHATCHMAN","YOU KILLED THIS MAN BY STRANGULATION !");
        prison0.addCorpse(watchMan);
        
        Room securityRoom0 = new Room("SECURTY-ROOM0");
        ret.addRoom(securityRoom0);
        KeyLockedDoor secCorri = new KeyLockedDoor();
        securityRoom0.addDoor(secCorri);
        corridor0.addDoor(secCorri);
        secCorri.createKey(10);
        
        Collectable note = new Collectable("NOTE0", 1, "A STRANGE PAPER", "911");
        securityRoom0.addObject(note);
        
        Room coffeeRoom0 = new Room("COFFEE-ROOM0");
        ret.addRoom(coffeeRoom0);
        Door cofCorri = new Door();
        coffeeRoom0.addDoor(cofCorri);
        corridor0.addDoor(cofCorri);
        
        // npc dans la salle
        Npc recuit = new Npc("RECRUIT0",10 ,coffeeRoom0, 10, coef, 1);
        coffeeRoom0.addPerson(recuit);
        //arme de la recrue
        MeleeWeapon knife = new MeleeWeapon("KNIFE0", 25, "A BASIC KNIFE", 25);
        recuit.addObject(knife);
        recuit.equipObject("KNIFE0");
        recuit.addObject(secCorri.getCurrentKey());
        
        Room stairs0 = new Room("STAIRS0");
        ret.addRoom(stairs0);
        CodeLockedDoor staiCorri = new CodeLockedDoor(911);
        stairs0.addDoor(staiCorri);
        corridor0.addDoor(staiCorri);
        
        return ret;
    }
    
    public static Floor initFirstFloor(Floor basement, float coef){
        Floor ret = new Floor("FIRST-FLOOR");
        
        // initialisation des salles 
        Room stairs0 = basement.getRoom("STAIRS0");
        ret.addRoom(stairs0);
        Door staiCorr = new Door();
        stairs0.addDoor(staiCorr);
        
        Room corridor1 = new Room("CORRIDOR1");
        ret.addRoom(corridor1);
        corridor1.addDoor(staiCorr);
        
        // creation et ajout d'une potion dans le couloir 
        Consumable potion = new Consumable("HEALING-POTION", "CAN HEAL SOMEBODY", 150);
        corridor1.addObject(potion);
        
        
        Room livingRoom1 = new Room("LIVINGROOM1");
        ret.addRoom(livingRoom1);
        Door livCorri = new Door();
        livingRoom1.addDoor(livCorri);
        corridor1.addDoor(livCorri);
        
        // ajout d'un calendier
        Collectable calendar = new Collectable("CALENDAR0", 1, "THIS IS THE CALENDAR OF LAST YEAR", "THE CALENDAR IS OPEN ON NOVEMBER 23 2017");
        livingRoom1.addObject(calendar);
        
        Room wc1 = new Room("WC1");
        ret.addRoom(wc1);
        CodeLockedDoor wcCorri = new CodeLockedDoor(415231117);
        wc1.addDoor(wcCorri);
        corridor1.addDoor(wcCorri);
        
        Room shop1 = new Room("SHOP1");
        ret.addRoom(shop1);
        Door shoCorri = new Door();
        shop1.addDoor(shoCorri);
        corridor1.addDoor(shoCorri);
        
        // Creation du marchant
        Trader trader = new Trader("RHORHO", 80, shop1, 150, coef);
        shop1.addPerson(trader);
        
        //Creation d'une arme et d'un chargeur
        Gun ak = new Gun("AK-47", 200, "A STRONG WEAPON", 150, 31);
        Charger rifleCharger = new Charger("RIFLE-AMMO", "A CHARGER FOR RIFLE WEAPON");
        MeleeWeapon longknife = new MeleeWeapon("LONG-KNIFE", 25, "A LARGE KNIFE", 1000);
        
        trader.addObject(ak);
        trader.addObject(rifleCharger);
        trader.addObject(longknife);
        
        Room kitchen1 = new Room("KITCHEN1");
        ret.addRoom(kitchen1);
        Door kitCorri = new Door();
        kitchen1.addDoor(kitCorri);
        corridor1.addDoor(kitCorri);
        
        // ajout d'une horloge
        Collectable clock = new Collectable("CLOCK0", 1, "THIS IS A BROCKEN CLOCK", "THE CLOCK IS FREEZ ON 4AM15");
        kitchen1.addObject(clock);
        
        Room stairs1 = new Room("STAIRS1");
        ret.addRoom(stairs1);
        KeyLockedDoor staiCorri = new KeyLockedDoor();
        stairs1.addDoor(staiCorri);
        corridor1.addDoor(staiCorri);
        staiCorri.createKey(10);
        
        // on met la clef dans les toilletes
        wc1.addObject(staiCorri.getCurrentKey());
        
        
        return ret;
    }
}