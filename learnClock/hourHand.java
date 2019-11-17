import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hourHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hourHand extends Hand
{
    public minHand minute = null;
    
    public int getHour()
    {
        return ((getRotation()/30)+3)%12;
    }
    public void setTime(int iHour,int iMin)
    {
        setRotation(iHour*30-90+iMin/2);
        minute.setTime(iMin);
    }
    public void paint()
    {
        int iWidth=41;
        int iLength=250;
        int iAxleRadius=13;
        img = new GreenfootImage(MyWorld.radius*2,iWidth);
        int iPolyX[]={MyWorld.radius-iWidth/2,MyWorld.radius,MyWorld.radius+iLength,MyWorld.radius};
        int iPolyY[]={iWidth/2,0,iWidth/2,iWidth};
        
        img.setColor(Color.RED);
        img.fillPolygon(iPolyX,iPolyY,4);
        
        img.setColor(Color.BLACK);
        img.fillOval(MyWorld.radius-iAxleRadius,iWidth/2-iAxleRadius,iAxleRadius*2,iAxleRadius*2);
        
        setImage(img);
    }
    
        protected void turnTo(int x,int y)
    {
        turnTowards(x,y);
        minute.setTime(getRotation()%30*2);
    }


}
