import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
Barrier Class
@author Ayman Rahadian
@version 4/4/2018
*/
public class Barrier
{
   /** Size of individual barriers */
   public static final int SIZE = 20;
   /** Constant for lives of the barriers */
   public static final int LIVES = 1;
   
   /** X-Position of the barriers */
   private double myX;
   /** Y-Position of the barriers */
   private double myY;
   /** lives of each barrier */
   private int myLives;
   
   /** The GameApp that will run the game */
   private GameApp myApp;
   
   /** Rectangular shape of the blocks*/
   private Rectangle2D.Double block1;
   
   /**
   Constructor of the barrier
   */
   public Barrier()
   {
      myLives = LIVES;  
   }
   
   /** 
   Constructor of the barrier
   @param x x-position of the barrier
   @param y y-position of the barrier
   */
   public Barrier(double x, double y)
   {
      myLives = LIVES;
      
      myX = x;
      myY = y;   
   }
   
   /**
   Gets the x-position of the barrier
   @return myX 
   */
   public double getX()
   {
      return myX;
   }
   
   /**
   Gets the y-position of the barrier
   @return myY 
   */
   public double getY()
   {
      return myY;
   }
   
   /** 
   Return the remaining lives of the barrier 
   @return remianing barrier lives
   */
   public int getLives()
   {
      return myLives;
   }
   
   /**
   Sets a certain int for the lives of the barrier
   @param x the lives of the barrier
   */
   public void setLives(int x)
   {
      myLives = x;
   }
   
   /**
   Subtracts the lives of the barrier by 1
   */
   public void hit()
   {
      myLives = myLives - 1;
   }
   
   /**
   Sets the barrier's lives to 0
   */
   public void destroy()
   {
      myLives = 0;
   }
   
   /**
   Draws the barrier
   @param g2 the graphics handler
   */
   public void drawMe(Graphics2D g2)
   {  
      block1 = new Rectangle2D.Double(myX, myY, SIZE, SIZE);
      g2.setColor(Color.white);
      g2.fill(block1);         
   }
}