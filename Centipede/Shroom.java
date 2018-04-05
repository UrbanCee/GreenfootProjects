import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shroom extends Actor
{
    static public int iUrgent=0;
    int iDamageTaken=0;

    public Shroom()
    {
        updateGraphics();
    }
    
    public void act()
    {
        if (isTouching(Bullet.class))
        {
            iDamageTaken++;
            removeTouching(Bullet.class);
            if (iDamageTaken>3)
            {
                getWorld().removeObject(this);
                return;
            }
            updateGraphics();
        }

    }

    public void updateGraphics()
    {
        setImage(Tex.shroomCatalogue.get(iDamageTaken+iUrgent*4));
    }
}
