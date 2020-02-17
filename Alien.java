import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;
/**
Alien Class
@author Ayman Rahadian
@version 4/4/2018
*/
public class Alien extends GameChars
{
   /** Speed for the timer that moves the aliens */
   private static final int MOVE_SPEED = 12;
   /** Speed for the timer that changes the sprite of the aliens */
   private static final int CHANGE_TIME = 500;
   /** The minimum x-position the aliens can go to */
   private static final int EDGE_L = 50;
   /** The maximum x-position the aliens can go to */
   private static final int EDGE_R = 1000;
   
   /** The GameApp that will run the game */
   private GameApp myApp;
   /** The GamePanel that will contain the aliens */
   private GamePanel myPanel;

   /** The lives for the aliens */
   private int myLives;
   
   /** The timer that allows the aliens to move */   
   private Timer myMovement;
   /** The timer that allows the aliens to change between sprites */   
   private Timer myChangePic;
   
   /** Indicates when aliens needs to switch sprites */
   private boolean changePic;
   /** Indicates when aliens are at the edge and needs to move down */
   private boolean atEdge;
   
   /** First aliens sprite*/
   private BufferedImage myImage;
   /** Second aliens sprite*/
   private BufferedImage myImage2;
   
   /** 
   Constructor for the aliens 
   @param x X-position of the alien
   @param y Y-position of the alien
   */   
   public Alien(double x, double y)
   {
      super(x, y);
      
      myLives = 1;
      
      atEdge = false;
      changePic = false;
      
      change();
            
      try
      {
         InputStream is = getClass().getResourceAsStream("Alien.png");
         InputStream is2 = getClass().getResourceAsStream("Alien(2).png");
         
         myImage = ImageIO.read(is);
         myImage2 = ImageIO.read(is2);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /** 
   Constructor for the aliens in the Game Panel
   @param x X-position of the alien
   @param y Y-position of the alien
   @param app the App that will run the game
   @param panel the game panel that will contain the aliens
   */
   public Alien(double x, double y, GameApp app, GamePanel panel)
   {
      super(x, y);
        
      myLives = 1;
      
      myApp = app;
      myPanel = panel;
      atEdge = false;
      changePic = false;
      
      move();
      change();
            
      try
      {
         InputStream is = getClass().getResourceAsStream("Alien.png");
         InputStream is2 = getClass().getResourceAsStream("Alien(2).png");
         
         myImage = ImageIO.read(is);
         myImage2 = ImageIO.read(is2);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /** 
   Return the remaining lives of the aliens 
   @return remianing aliens lives
   */
   public int getLives()
   {
      return myLives;
   }   
   
   /** Subtracts the lives of the aliens by one */
   public void hit()
   {
      myLives = myLives - 1;
   }
   
   /** 
   Returns the timer that allows the aliens to move
   @return the movement timer
   */
   public Timer getTimer1()
   {
      return myMovement;
   }

   /** 
   Returns the timer that allows the aliens to change sprites
   @return the movement timer
   */
   public Timer getTimer3()
   {
      return myChangePic;
   }
   
   /** Creates the timer to move the aliens */
   public void move()
   { 
      int numWave = myPanel.getWaveNum();
      int speed = (int)(MOVE_SPEED / numWave);
      
      myMovement = new Timer();
      myMovement.schedule(new Updater(), 0, speed);
   }
   
   /** Creates the timer to change the sprite of the aliens */
   public void change()
   {
      myChangePic = new Timer();
      myChangePic.schedule(new PicUpdater(), 0, CHANGE_TIME);   
   }
   
   /** TimerTask class to move the aliens */
   private class Updater extends TimerTask
   {
      /** Runs the TimerTask which will move the aliens */
      public void run()
      {
         if(!myApp.isPaused())
         {
            if(getX() < EDGE_L)
            {
               moveD();
               atEdge = true;
            }
            else if(getX() > EDGE_R)
            {
               moveD();
               atEdge = false;
            }
            
            if(atEdge == true)
            {
               right();
            }
            else
            {
               left();
            }
         }
      }
   }
   
   /** TimerTask class to change the sprite of the aliens */
   private class PicUpdater extends TimerTask
   {
      /** Runs the TimerTask which will change the sprites of the aliens */
      public void run()
      {
         if(changePic == true)
         {
            changePic = false;
         }
         else
         {
            changePic = true;
         }
      }
   }

   /** 
   Draws the aliens
   @param g2 the graphics handler
   */
   public void drawMe(Graphics2D g2)
   {
      double topX = getX();
      double topY = getY();
      
      if(changePic == false)
      {
         g2.drawImage(myImage, (int)topX, (int)topY, null);
      }
      else
      {
         g2.drawImage(myImage2, (int)topX, (int)topY, null);   
      }
   }
}
