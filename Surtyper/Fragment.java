import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

/**
 * Write a description of class Fragment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fragment extends AnimatedObject
{
    double vx,vy;
    long startTime = System.currentTimeMillis();
    static final long alife=5000;
    static final double dFrictionFac=2000.0;
    double rotSpeed = Greenfoot.getRandomNumber(1000)-500;
    double rot=0;
    public Fragment(GreenfootImage image, double vx, double vy)
    {
        this.vx=vx;
        this.vy=vy;
        setImage(image);
    }

    public void act() 
    {
        updateTime();
        if (System.currentTimeMillis()-startTime>alife || getY()>getWorld().getHeight()-getImage().getHeight())
        {
            getWorld().removeObject(this);
        }
        double v=Math.sqrt(vx*vx+vy*vy);
        double currFrictionFac=-dFrictionFac*dT;
        if (v>0.0)
            currFrictionFac=currFrictionFac/v;
        else 
            currFrictionFac=0.0;
        vx+=vx*currFrictionFac;
        vy+=vy*currFrictionFac;
        vy+=3000.0*dT;
        dy+=vy*dT;
        dx+=vx*dT;
        rot+=rotSpeed*dT;
        setRotation((int)rot);
        setPos();
    }
    
    public static void createExplodingFragments(Actor actor, int ixDivide, int iyDivide)
    {
        int iChunkWidth=actor.getImage().getWidth()/ixDivide;
        int iChunkHeight=actor.getImage().getHeight()/iyDivide;
        for (int ix=0;ix<ixDivide;ix++)
        {
            for(int iy=0;iy<iyDivide;iy++)
            {
                BufferedImage bufImage = actor.getImage().getAwtImage().getSubimage(ix*iChunkWidth,iy*iChunkHeight,iChunkWidth-1,iChunkHeight-1);
                GreenfootImage gImage = new GreenfootImage(bufImage.getWidth(), bufImage.getHeight());
                BufferedImage gBufImg = gImage.getAwtImage();
                Graphics2D graphics = (Graphics2D)gBufImg.getGraphics();
                graphics.drawImage(bufImage, null, 0, 0);
                int deltaX=-actor.getImage().getWidth()/2+((2*ix+1)*iChunkWidth)/2;
                int deltaY=-actor.getImage().getHeight()/2+((2*iy+1)*iChunkHeight)/2;
                double dSpeed=Greenfoot.getRandomNumber(10)+10;
                actor.getWorld().addObject(new Fragment(gImage,deltaX*dSpeed,deltaY*dSpeed),actor.getX()+deltaX,actor.getY()+deltaY);
            }
        }
        
    }

}
