import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;
/**
Alien Projectile Class
@author Ayman Rahadian
@version 5/4/2018
*/
public class AlienProj
{
   /** The width of the aliens' projectiles */
   public static int WIDTH = 10;
   /** The height of the aliens' projectiles */
   public static int HEIGHT = 10;
   
   /** Speed for the timer that moves the projectiles */
   public static final int MOVE_SPEED = 5;
   
   /** Width of the game app */
   public static final int APP_WIDTH = 1100;
   /** Length of the game app */
   public static final int APP_LENGTH = 800; 
   /** Distance travelled by the projectile every time the timer is run */
   public static final int MOVEMENT = 3;
   
   /** X-Position of the projectile */
   private double myX;
   /** Y-Position of the projectile */
   private double myY;
   
   /** Indicates whther or not the projectile has been generated */
   private boolean generated;
   /** The timer that allows the projectile to move */
   private Timer myMovement;
   
   /**
   Constructor for the alien projectile 
   */
   public AlienProj()
   {
      myX = 0;
      myY = 0;
      generated = true;
   }
   
   /**
   Constructor for the alien projectile 
   @param x x-position of the projectile
   @param y y-position of the projectile
   */
   public AlienProj(double x, double y)
   {
      myX = x;
      myY = y;
      generated = true;
   }
   
   /**
   Gets the x-position of the projectile
   @return myX
   */
   public double getX()
   {
      return myX;
   }
   
   /**
   Gets the y-position of the projectile
   @return myY
   */
   public double getY()
   {
      return myY;
   }
   
   /**
   Indicates if the projectile has been generated
   @return generated 
   */
   public boolean isGenerated()
   {
      return generated;
   }
   
   /**
   Draws the alien projectiles
   @param g2 the graphics handler
   */   
   public void drawMe(Graphics2D g2)
   {
      Ellipse2D.Double alienProjectile = new Ellipse2D.Double(myX, myY, WIDTH, HEIGHT);
      g2.setColor(Color.green);
      g2.fill(alienProjectile);
   }
   
   /** Creates the timer to move the aliens */
   public void move()
   { 
      myMovement = new Timer();
      myMovement.schedule(new Updater(), 0, MOVE_SPEED);
   }
   
   /**
   Changes the position, cancels the timer, and switches the generated boolean
   to false if the projectile collides with another object
   */
   public void collide()
   {
      myX = APP_WIDTH;
      myY = APP_LENGTH;
      myMovement.cancel();
      generated = false;
   }
   
   /** TimerTask class to move the projectiles */
   private class Updater extends TimerTask
   {
      /** Runs the TimerTask which will move the projectiles */
      public void run()
      {
         if(myY < 0 - HEIGHT)
         {
            generated = false;
            myMovement.cancel();
         }
         else
         {
            myY = myY + MOVEMENT;
         }
      }
   }
}