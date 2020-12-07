
package Manor;

import java.util.ArrayList;

public class Game{
    private ArrayList<Floor> manoir = new ArrayList<>();
    private Player player;


    
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
    public int exec(ArrayList<String> com){
        int lenList = com.size();
        if(lenList>0){
            int ret = -15;
            switch (com.get(0)){
                case "GO" :
                    if(lenList == 2){
                        ret = this.go(com.get(1));
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
                        ret = this.help(com.get(1));
                    }
                    else{
                        if(lenList == 1){
                            ret = this.help(null);
                        }
                    }
                    break;
                case "LOOK":
                    if(lenList == 2){
                        ret = this.look(com.get(1));
                    }
                    else{
                        if(lenList == 1){
                            ret = this.look(null);
                        }
                    }
                    break;
                case "TAKE":
                    if(lenList == 2){
                        ret = this.take(com.get(1));
                    }
 
                    break;
                case "USE": 
                    if(lenList == 3){
                        ret = this.use(com.get(1), com.get(1));
                    }
                    else{
                        if(lenList == 2){
                            ret = this.use(com.get(1), null);
                        }
                    }
                    
                    break;
                case "EQUIP":
                    if(lenList == 2){
                        ret = this.take(com.get(1));
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
}