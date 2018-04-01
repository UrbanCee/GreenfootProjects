import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
    long lastUpdate = System.currentTimeMillis();
    double dT = 0.0;
    double x=0.0,y=0.0;
    
    public void addedToWorld(World world)
    {
        x=getX();
        y=getY();
    }
    
    public void setPos()
    {
        setLocation((int)x,(int)y);
    }
    
    public void updateTime()
    {
        long newTime=System.currentTimeMillis();
        dT=(double)(newTime-lastUpdate)/1000.0;
        if (dT>0.2)
            dT=0.0;
       lastUpdate=newTime;
    }    
}
