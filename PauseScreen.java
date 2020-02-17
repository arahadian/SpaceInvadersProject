import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
Class for the Pause Screen
@author Ayman Rahadian
@version 6/1/2018
*/
public class PauseScreen extends JPanel
{
   /** x-location of the pause tab */
   public static final int PAUSE_TABX = 300;
   /** y-location of the pause tab */ 
   public static final int PAUSE_TABY = 150;
   /** x-location of the pause title */
   public static final int PAUSE_TITX = 475;
   /** y-location of the pause title */
   public static final int PAUSE_TITY = 301; 
   
   /** x-location of the resume icon */
   public static final int RESUME_X = 468;
   /** y-location of the resume icon */
   public static final int RESUME_Y = 370;
   /** x-location of the resume text */
   public static final int RESUME_X2 = 528;
   /** y-location of the resume text */
   public static final int RESUME_Y2 = 382; 
   
   /** x-location of the menu icon */
   public static final int MENU_X = 446;
   /** y-location of the menu icon */
   public static final int MENU_Y = 440;
   /** x-location of the menu text */
   public static final int MENU_X2 = 506;
   /** y-location of the menu text */
   public static final int MENU_Y2 = 449;
   
   /** width of the resume button */
   public static final int RES_WIDTH = 164;
   /** width of the menu button */
   public static final int MENU_WIDTH = 208;
   /** length of the button */ 
   public static final int BUTTON_LENGTH = 50;
   
   /** The GameApp that will run the game */ 
   private GameApp myApp;
   /** The game panel that contains the game */
   private GamePanel myGamePanel;
   
   /** Background of the screen */
   private Rectangle2D.Double myBackground;
   
   /** Resume button */
   private Rectangle2D.Double myResumeButton;
   /** Menu button */
   private Rectangle2D.Double myMenuButton;
   
   /** Image of the pause title */
   private BufferedImage myPauseTitle;
   /** Image of the resume icon */
   private BufferedImage myResumeIcon;
   /** Image of the resume text */
   private BufferedImage myResumeText;
   /** Image of the menu icon */
   private BufferedImage myMenuIcon;
   /** Image of the menu text */
   private BufferedImage myMenuText;
   /** Image of the pause tab */
   private BufferedImage myPauseTab;
   
   /**
   Constructor for the pause screen
   @param app the game app that will contain the screen
   @param panel the game panel the contains the game
   */
   public PauseScreen(GameApp app, GamePanel panel)
   {
      myApp = app;
      myGamePanel = panel;
      
      addMouseListener(new MyButtonListener());
      
      try
      {
         InputStream is2 = getClass().getResourceAsStream("PauseT.png");
         InputStream is3 = getClass().getResourceAsStream("Play Button.png");
         InputStream is4 = getClass().getResourceAsStream("Resume.png");
         InputStream is5 = getClass().getResourceAsStream("titleIcon.png");
         InputStream is6 = getClass().getResourceAsStream("tText.png");
         InputStream is7 = getClass().getResourceAsStream("Pause Tab.png");
         
         myPauseTitle = ImageIO.read(is2);
         myResumeIcon = ImageIO.read(is3);
         myResumeText = ImageIO.read(is4);
         myMenuIcon = ImageIO.read(is5);
         myMenuText = ImageIO.read(is6);
         myPauseTab = ImageIO.read(is7);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /**
   Paints/Creates the pause screen
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      myBackground = new Rectangle2D.Double(0, 0, 1100, 800); 
      g2.fill(myBackground);
      
      g2.drawImage(myPauseTab, PAUSE_TABX, PAUSE_TABY, null);
      g2.drawImage(myPauseTitle, PAUSE_TITX, PAUSE_TITY, null);
      g2.drawImage(myResumeIcon, RESUME_X, RESUME_Y, null);
      g2.drawImage(myResumeText, RESUME_X2, RESUME_Y2, null);
      g2.drawImage(myMenuIcon, MENU_X, MENU_Y, null);
      g2.drawImage(myMenuText, MENU_X2, MENU_Y2, null); 
      
      myResumeButton = new Rectangle2D.Double(RESUME_X, RESUME_Y, RES_WIDTH, BUTTON_LENGTH);
      myMenuButton = new Rectangle2D.Double(MENU_X, MENU_Y, MENU_WIDTH, BUTTON_LENGTH);
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
         
         if(myResumeButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("game");
         }
         else if(myMenuButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("title");
            myGamePanel.redraw(myApp);
            myGamePanel.restoreShip();
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