import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
Class for the Control Screen
@author Ayman Rahadian
@version 6/1/2018
*/
public class ControlScreen extends JPanel
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
   public static final int TITLE_X = 371;
   /** Y-Position of the title */
   public static final int TITLE_Y = 50;
   
   /** X-Position of the spacebar image */
   public static final int SPACEBAR_X = 85;
   /** Y-Position of the spacebar image */
   public static final int SPACEBAR_Y = 100;
   /** X-Position of the spacebar2 image */
   public static final int SPACEBAR2_X = 390;
   /** X-Position of the spacebar2 image */
   public static final int SPACEBAR2_Y = 305;
   /** Y-Position of the spacebar texts */
   public static final int SPACEBART_Y = 450;
   
   /** Y-Position of the arrow images */
   public static final int ARROW_Y = 200;
   /** X-Position of the left arrow image */
   public static final int ARROW_X = 585;
   /** X-Position of the right arrow image */
   public static final int ARROW2_X = 815;
   /** Y-Position of the arrow texts */
   public static final int ARROWT_Y = 450;
   
   /** The GameApp that will run the game */
   private GameApp myApp;
   
   /** The back button */
   private Rectangle2D.Double myBackButton;
   
   /** Image of the background */
   private BufferedImage myBackground;
   
   /** Image of the spacebar */
   private BufferedImage mySpacebar;
   /** Image of the spacebar2 */
   private BufferedImage mySpacebarT;
   /** Image of the spacebar texts */
   private BufferedImage mySpaceText;
   
   /** Image of the left arrow */
   private BufferedImage myLeftArrow;
   /** Image of the right arrow */
   private BufferedImage myRightArrow;
   /** Image of the arrow texts */
   private BufferedImage myArrowText;
   
   /** Image of the back icon */
   private BufferedImage myBack;
   /** Image of the back text */
   private BufferedImage myBackText;
   
   /** Image of the screen title */
   private BufferedImage myControlTitle;
   
   /**
   Consturctor for the Control Screen 
   @param app the game app that will contain the screen
   */
   public ControlScreen(GameApp app)
   {
      myApp = app;
      
      addMouseListener(new MyButtonListener());
            
      try
      {
         InputStream is = getClass().getResourceAsStream("CONTROLS.png");
         InputStream is2 = getClass().getResourceAsStream("backIcon.png");
         InputStream is3 = getClass().getResourceAsStream("back.png");
         InputStream is4 = getClass().getResourceAsStream("background.jpg");
         InputStream is5 = getClass().getResourceAsStream("Spacebar.png");
         InputStream is6 = getClass().getResourceAsStream("spacebarT.png");
         InputStream is7 = getClass().getResourceAsStream("Left Arrow.png");
         InputStream is8 = getClass().getResourceAsStream("Right Arrow.png");
         InputStream is9 = getClass().getResourceAsStream("Control Text S.png");
         InputStream is10 = getClass().getResourceAsStream("Control Text A.png");

         myControlTitle = ImageIO.read(is);
         myBack = ImageIO.read(is2);
         myBackText = ImageIO.read(is3);
         myBackground = ImageIO.read(is4);
         mySpacebar = ImageIO.read(is5);
         mySpacebarT = ImageIO.read(is6);
         myLeftArrow = ImageIO.read(is7);
         myRightArrow = ImageIO.read(is8);
         mySpaceText = ImageIO.read(is9);
         myArrowText = ImageIO.read(is10);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /**
   Paints/Creates the control screen
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      g2.drawImage(myBackground, BACKGROUND_X, BACKGROUND_Y, null);
      
      myBackButton = new Rectangle2D.Double(BACK_X, BACK_Y, BACK_WIDTH, BACK_LENGTH);
         
      g2.drawImage(myControlTitle, TITLE_X, TITLE_Y, null);
       
      g2.drawImage(mySpacebar, SPACEBAR_X, SPACEBAR_Y, null);
      g2.drawImage(mySpacebarT, SPACEBAR2_X, SPACEBAR2_Y, null);
      g2.drawImage(mySpaceText, SPACEBAR_X, SPACEBART_Y, null); 
      
      g2.drawImage(myLeftArrow, ARROW_X, ARROW_Y, null);
      g2.drawImage(myRightArrow, ARROW2_X, ARROW_Y, null);
      g2.drawImage(myArrowText, ARROW_X, ARROWT_Y, null); 
            
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