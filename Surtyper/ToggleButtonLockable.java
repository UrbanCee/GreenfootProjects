import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToggleButtonLockable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToggleButtonLockable extends Button
{
    Color col1;
    Color col2;
    Color col3;

    boolean active=false;
    boolean buttonDown=false;
    boolean locked=false;

    public ToggleButtonLockable(String text, Color col1, Color col2, Color col3)
    {
        super(text,col1);
        this.col1=col1;
        this.col2=col2;
        this.col3=col3;
        paint();
    }

    public void act() 
    {
        if (locked)
            return;
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
        if (locked)
            drawColor=col3;
        else if (active)
            drawColor=col2;
        else
            drawColor=col1;
    }
    
    public void lock()
    {
        locked=true;
        setActive(false);
    }
    public void unlock()
    {
        locked=false;
        setActive(false);
    }

    
}
