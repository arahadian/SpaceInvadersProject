import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
Class for the Lose Screen
@author Ayman Rahadian
@version 6/1/2018
*/
public class LoseScreen extends JPanel
{
   /** x-position of the lose title */
   public static final int LOSE_X = 321;
   /** y-position of the lose title */
   public static final int LOSE_Y = 335;
   
   /** x-position of the replay icon */
   public static final int REPLAY_X = 470;
   /** y-position of the replay icon */
   public static final int REPLAY_Y = 425; 
   /** width of the replay button */
   public static final int REPLAY_WIDTH = 160;
   /** length of the replay button */
   public static final int REPLAY_LENGTH = 50;
   /** x-position of the replay text */
   public static final int REPLAY_X2 = 525;
   /** y-position of the replay text */
   public static final int REPLAY_Y2 = 434;
   
   /** x-position of the menu icon */
   public static final int MENU_X = 448;
   /** y-position of the menu icon */
   public static final int MENU_Y = 495;
   /** width of the menu button */
   public static final int MENU_WIDTH = 203;
   /** width of the menu button */
   public static final int MENU_LENGTH = 50;
   /** x-position of the menu text */
   public static final int MENU_X2 = 503;
   /** y-position of the menu text */
   public static final int MENU_Y2 = 504;
   
   /** The GameApp that will run the game */
   private GameApp myApp;
   
   /** Background of the screen */
   private Rectangle2D.Double myBackground;
   
   /** The replay button */
   private Rectangle2D.Double myReplayButton;
   /** The title button */
   private Rectangle2D.Double myTitleButton;
   
   /** Image of the lose title */
   private BufferedImage myImage;
   /** Image of the replay icon */
   private BufferedImage myReplayIcon;
   /** Image of the replay text */
   private BufferedImage myReplayText;
   /** Image of the title icon */
   private BufferedImage myTitleIcon;
   /** Image of the title text */
   private BufferedImage myTitleText;
   
   /**
   Contructor for the Lose Screen
   @param app the game app that contains the screen
   */
   public LoseScreen(GameApp app)
   {
      myApp = app;
      
      addMouseListener(new MyButtonListener());
      
      try
      {
         InputStream is = getClass().getResourceAsStream("lose.png");
         InputStream is2 = getClass().getResourceAsStream("replayIcon.png");
         InputStream is3 = getClass().getResourceAsStream("reText.png");
         InputStream is4 = getClass().getResourceAsStream("titleIcon.png");
         InputStream is5 = getClass().getResourceAsStream("tText.png");
         
         myImage = ImageIO.read(is);
         myReplayIcon = ImageIO.read(is2);
         myReplayText = ImageIO.read(is3);
         myTitleIcon = ImageIO.read(is4);
         myTitleText = ImageIO.read(is5);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /**
   Paints/Creates the lose screen
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      myBackground = new Rectangle2D.Double(0, 0, myApp.APP_WIDTH, myApp.APP_HEIGHT); 
      g2.fill(myBackground);

      g2.drawImage(myImage, LOSE_X, LOSE_Y, null);
      
      myReplayButton = new Rectangle2D.Double(REPLAY_X, REPLAY_Y, REPLAY_WIDTH, REPLAY_LENGTH);
      myTitleButton = new Rectangle2D.Double(MENU_X, MENU_Y, MENU_WIDTH, MENU_LENGTH);
         
      g2.drawImage(myReplayIcon, REPLAY_X, REPLAY_Y, null);
      g2.drawImage(myReplayText, REPLAY_X2, REPLAY_Y2, null);
      g2.drawImage(myTitleIcon, MENU_X, MENU_Y, null);
      g2.drawImage(myTitleText, MENU_X2, MENU_Y2, null);   
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
         
         if(myReplayButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("char");
         }
         else if(myTitleButton.contains(mouseX, mouseY))
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
      public void mouseEntered(MouseEvent e) { }
      
      /**
      Events when mouse exits
      @param e mouse event
      */
      public void mouseExited(MouseEvent e) { }
   }
}
