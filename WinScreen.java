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
Class for the Win Screen
@author Ayman Rahadian
@version 6/1/2018
*/
public class WinScreen extends JPanel
{
   /** The GameApp that will run the game */
   private GameApp myApp;
   /** Image of the win title */
   private BufferedImage myImage;
   
   /** Background of the screen */
   private Rectangle2D.Double myBackground;
   /** The title button */ 
   private Rectangle2D.Double myTitleButton;
   
   /** Image of the title icon */
   private BufferedImage myTitleIcon;
   /** Image of the title text */
   private BufferedImage myTitleText;
   
   /**
   Contructor for the win Screen
   @param app the game app that contains the screen
   */
   public WinScreen(GameApp app)
   {
      myApp = app;
      
      addMouseListener(new MyButtonListener());
      
      try
      {
         InputStream is = getClass().getResourceAsStream("win.png");
         InputStream is2 = getClass().getResourceAsStream("titleIcon.png");
         InputStream is3 = getClass().getResourceAsStream("tText.png");
         
         myImage = ImageIO.read(is);
         myTitleIcon = ImageIO.read(is2);
         myTitleText = ImageIO.read(is3);
      }
      catch(IOException ioe)
      {
         
      }
   }
   
  /**
  Paints/Creates the win screen
  @param g the graphics handler
  */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      myBackground = new Rectangle2D.Double(0, 0, 1100, 800); 
      g2.fill(myBackground);      
      
      int posX = (GameApp.APP_WIDTH / 2) - (200 / 2) - 110;
      int posY = (GameApp.APP_HEIGHT / 2) - (50 / 2) - 40;
      g2.drawImage(myImage, 332, posY - 10, null);
      
      myTitleButton = new Rectangle2D.Double(448, posY + 90, 
          203, 50);
          
      g2.drawImage(myTitleIcon, 448, posY + 90, null);
      g2.drawImage(myTitleText, 503, posY + 99, null);
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
         
         if(myTitleButton.contains(mouseX, mouseY))
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
