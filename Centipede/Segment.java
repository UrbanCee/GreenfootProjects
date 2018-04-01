import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class Segment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Segment extends Body
{
    static double SPEED=30.0;
    static final double size=10;

    double dCurrentDist=0.0;
    Body nextSegment=null;
    List<VectorDist> positions = null;

    public Segment()
    {
        if (baseImages==null)
            loadImagesFromFile();
        setImage(imageCatalogueBody.get(0));
    }

}
