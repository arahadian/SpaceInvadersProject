import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.geom.*;
/**
GameScreen class that contains the GamePanel
@author Ayman Rahadian
@version 6/1/2018
*/
public class GameScreen extends JPanel
{
   /** The x-position of the pause button */
   public static final int PAUSE_X = 925;
   /** The y-position of the pause button */
   public static final int PAUSE_Y = 40;
   /** The width of the pause button */
   public static final int PAUSE_WIDTH = 145;
   /** The length of the pause button */
   public static final int PAUSE_LENGTH = 90;

   /** Game App that will run the entire game */
   private GameApp myApp;
   /** Character Screen that allows users to choose their spaceship */
   private CharacterScreen myChar;
   /** GamePanal that contain features of the game */
   private GamePanel myGamePanel;
   
   /** The pause button */
   private Rectangle2D.Double myPauseButton;

   /** 
   Constructor for the GameScreen
   @param app the game app that will run the game
   @param charS Character Screen where the user decides the spaceship 
      they will use for the game
   */
   public GameScreen(GameApp app, CharacterScreen charS)
   {
      myApp = app;
      myChar = charS;
      
      myGamePanel = new GamePanel(myApp, myChar);
           
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1;
      gbc.weighty = 1;
   
      add(myGamePanel, gbc);
      
      myPauseButton = new Rectangle2D.Double(PAUSE_X, PAUSE_Y, PAUSE_WIDTH, 
         PAUSE_LENGTH);
      
      addKeyListener(new MyKeyListener());
      addMouseListener(new MyButtonListener());
      requestFocusInWindow();  
   }
   
   /** 
   Obtains the game panel that is contained within the screen
   @return myGamePanel
   */
   public GamePanel getPanel()
   {
      return myGamePanel;
   }
   
   /** Inner class for keyboard activities */
   private class MyKeyListener implements KeyListener
   {
      /** 
      Events when key is pressed 
      @param e Keyboard key that is pressed
      */
      public void keyPressed(KeyEvent e)
      {
         int code = e.getKeyCode();
               
         if(code == KeyEvent.VK_RIGHT)
         {
            myGamePanel.moveShipR();
         }
         else if(code == KeyEvent.VK_LEFT)
         {
            myGamePanel.moveShipL();
         }
         else if(code == KeyEvent.VK_SPACE)
         {
            if(myGamePanel.reshoot() == false)
            {
               myGamePanel.shoot();
            }
         }
         
         repaint();
      }
      
      /** 
      Events when key is released 
      @param e Keyboard key that is released
      */
      public void keyReleased(KeyEvent e)
      {
      }
      
      /** 
      Events when key is typed 
      @param e Keyboard key that is typed
      */
      public void keyTyped(KeyEvent e)
      {
      }
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
         
         if(myPauseButton.contains(mouseX, mouseY))
         {
            myApp.switchScreen("pause");
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