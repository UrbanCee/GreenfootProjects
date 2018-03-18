import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Vector xRange = new Vector(-16,16);
    Vector yRange = new Vector(-6,6);
    Vector size = new Vector();

    List<Function> funcList = new ArrayList<Function>();
    ApproxSinFunc approxSinFunc = new ApproxSinFunc();
    eFuncApprox approxEFunc = new eFuncApprox();
    ToggleButton butSin = new ToggleButton("sin",Color.RED,Color.GREEN);
    ToggleButton bute = new ToggleButton(" e ",Color.RED,Color.GREEN);
    boolean togglebuttonState1 = butSin.isActive();
    boolean togglebuttonState2 = bute.isActive();

    int iMargin=2;
    int iCorrdArrowSize=6;
    int iGranularity=getWidth()*2;
    Slider approxOrderSlider = new Slider();
    int iLastOrder=1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(approxOrderSlider,getWidth()-10-approxOrderSlider.getImage().getWidth()/2,10+approxOrderSlider.getImage().getHeight()/2);
        butSin.setActive(true);
        togglebuttonState1 = butSin.isActive();
        togglebuttonState2 = bute.isActive();
        addObject(butSin,butSin.getImage().getWidth()/2+10,butSin.getImage().getHeight()/2+10);
        addObject(bute,butSin.getX()+butSin.getImage().getWidth()/2+10+bute.getImage().getWidth(),bute.getImage().getHeight()/2+10);
        approxOrderSlider.setRange(1,20);
        approxOrderSlider.setValue(iLastOrder);
        funcList.add(new SinFunction());
        approxSinFunc.setColor(Color.RED);
        funcList.add(approxSinFunc);
        funcList.add(new eFunc());
        approxEFunc.setColor(Color.GREEN);
        funcList.add(approxEFunc);
        calcRange();
        paint();
        Greenfoot.start();
    }

    public void act()
    {
        if (approxOrderSlider.getValue()!=iLastOrder)
        {
            iLastOrder=approxOrderSlider.getValue();
            approxSinFunc.setApproxFactor(approxOrderSlider.getValue());
            approxEFunc.setApproxFactor(approxOrderSlider.getValue());
            paint();
        }
        if (togglebuttonState1!=butSin.isActive())
        {
            togglebuttonState1=butSin.isActive();
            paint();
        }
        if (togglebuttonState2!=bute.isActive())
        {
            togglebuttonState2=bute.isActive();
            paint();
        }
    }

    public int x2pix(double x)
    {
        double dWidth=(double)getWidth()-1.0-2.0*iMargin;
        return iMargin+(int) Math.round((x-xRange.x)/size.x*dWidth);
    }

    public int y2pix(double y)
    {
        double dHeight=(double)getHeight()-1.0-2.0*iMargin;
        return getHeight()-1-iMargin-(int) Math.round((y-yRange.x)/size.y*dHeight);
    }

    public void setXRange(Vector newXRange)
    {
        xRange=new Vector(newXRange);
        calcRange();
    }

    public void setYRange(Vector newYRange)
    {
        yRange=new Vector(newYRange);
        calcRange();
    }

    public void paint()
    {
        GreenfootImage img = getBackground();
        img.setColor(Color.WHITE);
        img.fill();
        createCoordinateSystem();
        int iCount=-1;
        for(Function func : funcList)
        {
            iCount++;
            if ( (iCount/2==0 && butSin.isActive()) || (iCount/2==1 && bute.isActive()) )
            {
                List<Vector> points = func.calcPoints(xRange,iGranularity);
                img.setColor(func.col);
                for (int i=0;i<points.size()-1;i++)
                {
                    int x1=x2pix(points.get(i).x);
                    int y1=y2pix(points.get(i).y);
                    int x2=x2pix(points.get(i+1).x);
                    int y2=y2pix(points.get(i+1).y);
                    img.drawLine(x1,y1,x2,y2);
                }
            }
        }
    }

    private void calcRange()
    {
        size = new Vector(xRange.y-xRange.x,yRange.y-yRange.x);
    }

    public void createCoordinateSystem()
    {
        GreenfootImage img=getBackground();
        img.setColor(Color.BLACK);
        int x11=x2pix(xRange.x);
        int x12=x2pix(xRange.y);
        int y1=y2pix(0.0);
        if ( y1>=0 && y1<=getHeight())
        {
            img.drawLine(x11,y1,x12,y1);
            img.drawLine(x12-iCorrdArrowSize,y1-iCorrdArrowSize,x12,y1);
            img.drawLine(x12-iCorrdArrowSize,y1+iCorrdArrowSize,x12,y1);
        }
        int x2=x2pix(0.0);
        int y21=y2pix(yRange.x);
        int y22=y2pix(yRange.y);
        if ( x2>=0 && x2<=getWidth())
        {
            img.drawLine(x2,y21,x2,y22);
            img.drawLine(x2-iCorrdArrowSize,y22+iCorrdArrowSize,x2,y22);
            img.drawLine(x2+iCorrdArrowSize,y22+iCorrdArrowSize,x2,y22);
        }
    }

}
