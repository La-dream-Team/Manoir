/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manor;

/**
 *
 * @author thibault
 */
public class KeyLockedDoor extends DoorWithLock{
    private Key currentKey;
    
    
    // attributs 
    public KeyLockedDoor(Room r, int uses){
        super(r);
        this.currentKey = new Key(("KEY NUMBER : " + this.getID()), uses, "THIS KEY CAN MAYBE OPEN A LOCKED DOOR NEARBY", this);
    }
    
    public Key getCurrentKey()
    {
        return this.currentKey;
    }
    
    @Override
    public void unlock(){
        System.out.print("NO KEY FOUND");
    }
    
    public void unlock(Key k){
        if(this.currentKey == k){
            super.unlock();
        }
    }
}
