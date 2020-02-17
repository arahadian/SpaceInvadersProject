import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
Spaceship Class
@author Ayman Rahadian
@version 4/4/2018
*/
public class Spaceship extends GameChars
{
   /** Constant starting lives of the spaceship*/
   public static final int LIVES = 3;
   /** Size of the spaceship*/
   public static final int SIZE = 76;

   /** lives of the spaceship */
   private int myLives;
   
   /** Image of spaceship 1 */
   private BufferedImage ship1;
   /** Image of spaceship 2 */
   private BufferedImage ship2;
   /** Image of spaceship 3 */
   private BufferedImage ship3;
   
   /** The GameApp that will run the game */
   private GameApp myApp;
   /** Character Screen that allows users to choose their spaceship */
   private CharacterScreen myChar;
   
   /** 
   Default constructor of the spaceship
   */
   public Spaceship()
   {
      super();
      
      myLives = LIVES;
      
   }
   
   /**
   constructor of the spaceship
   @param x x position of the spaceship
   @param y y position of the spaceship
   @param app the game app that runs the game 
   */
   public Spaceship(double x, double y, GameApp app)
   {
      super(x, y);
   
      myLives = LIVES;
   
      myApp = app;
            
      try
      {
         InputStream is = getClass().getResourceAsStream("Spaceship(1).png");
         InputStream is2 = getClass().getResourceAsStream("Spaceship(2).png");
         InputStream is3 = getClass().getResourceAsStream("Spaceship(3).png");
         
         ship1 = ImageIO.read(is);
         ship2 = ImageIO.read(is2);
         ship3 = ImageIO.read(is3);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /** 
   Return the remaining lives of the spaceship 
   @return remianing spaceship lives
   */
   public int getLives()
   {
      return myLives;
   }
   
   /**
   Sets a certain int for the lives of the spaceship
   @param x the lives of the spaceship
   */
   public void setLives(int x)
   {
      myLives = x;
   }
   
   /**
   Subtracts the spaceship's lives by 1
   */
   public void hit()
   {
      myLives = myLives - 1;
      System.out.println(myLives);
   }
   
   /**
   constructor of the spaceship
   @param x x position of the spaceship
   @param y y position of the spaceship
   @param app the game app that runs the game 
   @param charS contains the characters of the spaceship
   */
   public Spaceship(double x, double y, GameApp app, CharacterScreen charS)
   {
      super(x, y);
      
      myApp = app;
      myChar = charS;
      
      myLives = LIVES;
            
      try
      {
         InputStream is = getClass().getResourceAsStream("Spaceship(1).png");
         InputStream is2 = getClass().getResourceAsStream("Spaceship(2).png");
         InputStream is3 = getClass().getResourceAsStream("Spaceship(3).png");
         
         ship1 = ImageIO.read(is);
         ship2 = ImageIO.read(is2);
         ship3 = ImageIO.read(is3);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /**
   Draws the spaceship
   @param g2 the graphics handler
   */
   public void drawMe(Graphics2D g2)
   {
      double topX = getX();
      double topY = getY();
      
      if(myChar != null)
      {
         if(myChar.getChoice() == "one")
         {
            g2.drawImage(ship1, (int)topX, (int)topY, null);
         }
         else if(myChar.getChoice() == "two")
         {
            g2.drawImage(ship2, (int)topX, (int)topY, null);   
         }
         else if(myChar.getChoice() == "three")
         {
            g2.drawImage(ship3, (int)topX, (int)topY, null);   
         }
      }     
   }
}