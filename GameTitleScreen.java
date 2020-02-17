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
Class for the Game Title Screen
@author Ayman Rahadian
@version 6/1/2018
*/
public class GameTitleScreen extends JPanel
{
   /** X-location of the play button */
   public static final int PLAY_X = 60;
   /** Y-location of the play button */
   public static final int PLAY_Y = 40;
   /** Width of the play button */
   public static final int PLAY_WIDTH = 350;
   /** Length of all the buttons */
   public static final int BUTTON_LENGTH = 50;
   /** X-location of the how button */
   public static final int HOW_X = 80;
   /** Y-location of the how button */
   public static final int HOW_Y = 110;
   /** Width of the how button */
   public static final int HOW_WIDTH = 400;
   /** X-location of the control button */
   public static final int CONT_X = 50;
   /** Y-location of the control button */
   public static final int CONT_Y = 180;
   /** Width of the control button */
   public static final int CONT_WIDTH = 335;
   /** Width of the button */
   public static final int BUTTON_WIDTH = 200;
   /** Height of the button */
   public static final int BUTTON_HEIGHT = 50;

   /** X-Position of the background */
   public static final int BACKGROUND_X = -410;
   /** Y-Position of the background */
   public static final int BACKGROUND_Y = -280;
   
   /** X-Position of the ship */
   public static final int SHIP_X = 512;
   /** Y-Position of the ship */
   public static final int SHIP_Y = 650;
   
   /** Number of aliens */
   public static final int ALIEN_NUM = 11;
   /** X-Position of the aliens */
   public static final int ALIEN_X = 152;
   /** Y-Position of the aliens */
   public static final int ALIEN_Y= 45;
   /** gap between the aliens */
   public static final int GAP = 75;
   
   /** X position gap for the play icon */
   public static final int PLAYX_GAP = 60;
   /** Y position gap for the play icon */
   public static final int PLAYY_GAP = 40;
   /** Y position gap for the play text */
   public static final int PLAYY2_GAP = 43;
   
   /** X position gap for the how icon */
   public static final int HOWX_GAP = 80;
   /** Y position gap for the how icon */
   public static final int HOWY_GAP = 110;
   /** X position gap for the how text */
   public static final int HOWX2_GAP = 20;
   /** Y position gap for the how text */
   public static final int HOWY2_GAP = 113;
   
   /** X position gap for the control icon */
   public static final int CONTX_GAP = 50;
   /** Y position gap for the control icon */
   public static final int CONTY_GAP = 180;
   /** X position gap for the control text */
   public static final int CONTX2_GAP = 10;
   /** Y position gap for the control text */
   public static final int CONTY2_GAP = 183;
   
   /** Font size for the text */
   public static final int TEXT_FONT = 9;
   /** X-location of the text */
   public static final int TEXT_X = 1000;
   /** Y-location of the text */
   public static final int TEXT_Y = 770;
   
   /** X-location of the title */
   public static final int TITLE_X = 240;
   /** Y-location of the title */
   public static final int TITLE_Y = 237;
   /** X-location of the subtitle */
   public static final int SUBT_X = 358;
   /** Y-location of the subtitle */
   public static final int SUBT_Y = 37;

   /** The GameApp that will run the game */
   private GameApp myApp;

   /** The play button */
   private Rectangle2D.Double myPlayButton;
   /** The how button */
   private Rectangle2D.Double myHowButton;
   /** The control button */
   private Rectangle2D.Double myContButton; 
   
   /** Array list of aliens */
   private ArrayList<Alien> myAliens;
   /** The spaceship the user controls */
   private Spaceship myShip;
   
   /** Image of the Game title */
   private BufferedImage myImage;
   /** Image of the ship */
   private BufferedImage myShipImage;
   /** Image of the alien */
   private BufferedImage myAlienImage;
   /** Image of the background */
   private BufferedImage myBackground;
   /** Image of the play icon */
   private BufferedImage myPlayIcon;
   /** Image of the play text */
   private BufferedImage myPlayText;
   /** Image of the how icon */
   private BufferedImage myHowIcon;
   /** Image of the how text */
   private BufferedImage myHowText;
   /** Image of the control icon */
   private BufferedImage myControl;
   /** Image of the control text */
   private BufferedImage myControlText;
   /** Image of the subtitle to the main title */
   private BufferedImage mySubTitle;
   
   /** 
   Constructor of the Game Title Screen
   @param app the app that contains the screen
   */
   public GameTitleScreen(GameApp app)
   {
      myApp = app;
            
      addMouseListener(new MyButtonListener());
      
      try
      {
         InputStream is = getClass().getResourceAsStream("title.png");
         InputStream is2 = getClass().getResourceAsStream("Spaceship(1).png");
         InputStream is11 = getClass().getResourceAsStream("Alien.png");
         InputStream is3 = getClass().getResourceAsStream("background.jpg");
         InputStream is4 = getClass().getResourceAsStream("Play Button.png");
         InputStream is5 = getClass().getResourceAsStream("playGame.png");
         InputStream is6 = getClass().getResourceAsStream("How-to-play.png");
         InputStream is7 = getClass().getResourceAsStream("howText.png");
         InputStream is8 = getClass().getResourceAsStream("control.png");
         InputStream is9 = getClass().getResourceAsStream("conText.png");
         InputStream is10 = getClass().getResourceAsStream("subtitle.png");
         
         myImage = ImageIO.read(is);
         myShipImage = ImageIO.read(is2);
         myAlienImage = ImageIO.read(is11);
         myBackground = ImageIO.read(is3);
         myPlayIcon = ImageIO.read(is4);
         myPlayText = ImageIO.read(is5);
         myHowIcon = ImageIO.read(is6);
         myHowText = ImageIO.read(is7);
         myControl = ImageIO.read(is8);
         myControlText = ImageIO.read(is9);
         mySubTitle = ImageIO.read(is10);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
   /** 
   Paints/Creates the title screen
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      setBackground(Color.black);
      
      g2.drawImage(myBackground, BACKGROUND_X, BACKGROUND_Y, null);
      
      int buttonX = (GameApp.APP_WIDTH / 2) - (BUTTON_WIDTH / 2);
      int buttonY = (GameApp.APP_HEIGHT / 2) - (BUTTON_HEIGHT / 2);
      
      for(int i = 0; i < ALIEN_NUM; i++)
      {
         g2.drawImage(myAlienImage, ALIEN_X + GAP*(i), ALIEN_Y, null);
      }
      
      g2.setColor(Color.green);
      
      myPlayButton = new Rectangle2D.Double(buttonX - PLAY_X, buttonY + PLAY_Y, 
         PLAY_WIDTH, BUTTON_LENGTH);
      myHowButton = new Rectangle2D.Double(buttonX - HOW_X, buttonY + HOW_Y, 
         HOW_WIDTH, BUTTON_LENGTH);
      myContButton = new Rectangle2D.Double(buttonX - CONT_X, buttonY + CONT_Y, 
         CONT_WIDTH, BUTTON_LENGTH);
         
      g2.drawImage(myPlayIcon, buttonX - PLAYX_GAP, buttonY + PLAYY_GAP, null);
      g2.drawImage(myPlayText, buttonX, buttonY + PLAYY2_GAP, null);
      g2.drawImage(myHowIcon, buttonX - HOWX_GAP, buttonY + HOWY_GAP, null);
      g2.drawImage(myHowText, buttonX - HOWX2_GAP, buttonY + HOWY2_GAP, null);
      g2.drawImage(myControl, buttonX - CONTX_GAP, buttonY + CONTY_GAP, null);
      g2.drawImage(myControlText, buttonX + CONTX2_GAP, buttonY + CONTY2_GAP, null);

      g2.setColor(Color.white);
      g2.setFont(new Font("Comic Sans", Font.BOLD, TEXT_FONT));
      g2.drawString("By Ayman Rahadian", TEXT_X, TEXT_Y);
     
      g2.drawImage(myImage, TITLE_X, buttonY - TITLE_Y, null);
      g2.drawImage(mySubTitle, SUBT_X, buttonY - SUBT_Y, null);
      g2.drawImage(myShipImage, SHIP_X, SHIP_Y, null);
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
         
         if(myPlayButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("char");
         }
         else if(myHowButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("how");
         }
         else if(myContButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("cont");
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