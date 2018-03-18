import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SizeChangingTextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SizeChangingTextField extends TextField
{
    long creationTime = System.currentTimeMillis();
    GreenfootImage baseImage;

    public SizeChangingTextField(String text, int iSize)
    {
        super(text,iSize);
        updateBaseImage();
    }

    public void updateBaseImage()
    {
        baseImage=getImage();
    }
    
    public void scaleBaseImage(double dScaleFactor)
    {
        GreenfootImage newImage = new GreenfootImage(baseImage);
        int cx=(int)(baseImage.getWidth()*dScaleFactor);
        int cy=(int)(baseImage.getHeight()*dScaleFactor);
        cx=Math.max(cx,1);
        cy=Math.max(cy,1);
        newImage.scale(cx,cy);
        setImage(newImage);
    }

    
}
