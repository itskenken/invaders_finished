import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 */
public class Bullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 50;
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    public static int score = 0;
    public Bullet()
    {
    }
    
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addForce(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
       
        
        else {
            life--;
            move();
            checkHit();
        }
    }
    
    /**
     * Check whether we have hit an asteroid.
     */
    private void checkHit()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        Baddie nme = (Baddie) getOneIntersectingObject(Baddie.class);
        
        if (asteroid != null){
            getWorld().removeObject(this);
            asteroid.hit(damage);
            
        }
        else if(nme != null)
        {
            Explosion ex = new Explosion();
            getWorld().addObject(ex, getX(), getY());
            getWorld().removeObject(nme);
            getWorld().removeObject(this);
            Greenfoot.playSound("Explosion.wav");
            score = score+30;
           
            
        }
    }
    
}