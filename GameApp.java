import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.io.*;
/**
GameApp Class that runs the App
@author Ayman Rahadian
@version 6/1/2018
*/
public class GameApp
{
   /** Width of the game app */
   public static final int APP_WIDTH = 1100;
   /** Height of the game app */
   public static final int APP_HEIGHT = 800;

   /** JFrame that sets up the app */
   private JFrame myApp;
   /** App panel that contains all the screens of the game */ 
   private JPanel myAppPanel;
   
   /** Game screen that contains the game panel */
   private GameScreen myGameScreen;
   /** The Game title screen */
   private GameTitleScreen myTitleScreen;
   /** The Game panel contained in the Game screen */
   private GamePanel myGamePanel;
   /** The character selection screen */
   private CharacterScreen myCharChoice;
   /** The How to play screen */
   private HowToScreen myHowScreen;
   /** The controls screen */
   private ControlScreen myControls;
   /** The win screen */
   private WinScreen myWin;
   /** The lose screen */
   private LoseScreen myLose;
   /** The pause screen */
   private PauseScreen myPause;
   
   /** The string that indicates individual screens */
   private String screenName;
   
   /** Boolean that pauses activity throughout the game */
   private boolean paused;
   
   public static void main(String[] args)
   {
      GameApp app = new GameApp();
      app.run();
   }
   
   /** 
   Indicates whether the app is paused or not
   @return paused
   */
   public boolean isPaused()
   {
      return paused;
   }
   
   /** 
   Sets the paused boolean to either true or false
   @param flag true or false
   */
   public void setPaused(boolean flag)
   {
      paused = flag;
   }
   
   /**
   Runs the app
   */
   public void run()
   {
      setupFrame();
   }
   
   /** 
   Sets up the frame/App of the game
   */
   private void setupFrame()
   {
   
      myApp = new JFrame();
      myApp.setSize(APP_WIDTH, APP_HEIGHT);
      paused = true;
      screenName = "title";
      
      myAppPanel = new JPanel(new CardLayout());
      myTitleScreen = new GameTitleScreen(this);
      myCharChoice = new CharacterScreen(this);
      myHowScreen = new HowToScreen(this);
      myControls = new ControlScreen(this);
      myGameScreen = new GameScreen(this, myCharChoice);
      myWin = new WinScreen(this);
      myLose = new LoseScreen(this);
      myPause = new PauseScreen(this, myGameScreen.getPanel());
      
      myAppPanel.add(myTitleScreen, "title");
      myAppPanel.add(myGameScreen, "game");
      myAppPanel.add(myCharChoice, "char");
      myAppPanel.add(myHowScreen, "how");
      myAppPanel.add(myControls, "cont");
      myAppPanel.add(myLose, "lose");
      myAppPanel.add(myWin, "win");
      myAppPanel.add(myPause, "pause");

      myGameScreen.setFocusable(true);
      myGameScreen.requestFocusInWindow();
      
      myApp.add(myAppPanel);
      myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myApp.setVisible(true);
   }
   
   /**
   Switches the screen in the app
   @param whichScreen the string of the screen 
   */
   public void switchScreen(String whichScreen)
   {
      CardLayout layout = (CardLayout) myAppPanel.getLayout();
      layout.show(myAppPanel, whichScreen);
      
      if(whichScreen == "game")
      {
         myGameScreen.requestFocusInWindow();
         paused = false;
         screenName = "game";
      }
      
      if(whichScreen != "game")
      {
         paused = true;
      } 
   }
}