import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Player player = new Player();
    static final int initialShroomCount=48;
    static final int centipedeLength=15;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        Tex.loadImagesFromFile();
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        addObject(player,getWidth()/2,getHeight()-20);
        spawnNewCentipede();
        for(int i=0;i<initialShroomCount;i++)
        {
            int x=Greenfoot.getRandomNumber(25)*16+8;
            int y=Greenfoot.getRandomNumber(32)*16+8+16;
            if (getObjectsAt(x,y,Shroom.class).isEmpty())
            {
                addObject(new Shroom(),x,y);
            }
        }
    }

    public void spawnNewCentipede()
    {
        Segment oldSeg = null;
        Segment seg = null;
        for(int i=0;i<centipedeLength;i++)
        {
            if (i<centipedeLength-1){
                seg = new Segment();
                if (oldSeg!=null){
                    oldSeg.setLeadingSegment(seg);
                }
            }
            else{ 
                seg = new Segment(true);
            }
            if (oldSeg!=null)
                seg.setNextSegment(oldSeg);
            oldSeg=seg;
            addObject(seg,8+12*16,0);            
        }
        seg.setUpperStart();
    }
}
