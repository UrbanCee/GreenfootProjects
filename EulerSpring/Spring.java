import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spring here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spring extends AnimatedObject
{
    SpringAnchor anchor;
    SpringBall ball;
    public static int SpringWidth=21;
    double restLength = 200;
    double k=5;
    int iCoils=20;
    public Spring(SpringAnchor anchor, SpringBall ball)
    {
        this.anchor=anchor;
        this.ball=ball;
    }
    
    public void act() 
    {
        update();
    }   
    
    public void update()
    {
        Vector va= new Vector(anchor.getX(),anchor.getY());
        Vector vs= new Vector(ball.getX(),ball.getY());
        Vector as = Vector.sub(vs,va);
        Vector pos = Vector.add(vs,va);
        pos.mult(0.5);
        setImage(drawSpring());
        setRotation(as.getGreenfootRotation());
        setLocation((int) Math.round(pos.x),(int) Math.round(pos.y));
        
    }
    
    public void setRestLength(double restLength)
    {
        this.restLength=restLength;
    }
    
    public void setK(double k)
    {
        this.k=k;
    }
    
    public Vector force()
    {
        Vector va= new Vector(anchor.getX(),anchor.getY());
        Vector vs= new Vector(ball.getX(),ball.getY());
        Vector as = Vector.sub(vs,va);
        Vector rest = new Vector(as);
        rest.normalize();
        rest.mult(restLength);
        Vector force = new Vector(rest);
        force.sub(as);
        return force.mult(k);
    }
    
    GreenfootImage drawSpring()
    {
        Vector va= new Vector(anchor.getX(),anchor.getY());
        Vector vs= new Vector(ball.getX(),ball.getY());
        Vector as = Vector.sub(vs,va);
        GreenfootImage baseImage = new GreenfootImage(SpringWidth,Math.max((int)Math.round(as.r),1));
        baseImage.setColor(Color.GRAY);
        double dSpringLength=baseImage.getHeight()-20;
        double dSpringIncrement=dSpringLength/((double)iCoils+0.5);
        double dHSPi=dSpringIncrement/2;
        double dQSPi=dSpringIncrement/4;
        baseImage.drawLine(SpringWidth/2,0,SpringWidth/2,10);
        baseImage.drawLine(SpringWidth/2,10,0,10+(int)Math.round(dQSPi));
        for (int i=0;i<iCoils;i++)
        {
            int x1=(int)Math.round(dSpringIncrement*i+dQSPi)+10;
            int x2=(int)Math.round(dSpringIncrement*i+dHSPi+dQSPi)+10;
            int x3=(int)Math.round(dSpringIncrement*(i+1)+dQSPi)+10;
            baseImage.drawLine(0,x1,SpringWidth,x2);
            baseImage.drawLine(SpringWidth,x2,0,x3);
        }
        baseImage.drawLine(SpringWidth/2,baseImage.getHeight(),SpringWidth/2,baseImage.getHeight()-10);
        baseImage.drawLine(SpringWidth/2,baseImage.getHeight()-10,0,baseImage.getHeight()-10-(int)Math.round(dQSPi));
        return baseImage;
    }
    
}
