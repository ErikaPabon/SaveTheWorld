import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class diver extends Actor
{
    final int MIN_HEALTH=0, MAX_HEALTH=150;
    HealthDisplay tankDisplay;
    int health = 150;

    private GifImage img = new GifImage("diver2.gif");

    protected void addedToWorld(World Ocean)
    {
        Ocean.setPaintOrder(diver.HealthDisplay.class);
        if(tankDisplay==null)
        {
            tankDisplay = new HealthDisplay();
        }
        Ocean.addObject(tankDisplay, 0, 0);
        tankDisplay.act();
        tankDisplay.adjustHealth(0);

    }

    /**
     * Act - do whatever the diver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(img.getCurrentImage());// Add your action code here.
        followMouse();
    } 

    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        int ds = 0;
        if(mi != null)
        {
            setLocation(mi.getX(), mi.getY());
            ds++;
        }
        if(ds != 0 && Greenfoot.getRandomNumber(3)==0) tankDisplay.adjustHealth(-1);
        if(isTouching(tankhealth.class))
        {
            removeTouching(tankhealth.class);
            tankDisplay.adjustHealth(100);
        }
        if (health == 0) {
            Ocean.bkgMusic.stop();
            Greenfoot.setWorld(new gameOver());
            getWorld().removeObject(this);
        }
        else checkForCollisions();
    }
    public void checkForCollisions()
    {
        Actor trash;
        trash = getOneIntersectingObject(trash.class);
        if (trash != null)
        {
            World Ocean;
            Ocean = getWorld();
            Ocean.removeObject(trash);
        }
        Actor net = getOneIntersectingObject(net.class);
        if(net != null)
        {
            //ends the game
            Ocean.bkgMusic.stop();
            Greenfoot.setWorld(new gameOver());
            getWorld().removeObject(this);
        }
        
    }
    
    private class HealthDisplay extends Actor
    {
        public void act()
        {
            if(diver.this.getWorld()==null)getWorld().removeObject(this);
            else setLocation(diver.this.getX(),diver.this.getY()-50);
        }

        public void adjustHealth(int amt)
        {
            health += amt;
            if(health > MAX_HEALTH) health = MAX_HEALTH;
            if(health < MIN_HEALTH) health = MIN_HEALTH;
            GreenfootImage img = new GreenfootImage(""+health, 24, Color.BLACK, Color.WHITE);
            setImage(img);
        }
    }
}