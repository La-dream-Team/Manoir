
package manor;


import person.Trader;
import person.Npc;
import person.Corpse;
import object.Charger;
import object.Collectable;
import object.Consumable;
import object.Gun;
import object.MeleeWeapon;
import door.CodeLockedDoor;
import door.Door;
import door.KeyLockedDoor;
import door.DoorLockedOut;
import door.DoorWithLock;
import java.util.ArrayList;

public class Map{
    
    public static Floor getFloor(ArrayList<Floor> l, String name){
        Floor ret = null;
        for(Floor current : l){
            if(current.getName().equals(name))
            {
                ret = current;
                break;
            }
        }
        return ret;
    }
    
    public static ArrayList<Floor> initMap(float coef){
        ArrayList<Floor> ret = new ArrayList<>();
        ret.add(initBasement(coef));
        ret.add(initFirstFloor(getFloor(ret, "BASEMENT"), coef));
        ret.add(initSecondFloor(getFloor(ret, "FIRST-FLOOR"), coef));
        ret.add(initThirdFloor(getFloor(ret, "SECOND-FLOOR"), coef));
        ret.add(initLastFloor(getFloor(ret, "THIRD-FLOOR"), coef));
        
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
        Gun ak = new Gun("AK-47", 200, "A STRONG WEAPON", 10, 31);
        Charger rifleCharger = new Charger("RIFLE-AMMO", "A CHARGER FOR RIFLE WEAPON");
        MeleeWeapon longknife = new MeleeWeapon("LONG-KNIFE", 25, "A LARGE KNIFE", 120);
        
        trader.addObject(ak);
        trader.addObject(rifleCharger);
        trader.addObject(longknife);
        
        Room kitchen1 = new Room("KITCHEN1");
        ret.addRoom(kitchen1);
        Door kitCorri = new Door();
        kitchen1.addDoor(kitCorri);
        corridor1.addDoor(kitCorri);
        
        // ajout d'une horloge
        Collectable clock = new Collectable("CLOCK0", 1, "THIS IS A BROCKEN CLOCK", "THE CLOCK IS STOPPED AT 4AM15");
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
    
    public static Floor initSecondFloor(Floor firstFloor, float coef){
        Floor ret = new Floor("SECOND-FLOOR");
        
        // initialisation des salles 
        Room stairs1 = firstFloor.getRoom("STAIRS1");
        ret.addRoom(stairs1);
        Door staiCorr = new Door();
        stairs1.addDoor(staiCorr);
        staiCorr.open();

        // creation d'une salle        
        Room corridor = new Room("CORRIDOR2");
        ret.addRoom(corridor);
        corridor.addDoor(staiCorr);
        
        // creation d'une salle      
        Room shower = new Room("SHOWER2");
        ret.addRoom(shower);
        DoorWithLock shoCorri = new DoorWithLock();
        shower.addDoor(shoCorri);
        corridor.addDoor(shoCorri);
        
        // creation d'une salle        
        Room museumRoom = new Room("MUSEUM-ROOM2");
        ret.addRoom(museumRoom);
        CodeLockedDoor muroCorri = new CodeLockedDoor(1978);
        museumRoom.addDoor(muroCorri);
        corridor.addDoor(muroCorri);
        Gun goldenGun = new Gun("Golden Gun", 1, "THIS GUN WILL ALLOW YOU TO ONESHOT ONE ENEMY", 9999, 1);
        museumRoom.addObject(goldenGun);
        
        // creation d'une salle
        Room dinningRoom = new Room("DINNING-ROOM2");
        ret.addRoom(dinningRoom);
        KeyLockedDoor divCorri = new KeyLockedDoor();
        dinningRoom.addDoor(divCorri);
        corridor.addDoor(divCorri);
        Collectable dish = new Collectable("BROKEN-DISH", 1, "WHAT LITTLE IS LEFT OF THIS DISH INDICATES THAT IT WAS HISTORICAL, MAYBE IF YOU TURN THE PLATE YOU FIND SOMETHING ...", "CREATED IN 1978");
        MeleeWeapon fork = new MeleeWeapon("FORK", 1, "THIS FORK WAS USED RECENTLY", 4); 
        MeleeWeapon spoon = new MeleeWeapon("SPOON", 1, "THERE'S STILL SOUP LEFT IN THIS SPOON IN CASE YOU WANT IT", 2); 
        MeleeWeapon knife1 = new MeleeWeapon("KNIFE1", 1, "THERE ARE STILL REMAINS OF MEAT ON THE EDGE OF THE KNIFE", 6); 
        dinningRoom.addObject(dish);
        dinningRoom.addObject(fork);
        dinningRoom.addObject(spoon);
        dinningRoom.addObject(knife1);
        // npc dans la salle
        Npc recuit = new Npc("RECRUIT1", 800, dinningRoom, 0, coef, 1);
        dinningRoom.addPerson(recuit);
        //arme de la recrue
        MeleeWeapon goldenKnife = new MeleeWeapon("GOLDEN-KNIFE", 5, "A BASIC KNIFE", 9999);
        recuit.addObject(goldenKnife);
        recuit.equipObject("GOLDEN-KNIFE");
        
        // initialisation de la clé et placement dans la douche
        divCorri.createKey(1);
        shower.addObject(divCorri.getCurrentKey());
        
        
        // creation d'une salle        
        Room stairs = new Room("STAIRS2");
        ret.addRoom(stairs);
        Door staiCorri = new Door();
        stairs.addDoor(staiCorri);
        corridor.addDoor(staiCorri);
        
        
        return ret;
    }
    
    public static Floor initThirdFloor(Floor SecondFloor, float coef){
        Floor ret = new Floor("THIRD-FLOOR");
        
        // initialisation des salles 
        Room stairs2 = SecondFloor.getRoom("STAIRS2");
        ret.addRoom(stairs2);
        Door staiCorr = new Door();
        stairs2.addDoor(staiCorr);
        staiCorr.open();

        // creation d'une salle        
        Room corridor = new Room("CORRIDOR3");
        ret.addRoom(corridor);
        corridor.addDoor(staiCorr);
        
        // creation d'une salle        
        Room privateRoom = new Room("PRIVATE-ROOM");
        ret.addRoom(privateRoom);
        DoorLockedOut priCorri = new DoorLockedOut();
        privateRoom.addDoor(priCorri);
        corridor.addDoor(priCorri);
        
        // creation d'une salle        
        Room stairs = new Room("STAIRS3");
        ret.addRoom(stairs);
        Door staiCorri = new Door();
        stairs.addDoor(staiCorri);
        corridor.addDoor(staiCorri);
        
        
        return ret;
    }
    
    public static Floor initLastFloor(Floor ThirdFloor, float coef){
        Floor ret = new Floor("ROOF");
        
        // initialisation des salles 
        Room stairs3 = ThirdFloor.getRoom("STAIRS3");
        ret.addRoom(stairs3);
        Door helCorr = new Door();
        stairs3.addDoor(helCorr);
        helCorr.open();

        // creation d'une salle        
        Room heliport = new Room("HELIPORT");
        ret.addRoom(heliport);
        heliport.addDoor(helCorr);
        
        
        return ret;
    }
}