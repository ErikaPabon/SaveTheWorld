import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animals wonder around
 * 
 * @author (ErikaPabon) 
 * @version (1.1)
 */
public class animals extends Actor
{
    /**
     * Act - do whatever the animals wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()+1, getY());// Add your action code here.
        if( getX() > getWorld().getWidth() - 20)
            getWorld().removeObject(this);
    }    
}
