
package person;

import object.Object;
import java.util.Scanner;
import manor.Room;

public class Trader extends Npc{

    public Trader(String Name,int Health, Room CurrentRoom, int Money, float Difficulty){
        super(Name, Health, CurrentRoom, Money, Difficulty, 2);   
    }
    
    //Fonction pour echanger des objects par argent   
    public void exchange(Player buyer, int price)
    {
        Scanner ChosenObject = new Scanner(System.in); 
        
        int codeObject = -1;
        do{
            System.out.println("I HAVE ALL THOSE ITEMS :");
            this.printInventory();
            System.out.println("EACH ONE COSTS " + price + " PIECES");
            System.out.println("REMEMBER YOU HAVE " + buyer.getMoney() + " PIECES AVAILABLES TO BUY. THANK GOD YOU HAVEN'T FORGOTTEN YOUR WALLET AT HOME");
            System.out.println("CHOOSE THE OBJECT YOU WANT TO BUY ME AND ENTER ITS NUMBER (IF YOU WANT TO EXIT THE SHOP ENTER -1) :");
            codeObject = ChosenObject.nextInt();
            if((codeObject >= -1) || (codeObject < this.getBag().size()))
            {
                if(codeObject != -1)
                {
                    if(buyer.getMoney() - price >= 0)
                    {
                        if(buyer.getBag().size() < buyer.getDefaultBagSize())
                        {
                            Object current = this.getBag().get(codeObject);
                            this.removeObject(current);
                            buyer.addObject((Object)current);
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
                        Object Item = (Object)this.getBag().get(codeObject);
                        System.out.println("IM SORRY MAN BUT YOU DON'T HAVE ENOUGH MONEY TO BUY MY" + Item.getName());
                    }
                }
            }
            else
            {
                System.out.println("NUMBER OUT OF BOUNDS, THE NUMBER YOU ENTER HAS TO BE BETWEEN" + -1 + "AND" + (this.getBag().size()-1));
            }
        }while(codeObject != -1);
    }//fin exchange
}//fin class
