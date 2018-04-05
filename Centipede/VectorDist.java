/**
 * Write a description of class VectorDist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VectorDist  
{
    public double x,y,dist,dDir,dDownMove;
    public int iAnimationFrame;
    public VectorDist(double x,double y,double dist,double dDir,double dDownMove,int iAnimationFrame)
    {
        this.x=x;
        this.y=y;
        this.dist=dist;
        this.dDir=dDir;
        this.dDownMove=dDownMove;
        this.iAnimationFrame=iAnimationFrame;
    }
    
    public VectorDist()
    {
        x=0.0;
        y=0.0;
        dist=0.0;
        dDir=1.0;
        dDownMove=-1.0;
        iAnimationFrame=0;
    }
    
    public double getDist()
    {
        return dist;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public int getAnimationFrame()
    {
        return iAnimationFrame;
    }

}
