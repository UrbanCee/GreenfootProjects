import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hand extends Actor
{
    GreenfootImage img;
    boolean bMoveMode=false;

    public Hand()
    {
        setLocation(400,400);
        paint();
    }

    /**
     * Act - do whatever the Hand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(400,400);
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse!=null)
        {
            if (mouse.getButton()==1)
            {
                if (!bMoveMode)
                {
                    if (mouse.getActor()==this)
                        bMoveMode=true;
                }else
                    turnTo(mouse.getX(), mouse.getY());
            }else
                bMoveMode=false;
        }else{
            bMoveMode=false;
        }
    }    

    public void paint()
    {
        img = new GreenfootImage(MyWorld.radius*2,3);
        img.setColor(Color.BLACK);
        img.fill();
        setImage(img);
    }

    protected void turnTo(int x,int y)
    {
        turnTowards(x,y);
    }
}
