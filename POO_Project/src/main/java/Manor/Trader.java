
package Manor;

import java.util.Scanner;

public class Trader extends Npc{
    
    public Trader(String nom,int helt, Room androRoom, int type){
       super(nom,helt,androRoom, type);
    }
    
    public void Exchange(Person buyer, int price){
         

//tout **********************************-**************

        /*for (int i = 0; i < this.bag.size(); i++) {
            addObject(buyer.bag.get(i));
        }*/
         

//object par object **********************************

        /*Scanner coder = new Scanner(System.in); 
        int codObj, objChois;
        System.out.println("Producteur Ã  Ã©changer");
        for (int i = 0; i < this.bag.size(); i++) {
             System.out.println(i+" ");
             System.out.println(this.bag.get(i)+"/");
        }//fin for
        System.out.println("Choisissez l'Ã©lÃ©ment Ã  changer/");
        codObj = coder.nextInt();
        System.out.println("Pour quel objet vous allez le changer");
        for (int i = 0; i < buyer.bag.size(); i++) {
             System.out.println(i+" ");
             System.out.println(buyer.bag.get(i)+"/");
        }//fin for
        System.out.println("Les Ã©lÃ©ments doivent Ãªtre du mÃªme type/");
        objChois = coder.nextInt();
        addObject(this.bag.get(codObj));
        removeObject(buyer.bag.get(objChois));
        //if (assertReflectionEquals(this.bag.get(codObj), buyer.bag.get(objChois))){
        //if(this.bag.get(codObj) isintanceof buyer.bag.get(objChois)){
           //this.equippedItem.use(Target);
           
        //}//fin if
    */

//object par argent **********************************
        
        Scanner ChosenObject = new Scanner(System.in); 
        System.out.println("I HAVE ALL THOSE ITEMS :");
        for (int i = 0; i < this.bag.size(); i++) {
             System.out.println("|" + i + "|" + this.bag.get(i).getName());
        }//fin for
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

  /*  private boolean assertReflectionEquals(Object get, Object get0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}//fin class
