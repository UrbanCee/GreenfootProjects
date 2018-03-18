import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics2D;
import java.awt.FontMetrics;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    String buttonText;
    Color drawColor;
    int width=100;
    int height=50;

    public Button(String text, Color col)
    {
        this.drawColor=col;
        buttonText=text;
        paint();
    }


    public void paint()
    {
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(drawColor);
        image.fillRect(0,0,width,height);
        image.setColor(Color.WHITE);
        image.fillRect(5,5,width-10,height-10);
        image.setColor(drawColor);
        Font font = image.getFont().deriveFont(20.0f);
        image.setFont(font);
        java.awt.Graphics2D g = getImage().getAwtImage().createGraphics();
        FontMetrics fm = g.getFontMetrics(new java.awt.Font(font.getName(),1,font.getSize()));
        int actualTextWidth = fm.stringWidth(buttonText);
        int textHeight = fm.getAscent();

        image.drawString(buttonText,width/2-actualTextWidth/2,height/2+textHeight/2);

        setImage(image);
    }


    
}
