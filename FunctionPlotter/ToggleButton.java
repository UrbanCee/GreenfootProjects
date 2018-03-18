import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToggleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToggleButton extends Button
{
    Color col1;
    Color col2;

    boolean active=false;
    boolean buttonDown=false;

    public ToggleButton(String text, Color col1, Color col2)
    {
        super(text,col1);
        this.col1=col1;
        this.col2=col2;
        paint();
    }

    public void act() 
    {
        MouseInfo m= Greenfoot.getMouseInfo();
        if (m!=null)
        {
            if (m.getActor()==this)
            {
                if (m.getButton()==1)
                {
                    if (!buttonDown)
                        toggle();
                    buttonDown=true;
                }else{
                    buttonDown=false;
                }
            }
        }
    }  

    
    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active=active;
        updateColor();
        paint();
    }

    public void toggle()
    {
        active=!active;
        updateColor();
        paint();
    }
    
    public void updateColor()
    {
        if (active)
            drawColor=col2;
            else
            drawColor=col1;
    }

    
}
