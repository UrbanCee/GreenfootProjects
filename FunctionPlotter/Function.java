import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Function here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Function
{
    Color col = Color.BLUE;
    public List<Vector> calcPoints(Vector range, int iGranularity)
    {
        List<Vector> points = new ArrayList<Vector>(iGranularity+1);
        double dStepSize=1.0/(range.y-range.x);
        for(int i=0;i<iGranularity+1;i++)
        {
            double x=range.x+dStepSize*i;
            points.add(new Vector(x,calcValue(x)));
        }
        return points;
    }
    
    public void setColor(Color col)
    {
        this.col=col;
    }
    
    public abstract double calcValue(double x);
    
    public static double fac(int i)
    {
        if (i<=0)
            return 0.0;
        double val=1.0;
        for (int j=1;j<=i;j++)
        {
            val*=j;
        }
        return val;
    }
}
