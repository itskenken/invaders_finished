import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.util.List;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{
     
      List<Baddie> nme = getObjects(Baddie.class);
    private Counter scoreCounter;
    
    private boolean dead;
    private GreenfootImage[] explosion; //This array contains explosion information. Namely the animation frames
    GreenfootSound bgm = new GreenfootSound("nsp.mp3");
    public static int score = 0;
    GreenfootSound BackgroundMusic = new GreenfootSound("nsp.mp3");

    public Space() 
    {
        super(600, 500, 1);
        
        dead = false;
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        //
        
        explosion = new GreenfootImage[13];
        for (int i = 0; i < 13; i++)
        {
            explosion[i] = new GreenfootImage("explode" + i + ".gif");
        }
        
        
        Rocket rocket = new Rocket();
        addObject(rocket, 90,480);
        
        spawnBaddies();
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 380);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        
    
        
        
        
    }
           
            
    
    
    public void act()
    {
        Started();
        List<Baddie> enemies = getObjects(Baddie.class);
        
               if(enemies.size()==1) {
            
            for(int i=0; i<8; i++){
                addObject(new Enemy3(), (20 + 70 * i), 50);
            }
            
            for (int i=0; i<7; i++){
                addObject(new Enemy3(), (45 + 70 * i), 90);
            }
            
        
    }
    //Greenfoot.playSound("nsp.mp3");
}
public void Started()
{BackgroundMusic.play();
}

    public void spawnBaddies(){
        
        for(int i = 0; i<10; i++)
        {
            Baddie nme = new Enemy1();
            addObject(nme, 55+(i*50), 100    );
        }
        for (int i = 0; i<8; i++)
        {
            Baddie nme = new Enemy2();
            addObject(nme, 80+(i*50), 140);
        }
        for(int i = 0; i<6; i++)
        {
            Baddie nme = new Enemy2();
            addObject(nme, 60+(i*80), 60);
        }
    }
  
   
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
         // TODO: show the score board here. Currently missing.
     }
      public GreenfootImage[] getExplosion(){return explosion;}
   
   }