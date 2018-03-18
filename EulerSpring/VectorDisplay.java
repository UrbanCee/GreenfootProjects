import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VectorDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VectorDisplay extends Actor
{
    Vector v;
    static final int size=20;
    static final Color col = Color.GRAY;
    static final Color colBack = new Color(0,0,0,0);
    public VectorDisplay(Vector v)
    {
        this.v=v;
        paint();
    }
    public void act()
    {
        paint();
    }
    public void setVector(Vector v)
    {
        this.v=v;
        paint();
    }
    
    public void paint()
    {
        GreenfootImage i1 = new GreenfootImage(String.valueOf(v.x),size,col,colBack);
        GreenfootImage i2 = new GreenfootImage(String.valueOf(v.y),size,col,colBack);
        GreenfootImage img = new GreenfootImage(Math.max(i1.getWidth(),i2.getWidth()),i1.getHeight()+i2.getHeight());
        img.drawImage(i1,0,0);
        img.drawImage(i2,0,i1.getHeight());
        setImage(img);
    }
}
