import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VanishingTextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VanishingTextField extends TextField
{
    long dLifeSpanMS;
    long creationTime=System.currentTimeMillis();
    public VanishingTextField(String text, int iSize, double dLifeSpanInSeconds)
    {
        super(text,iSize);
        dLifeSpanMS=(long)(dLifeSpanInSeconds*1000.0);
    }

    public void act() 
    {
        if (System.currentTimeMillis()-creationTime>dLifeSpanMS)
        {
            killMe();
            getWorld().removeObject(this);
        }
    }  
    
    public void killMe()
    {
        
    }
}
