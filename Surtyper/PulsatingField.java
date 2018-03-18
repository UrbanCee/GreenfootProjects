import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PulsatingField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PulsatingField extends SizeChangingTextField 
{
    double dCoeff;
    double dOmega;
    public PulsatingField(String text, int iSize, double dPulseCoeff, double dPulseFreq)
    {
        super(text,iSize);
        dCoeff=dPulseCoeff;
        dOmega=dPulseFreq*Math.PI;
    }
    
    public void act() 
    {
        double dTime=(System.currentTimeMillis()-creationTime)/1000.0;
        double dFactor=dCoeff*Math.sin(dOmega*dTime);
        if (dFactor>=0)
            dFactor=1.0+dFactor;
        else
            dFactor=1.0/(1.0-dFactor);
        scaleBaseImage(dFactor);
    }    
    
    
}
