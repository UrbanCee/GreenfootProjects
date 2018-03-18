import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextField extends Actor
{
    String text;
    int iSize;
    Color colFront = Color.GRAY;
    Color colBack = new Color(0,0,0,0);
    
    public TextField(String text, int iSize)
    {
        setText(text,iSize);
    }
    
    public void setText(String text)
    {
        setText(text,iSize);
    }
    
    
    public void setSize(int iSize)
    {
        setText(text,iSize);
    }

    public void setText(String text, int iSize)
    {
        this.iSize=iSize;
        this.text=text;
        setImage(new GreenfootImage(text,iSize,colFront,colBack));
        updateBaseImage();
    }
    
    public void setForeground(Color col)
    {
        colFront=col;
        setText(text,iSize);
    }
    public void setBackground(Color col)
    {
        colBack=col;
        setText(text,iSize);
    }
    
    public void updateBaseImage()
    {
    }
    
    public String getText()
    {
        return text;
    }
}
