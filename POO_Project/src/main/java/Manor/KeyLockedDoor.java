
package Manor;

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
    
    @Override
    public int unlock(int arg){
        System.out.println("YOU MUST USE YOUR KEY FOR OPEN ME !");
        return 0;
    }
    
    public void unlock(Key k){
        if(this.currentKey == k){
            super.unlock(-1);
        }
    }
}
