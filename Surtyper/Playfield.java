import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Playfield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playfield extends World
{
    public static int iBaseScoreValue=100;
    public static int iHitsRequiredForLevelUp=20;
    public static int iHitsRequiredForComboUp=9;
    public static int iMaxCombo=4;
    StartScreen returnWorld;
    Shooter shooter = new Shooter();
    public static double dInitialTimeToSpawn=1.0;
    double dTimeToSpawnUpdate=dInitialTimeToSpawn;
    int iSpawnsSinceLastLevelUp=0;
    int iComboKills=0;
    int iCurrentCombo=1;
    int iLevel=1;
    long lastUpdate=System.currentTimeMillis();
    List<String> stringList;
    TextField scoreLabel = new TextField("Score:",20);
    TextField score = new TextField("0",30);
    TextField level = new TextField("LEVEL 1",30);
    PulsatingField combo = new PulsatingField("COMBO 1x",30,0.3,3);
    ExplodingTextField currentScoreAddition;
    Color transparent = new Color(0,0,0,0);
    int iGameOverMode=0;
    int iScore=0;

    /**
     * Constructor for objects of class Playfield.
     * 
     */
    public Playfield(World returnWorld, List<String> stringList)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        this.returnWorld=(StartScreen) returnWorld;
        this.stringList=stringList;
        addObject(shooter,getWidth()/2,getHeight());
        shooter.setRotation(270);
        addObject(scoreLabel,getWidth()-scoreLabel.getImage().getWidth()/2-20,scoreLabel.getImage().getHeight()/2+20);
        addObject(score,0,0);
        realignScore();
        combo.setForeground(transparent);
        addObject(combo,getWidth()-(combo.getImage().getWidth()*3)/4,score.getY()+50+combo.getImage().getHeight()/2);
        addObject(level,0,0);
        realignLevelLabel();
        Enemy.dFallSpeed=Enemy.dInitialFallSpeed;
    }

    public void act()
    {
        long curTime=System.currentTimeMillis();
        if (iGameOverMode>0)
        {
            if (curTime-lastUpdate>1000)
            {
                if (iGameOverMode==1)
                {
                    FlashingField finalScore = new FlashingField(new String("Final Score: ")+String.valueOf(iScore),40,1);
                    finalScore.setForeground(Color.YELLOW);
                    addObject(finalScore,getWidth()/2,getHeight()/4+60);  
                    iGameOverMode=2;
                    lastUpdate=curTime;
                }else if (iGameOverMode==2)
                {
                    FlashingField pressEnter = new FlashingField(new String("Press Enter to restart the game!"),20,1);
                    pressEnter.setForeground(Color.GRAY);
                    addObject(pressEnter,getWidth()/2,getHeight()/4+100);  
                    iGameOverMode=3;                    
                }
            }
            if (Greenfoot.isKeyDown("Enter"))
            {
                returnWorld.setHighScore(iScore);
                Greenfoot.setWorld(returnWorld);
            }
            return;
        }
        List<Enemy> enemies = getObjects(Enemy.class);
        for(int i=0;i<enemies.size();i++)
        {
            if (enemies.get(i).getY()>getHeight()-10)
            {
                iGameOverMode=1;
                for (int j=0;j<enemies.size();j++)
                {
                    Fragment.createExplodingFragments(enemies.get(j),4,4);
                    removeObject(enemies.get(j));
                }
                FlashingField gameOver = new FlashingField("GAME OVER!",100,1);
                gameOver.setForeground(Color.RED);
                addObject(gameOver,getWidth()/2,getHeight()/4);  
                lastUpdate=curTime;
                return;
            }
        }

        if ((curTime-lastUpdate)/1000.0 >dTimeToSpawnUpdate)
        {
            lastUpdate=curTime;
            spawnEnemy();
        }
        String pressed = Greenfoot.getKey();
        if (!(pressed==null))
        {

            boolean bFoundTarget=false;
            for(int i=0;i<enemies.size();i++)
            {
                if (enemies.get(i).isMarked())
                    continue;
                if (enemies.get(i).isHit(pressed))
                {
                    enemies.get(i).mark();
                    shooter.turnTowards(enemies.get(i).getX(),enemies.get(i).getY());
                    int dx=(int)(50.0*Math.cos(Math.toRadians(shooter.getRotation())));
                    int dy=(int)(50*Math.sin(Math.toRadians(shooter.getRotation())));
                    addObject(new Bullet(enemies.get(i)),getWidth()/2+dx,getHeight()+dy);
                    bFoundTarget=true;
                    break;
                }
            }
            if (!bFoundTarget)
            {
                iComboKills=0;
                if (iCurrentCombo>1)
                {
                    iCurrentCombo=1;
                    ExplodingTextField comboBroken = new ExplodingTextField(combo.getText(),combo.getImage().getHeight(),0.3);
                    comboBroken.setForeground(Color.MAGENTA);
                    addObject(comboBroken,getWidth()/2,50);
                    combo.setForeground(transparent);
                }
                spawnEnemy();
            }
        }

    }

    public void realignScore()
    {
        score.setLocation(getWidth()-20-score.getImage().getWidth()/2,scoreLabel.getImage().getHeight()+20+score.getImage().getHeight()/2);
    }

    public void realignLevelLabel()
    {
        level.setText(new String("LEVEL ")+String.valueOf(iLevel));
        level.setLocation(20+level.getImage().getWidth()/2,level.getImage().getHeight()/2+20);
    }

    public String createString()
    {
        int poss=stringList.size();
        return stringList.get(Greenfoot.getRandomNumber(poss));
    }

    public void spawnEnemy()
    {

        if (iSpawnsSinceLastLevelUp>iHitsRequiredForLevelUp)
        {
            iSpawnsSinceLastLevelUp=0;
            iLevel++;
            dTimeToSpawnUpdate=dInitialTimeToSpawn/(1.0+(iLevel-1)*0.1);
            ExplodingTextField lvlUp = new ExplodingTextField("LEVEL UP!",40,1);
            lvlUp.setForeground(Color.YELLOW);
            addObject(lvlUp,20+lvlUp.getImage().getWidth()/2,level.getX()+level.getImage().getHeight()/2+20+lvlUp.getImage().getHeight()/2);
            Enemy.dFallSpeed*=1.1;
            realignLevelLabel();
        }
        addObject(new Enemy(createString()),Greenfoot.getRandomNumber(getWidth()-300)+150,0);
    }

    public void enemyDestroyed()
    {
        iComboKills++;
        int iCalcCombo=iComboKills/iHitsRequiredForComboUp+1;
        if (iCalcCombo!=iCurrentCombo && iCalcCombo<=iMaxCombo)
        {
            iCurrentCombo=iCalcCombo;
            combo.setSize(26+4*iCurrentCombo);
            combo.setText(new String("Combo: ")+String.valueOf(iCurrentCombo)+new String("x"));
            combo.setForeground(Color.MAGENTA);
        }
        iSpawnsSinceLastLevelUp++;
        int iAdditionValue=iBaseScoreValue*iCurrentCombo;
        iScore+=iAdditionValue;
        score.setText(String.valueOf(iScore));
        realignScore();
        if (currentScoreAddition!=null && getObjects(ExplodingTextField.class).contains(currentScoreAddition)){
            Fragment.createExplodingFragments(currentScoreAddition,4,4);
            removeObject(currentScoreAddition);
        }
        currentScoreAddition = new ExplodingTextField(new String("+")+String.valueOf(iAdditionValue),30,1);
        currentScoreAddition.setForeground(Color.CYAN);
        addObject(currentScoreAddition,getWidth()-20-currentScoreAddition.getImage().getWidth()/2,score.getY()+score.getImage().getHeight()/2+currentScoreAddition.getImage().getHeight()/2);
    }

}
