
package Manor;

public class Player extends Person {
    
    public Player(String Name,int Health, Room CurrentRoom)
    {
        super(Name, Health, CurrentRoom, 0);
    }
    
    public void takeMoney(Person corpse)
    {
        if(corpse.getMoney() != 0)
        {
            this.addMoney(corpse.getMoney());
            corpse.substractMoney(corpse.getMoney());
        }
    }
    
    public void takeObjects(Person corpse){
        this.takeMoney(corpse);
        if(this.bag.size() < this.getDefaultBagSize())
        {
            int remainingSpace = this.getDefaultBagSize() - this.bag.size();
            if(remainingSpace > corpse.getBag().size()) //Si l'espace qui lui reste au joueur dans son sac est superieur à la taille du sac du cadavre
            {
                //On garde tous les objects
                for (int i = 0; i < corpse.getBag().size(); i++) {
                    addObject((Object) corpse.getBag().get(i));
                } 
            }
            else //Sinon on garde les items jusqu'a le sac soit complet
            {
                System.out.println("YOU DON'T HAVE ENOUGH SPACE TO SAVE ALL THE OBJECTS SO YOU HAVE TAKEN THE FIRST" + remainingSpace + "ITEMS OF THE CORPSE");
                for (int i = 0; i < remainingSpace; i++) {
                    addObject((Object) corpse.getBag().get(i));
                }
            }
        }
        else
        {
            System.out.println("YOU DON'T HAVE ENOUGH SPACE TO SAVE MORE OBJECTS");
        }
    }
}
