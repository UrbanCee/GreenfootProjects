import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends AnimatedObject
{
    Enemy target;
    static final double bulletSpeed=800.0;
    public Bullet(Enemy target)
    {
        this.target=target;
        paint();
    }
    
    public void act() 
    {
        if (target.getWorld()==null)
        {
            getWorld().removeObject(this);
            return;
        }
        if (getIntersectingObjects(Enemy.class).contains(target))
        {
            Fragment.createExplodingFragments(target,4,4);
            ((Playfield)getWorld()).enemyDestroyed();
            getWorld().removeObject(target);
            getWorld().removeObject(this);
            return;
        }
        updateTime();
        turnTowards(target.getX(),target.getY());
        
        dx+=dT*bulletSpeed*Math.cos(Math.toRadians(getRotation()));
        dy+=dT*bulletSpeed*Math.sin(Math.toRadians(getRotation()));
        
        setLocation((int)dx,(int)dy);
    } 
    
    
    public void paint()
    {
        GreenfootImage image = new GreenfootImage(15,5);
        image.setColor(Color.CYAN);
        image.fillRect(0,0,image.getWidth(),image.getHeight());
        setImage(image);

    }
    
}
