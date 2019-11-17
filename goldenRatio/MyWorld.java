import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    static int iSize=20;
    static double dProgression=0.3;
    static double dAngleRatio=1;
    static final int iPetals=1000;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 600, 1); 
        dProgression=(double) (getWidth()/2)/ (double) iPetals;
        double mx=getWidth()/2.0;
        double my=getHeight()/2.0;
        for (int i=0;i<iPetals;i++)
        {
            double dAngle=2/dAngleRatio*Math.PI;
            
            addObject(new Seed(),(int) (mx+dProgression*Math.cos(i*dAngle)), (int) (mx+i*dProgression*Math.sin(i*dAngle)));
        }
    }
    
    public void act()
    {
        dAngleRatio-=0.000003;
        List<Seed> seeds = getObjects(Seed.class);
        double mx=getWidth()/2.0;
        double my=getHeight()/2.0;
        for (int i=0;i<seeds.size();i++)
        {
            double dAngle=2/dAngleRatio*Math.PI*i;
            seeds.get(i).setLocation( (int) (mx-i*dProgression*Math.cos(dAngle)), (int) (mx-i*dProgression*Math.sin(dAngle)));
        }
    }
}
