
import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * 
 * @version 1.0
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 15;         // The minimum delay between firing the gun.

    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
    {
        
        
        //adjust their size, the image is a bit big...
        GreenfootImage myimage = getImage();
        int h = myimage.getHeight();
        int w = myimage.getWidth();
        myimage.scale(w*1/5, h*1/5);
        setImage(myimage);
  
    }

    /**
     * Initilise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        dead();
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
     
        if (Greenfoot.isKeyDown("right"))
        {
            moveRight();
        }
        if (Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getMovement().copy(), 270);
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
    private void dead()
    {
        Space w = (Space)getWorld();
        Baddie nme = (Baddie) getOneIntersectingObject(Baddie.class);
        
        if (nme != null)
        {
            ScoreBoard score = new ScoreBoard();
             Explosion ex = new Explosion();
            getWorld().addObject(ex, getX(), getY());
            Greenfoot.playSound("Explosion.wav");
            getWorld().addObject(score, 300, 300);
            getWorld().removeObject(this);
            w.gameOver();
            
            Greenfoot.stop();
        }
    }
}