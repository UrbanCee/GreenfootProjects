import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    List<Vector> points= new ArrayList<Vector>(0);
    double iDir=1.0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        points.add(new Vector(0,550));
        points.add(new Vector(600,550));
        draw();
    }
    
    public void iterate()
    {
        List<Vector> newPoints = new ArrayList<Vector>(points.size()*3);
        for (int i=0;i<points.size()-1;i++)
        {
            Vector a=new Vector (points.get(i));
            Vector b=new Vector (points.get(i+1));
            Vector delta=Vector.sub(b,a);
            delta.mult(0.5);
            delta.turnDeg(60*iDir);
            Vector a1=Vector.add(a,delta);
            delta.turnDeg(60*iDir);
            Vector a2=Vector.add(b,delta);
            newPoints.add(a);
            newPoints.add(a1);
            newPoints.add(a2);
            iDir*=-1;
        }
        newPoints.add(points.get(points.size()-1));
        points=newPoints;
        draw();
    }
    
    public void draw()
    {
        getBackground().setColor(Color.WHITE);
        getBackground().fill();
        getBackground().setColor(Color.BLUE);
        for (int i=0;i<points.size()-1;i++)
        {
            getBackground().drawLine((int)points.get(i).x,(int)points.get(i).y,(int)points.get(i+1).x,(int)points.get(i+1).y);
        }
        
    }
}
