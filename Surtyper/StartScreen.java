import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    ToggleButtonLockable startButton = new ToggleButtonLockable("START!",Color.RED,Color.GREEN,Color.GRAY);
    List<ToggleButton> buttonList = new ArrayList<ToggleButton>(8);
    List<List<String>> allKeySets =new ArrayList<List<String>>(8); 
    TextField baseScore = new TextField(new String("Base Score: ")+String.valueOf(200),30);
    TextField highScore = null;

    int iHighScore=0;
    boolean bReadyToGo=true;

    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(startButton,getWidth()/2,getHeight()*3/4);
        Greenfoot.start();
        createLists();
        buttonList.add(new ToggleButton("Little L",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Ring L",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Middle L",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Index L",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Index R",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Middle R",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Ring R",Color.RED,Color.GREEN));
        buttonList.add(new ToggleButton("Little R",Color.RED,Color.GREEN));
        
        
        createTextFields();

        for (int i=0;i<buttonList.size();i++)
        {
            int ix=(int)(getWidth()*(2.0*i+1.0)/16.0);
            addObject(buttonList.get(i),ix,getHeight()/2);
            buttonList.get(i).setActive(true);
        }

    }

    public void act()
    {
        int iActive=0;
        for (int i=0;i<buttonList.size();i++)
        {
            if (buttonList.get(i).isActive())
                iActive++;
        }
        Playfield.iBaseScoreValue=60+5*iActive;
        baseScore.setText(new String("Base Score: ")+String.valueOf(Playfield.iBaseScoreValue),30);
        if (bReadyToGo!=(iActive>0)){
            if (iActive>0)
                startButton.unlock();
            else
                startButton.lock();
            bReadyToGo=(iActive>0);
        }
        
        if (startButton.isActive())
        {
            startButton.setActive(false);
            createPlayfield();
        }
    }

    public void createPlayfield()
    {
        List<String> currentList= new ArrayList<String>();
        for(int idx=0;idx<buttonList.size();idx++)
        {
            if (buttonList.get(idx).isActive())
            {
                for (int i=0;i<allKeySets.get(idx).size();i++)
                {
                    currentList.add(allKeySets.get(idx).get(i));
                }
            }
        }
        Playfield playfield = new Playfield(this,currentList);
        Greenfoot.setWorld(playfield);    
    }
    
    public void createTextFields()
    {
        TextField gameName = new TextField("SURTYPER!",60);
        gameName.setForeground(Color.BLUE);
        TextField gameSubName = new TextField("survive by typing as long as possible",20);
        addObject(gameName,getWidth()/2,30+gameName.getImage().getHeight()/2);
        addObject(gameSubName,getWidth()/2,40+gameName.getImage().getHeight()/2+gameSubName.getImage().getHeight());
        TextField selectText = new TextField("Select fingers you want to train, the more fingers the higher the score",25);
        addObject(selectText,getWidth()/2,getHeight()/2-60+selectText.getImage().getHeight()/2);
        addObject(baseScore,getWidth()/2,getHeight()/2+60-baseScore.getImage().getHeight()/2);
        setHighScore(0);
    }

    public void createLists()
    {
        List<String> leftLittle= new ArrayList<String>(3);
        leftLittle.add("y");leftLittle.add("a");leftLittle.add("q");
        List<String> leftRing= new ArrayList<String>(3);
        leftRing.add("x");leftRing.add("s");leftRing.add("w");
        List<String> leftMiddle= new ArrayList<String>(3);
        leftMiddle.add("c");leftMiddle.add("d");leftMiddle.add("e");
        List<String> leftIndex= new ArrayList<String>(6);
        leftIndex.add("v");leftIndex.add("f");leftIndex.add("r");
        leftIndex.add("b");leftIndex.add("g");leftIndex.add("t");
        List<String> rightLittle= new ArrayList<String>(3);
        rightLittle.add("-");rightLittle.add("ö");rightLittle.add("p");
        List<String> rightRing= new ArrayList<String>(3);
        rightRing.add(".");rightRing.add("l");rightRing.add("o");
        List<String> rightMiddle= new ArrayList<String>(3);
        rightMiddle.add(",");rightMiddle.add("k");rightMiddle.add("i");
        List<String> rightIndex= new ArrayList<String>(6);
        rightIndex.add("m");rightIndex.add("j");rightIndex.add("u");
        rightIndex.add("n");rightIndex.add("h");rightIndex.add("z");
        allKeySets.add(leftLittle);
        allKeySets.add(leftRing);
        allKeySets.add(leftMiddle);
        allKeySets.add(leftIndex);
        allKeySets.add(rightIndex);
        allKeySets.add(rightMiddle);
        allKeySets.add(rightRing);
        allKeySets.add(rightLittle);   
    }
    
    public void setHighScore(int iNewScore)
    {
        if (iNewScore>iHighScore)
        {
            iHighScore=iNewScore;
        }
        if (highScore!=null)
        {
            removeObject(highScore);
        }
        highScore = new TextField(new String("Highscore: ")+String.valueOf(iHighScore),40);
        highScore.setForeground(Color.MAGENTA);
        addObject(highScore,getWidth()/2,getHeight()/4);
    }
}
