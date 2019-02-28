import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seed extends Actor
{
    public Seed()
    {
        GreenfootImage image = new GreenfootImage(MyWorld.iSize,MyWorld.iSize);
        image.setColor(Color.RED);
        image.fillOval(0,0,MyWorld.iSize-1,MyWorld.iSize-1);
        image.setColor(Color.BLUE);
        image.drawOval(0,0,MyWorld.iSize-1,MyWorld.iSize-1);
        setImage(image);
        
    }
    

}
