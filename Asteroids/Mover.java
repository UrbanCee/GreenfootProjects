import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    long lastUpdate = System.currentTimeMillis();
    Vector x = new Vector();
    Vector v = new Vector();
    Vector a = new Vector();
    double dT=0.0;
    double dRot;
    
    public void addedToWorld(World world)
    {
        x=new Vector(getX(),getY());
        dRot=getRotation();
    }

    public void move()
    {
        v.add(Vector.mult(a,dT));
        x.add(Vector.mult(v,dT));
        setLocation((int) x.x,(int) x.y);
    }
    
    public void updateTime()
    {
        long currentTime=System.currentTimeMillis();
        dT=(double)(currentTime-lastUpdate)/1000.0;
        if (dT>0.5)
            dT=0.0;
        lastUpdate=currentTime;
    }

}
