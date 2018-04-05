import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class Segment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Segment extends AnimatedActor
{
    static double SPEED=100.0;

    double dCurrentDist=0.0;
    double dDir=-1.0;
    double dDownMove=-1.0;
    Segment nextSegment=null;
    Segment leadingSegment=null;
    LinkedList<VectorDist> positions = new LinkedList<VectorDist>();

    boolean isHead=false;
    int iAnimationFrame=0;
    int iLeftAndRightOffset=0;

    public Segment()
    {
        updateGraphics();
    }

    public Segment(boolean isHead)
    {
        this.isHead=isHead;
        updateGraphics();
    }

    public void updateGraphics()
    {
        if (isHead)
            setImage(Tex.imageCatalogueHead.get(iAnimationFrame));
        else
            setImage(Tex.imageCatalogueBody.get(iAnimationFrame));
    }

    public void act()
    {
        if (isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
            getWorld().addObject(new Shroom(),getX(),getY());
            if (nextSegment!=null){
                nextSegment.promoteHead();
            }
            getWorld().removeObject(this);
            if (leadingSegment!=null)
            {
                leadingSegment.setNextSegment(null);
            }
            return;
        }
        if (!isHead)
            return;
        updateTime();
        int iNewAnimationFrame=0;
        if (dDownMove==-1.0){
            if ((dDir>0 && x>getWorld().getWidth()-9)||(dDir<0 && x<8)){
                dDownMove=16.0;
            }else if (isTouching(Shroom.class)){
                if (dDir>0){
                    if (getOneIntersectingObject(Shroom.class).getX()>getX())
                        dDownMove=16.0;
                }else{
                    if (getOneIntersectingObject(Shroom.class).getX()<getX())
                        dDownMove=16.0;
                }
            }
        }
        double dMoveDist=dT*SPEED;
        if (dDownMove>-1.0)
        {
            dDownMove-=dMoveDist;
            y+=dMoveDist;
            if (dDownMove<=0.0){
                y=Math.round(y);
                dDir*=-1;
                iLeftAndRightOffset=(int)(dDir+1)/2*Tex.baseSegmentImageSize();
                x+=dMoveDist*dDir;
                iNewAnimationFrame=(((int)dCurrentDist/4)%5)+iLeftAndRightOffset;
                dDownMove=-1.0;
            }else{
                iNewAnimationFrame=11-(int)(6*dDownMove/16.0)+iLeftAndRightOffset;
            }
        }else{
            x+=dMoveDist*dDir;
            iNewAnimationFrame=(((int)dCurrentDist/4)%5)+iLeftAndRightOffset;
        }
        dCurrentDist+=dMoveDist;
        if (iNewAnimationFrame!=iAnimationFrame){
            setImage(Tex.imageCatalogueHead.get(iAnimationFrame));
            iAnimationFrame=iNewAnimationFrame;
        }
        setPos();
        storePosition();
    }
    
    public void promoteHead()
    {
        isHead=true;
    }
    

    public void moveTo(VectorDist vd)
    {
        x=vd.getX();
        y=vd.getY();
        dCurrentDist=vd.getDist();
        dDownMove=vd.dDownMove;
        dDir=vd.dDir;
        if (vd.getAnimationFrame()!=iAnimationFrame){
            iAnimationFrame=vd.getAnimationFrame();
            setImage(Tex.imageCatalogueBody.get(iAnimationFrame));
        }
        setPos();
        storePosition();

    }

    private void storePosition()
    {
        positions.add(new VectorDist(x,y,dCurrentDist,dDir,dDownMove,iAnimationFrame));
        VectorDist vd = null;
        while(dCurrentDist-positions.getFirst().getDist()>16){
            vd = positions.removeFirst();
        }
        if (vd==null || nextSegment==null)
            return;
        nextSegment.moveTo(vd);

    }

    public void setNextSegment(Segment nextSegment)
    {
        this.nextSegment=nextSegment;
    }
    public void setLeadingSegment(Segment leadingSegment)
    {
        this.leadingSegment=leadingSegment;
    }

    public void setUpperStart(){
        y=-8;
        dDownMove=16.0;
    }

}
