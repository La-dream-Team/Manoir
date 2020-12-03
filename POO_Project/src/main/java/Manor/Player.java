
package Manor;

public class Player extends Person {
    
    public void takeObjects(Person corp){
        for (int i = 0; i < corp.bag.size(); i++) {
            addObject(this.bag.get(i));
        }
    }
    
}
