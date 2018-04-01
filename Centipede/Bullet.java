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
    static GreenfootImage bulletImage = null;

    public Bullet()
    {
        if (bulletImage==null)
        {
            draw();
        }
        setImage(bulletImage);
    }

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

    static public void draw()
    {
        bulletImage= new GreenfootImage(2,10);
        bulletImage.setColor(Color.RED);
        bulletImage.fillRect(0,0,2,10);
    }

}
