import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class net here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class net extends Actor
{
    /**
     * Act - do whatever the net wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + Greenfoot.getRandomNumber(21) - 10 , getY()+1);
        if( getY() > getWorld().getHeight() - 20)
            getWorld().removeObject(this);
    }

    public void setSpeed(int s)
    {
        int speed = s;
    }
}
