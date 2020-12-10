/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

//import Manor.Key;
//import Manor.Room;

/**
 *
 * @author thibault
 */
public class KeyLockedDoor extends DoorWithLock{
    private Key currentKey;
    
    
    // attributs 
    public KeyLockedDoor(){
        super();
        this.currentKey = null;
    }
    
    public Key getCurrentKey()
    {
        return this.currentKey;
    }
    
    public void createKey(int uses){
        this.currentKey = new Key(("KEY" + this.getID()), uses, "THIS KEY CAN MAYBE OPEN A LOCKED DOOR NEARBY", this);

    }
    
    
    public void unlock(Key k){
        if(this.currentKey == k){
            super.unlock(-1);
        }
    }
}
