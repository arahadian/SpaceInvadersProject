/**
GameChars Class, Parent class for
the game characters (Aliens and Spaceship)
@author Ayman Rahadian
@version 4/4/2018
*/
public class GameChars
{
   /** Distance moved by the character */
   private static final int SPEED = 40;
   /** Maximum x-position for the character */
   private static final int X_MAX = 950;
   /** Minimum x-position for the character */
   private static final int X_MIN = 50;
   /** Distance moved downwads by the character */
   private static final int D_MOVE = 50;
   
   /** X-Position of the character */
   private double myX;
   /** Y-Position of the character */
   private double myY;

   /** 
   Indicates whether the character is at the
      edge of the screen
   */
   private boolean atEdge;
   
   /** Constructor for the game character */   
   public GameChars()
   {
      myX = 0;
      myY = 0;
   
   }
   
   /** 
   Constructor for the game character
   @param x x-position of the character
   @param y y-position of the character 
   */   
   public GameChars(double x, double y)
   {
      myX = x;
      myY = y;
   }
   
   /**
   Gets the x-position of the character
   @return myX
   */
   public double getX()
   {
      return myX;
   }
   
   /**
   Gets the y-position of the character
   @return myY
   */
   public double getY()
   {
      return myY;
   }
   
   /**
   Sets the x-position of the character
   @param x new x-position
   */
   public void setX(double x)
   {
      myX = x;
   }
   
   /**
   Sets the y-position of the character
   @param y new y-position
   */
   public void setY(double y)
   {
      myY = y;
   }
   
   /**
   Moves the character to the right
   */
   public void moveR()
   {
      if(myX < X_MAX)
      {
         myX = myX + SPEED;
      }
   }
   
   /**
   Moves the character to the left
   */
   public void moveL()
   {
      if(myX > X_MIN)
      {
         myX = myX - SPEED;
      }
   }
   
   /**
   Moves the character up
   */
   public void moveU()
   {
      myY = myY - SPEED;
   }
   
   /**
   Moves the character down
   */
   public void moveD()
   {
      myY = myY + D_MOVE;
   }
   
   /**
   Moves the character to the left (for Aliens)
   */
   public void left()
   {
      myX = myX - 1;
   }
   
   /**
   Moves the character to the right (for Aliens)
   */
   public void right()
   {
      myX = myX + 1;
   }
}