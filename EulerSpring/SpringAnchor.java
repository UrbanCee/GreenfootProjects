import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpringAnchor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpringAnchor extends PhysicsObject

{
    double dSpeed=100.0;
    double dXA=0.0;
    double dYA=0.0;
    double dXf=1.0;
    double dYf=1.0;
    
    public SpringAnchor()
    {
        paintSphere(8,Color.BLUE);
    }
    public void act()
    {
        updateTime();
        if (Greenfoot.isKeyDown("up"))
        {
           pos.y-=dSpeed*dt;
        }
        if (Greenfoot.isKeyDown("down"))
        {
           pos.y+=dSpeed*dt;
        }
        if (Greenfoot.isKeyDown("right"))
        {
           pos.x+=dSpeed*dt;
        }
        if (Greenfoot.isKeyDown("left"))
        {
           pos.x-=dSpeed*dt;
        }
        double dTime=(System.currentTimeMillis()-timeCreated)/1000.0;
        double dX=Math.sin(Math.PI*2.0*dXf*dTime)*dXA;
        double dY=Math.cos(Math.PI*2.0*dYf*dTime)*dYA;
        setLocation((int)(pos.x+dX),(int)(pos.y+dY));
    }
    
    public void setXAmplitude(double dXA)
    {
        this.dXA=dXA;
    }
    public void setYAmplitude(double dYA)
    {
        this.dYA=dYA;
    }
    public void setXFrequency(double dXf)
    {
        this.dXf=dXf;
    }
    public void setYFrequency(double dYf)
    {
        this.dYf=dYf;
    }
    
}
