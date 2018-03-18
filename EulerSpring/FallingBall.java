import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingBall extends PhysicsObject
{
    public FallingBall()
    {
        paintSphere(10,Color.RED);
    }

    
    
    public void act() 
    {
        updateTime();
        calcPos(new Vector(0,100));
    }    
}
