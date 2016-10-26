import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Baddie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baddie extends SmoothMover
{
    
    {
        
        
        //adjust their size, the image is a bit big...
        GreenfootImage myimage = getImage();
        int h = myimage.getHeight();
        int w = myimage.getWidth();
        myimage.scale(w*3/5, h*3/5);
        setImage(myimage);
  
    }
    
    
    /**
     * Act - do whatever the Baddie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        moveRight();
        move();
        
    } 
    public void hit() 
    {
        
        Greenfoot.playSound("Explosion.wav");
    }    
    public void move()
        {
            super.move();
            
    
          //fix the move method here
          //add more sophisticated motion;
          
          
            
        }
        public void descend()
    {
        int a = 1;
        int b = 2;
         List<Baddie> enemies = getWorld().getObjects(Baddie.class);
        setLocation(getX()-a, getY()+b);
       
    }

    public void reform()
    {
        descend(); 
    }
    
    
    
    }

