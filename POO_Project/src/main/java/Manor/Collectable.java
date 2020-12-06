package Manor;

public class Collectable extends Object{
    
    //Attribut
    String content;

    //Constructor
    public Collectable(String CollectableName, int RemainingUses, String Description, String Content)
    {
        super(CollectableName, RemainingUses, Description);
        this.content = Content;
    }  

    //Method
    @Override
    public void use(Person Objective)
    {   
        if(this.hasOwner())
        {
            if(this.canUse())
            {
                if(this.getRemainingUses() == 1)
                {
                    if(Objective == null)
                    {
                        if(this.content.equals("") || this.content == null)
                        {   
                            System.out.println("WHO ARE THOSE PROGRAMMERS THAT  HAVE FORGOTTEN TO PUT CONTENT ON THIS OBJECT ... OR COULD IT BE DELIBERATE ...");
                        }
                        else
                        {
                            System.out.println(this.content);
                            this.setRemainingUses();
                            System.out.println("YOU HAVE ALREADY USED ME TOO MANY TIMES, LET ME REST IN PEACE");
                            this.getOwner().removeObject(this.getId());
                        }
                    }
                    else
                    {
                        System.out.println("THIS IS NOT A WEAPON NOR CONSUMABLE. YOU CANT ATTACK SOMEONE WITH IT, IT ONLY CAN GIVE YOU KNOWLEDGE SO BE GRATEFUL");
                    }
                }
                else
                {
                    if(Objective == null)
                    {
                        if(this.content.equals("") || this.content == null)
                        {   
                            System.out.println("WHO ARE THOSE PROGRAMMERS THAT  HAVE FORGOTTEN TO PUT CONTENT ON THIS OBJECT ... OR COULD IT BE DELIBERATE ...");
                        }
                        else
                        {
                            System.out.println(this.content);
                            this.setRemainingUses();
                        }
                    }
                    else
                    {
                        System.out.println("THIS IS NOT A WEAPON NOR CONSUMABLE. YOU CANT ATTACK SOMEONE WITH IT, IT ONLY CAN GIVE YOU KNOWLEDGE SO BE GRATEFUL");
                    }
                }
            }
        }
    }
}