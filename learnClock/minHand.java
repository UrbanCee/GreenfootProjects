import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class minHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class minHand extends Hand
{
    public hourHand hour = null;

    public int getMinute()
    {
        return ((getRotation()+90)%360)/6;
    }

    void setTime(int min)
    {
        setRotation(min*6-90);
    }

    public void paint()
    {
        int iWidth=20;
        int iLength=390;
        int iAxleRadius=7;
        img = new GreenfootImage(MyWorld.radius*2,iWidth);
        int iPolyX[]={MyWorld.radius-iWidth/2,MyWorld.radius,MyWorld.radius+iLength,MyWorld.radius};
        int iPolyY[]={iWidth/2,0,iWidth/2,iWidth};

        img.setColor(Color.BLUE);
        img.fillPolygon(iPolyX,iPolyY,4);

        img.setColor(Color.BLACK);
        img.fillOval(MyWorld.radius-iAxleRadius,iWidth/2-iAxleRadius,iAxleRadius*2,iAxleRadius*2);

        setImage(img);
    }

    protected void turnTo(int x,int y)
    {
        int lastMin=getMinute();
        turnTowards(x,y);
        int currMin=getMinute();
        int elapsed=currMin-lastMin;
        System.out.println(lastMin + "  " + currMin + "  " + elapsed);
        int hour=this.hour.getHour();
        if (elapsed>0)
        {
            if (elapsed>30)
                hour--;
        }else if (elapsed<0)
        {
            if (elapsed<-30)
                hour++;
        }else
            return;
        this.hour.setTime(hour,currMin);
    }

}
