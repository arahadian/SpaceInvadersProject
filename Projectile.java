import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;
/**
Projectile Class
@author Ayman Rahadian
@version 4/4/2018
*/
public class Projectile
{
   /** Width of the app */
   public static final int APP_WIDTH = 1100;
   /** Length of the app */
   public static final int APP_HEIGHT = 800;

   /** x location of the projectile */
   private double myX;
   /** y location of the projectile */
   private double myY;
   
   /** Boolean of the projectile whether it is generated or not */
   private boolean generated;
   
   /** Width of the projectile */
   public static int WIDTH = 5;
   /** Height of the projectile */
   public static int HEIGHT = 17;
   
   /** Timer that moves the projectile */
   private Timer myMovement;
   
   /** Default constructor of the projectile */
   public Projectile()
   {
      myX = 0;
      myY = 0;
      generated = true;
   }
   
   /**
   Constructor of the projectile
   @param x the x location of the projectile
   @param y the y location of the projectile 
   */
   public Projectile(double x, double y)
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
   Draws the projectile
   @param g2 the graphics handler
   */   
   public void drawMe(Graphics2D g2)
   {
      Rectangle2D.Double projectile = new Rectangle2D.Double(myX, myY, WIDTH, HEIGHT);
      g2.setColor(Color.white);
      g2.fill(projectile);
   }
   
   /** Creates the timer to move the aliens */
   public void move()
   { 
      myMovement = new Timer();
      myMovement.schedule(new Updater(), 0, 1);
   }
   
   /**
   Changes the position, cancels the timer, and switches the generated boolean
   to false if the projectile collides with another object
   */
   public void collide()
   {
      myX = APP_WIDTH;
      myY = APP_HEIGHT;
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
            myY = myY - 2;
         }
      }
   }  
}