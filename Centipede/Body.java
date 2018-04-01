import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.LinkedList;


/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends AnimatedActor
{
    double dCurrentDist=0.0;
    Body nextSegment=null;
    List<VectorDist> positions;
    static double SPEED=30.0;
    static final double size=10;
    
    public void act() 
    {
    }    
}
