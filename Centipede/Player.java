import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends AnimatedActor
{
    static final double PLAYERSPEED=200.0;
    public void act() 
    {
        updateTime();
        if (Greenfoot.isKeyDown("left"))
        {
            x-=PLAYERSPEED*dT;
            if (x<0)
                x=0;
            else if (x>getWorld().getWidth()-1)
                x=getWorld().getWidth()-1;
        }

        if (Greenfoot.isKeyDown("right"))
        {
            x+=PLAYERSPEED*dT;
            if (x<0)
                x=0;
            else if (x>getWorld().getWidth()-1)
                x=getWorld().getWidth()-1;
        }

        if (Greenfoot.isKeyDown("space"))
        {
            if (getWorld().getObjects(Bullet.class).isEmpty())
            {
                getWorld().addObject(new Bullet(),getX(),getY()-6);
            }
        }

        setPos();
    }    
}
