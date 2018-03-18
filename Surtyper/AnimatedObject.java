import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedObject extends Actor
{
    double dT;
    long lastTime=System.currentTimeMillis();
    double dx, dy;

    
    public void updateTime()
    {
        long newTime=System.currentTimeMillis();
        dT=(newTime-lastTime)/1000.0;
        if (dT>0.5)
            dT=0;
        lastTime=newTime;
    }
    
    public void addedToWorld(World world)
    {
        dx=getX();
        dy=getY();
    }
    
    public void setPos()
    {
        setLocation((int)dx,(int)dy);
    }
    
    
}
