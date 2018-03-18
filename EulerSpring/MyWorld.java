import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    TextField arrows = new TextField("↑↓→←: move anchor",20);
    TextField dampingLabel = new TextField("damping",20);
    TextField xAmplitudeLabel = new TextField("x-Amplitude",20);
    TextField yAmplitudeLabel = new TextField("y-Amplitude",20);
    TextField xFrequencyLabel= new TextField("x-Frequency",20);
    TextField yFrequencyLabel = new TextField("y-Frequency",20);
    Slider dampingSlider = new Slider();
    Slider xAmplitudeSlider= new Slider();
    Slider yAmplitudeSlider= new Slider();
    Slider xFrequencySlider= new Slider();
    Slider yFrequencySlider= new Slider();
    SpringAnchor a = new SpringAnchor();
    SpringBall b = new SpringBall(a);
    Spring s = new Spring(a,b);
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(a,getWidth()/2,getHeight()/4);
        addObject(b,getWidth()/2-100,(getHeight())/4+30);
        addObject(s,0,0);
        b.setSpring(s);
        s.setRestLength(getHeight()/4);
        arrows.setForeground(Color.GRAY);
        addObject(arrows,getWidth()-arrows.getImage().getWidth()/2-10,arrows.getImage().getHeight());
        dampingSlider.setValue(0);
        xAmplitudeSlider.setValue(0);
        xFrequencySlider.setValue(0);
        xFrequencySlider.setRange(-100,100);
        yAmplitudeSlider.setValue(0);
        yFrequencySlider.setValue(0);
        yFrequencySlider.setRange(-100,100);

        yAmplitudeSlider.setValue(0);
        addSliderLabelComboFromRight(dampingLabel, dampingSlider,arrows.getY()+20);
        addSliderLabelComboFromRight(xAmplitudeLabel, xAmplitudeSlider,dampingSlider.getY()+20);
        addSliderLabelComboFromRight(xFrequencyLabel, xFrequencySlider,xAmplitudeSlider.getY()+15);
        addSliderLabelComboFromRight(yAmplitudeLabel, yAmplitudeSlider,xFrequencySlider.getY()+20);
        addSliderLabelComboFromRight(yFrequencyLabel, yFrequencySlider,yAmplitudeSlider.getY()+15);
        Greenfoot.start();
    }
    
    public void act()
    {
        b.setDamping(dampingSlider.getValue()/50.0);
        a.setXAmplitude(xAmplitudeSlider.getValue());
        a.setYAmplitude(yAmplitudeSlider.getValue());
        a.setXFrequency(Math.pow(10,xFrequencySlider.getValue()/100.0));
        a.setYFrequency(Math.pow(10,yFrequencySlider.getValue()/100.0));
    }
    
    public void addSliderLabelComboFromRight(Actor label, Actor slider, int y)
    {
        int sw=slider.getImage().getWidth();
        y+=slider.getImage().getHeight()/2;
        addObject(slider,getWidth()-sw/2-10,y);
        addObject(label,slider.getX()-sw/2-10-label.getImage().getWidth()/2,y);
    }
}
