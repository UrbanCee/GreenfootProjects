import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedObject extends Actor
{
    double dt=0.0;
    double dAge=0.0;
    long timeCreated=System.currentTimeMillis();
    long lastUpdate=timeCreated;


    public void updateTime()
    {
        long curTime=System.currentTimeMillis();
        dt=(curTime-lastUpdate)/1000.0;
        dAge=(curTime-timeCreated)/1000.0;
        if (dt>=0.1)
            dt=0.0;
        lastUpdate=curTime;
    }
    
    public void paintSphere(int r, Color col)
    {
        GreenfootImage image = new GreenfootImage(2*r,2*r);
        image.setColor(col);
        image.fillOval(0,0,2*r,2*r);
        setImage(image);
    }


}
