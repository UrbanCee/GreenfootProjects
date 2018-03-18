import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slider extends Actor
{
    
    
    int iSliderMin=0;
    int iSliderMax=100;
    int iSliderWidth=100;
    int iSliderKnobRadius=10;
    int iSliderValue=50;

    public Slider()
    {
        draw();
    }

    
    public void act() 
    {
        
        if (Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            double dRelVal=0.5+(double)(mouse.getX()-getX())/(double)iSliderWidth;
            if (dRelVal<0.0)
                dRelVal=0;
            else if (dRelVal>1.0)
                dRelVal=1.0;
            setValue((int)Math.round(dRelVal*(iSliderMax-iSliderMin))+iSliderMin);
        }                
    }    
    
    
    public void draw()
    {
        GreenfootImage img = new GreenfootImage(iSliderWidth+2*iSliderKnobRadius+2,2*iSliderKnobRadius+1);
        img.setColor(Color.GRAY);
        img.fillRect(iSliderKnobRadius-1,iSliderKnobRadius-1,iSliderWidth,3);
        int xc=getSliderKnobPos();
        img.setColor(Color.BLUE);
        img.fillOval(xc-iSliderKnobRadius,0,2*iSliderKnobRadius,iSliderKnobRadius*2);
        img.setColor(Color.BLACK);
        img.drawOval(xc-iSliderKnobRadius,0,2*iSliderKnobRadius,iSliderKnobRadius*2);
        setImage(img);
    }
    
    private double dRelSlider()
    {
        return (double)(iSliderValue-iSliderMin)/(double)(iSliderMax-iSliderMin);
    }
   
    private int getSliderKnobPos()
    {
        double dRel=dRelSlider();
        return (int)Math.round(((dRel-0.5)*iSliderWidth))+iSliderWidth/2+iSliderKnobRadius+1;
    }
    
    
    public void setValue(int iValue)
    {
        iSliderValue=Math.min(Math.max(iSliderMin,iValue),iSliderMax);
        draw();
    }
    
    public int getValue()
    {
        return iSliderValue;
    }
    
    public void setMin(int newMin)
    {
        iSliderMin=newMin;
        draw();
    }
    public void setMax(int newMax)
    {
        iSliderMax=newMax;
        draw();
    }
    public void setRange(int newMin, int newMax)
    {
        iSliderMax=newMax;
        iSliderMin=newMin;
        draw();
    }
    
}
