import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BaseAgent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseAgent extends Actor
{
    static final int size=21;
    static final double repelWallStrength = 20;
    static final double repelWallDist = size;
    static final double repelAgentDist = size * 1.2;
    Vector x = new Vector();
    Vector v = new Vector();
    double dT;
    long lastUpdate=System.currentTimeMillis();
    Color col;
    public BaseAgent()
    {
        col=Color.BLACK;
    }
    
    
    public void act()
    {
        updateTime();
        Vector a = Vector.add(repellWall(),Vector.mult(v,-0.1));
        v.add(Vector.mult(a,dT));
        x.add(Vector.mult(v,dT));
        setLocation((int)x.x,(int)x.y);
    }
    
    public Vector repellWall()
    {
        Vector a = new Vector();
        if (x.x<repelWallDist)
        {
            double dx=repelWallDist-x.x;
            a.setX(dx*dx*repelWallStrength);
        }
        if (x.x>getWorld().getWidth()-repelWallDist)
        {
            double dx=repelWallDist-getWorld().getWidth()+x.x;
            a.setX(-dx*dx*repelWallStrength);
        }
        if (x.y<repelWallDist)
        {
            double dy=repelWallDist-x.y;
            a.setY(dy*dy*repelWallStrength);
        }
        if (x.y>getWorld().getHeight()-repelWallDist)
        {
            double dy=repelWallDist-getWorld().getHeight()+x.y;
            a.setY(-dy*dy*repelWallStrength);
        }
        return a;
    }
    
    public void addedToWorld(World world)
    {
        draw();
        x.setX(getX());
        x.setY(getY());
        v.setLength(Greenfoot.getRandomNumber(200)+50);
        v.setAngleDeg(Greenfoot.getRandomNumber(360));
    }
    
    
    private void draw()
    {
        GreenfootImage image = new GreenfootImage(size,size);
        image.setColor(col);
        image.fillOval(0,0,size-1,size-1);
        setImage(image);
    }
    
    private void updateTime()
    {
        long currentTime=System.currentTimeMillis();
        dT=(double)(currentTime-lastUpdate)/1000.0;
        lastUpdate=currentTime;
        if (dT>0.5)
            dT=0;
    }
    
}
