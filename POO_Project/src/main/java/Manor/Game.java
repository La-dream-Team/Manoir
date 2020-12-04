
package Manor;

import java.util.ArrayList;

public class Game{
    private ArrayList<Floor> manoir = new ArrayList<>();
    private Person Player;


    
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
                default :  
                    ret = 0;
            };
            return ret;
        }
        else
            return 0;
    }
    
    // il n'y a pas de sevgarde donc on renvoie simplement -1 pour dire au programme que l'utilisateur veux quiter le jeu
    public int quit(){
        return -1;
    }
    
    public int help(String com){
        int ret = 0;
        if(com == null){
            System.out.println("This is the order list :");
            System.out.println("   - QUIT : to close the program.");
            System.out.println("   - GO <name_Room> : to go to the given room.");
            System.out.println("   - HELP <order> : to show order's uses.");
        }
        else{
            switch (com){
                
                default : 
            }
        }
        return ret; 
    }
    
    public int go(String com){
        int ret = 0; 
        if(com != null){
            ret = this.Player.setRoom(com);
        }
        return ret;
    }
    
}