import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static final int centerX = 400;
    public static final int centerY = 400;
    public static final int radius = 375;
    public int time=0;
    public hourHand hour=null;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        GreenfootImage bgd=getBackground();
        bgd.clear();
        bgd.setColor(Color.WHITE);
        bgd.fill();
        bgd.setColor(Color.BLACK);
        int iOuterClockThickness = 5;
        int iOuterClockOverlap = 1;
        bgd.fillOval(centerX-radius-iOuterClockThickness,centerX-radius-iOuterClockThickness , 
                    (radius+iOuterClockThickness)*2, (radius+iOuterClockThickness)*2);
        bgd.setColor(Color.WHITE);
        bgd.fillOval(centerX-radius+iOuterClockOverlap, centerX-radius+iOuterClockOverlap, 
                    (radius-iOuterClockOverlap)*2, (radius-iOuterClockOverlap)*2);
        setBackground(bgd);
        //Hour Markers
        double bigMarkerThickness=6;
        double bigMarkerLength=40;
        for(int i=0;i<12;i++)
        {
            double dDirX=Math.cos((double)i/6.0*Math.PI);
            double dDirY=Math.sin((double)i/6.0*Math.PI);
            double dNormX=dDirY;
            double dNormY=-dDirX;
            int xPos[] = {
                (int)(400.0+dDirX*(375.0-bigMarkerLength)+dNormX*bigMarkerThickness/2.0),
                (int)(400.0+dDirX*(375.0)+dNormX*bigMarkerThickness/2.0),
                (int)(400.0+dDirX*(375.0)-dNormX*bigMarkerThickness/2.0),
                (int)(400.0+dDirX*(375.0-bigMarkerLength)-dNormX*bigMarkerThickness/2.0)                
            };
            int yPos[] = {
                (int)(400.0+dDirY*(375.0-bigMarkerLength)+dNormY*bigMarkerThickness/2.0),
                (int)(400.0+dDirY*(375.0)+dNormY*bigMarkerThickness/2.0),
                (int)(400.0+dDirY*(375.0)-dNormY*bigMarkerThickness/2.0),
                (int)(400.0+dDirY*(375.0-bigMarkerLength)-dNormY*bigMarkerThickness/2.0)                
            };
            bgd.setColor(Color.BLACK);
            bgd.fillPolygon(xPos,yPos,4);
        }
        bigMarkerThickness=2;
        bigMarkerLength=20;
        for(int i=0;i<60;i++)
        {
            double dDirX=Math.cos((double)i/30.0*Math.PI);
            double dDirY=Math.sin((double)i/30.0*Math.PI);
            double dNormX=dDirY;
            double dNormY=-dDirX;
            int xPos[] = {
                (int)(400.0+dDirX*(375.0-bigMarkerLength)+dNormX*bigMarkerThickness/2.0),
                (int)(400.0+dDirX*(375.0)+dNormX*bigMarkerThickness/2.0),
                (int)(400.0+dDirX*(375.0)-dNormX*bigMarkerThickness/2.0),
                (int)(400.0+dDirX*(375.0-bigMarkerLength)-dNormX*bigMarkerThickness/2.0)                
            };
            int yPos[] = {
                (int)(400.0+dDirY*(375.0-bigMarkerLength)+dNormY*bigMarkerThickness/2.0),
                (int)(400.0+dDirY*(375.0)+dNormY*bigMarkerThickness/2.0),
                (int)(400.0+dDirY*(375.0)-dNormY*bigMarkerThickness/2.0),
                (int)(400.0+dDirY*(375.0-bigMarkerLength)-dNormY*bigMarkerThickness/2.0)                
            };
            bgd.setColor(Color.BLACK);
            bgd.fillPolygon(xPos,yPos,4);
        }
        setPaintOrder(minHand.class,hourHand.class);
        
        hour= new hourHand();
        minHand minute = new minHand();
        hour.minute=minute;
        minute.hour=hour;
        
        addObject(hour,400,400);
        addObject(minute,400,400);
        
        hour.setTime(2,49);
        Greenfoot.start();
    }
    
    public void act()
    {
    }
        
}
