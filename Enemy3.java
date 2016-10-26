import greenfoot.*;

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Baddie
{
    /**
     * Act - do whatever the Enemy3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(exactX >= getWorld().getWidth()) {
            exactX = 0;
        }
        if(exactX < 0) {
            exactX = getWorld().getWidth() - 1;
        }
        if(exactY >= getWorld().getHeight()) {
            exactY = 0;
        }
        if(exactY < 0) {
            exactY = getWorld().getHeight() - 1;
        }
        super.setLocation((int) exactX, (int) exactY);
        reform();
        // Add your action code here.
    }    
}
