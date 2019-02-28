import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        Ship s1=new Ship(Color.WHITE);
        Ship s2=new Ship(Color.YELLOW);
        s1.setDRot(270.0);
        s2.setDRot(270.0);
        
        addObject(s1,getWidth()/5,getHeight()/2);
        addObject(s2,(4*getWidth())/5,getHeight()/2);
    }
}
