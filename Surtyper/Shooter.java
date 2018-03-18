import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooter extends AnimatedObject
{
    public Shooter()
    {
        paint();
    }
    
    
    public void act() 
    {
        updateTime();
    }
    
    public void paint()
    {
        GreenfootImage image = new GreenfootImage(100,50);
        image.setColor(Color.WHITE);
        image.fillOval(25,0,50,50);
        image.fillRect(0,23,25,5);
        image.mirrorHorizontally();
        setImage(image);
    }
}
