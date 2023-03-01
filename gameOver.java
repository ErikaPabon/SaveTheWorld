import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World
{
    public static GreenfootSound bkgMusic;
    /**
     * Constructor for objects of class gameOver.
     * 
     */
    public gameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        bkgMusic = new GreenfootSound("Badger.mp3");
        bkgMusic.playLoop();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            bkgMusic.stop();
            Greenfoot.setWorld(new Ocean());
        }
    }
}