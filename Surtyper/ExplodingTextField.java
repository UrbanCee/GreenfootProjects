import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplodingTextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplodingTextField extends VanishingTextField
{
    public ExplodingTextField(String text, int iSize, double dLifeSpanInSeconds)
    {
        super(text,iSize,dLifeSpanInSeconds);
    }
    
    public void killMe()
    {
        int ixFactor=(getImage().getWidth()*4)/getImage().getHeight();
        Fragment.createExplodingFragments(this,ixFactor,4);
    }
}
