
package Manor;

import java.util.Scanner;
import java.util.ArrayList;

public class Game{
    private ArrayList<Floor> manoir = new ArrayList<>();
    private Player player;
    private Npc finalboss;
    private int difficulty;
    
    
    
    public Game(){
        this.manoir = Map.initMap();
        this.player = this.scanPlayer();
        this.finalboss = this.initBoss();
        
        this.doGame();
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
        
        do{
        System.out.println("ENTER THE DIFFICULTY 1, 2 or 3 !");
        this.difficulty = scan.nextInt();
        }while(((this.difficulty < 1) || (this.difficulty > 3)));
        
        Floor starterFloor = this.getFloor("BASEMENT");
        Room starterRoom = starterFloor.getRoom("PRISON0");
        
        ret = new Player(name, (150 - (30 * this.difficulty)), starterRoom);
        starterRoom.addPerson(ret);
        
        return ret;
    }
    
    public Npc initBoss(){
        Floor starterFloor = this.getFloor("BASEMENT");
        Room boosRoom = starterFloor.getRoom("WC1");
        
        Npc ret = new Npc("BADBOY", (150 - (30 * this.difficulty)), boosRoom, 150, 3);
        boosRoom.addPerson(ret);
        
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
    
    public void doGame(){
        int ret = 0 ;
        do{
            ret = doRond();
        }while(((this.player.isAlive()) && (this.finalboss.isAlive()) && (ret != -1)));
        
        if(ret == -1)
            System.out.println("THANK YOU FOR PLAYING !");
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
                        System.out.println("PLEASE ENTER YES OR NO.");
                }
            }while(true);
            
            
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
                 if(currentRoom.getName() == strr){
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
                        ret = this.take(com[1]);
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
                    System.out.println("ACCORDING TO THE VALUE OF THE ARGUMENT, YOU WILL SHOW YOUR INVENTORY OR A TRADER'S INVENTORY OR YOU WILL LOOK AT THE DESCRIPTION OF A ROOM OR AN OBJECT.");
                    //System.out.println("IF YOU DON'T ENTER ANY ARGUMENT, THE COMMAND WILL ALLOW YOU TO SEE A DESCRIPTION OF YOUR CURRENT ROOM.");
                    break;
                case "TAKE":
                    System.out.println("YOU NEED TO ENTER TAKE + ONE ARGUMENT.");
                    System.out.println("YOU CAN ONLY TAKE ONE OBJECT FROM YOUR CURRENT ROOM'S FLOOR.");
                    break;
                case "USE":
                    System.out.println("YOU CAN ENTER USE + ONE OR USE + TWO ARGUMENTS.");
                    break;
                case "EQUIP":
                    System.out.println("YOU NEED TO ENTER EQUIP + ONE ARGUMENT.");
                    System.out.println("You can only equipe an object on your invetory.");
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
                    this.player.getRoom().print();
                    
                    break;
                case "TRADERS":
                    this.player.getRoom().printMarkets();
                    
                    break;
                default: 
                    System.out.println("UNUSABLE ARGUMENT !");
            }
        }
        return ret;
    }
    
    public int take(String s1){
        int ret = 0;
        if(s1 != null){
            this.player.takeObject(s1);
        }
        return ret;
    }
    
    public int use(String s1, String s2){
        if(s1 != null){
            this.player.useObject(s1, s2);
        }
        return 1;
    }
    
    public int equipe(String obj){
        int ret = 0;
        if(obj != null){
            ret = this.player.equipObject(obj);
        }
        return ret;
    }
    
    public static void main(String[] args){
        Game currentGame = new Game();
    }
}