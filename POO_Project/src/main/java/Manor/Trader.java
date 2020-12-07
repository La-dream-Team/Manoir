
package Manor;

import java.util.Scanner;

public class Trader extends Npc{

    public Trader(String Name,int Health, Room CurrentRoom, int Money, int Type){
        super(Name, Health, CurrentRoom, Money, 2);   
    }
    
    //Fonction pour echanger des objects par argent   
    public void Exchange(Person buyer, int price)
    {
        Scanner ChosenObject = new Scanner(System.in); 
        System.out.println("I HAVE ALL THOSE ITEMS :");
        this.printInventory();
        System.out.println("EACH ONE COSTS" + price + "PIECES");
        System.out.println("REMEMBER YOU HAVE" + buyer.getMoney() + "PIECES AVAILABLES TO BUY");
        System.out.println("CHOOSE THE OBJECT YOU WANT TO BUY ME AND ENTER ITS NUMBER (IF YOU WANT TO EXIT THE SHOP ENTER -1) :");
        int CodeObject = ChosenObject.nextInt();
        if(CodeObject != -1)
        {
            if(buyer.getMoney() - price >= 0)
            {
                if(buyer.getBag().size() < buyer.getDefaultBagSize())
                {
                    buyer.addObject(this.bag.get(CodeObject));
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
                System.out.println("IM SORRY MAN BUT YOU DON'T HAVE ENOUGH MONEY TO BUY MY" + this.bag.get(CodeObject).getName());
            }
        }
    }//fin exchange
}//fin class
