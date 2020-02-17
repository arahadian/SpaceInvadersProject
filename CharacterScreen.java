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
Class for the Character Screen for users
to choose their character
@author Ayman Rahadian
@version 6/1/2018
*/
public class CharacterScreen extends JPanel
{
   /** Size for the character buttons */
   public static final int SIZE = 250;
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
   public static final int TITLE_X = 280;
   /** Y-Position of the title */
   public static final int TITLE_Y = 70;
   
   /** Y-Position of the icons */
   public static final int ICON_Y = 255;
   /** X-Position of icon 1 */
   public static final int ICON1_X = 100;
   /** X-Position of icon 2 */
   public static final int ICON2_X = 425;
   /** X-Position of icon 3 */
   public static final int ICON3_X = 750;
   /** Gap in between the icons */
   public static final int GAP = 25;

   /** The GameApp that will run the game */
   private GameApp myApp;
   /** Indicates the choice the user made */
   private String myShipChoice;
      
   /** The back button */
   private Rectangle2D.Double myBackButton;
   
   /** Image of the background */
   private BufferedImage myBackground;
   
   /** Image of the back icon */
   private BufferedImage myBack;
   /** Image of the back text */
   private BufferedImage myBackText;

   /** Image of the screen title */
   private BufferedImage myTitle;
   
   /** Image of the first ship icon */
   private BufferedImage shipIcon1;
   /** Image of the second ship icon */
   private BufferedImage shipIcon2;
   /** Image of the third ship icon */
   private BufferedImage shipIcon3;
   
   /** Button to select icon 1 */
   private Rectangle2D.Double ship1;
   /** Button to select icon 2 */
   private Rectangle2D.Double ship2;
   /** Button to select icon 3 */
   private Rectangle2D.Double ship3;
   
   /**
   Constructor for the character screen
   @param app the game app that will contain the screen
   */
   public CharacterScreen(GameApp app)
   {
      myApp = app;
            
      addMouseListener(new MyButtonListener());
            
      try
      {
         InputStream is = getClass().getResourceAsStream("choose.png");
         InputStream is2 = getClass().getResourceAsStream("icon1.png");
         InputStream is3 = getClass().getResourceAsStream("icon2.png");
         InputStream is4 = getClass().getResourceAsStream("icon3.png");
         InputStream is5 = getClass().getResourceAsStream("backIcon.png");
         InputStream is6 = getClass().getResourceAsStream("back.png");
         InputStream is7 = getClass().getResourceAsStream("background.jpg");
      
         myTitle = ImageIO.read(is);
         shipIcon1 = ImageIO.read(is2);
         shipIcon2 = ImageIO.read(is3);
         shipIcon3 = ImageIO.read(is4);
         myBack = ImageIO.read(is5);
         myBackText = ImageIO.read(is6);
         myBackground = ImageIO.read(is7);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /**
   Gets the character choice the user made
   @return the string containing which icon
   */
   public String getChoice()
   {
      return myShipChoice;
   }
   
   /**
   Paints/Creates the character screen
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      g2.drawImage(myBackground, BACKGROUND_X, BACKGROUND_Y, null);
      
      myBackButton = new Rectangle2D.Double(BACK_X, BACK_Y, BACK_WIDTH, 
         BACK_LENGTH);

      g2.setColor(Color.white);
      ship1 = new Rectangle2D.Double(ICON1_X, ICON_Y, SIZE, SIZE);
      g2.draw(ship1);
      
      g2.setColor(Color.white);
      ship2 = new Rectangle2D.Double(ICON2_X, ICON_Y, SIZE, SIZE);
      g2.draw(ship2);
      
      g2.setColor(Color.white);
      ship3 = new Rectangle2D.Double(ICON3_X, ICON_Y, SIZE, SIZE);
      g2.draw(ship3);
   
      g2.drawImage(myTitle, TITLE_X, TITLE_Y, null);
      
      g2.drawImage(shipIcon1, ICON1_X + GAP, ICON_Y + GAP, null);
      g2.drawImage(shipIcon2, ICON2_X + GAP, ICON_Y + GAP, null);
      g2.drawImage(shipIcon3, ICON3_X + GAP, ICON_Y + GAP, null); 
      
      g2.drawImage(myBack, BACK_X, BACK_Y, null);
      g2.drawImage(myBackText, BACKT_X, BACKT_Y, null);
   }
   
   /**
   Inner class for mouse activities
   */
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
         
         if(ship1.contains(mouseX, mouseY))
         {
            myShipChoice = "one";
            myApp.switchScreen("game");
         }
         else if(ship2.contains(mouseX, mouseY))
         {
            myShipChoice = "two";
            myApp.switchScreen("game");
         }
         else if(ship3.contains(mouseX, mouseY))
         {
            myShipChoice = "three";
            myApp.switchScreen("game");
         }
         else if(myBackButton.contains(mouseX, mouseY))
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