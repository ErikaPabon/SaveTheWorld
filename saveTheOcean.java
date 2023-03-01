import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class saveTheOcean here.
 * 
 * @author (ErikaPabon) 
 * @version (a version number or a date)
 */
public class saveTheOcean extends World
{

    /**
     * Constructor for objects of class saveTheOcean.
     * 
     */
    public saveTheOcean()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 440, 1); 
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Ocean());
        }
    }
}
