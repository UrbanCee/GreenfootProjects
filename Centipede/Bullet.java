import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends AnimatedActor
{
    static final double BULLETSPEED=800.0;
    public void act() 
    {
        updateTime();
        y-=BULLETSPEED*dT;
        if (y<0)
        {
            getWorld().removeObject(this);
            return;
        }
        setPos();
    }    
}
