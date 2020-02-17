import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
/**
Class for the How to Play Screen
@author Ayman Rahadian
@version 6/1/2018
*/
public class HowToScreen extends JPanel
{
   /** X-Position of the background */
   public static final int BACKGROUND_X = -410;
   /** Y-Position of the background */
   public static final int BACKGROUND_Y = -280;   
  
   /** X-Position of the back button */
   public static final int BACK_X = 20;
   /** Y-Position of the back button */
   public static final int BACK_Y = 680;
   /** Width of the back button */
   public static final int BACK_WIDTH = 286;
   /** Length of the back button */ 
   public static final int BACK_LENGTH = 76;
   /** X-Position of the back text */
   public static final int BACKT_X = 110;
   /** Y-Position of the back text */
   public static final int BACKT_Y = 696;
   
   /** X-Position of the title */
   public static final int TITLE_X = 322;
   /** Y-Position of the title */
   public static final int TITLE_Y = 50;
   /** X-Position of the text */
   public static final int TEXT_X = 50; 
   /** Y-Position of the text */
   public static final int TEXT_Y = 150;
   
   /** The GameApp that will run the game */
   private GameApp myApp;
   
   /** The back button */
   private Rectangle2D.Double myBackButton;
   
   /** Image of the background */
   private BufferedImage myBackground;
   
   /** Image of the back icon */
   private BufferedImage myBack;
   /** Image of the back text */
   private BufferedImage myBackText;

   /** Image of the title of the How to Screen */
   private BufferedImage myImage1;
   /** Image of the text of the How to Screen */
   private BufferedImage myHowText;
   
   /**
   Constructor of the How to Play Screen
   @param app the game app that will contain the screen
   */
   public HowToScreen(GameApp app)
   {
      myApp = app;
      
      addMouseListener(new MyButtonListener());
            
      try
      {
         InputStream is = getClass().getResourceAsStream("HOW.png");
         InputStream is2 = getClass().getResourceAsStream("backIcon.png");
         InputStream is3 = getClass().getResourceAsStream("back.png");
         InputStream is4 = getClass().getResourceAsStream("background.jpg");
         InputStream is5 = getClass().getResourceAsStream("HowTo Text.png");
      
         myImage1 = ImageIO.read(is);
         myBack = ImageIO.read(is2);
         myBackText = ImageIO.read(is3);
         myBackground = ImageIO.read(is4);
         myHowText = ImageIO.read(is5);
      }
      catch(IOException ioe)
      {
      }
   }
   
   /**
   Paints/Creates the How to Play screen
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      g2.drawImage(myBackground, BACKGROUND_X, BACKGROUND_Y, null);
            
      myBackButton = new Rectangle2D.Double(BACK_X, BACK_Y, BACK_WIDTH, 
         BACK_LENGTH);
         
      g2.drawImage(myImage1, TITLE_X, TITLE_Y, null);
      g2.drawImage(myHowText, TEXT_X, TEXT_Y, null);
   
      g2.drawImage(myBack, BACK_X, BACK_Y, null);
      g2.drawImage(myBackText, BACKT_X, BACKT_Y, null);
   }
   
   /** Inner class for mouse activities */
   private class MyButtonListener implements MouseListener
   {
      /**
      Events when mouse is pressed
      @param e mouse event
      */
      public void mousePressed(MouseEvent e)
      {
         int mouseX = e.getX();
         int mouseY = e.getY();
        
         if(myBackButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("title");
         }
      }
      
      /**
      Events when mouse is released
      @param e mouse event
      */
      public void mouseReleased(MouseEvent e) { }
      
      /**
      Events when mouse is clicked
      @param e mouse event
      */
      public void mouseClicked(MouseEvent e) { }
      
      /**
      Events when mouse enters
      @param e mouse event
      */
      public void mouseEntered(MouseEvent e) 
      {
      }
      
      /**
      Events when mouse exits
      @param e mouse event
      */
      public void mouseExited(MouseEvent e) 
      {
      }
   }
}