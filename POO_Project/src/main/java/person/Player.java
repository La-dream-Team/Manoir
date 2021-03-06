
package person;

import manor.Room;
import object.Object;

public class Player extends Person {
    
    public Player(String Name,int Health, Room CurrentRoom)
    {
        super(Name, Health, CurrentRoom, 150);
    }
    
    /*public void takeMoney(Person corpse)
    {
        if(corpse.getMoney() != 0)
        {
            this.addMoney(corpse.getMoney());
            corpse.substractMoney(corpse.getMoney());
        }
    }*/
    
    public void takeObject(String ItemName)
    { 
        if(this.bag.size() < this.getDefaultBagSize())
        {
            Object NewItem = this.getRoom().stringToObject(ItemName);
            this.getRoom().removeObject(NewItem);
            this.addObject(NewItem);
        }
        else
        {
            System.out.println("YOU DON'T HAVE ENOUGH SPACE TO SAVE MORE OBJECTS");
        }
    }
}
