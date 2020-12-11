
package manor;

import person.Person;
import person.Trader;
import person.Npc;
import person.Player;
import object.MeleeWeapon;
import door.CodeLockedDoor;
import door.Door;
import door.DoorWithLock;
import java.util.Scanner;
import java.util.ArrayList;

public class Game{
    private ArrayList<Floor> manoir = new ArrayList<>();
    private Player player;
    private Npc finalboss;
    private int difficulty;
    private float coef;
    
    
    
    public Game(){
        Scanner scan = new Scanner(System.in);
        do{
        System.out.println("ENTER THE DIFFICULTY 1, 2 or 3 !");
        this.difficulty = scan.nextInt();
        }while(((this.difficulty < 1) || (this.difficulty > 3)));
        
        switch (this.difficulty){
            case 1:
                this.coef = 1.f;
                break;
            case 2:
                this.coef = 1.2f;
                break;
            case 3:
                this.coef = 1.5f;
                break;
        }
        
        this.manoir = Map.initMap(this.coef);
        this.player = this.scanPlayer();
        this.finalboss = this.initBoss();
        
        this.help(null);
        
        if(this.doGame())
            new Game();
    }

    
    public String[] givecommand(){
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        
        return command.split(" ");
    }
    
    public Player scanPlayer(){
        Player ret = null;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("GIVE YOUR PLAYER NAME PLEASE !");
        String name = scan.nextLine();
       
        
        Floor starterFloor = this.getFloor("BASEMENT");
        Room starterRoom = starterFloor.getRoom("PRISON0");
        
        // creation et initialisation du joueur
        ret = new Player(name, (150 - (30 * this.difficulty)), starterRoom);
        starterRoom.addPerson(ret);
        
        // on lui donne un katana
        MeleeWeapon katana = new MeleeWeapon("KATANA0", 25, "A BASIC KATANA", 5);
        ret.addObject(katana);
        ret.equipObject("KATANA0");
        
        return ret;
    }
    
    public Npc initBoss(){
        Floor starterFloor = this.getFloor("ROOF");
        Room boosRoom = starterFloor.getRoom("HELIPORT");
        
        Npc ret = new Npc("BADBOY", (150 - (30 * this.difficulty)), boosRoom,150,this.coef, 3);
        boosRoom.addPerson(ret);
        
        MeleeWeapon sword = new MeleeWeapon("SWORD", 25, "THIS IS A HEAVY SWORD", 50);
        ret.addObject(sword);
        ret.equipObject(sword.getName());
        
        return ret;
    }
    
    public Floor getFloor(String f){
        Floor ret = null;
        for(Floor current : this.manoir){
            if(f.equals(current.getName())){
                ret = current;
                break;
            }
        }   
        return ret;
    }
    
    public boolean doGame(){
        int ret = 0 ;
        do{
            System.out.println("ENTER YOU ORDER :");
            ret = doRond();
            
            if(ret == 0){
                System.out.println("THE GAME HAS NOT CHANGED");
            }
            else{
                if(ret == 1){
                    System.out.println("THE GAME HAS CHANGED");
                }
            }
            this.playnpc();
        }while(((this.player.isAlive()) && (this.finalboss.isAlive()) && (ret != -1)));
        
        if(ret == -1){
            System.out.println("THANK YOU FOR PLAYING !");
            return false;
        }
        else{
            if(!(this.player.isAlive()))
                System.out.println("SORRY YOU ARE DEAD.");
            else
                System.out.println("GOOD JOB YOU FINISHED THE GAME !");
            
            System.out.println("DO YOU WANT PLAY AGAIN ? (YES/NO)");
            boolean play = false;
            do{
                String[] cmd = this.givecommand();
                if(cmd[0].equals("YES")){
                    play = true;
                    break;
                }
                else{
                    if(cmd[0].equals("NO"))
                        break;
                    else
                        System.out.println("PLEASE JUST ENTER YES OR NO.");
                }
            }while(true);
            
            return play;
        }
       
        
    }
    
    public void playnpc(){
        ArrayList<Person> personInRoom = this.player.getRoom().getPersons();
        for(Person currentp : personInRoom){
            if(currentp != this.player){
                ((Npc) currentp).attak(this.player);
            }
        }
    }
    
    public int doRond(){
        int ret = 0;
        String[] cmd = this.givecommand();
        ret = this.exec(cmd);
        return ret;
    }

    
    
    public Room findRoom(String strr){
        Room ret = null;
        for(Floor currentFloor : this.manoir){
             ArrayList<Room> list = currentFloor.getRooms();
             for(Room currentRoom : list){
                 if(currentRoom.getName().equals(strr)){
                     ret = currentRoom;
                     break;
                 }
             }
        }
        return ret;
    }
    
    // est la mathode pour executer les comanndes 
    // la liste contient tous les mots que l'utilisateur entre
    // la methode retourn -1 si le jeu s'arrete 
    // 0 si aucune action est faite et 1 si une action a été faite
    public int exec(String[] com){
        int lenList = com.length;
        if(lenList>0){
            int ret = -15;
            switch (com[0]){
                case "GO" :
                    if(lenList == 2){
                        ret = this.go(com[1]);
                    }
                    break;
                case "QUIT" :
                    if(lenList == 1){
                        ret = this.quit();
                    }
                    else{
                        ret = 0;
                    }
                    break;
                
                case "HELP" : 
                    if(lenList == 2){
                        ret = this.help(com[1]);
                    }
                    else{
                        if(lenList == 1){
                            ret = this.help(null);
                        }
                    }
                    break;
                case "LOOK":
                    if(lenList == 2){
                        ret = this.look(com[1]);
                    }
                    else{
                        if(lenList == 1){
                            ret = this.look(null);
                        }
                    }
                    break;
                case "TAKE":
                    if(lenList == 2){
                        ret = this.take(com[1]);
                    }
 
                    break;
                case "USE": 
                    if(lenList == 3){
                        ret = this.use(com[1], com[2]);
                    }
                    else{
                        if(lenList == 2){
                            ret = this.use(com[1], null);
                        }
                    }
                    
                    break;
                case "EQUIP":
                    if(lenList == 2){
                        ret = this.equip(com[1]);
                    }
                    
                    break;
                case "TRADE":
                    if(lenList == 2){
                        ret = this.trade(com[1]);
                    }
                    
                    break;
                case "OPEN":
                    if(lenList == 2){
                        ret = this.open(com[1]);
                    }
                  
                    break;
                case "UNLOCK":
                    if(lenList == 3){
                        ret = this.unlock(com[1], com[2]);
                    }
                    else{
                        if(lenList == 2){
                            ret = this.unlock(com[1], null);
                        }
                    }
                    
                    break;    
                
                default :  
                    ret = 0;
            };
            return ret;
        }
        else
            return 0;
    }
    
    // il n'y a pas de sauvegarde donc on renvoie simplement -1 pour dire au programme que l'utilisateur veux quiter le jeu
    public int quit(){
        return -1;
    }
    
    public int help(String com){
        int ret = 1;
        if(com == null){
            System.out.println("THIS IS THE COMMAND LIST :");
            System.out.println("   - QUIT : TO CLOSE THE PROGRAM.");
            System.out.println("   - GO <ROOM NAME> : TO GO TO THE DESIRED ROOM.");
            System.out.println("   - HELP <COMMAND> : TO SHOW COMMANDS USAGES.");
            System.out.println("   - LOOK <STRING PARAMETER> : TO DESCRIBE DIFFERENT OBJECTS.");
            System.out.println("   - TAKE <OBJECT NAME> : TO TAKE AN ITEM FROM THE CURRENT ROOM.");
            System.out.println("   - USE <OBJECT NAME> <TARGET NAME> : TO USE AN ITEM FROM YOUR INVENTORY.");
            System.out.println("   - EQUIP <OBJECT NAME> : TO EQUIP A WEAPON FROM YOUR INVENTORY.");
            System.out.println("   - TRADE <TRADER NAME> : TO EXCHANGE MONEY FOR ITEMS WITH A MERCHANT.");
            System.out.println("   - OPEN <DOOR NUMBER> : TO OPEN A DOOR IN YOUR ROOM.");
            System.out.println("   - UNLOCK <DOOR NUMBER> <UNLOCK CODE> : TO UNLOCK A LOCKED DOOR IN YOUR ROOM. IF THE DOOR IS CODE LOCKED, YOU ALSO NEED TO ENTER THE CODE");
        }
        else{
            switch (com){
                case "QUIT":
                    System.out.println("JUST USE QUIT WITH ZERO ARGUMENTS.");
                    System.out.println("WARNING, IF YOU QUIT YOU WILL LOSE ALL YOUR PROGRESS !");
                    break;
                case "GO":
                    System.out.println("YOU NEED TO ENTER GO + ONE ARGUMENT.");
                    System.out.println("YOU MUST GIVE THE NEXT ROOM NAME.");
                    break;
                case "LOOK":
                    System.out.println("YOU CAN ENTER LOOK + ONE ARGUMENT.");
                    System.out.println("ACCORDING TO THE VALUE OF THE ARGUMENT, YOU WILL SHOW YOUR INVENTORY \nOR A TRADER'S INVENTORY OR YOU WILL LOOK AT THE DESCRIPTION OF A ROOM OR AN OBJECT.");
                    break;
                case "TAKE":
                    System.out.println("YOU NEED TO ENTER TAKE + ONE ARGUMENT.");
                    System.out.println("YOU CAN ONLY TAKE ONE OBJECT FROM YOUR CURRENT ROOM'S FLOOR.");
                    break;
                case "USE":
                    System.out.println("YOU CAN ENTER USE + ONE OR USE + TWO ARGUMENTS.");
                    System.out.println("DEPENDING ON THE TYPE OF OBJECT YOU WANT TO USE.");
                    break;
                case "EQUIP":
                    System.out.println("YOU NEED TO ENTER EQUIP + ONE ARGUMENT.");
                    System.out.println("YOU CAN ONLY EQUIPE AN OBJECT THAT IS ON YOUR INVENTORY.");
                    break;
                case "TRADE":
                    System.out.println("YOU NEED TO ENTER TRADE + ONE ARGUMENT.");
                    System.out.println("THE MERCHANT MUST BE CLOSE TO YOU.");
                    break;
                case "OPEN":
                    System.out.println("YOU NEED TO ENTER OPEN + ONE ARGUMENT.");
                    System.out.println("THE DOOR YOU WANT TO OPEN HAS TO BE IN THE SAME ROOM AS YOU.");
                    break;
                case "UNLOCK":
                    System.out.println("YOU NEED TO ENTER UNLOCK + ONE OR TWO ARGUMENTS.");
                    System.out.println("THE DOOR YOU WANT TO UNLOCK HAS TO BE IN THE SAME ROOM AS YOU.");
                    break;
                default : 
                    ret = 0;
                    System.out.println("UNUSABLE ARGUMENT !");
            }
        }
        return ret; 
    }
    
    public int go(String com){
        int ret = 0; 
        if(com != null){
            Room r = this.findRoom(com);
            
            if(r != null){
                // si il est deja dans la pièce 
                if(r.getName().equals(this.player.getRoom().getName())){
                    System.out.println("YOU ARE ALREADY IN THIS ROOM !");
                }
                else
                    ret = this.player.setRoom(r);
            }
            else{
                System.out.println("ROOM FAILLURE");
                return ret;
            }
        }
        return ret;
    }
    
    public int look(String com){
        int ret = 0; 
        if(com != null){
            switch (com){
                case "INVENTORY" : 
                    this.player.printInventory();
                    ret = 1;
                    
                    break;
                case "ROOM":
                    this.player.getRoom().print(this.player);
                    
                    break;
                case "TRADERS":
                    this.player.getRoom().printMarkets();
                    
                    break;
                default: 
                    System.out.println("UNUSABLE ARGUMENT !");
            }
        }
        else
            System.out.println("PLEASE ENTER AN ARGUMENT OR DO <HELP LOOK>!");
        return ret;
    }
    
    public int take(String s1){
        int ret = 0;
        if(s1 != null){
            this.player.takeObject(s1);
            ret = 1;
        }
        return ret;
    }
    
    public int use(String s1, String s2){
        if(s1 != null){
            this.player.useObject(s1, s2);
        }
        return 1;
    }
    
    public int equip(String obj){
        int ret = 0;
        if(obj != null){
            ret = this.player.equipObject(obj);
        }
        return ret;
    }
    
    public int trade(String person){
        int ret = 0; 
        Trader npc =((Trader) this.player.getRoom().giveMeTrader(person));
        if(npc != null){
            npc.exchange(this.player, 10);
            ret = 1;
        }
        else{
            System.out.println("UNUSABLE ARGUMENT !");
        }
        
        return ret;
    }
    
    public int open(String door){
        int ret = 0;
        // convertion du string en entier 
        int number = Integer.valueOf(door);
        
        // recupère la porte correspondent à l'entier 
        Door openned = this.player.getRoom().giveMeDoor(number);
        if(openned != null){
            openned.open();
        
            // on verrifie si la porte est ouverte 
            if(openned.getIsOpen()){
                ret = 1;
            }
        }
        else{
            System.out.println("INVALID DOOR NUMBER !");
        }
        return ret;
    }
    
    public int unlock(String s1, String s2){
        int ret = 0;
        // convertion du string en entier 
        int number = Integer.valueOf(s1);
        
        if(this.player.getRoom().giveMeDoor(number) != null){
            // dans le jeu in n'y auras que les CodeLockedDoor et DoorWitchLock qui peuvent etre ouverte par l'utilisateur
            if(((this.player.getRoom().giveMeDoor(number) instanceof DoorWithLock) 
                    || (this.player.getRoom().giveMeDoor(number) instanceof CodeLockedDoor))){
            
                DoorWithLock d2 = (DoorWithLock) this.player.getRoom().giveMeDoor(number);
                if(s2 == null)
                    ret = d2.unlock(-1);
                else 
                    ret =((CodeLockedDoor) d2).unlock(Integer.valueOf(s2));
            }
            else{
                System.out.println("UNUSABLE ARGUMENT !");
            }
        }
        else{
           System.out.println("INVALID DOOR NUMBER !");  
        }
        
        return ret;
    }
    
    
    public static void main(String[] args){
        System.out.println("YOU ARE A FBI SPY THAT HAD INFILTRATED A MANOR TO KILL JEAN-MICHEL, A FRENCH EX MILITARY THAT KILLED YOUR WIFE IN THE 1997’S. ");
        System.out.println("NOW THE BIG QUESTION IS, HOW DID YOU GET INTO HIS MANOR? "
                + "\nBAH… IT’S RIDICULOUS TO SAY IT BUT IT WAS THROUGH A LITTLE WINDOW THAT LED YOU INTO THE PRISON OF THE MANOR. NO WORRIES, YOU ARE NOT BLOCKED.");
        System.out.println("WAIT WHAT ARE MY EYES SEEING… IT’S THE WATCHMAN OF THE PRISON.");
        System.out.println("YOU HAVE STRANGLED HIM TO PICK UP HIS CLOTHES.");
        System.out.println("NOW THAT YOU ARE DRESSED AS A WATCHMAN, I THINK YOU WILL BE COMPLETELY  UNNOTICED AMONG THE MANOR RESIDENTS.");
        
        Game currentGame = new Game();
    }
}