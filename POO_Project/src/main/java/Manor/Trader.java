
package Manor;

import java.util.Scanner;

public class Trader extends Npc{

    public Trader(String Name,int Health, Room CurrentRoom, int Money, float Difficulty, int Type){
        super(Name, Health, CurrentRoom, Money, Difficulty, 2);   
    }
    
    //Fonction pour echanger des objects par argent   
    public void exchange(Player buyer, int price)
    {
        Scanner ChosenObject = new Scanner(System.in); 
        System.out.println("I HAVE ALL THOSE ITEMS :");
        this.printInventory();
        System.out.println("EACH ONE COSTS" + price + "PIECES");
        System.out.println("REMEMBER YOU HAVE" + buyer.getMoney() + "PIECES AVAILABLES TO BUY");
        System.out.println("CHOOSE THE OBJECT YOU WANT TO BUY ME AND ENTER ITS NUMBER (IF YOU WANT TO EXIT THE SHOP ENTER 0) :");
        int CodeObject = ChosenObject.nextInt();
        if(CodeObject > -1 || CodeObject <= this.getBag().size())
        {
            if(CodeObject != 0)
            {
                if(buyer.getMoney() - price >= 0)
                {
                    if(buyer.getBag().size() < buyer.getDefaultBagSize())
                    {
                        buyer.addObject((Object)this.getBag().get(CodeObject-1));
                        buyer.substractMoney(price);
                        this.addMoney(price);
                    }
                    else
                    {
                        System.out.println("YOU DON'T HAVE ENOGH PLACE ON YOUR BAG TO STORE THIS NEW ITEM");
                    }
                }
                else
                {
                    Object Item = (Object)this.getBag().get(CodeObject-1);
                    System.out.println("IM SORRY MAN BUT YOU DON'T HAVE ENOUGH MONEY TO BUY MY" + Item.getName());
                }
            }
        }
        else
        {
            System.out.println("NUMBER OUT OF BOUNDS, THE NUMBER YOU ENTER HAS TO BE BETWEEN" + 0 + "AND" + this.getBag().size());
        }
    }//fin exchange
}//fin class
