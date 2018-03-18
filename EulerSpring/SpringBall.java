import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpringBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpringBall extends PhysicsObject
{
    Spring spring;
    Vector gravity=new Vector(0,g);
    double dDamping=0.0;
    public SpringBall(SpringAnchor anchor)
    {
        paintSphere(15,Color.RED);
    }
    public void setSpring(Spring spring)
    {
        this.spring=spring;
    }
    public void act() 
    {
       updateTime();
       Vector force = spring.force();
       force.add(gravity);
       force.mult(1.0/mass);
       Vector damp = Vector.mult(v,-dDamping);
       force.add(damp);
       calcPos(force);
    } 
    public void setDamping(double dDamping)
    {
        this.dDamping=dDamping;
    }
}
