
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
            int ret;
            switch (com.get(0)){
                case "QUIT" :
                    if(lenList == 1){
                        ret = this.quit();
                    }
                    else{
                        ret = 0;
                    }
                    break;
                        
                default :  
                    ret = 0;
            }
            return ret;
        }
        else
            return 0;
    }
    
    // il n'y a pas de sevgarde donc on renvoie simplement -1 pour dire au programme que l'utilisateur veux quiter le jeu
    public int quit(){
        return -1;
    }
}