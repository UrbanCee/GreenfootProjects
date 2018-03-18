import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlashingField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlashingField extends SizeChangingTextField
{
    double dEndX,dEndY;
    double dStartX,dStartY;
    double dAppearingTime;
    int iState=0;
    
    public FlashingField(String text, int iSize, double dAppearingTime)
    {
        super(text,iSize);
        this.dAppearingTime=dAppearingTime;
    }
    
    public void act()
    {
       double dCurrentTime=(System.currentTimeMillis()-creationTime)/1000.0;
       if (dCurrentTime<dAppearingTime)
       {
           double dFactor=dCurrentTime/dAppearingTime;
           int cx=(int)(dEndX*dFactor+dStartX*(1.0-dFactor));
           int cy=(int)(dEndY*dFactor+dStartY*(1.0-dFactor));
           setLocation(cx,cy);
           scaleBaseImage(dFactor);
       }
       else if (iState==0)
       {
           iState++;
           setLocation((int)dEndX,(int)dEndY);
           setImage(baseImage);
       }
    }

    public void addedToWorld(World world)
    {
        dEndX=getX();
        dEndY=getY();
        dStartX=world.getWidth()/2;
        dStartY=world.getHeight()/2;
    }
    
}
