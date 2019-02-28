import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Mover
{
    Color col;
    static final int WIDTH=41;
    static final int HEIGHT=21;
    static final double TURNSPEED=180;
    static final double THRUST=200;
    static int shipCount=0;
    String strUp = "up";
    String strRight = "right";
    String strLeft = "left";
    String strDown = "down";
    public Ship(Color col)
    {
        shipCount++;
        if (shipCount>1)
        {
            strUp = "w";
            strRight = "d";
            strLeft = "a";
            strDown = "s";
        }
        this.col=col;
        paint();
    }
    
    public void setDRot(double dRot)
    {
        this.dRot=dRot;
        setRotation((int)dRot);
    }
    
    public void act()
    {
        updateTime();
        if (Greenfoot.isKeyDown(strRight))
        {
            dRot+=dT*TURNSPEED;
            setRotation((int)dRot);
        }
        if (Greenfoot.isKeyDown(strLeft))
        {
            dRot-=dT*TURNSPEED;
            setRotation((int)dRot);
        }
        if (Greenfoot.isKeyDown(strUp))
        {
            a.x=THRUST*Math.cos(Math.toRadians(dRot));
            a.y=THRUST*Math.sin(Math.toRadians(dRot));
        }else
        {
            a.x=0;
            a.y=0;
        }
        move();
        if (x.x>getWorld().getWidth())
        {
            x.x-=getWorld().getWidth();
        }
        if (x.x<0)
        {
            x.x+=getWorld().getWidth();
        }
        if (x.y>getWorld().getHeight())
        {
            x.y-=getWorld().getHeight();
        }
        if (x.y<0)
        {
            x.y+=getWorld().getHeight();
        }
        
    }
    
    
    public void paint()
    {
        GreenfootImage img = new GreenfootImage(WIDTH,HEIGHT);
        int[] x = {0,WIDTH-1,0};
        int[] y = {0,HEIGHT/2,HEIGHT};
        img.setColor(col);
        img.fillPolygon(x,y,3);
        setImage(img);
    }
    
    
}
