import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends AnimatedObject
{
    String string;
    static public final double dInitialFallSpeed=50.0;
    static public double dFallSpeed=dInitialFallSpeed;
    boolean marked=false;
    GreenfootImage background;
//    Greenfoot color

    public Enemy(String string)
    {
        this.string=string;
        background=getImage();
        paint();
    }

    public void act() 
    {
        updateTime();
        dy+=dT*dFallSpeed;
        setPos();
    }  

    public boolean isHit(String hitString)
    {
        return string.equals(hitString);
    }

    public boolean isMarked()
    {
        return marked;
    }

    public void mark()
    {
        marked=true;
    }


    public void paint()
    {
        GreenfootImage image = new GreenfootImage(background);
/*       
        java.awt.Graphics2D g = image.getAwtImage().createGraphics();
        Font font = image.getFont().deriveFont(20.0f);
        FontMetrics fm = g.getFontMetrics(new java.awt.Font(font.getName(),1,font.getSize()));
        int fw = fm.stringWidth(paddedString);
        int fh = fm.getAscent();
        int iSIze=Math.max(fw,fh);*/
        GreenfootImage textImage = new GreenfootImage(string,40,Color.RED,new Color(0,0,0,0));
        int iSIze=Math.max(textImage.getWidth(),textImage.getHeight());
        
        image.scale((iSIze*5)/4,(iSIze*5)/4);
        image.drawImage(textImage,image.getWidth()/2-textImage.getWidth()/2,image.getHeight()/2-textImage.getHeight()/2);
    
        setImage(image);
    }

}
