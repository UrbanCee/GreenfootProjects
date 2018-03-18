import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysicsObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysicsObject extends AnimatedObject
{
    static final double g=500;
    double mass=1.0;
    Vector pos = new Vector(),v = new Vector();
    public void act() 
    {
        // Add your action code here.
    }    
    public void addedToWorld(World world)
    {
        pos.setXY(getX(),getY());
    }
    
    public void calcPos(Vector a)
    {
        v.add(Vector.mult(a,dt));
        pos.add(Vector.mult(v,dt));
        setLocation((int) pos.x, (int) pos.y);
    }
    
}
