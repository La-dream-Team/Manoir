
package Manor;

import java.util.ArrayList;

public class Game{
    private ArrayList<Floor> manoir = new ArrayList<>();
    private Person Player;


    
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
                        ret = this.take(com.get(1), com.get(1));
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
                case "EQUIPE":
                    if(lenList == 2){
                        ret = this.take(com.get(1), com.get(1));
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
            System.out.println("This is the order list :");
            System.out.println("   - QUIT : to close the program.");
            System.out.println("   - GO <name_Room> : to go to the given room.");
            System.out.println("   - HELP <order> : to show order's uses.");
            System.out.println("   - LOOK <object> : to discribe different objects.");
            System.out.println("   - TAKE <object> : to take objects on the current room.");
            System.out.println("   - USE <object> <special> : to use an object on your inventory.");
            System.out.println("   - EQUIPE <object> : to equipe an object on your inventory.");
        }
        else{
            switch (com){
                case "QUIT":
                    System.out.println("Just use QUIT with zero argument.");
                    System.out.println("Warning if you quit you will lose your progress !");
                    break;
                case "GO":
                    System.out.println("You need to use GO with one argument.");
                    System.out.println("You must give next room.");
                    break;
                case "LOOK":
                    System.out.println("You need to use LOOK with one argument.");
                    System.out.println("Give inventory, room or trader.");
                    System.out.println("If you didn't give argument, the order look the current room.");
                    break;
                case "TAKE":
                    System.out.println("You need to use TAKE with one argument.");
                    System.out.println("You can only take an object on your current room.");
                    break;
                case "USE":
                    System.out.println("You can give 2 or 1 arguments.");
                    break;
                case "EQUIPE":
                    System.out.println("You need to use EQUIPE with one argument.");
                    System.out.println("You can only equipe an object on your invetory.");
                    break;
                default : 
                    ret = 0;
                    System.out.println("Unusable argument !");
            }
        }
        return ret; 
    }
    
    public int go(String com){
        int ret = 0; 
        if(com != null){
            Room r = this.findRoom(com);
            if(r != null){
                ret = this.Player.setRoom(r);
            }
            else{
                System.out.println("Room Faillure");
                return ret;
            }
        }
        return ret;
    }
    
    public int look(String com){
        int ret = 0; 
        if(com != null){
            switch (com){
                case "inventory" : 
                    this.Player.printInventory();
                    ret = 1;
                    
                    break;
                case "room":
                    this.Player.getRoom().print();
                    
                    break;
                case "traders":
                    this.Player.getRoom().printMarkets();
                    
                    break;
                default: 
                    System.out.println("Unusable argument !");
            }
        }
        return ret;
    }
    
    public int take(String s1, String s2){
        int ret = 0;
        if(s1 != null){
            this.Player.takeObject(s1, s2);
        }
        return ret;
    }
    
    public int use(String s1, String s2){
        if(s1 != null){
            this.Player.useObject(s1, s2);
        }
        return 1;
    }
    
    public int equipe(String obj){
        int ret = 0;
        if(obj != null){
            ret = this.Player.equipObject(obj);
        }
        return ret;
    }
}