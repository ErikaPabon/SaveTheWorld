import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class trash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class trash extends Actor
{
    /**
     * Act - do whatever the trash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+1);
        if( getY() > getWorld().getHeight() - 20)
            getWorld().removeObject(this);
    }    
}
