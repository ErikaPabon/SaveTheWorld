import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ocean here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ocean extends World
{
    private SimpleTimer timer = new SimpleTimer();
    public static GreenfootSound bkgMusic;
    public static Counter score;
    private int netSpawnRate = 20;
    private int netSpeed = 1;
    private int nextLevel = 10;
    /**
     * Constructor for objects of class Ocean.
     * 
     */
    public Ocean()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 340, 1); 
        score = new Counter("Score: ");
        addObject(score, 70, 20);
        bkgMusic = new GreenfootSound("caper.mp3");
        prepare();
        timer.mark();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void increaseLevel() {
        if(score.getValue() > nextLevel) {
            netSpawnRate += 2;
            netSpeed++;
            nextLevel += 10;
        }
    }

    private void prepare()
    {
        diver diver = new diver();
        addObject(diver,475,78);
        tankhealth tankhealth = new tankhealth();
        addObject(tankhealth,43,37);
        trash trash = new trash();
        addObject(trash,122,210);
        trash.setLocation(133,222);
        diver.setLocation(93,154);
        tankhealth.setLocation(558,33);
        removeObject(trash);
    }

    public void act()
    {
        if(getObjects(animals.class).isEmpty()&&Greenfoot.getRandomNumber(220)==0)
        {
            int x = Greenfoot.getRandomNumber(getWidth()-132)+21;
            int y = Greenfoot.getRandomNumber(getHeight()-42)+16;
            addObject(new animals(),x, y);
        }
        if(getObjects(trash.class).isEmpty()&&Greenfoot.getRandomNumber(80)==0)
        {
            int x = Greenfoot.getRandomNumber(getWidth()-42)+21;
            int y = Greenfoot.getRandomNumber(getHeight()-132)+16;
            addObject(new trash(),x, y);
            score.setValue(score.getValue()+1);
        }
        if(getObjects(tankhealth.class).isEmpty()&&Greenfoot.getRandomNumber(220)==0)
        {
            int x = Greenfoot.getRandomNumber(getWidth()-42)+21;
            int y = Greenfoot.getRandomNumber(getHeight()-132)+16;
            addObject(new tankhealth(),x, y);
        }
        if(Greenfoot.getRandomNumber(10000) < netSpawnRate)
        {
            net e = new net();
            e.setSpeed(netSpeed);
            addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) +10, -30);
            score.setValue(score.getValue()+1);
        }
        increaseLevel();
        if (timer.millisElapsed() > 70000)
        {
            net b = new net();
            addObject(b, Greenfoot.getRandomNumber(getWidth()-20)+10, -30);
            timer.mark();
        }
        bkgMusic.playLoop();
        showText("Level: " +(nextLevel/10),540, 20);
    }
}