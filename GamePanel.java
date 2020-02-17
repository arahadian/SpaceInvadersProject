import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
Game Panel Class
This class creates the panel where
the Game occurs
@author Ayman Rahadian
@version 5/5/2018
*/
public class GamePanel extends JPanel
{
   /** Establishes the size of the shield */
   public static final int SIZE = 20;
   /** Number of frames for the explosion */
   public static final int EXPLOSION_FRAMES = 7;
   /** The time for the explosion to switch between frames */
   public static final int EXPLOSION_TIME = 80;
   /** The number of wave of aliens */
   public static final int WAVE_NUM = 5;
   /** x-position of the ship */
   public static final int SHIP_X = 512;
   /** y-position of the ship */
   public static final int SHIP_Y = 650;
   /** Center of the ship */
   public static final int SHIP_CEN = 35;
   /** Number of rows of alien */
   public static final int ROW = 5;
   /** Number of columns of aliens */
   public static final int COL = 12;
   /** x-position of the aliens */
   public static final int ALIEN_X = 100;
   /** y-position of the aliens */
   public static final int ALIEN_Y = 120;
   /** x gap in between the aliens */
   public static final int X_GAP = 70;
   /** y gap in between the aliens */
   public static final int Y_GAP = 50;
   
   /** time for the first alien projectile */
   public static final int SHOT_TIMER1 = 2500;
   /** time for the second alien projectile */ 
   public static final int SHOT_TIMER2 = 2400;
   /** time for the third alien projectile */
   public static final int SHOT_TIMER3 = 2300;
   /** time for the fourth alien projectile */
   public static final int SHOT_TIMER4 = 2200;
   /** time for the fifth alien projectile */
   public static final int SHOT_TIMER5 = 2100;
   /** time for the sixth alien projectile */
   public static final int SHOT_TIMER6 = 2000;
   
   /** total number of shields */
   public static final int SHIELD_NUM = 4;
   /** first x-position of the barriers */ 
   public static final int SHIELD_X1 = 130; 
   /** second x-position of the barriers */
   public static final int SHIELD_X2 = 150;
   /** third x-position of the barriers */
   public static final int SHIELD_X3 = 170;
   /** fourth x-position of the barriers */
   public static final int SHIELD_X4 = 190;
   /** fifth x-position of the barriers */
   public static final int SHIELD_X5 = 210;
   /** sixth x-position of the barriers */
   public static final int SHIELD_X6 = 230;
   /** first y-position of the barriers */
   public static final int SHIELD_Y1 = 510;
   /** second y-position of the barriers */ 
   public static final int SHIELD_Y2 = 520;
   /** third y-position of the barriers */
   public static final int SHIELD_Y3 = 530;
   /** fourth y-position of the barriers */
   public static final int SHIELD_Y4 = 540;
   /** fifth y-position of the barriers */
   public static final int SHIELD_Y5 = 550;
   /** sixth y-position of the barriers */
   public static final int SHIELD_Y6 = 560;
   /** seventh y-position of the barriers */
   public static final int SHIELD_Y7 = 580;
   /** gap between shields*/
   public static final int GAP = 240; 
   
   public static final int ALIEN_RANGE = 15;
   public static final int ALIEN_SELECT1 = 15;
   public static final int ALIEN_SELECT2 = 30;
   public static final int ALIEN_SELECT3 = 45;
   
   public static final int BOOM_MID = 50;
   public static final int BOOM_TIME = 5;
   

   /** Game App that will run the entire game */
   private GameApp myApp;
   /** Character Screen that allows users to choose their spaceship */
   private CharacterScreen myChar;
   /** Determines the wave number the use is on */
   private int waveNum;
   /** Image for the background of the game */
   private BufferedImage myBackground;
   
   /** Timer that allows the first projectile from the aliens to move */   
   private Timer alienShooting;
   /** Timer that allows the second projectile from the aliens to move */ 
   private Timer alienShooting2;
   /** Timer that allows the third projectile from the aliens to move */ 
   private Timer alienShooting3;
   /** Timer that allows the fourth projectile from the aliens to move */ 
   private Timer alienShooting4;
   /** Timer that allows the fifth projectile from the aliens to move */ 
   private Timer alienShooting5;
   /** Timer that allows the sixth projectile from the aliens to move */ 
   private Timer alienShooting6;
   
   /** Creates the spaceship controlled by the user */
   private Spaceship myShip;
   /** Creates an array list of aliens */ 
   private ArrayList<Alien> myAliens;
   /** Creates the projeciles that will be shot by the spaceship */
   private Projectile myShots;
   /** An array list of Barriers that will form the shield */
   private ArrayList<Barrier> myShield;
   
   /** Creates the first projeciles that will be shot by the alien */
   private AlienProj myAlienShots;
   /** Creates the second projeciles that will be shot by the alien */
   private AlienProj myAlienShots2;
   /** Creates the third projeciles that will be shot by the alien */
   private AlienProj myAlienShots3;
   /** Creates the fourth projeciles that will be shot by the alien */
   private AlienProj myAlienShots4;
   /** Creates the fifth projeciles that will be shot by the alien  */
   private AlienProj myAlienShots5;
   /** Creates the sixth projeciles that will be shot by the alien */
   private AlienProj myAlienShots6;
   
   /** An array list of images that will creat the animation of an explosion */
   private BufferedImage[] explosion;
   /** Time for the explosion */
   private double boomTime;
   /** x-position of the explosion */
   private int boomX;
   /** y-position of the explosion */
   private int boomY;
   /** Timer that allows the explosion to change between images */
   private Timer boomer;
   /** Indicates the boomer timer that the ship was hit */
   private boolean hit; 
   
   /** Array list of images with the wave numbers */
   private BufferedImage[] waves;
   /** An image with the text 'lives' */
   private BufferedImage livesT;
   /** An image with the Spaceship icon to indicate the remaining lives*/
   private BufferedImage lives1;
   /** An image with the Spaceship icon to indicate the remaining lives */
   private BufferedImage lives2;
   /** An image with the Spaceship icon to indicate the remaining lives */
   private BufferedImage lives3;
   
   /** An image of the pause icon */
   private BufferedImage myPauseIcon;
   /** An image of the pause text */
   private BufferedImage myPauseText;
   
   /**
   Constructor for the Game Panel
   @param app The Game App that will run the panel
   @param charS Character Screen where the user decides the spaceship 
      they will use for the game
   */   
   public GamePanel(GameApp app, CharacterScreen charS)
   {
      myApp = app;
      myChar = charS;
      boomTime = -1;
      boomX = 0;
      boomY = 0;
      hit = false;
      explosion = new BufferedImage[EXPLOSION_FRAMES];
      for(int i = 0; i < EXPLOSION_FRAMES; i++)
      {
         try
         {
            InputStream is = getClass().getResourceAsStream("frame" + i + ".gif");
            
            explosion[i] = ImageIO.read(is); 
         }
         catch(IOException ioe)
         {
            
         }
      }
      waveNum = 1;
      waves = new BufferedImage[WAVE_NUM];
      for(int i = 0; i < WAVE_NUM; i++)
      {
         try
         {
            InputStream is = getClass().getResourceAsStream("wave" + i + ".png");
            
            waves[i] = ImageIO.read(is); 
         }
         catch(IOException ioe)
         {
            
         }   
      }
   
      myShip = new Spaceship(SHIP_X, SHIP_Y, app, myChar);
      myShield = new ArrayList<Barrier>();
      createShield();
      myAliens = new ArrayList<Alien>();
      for(int row = 0; row < ROW; row++)
      {  
         for(int col = 0; col < COL; col++)
         {
            myAliens.add(new Alien(ALIEN_X + X_GAP*(col), ALIEN_Y + Y_GAP*(row), app, this));      
         }
      }
      alienShootTimer();
      try
      {
         InputStream is = getClass().getResourceAsStream("Background.jpg");
         InputStream is2 = getClass().getResourceAsStream("lives.png");
         InputStream is3 = getClass().getResourceAsStream("lives1.png");
         InputStream is4 = getClass().getResourceAsStream("lives2.png");
         InputStream is5 = getClass().getResourceAsStream("lives3.png");
         InputStream is6 = getClass().getResourceAsStream("pauseGP.png");
         InputStream is7 = getClass().getResourceAsStream("pause1.png");
         
         myBackground = ImageIO.read(is);
         livesT = ImageIO.read(is2);
         lives1 = ImageIO.read(is3);
         lives2 = ImageIO.read(is4);
         lives3 = ImageIO.read(is5);
         myPauseIcon = ImageIO.read(is6);
         myPauseText = ImageIO.read(is7);
      }
      catch(IOException ioe)
      {
      }
      
      boom();
      FieldUpdater newUpdater = new FieldUpdater();
      newUpdater.start();
   }
   
   /** Creates the timer for the explosion */
   public void boom()
   {
      boomer = new Timer();
      boomer.schedule(new goBoom(), 0, EXPLOSION_TIME);
   }
   
   /**
   Helper method for the constructor that will
   initialize the timer to run the alien's 
   projectiles 
   */
   public void alienShootTimer()
   {
      alienShooting = new Timer();
      alienShooting.schedule(new Updater(), 0, SHOT_TIMER1);
      
      alienShooting2 = new Timer();
      alienShooting2.schedule(new Updater2(), 0, SHOT_TIMER2);
      
      alienShooting3 = new Timer();
      alienShooting3.schedule(new Updater3(), 0, SHOT_TIMER3);
      
      alienShooting4 = new Timer();
      alienShooting4.schedule(new Updater4(), 0, SHOT_TIMER4);
      
      alienShooting5 = new Timer();
      alienShooting5.schedule(new Updater5(), 0, SHOT_TIMER5);
      
      alienShooting6 = new Timer();
      alienShooting6.schedule(new Updater6(), 0, SHOT_TIMER6);
   }
   
   /**
   Creates the shield and forms the shape that
   it has
   */
   public void createShield()
   {
      for(int i = 0; i < SHIELD_NUM; i++)
      {  
         myShield.add(new Barrier(SHIELD_X1+i*GAP, SHIELD_Y4));
         myShield.add(new Barrier(SHIELD_X1+i*GAP, SHIELD_Y6));
         myShield.add(new Barrier(SHIELD_X1+i*GAP, SHIELD_Y7));
      
         myShield.add(new Barrier(SHIELD_X2+i*GAP, SHIELD_Y2));
         myShield.add(new Barrier(SHIELD_X2+i*GAP, SHIELD_Y4));
         myShield.add(new Barrier(SHIELD_X2+i*GAP, SHIELD_Y6));
      
         myShield.add(new Barrier(SHIELD_X3+i*GAP, SHIELD_Y1));
         myShield.add(new Barrier(SHIELD_X3+i*GAP, SHIELD_Y3));
         myShield.add(new Barrier(SHIELD_X3+i*GAP, SHIELD_Y5));
      
         myShield.add(new Barrier(SHIELD_X4+i*GAP, SHIELD_Y1));
         myShield.add(new Barrier(SHIELD_X4+i*GAP, SHIELD_Y3));
         myShield.add(new Barrier(SHIELD_X4+i*GAP, SHIELD_Y5));
      
         myShield.add(new Barrier(SHIELD_X5+i*GAP, SHIELD_Y2));
         myShield.add(new Barrier(SHIELD_X5+i*GAP, SHIELD_Y4));
         myShield.add(new Barrier(SHIELD_X5+i*GAP, SHIELD_Y6));
      
         myShield.add(new Barrier(SHIELD_X6+i*GAP, SHIELD_Y4));
         myShield.add(new Barrier(SHIELD_X6+i*GAP, SHIELD_Y6));
         myShield.add(new Barrier(SHIELD_X6+i*GAP, SHIELD_Y7));
      }   
   }
   
   /**
   Resets the Game Panel to its original setup
   @param app The Game App that will run the game
   */
   public void redraw(GameApp app)
   {
      myApp = app;  
      
      waveNum = 1;    
   
      for(int i = 0; i < myAliens.size(); i++)
      {
         myAliens.get(i).getTimer1().cancel();
         myAliens.get(i).getTimer3().cancel();
      }
      
      myAliens.clear();
      
      myShip.setX(SHIP_X);
      myShip.setY(SHIP_Y);
      
      for(int row = 0; row < ROW; row++)
      {  
         for(int col = 0; col < COL; col++)
         {
            myAliens.add(new Alien(ALIEN_X + X_GAP*(col), ALIEN_Y + Y_GAP*(row), app, this));      
         }
      }
      
      myShield.clear();
      
      createShield();
   }
   
   /**
   Creates a new wave of aliens
   @param app The Game App that will run the game
   */
   public void redrawAlien(GameApp app)
   {
      myApp = app;
      
      for(int i = 0; i < myAliens.size(); i++)
      {
         myAliens.get(i).getTimer1().cancel();
         myAliens.get(i).getTimer3().cancel();
      }
      
      myAliens.clear();
      
      for(int row = 0; row < ROW; row++)
      {  
         for(int col = 0; col < COL; col++)
         {
            myAliens.add(new Alien(ALIEN_X + X_GAP*(col), ALIEN_Y + Y_GAP*(row), app, this));      
         }
      }
      
      waveNum = waveNum + 1;
   }
   
   /**
   Indicates the wave number the user is on
   @return the current wave number
   */   
   public int getWaveNum()
   {
      return waveNum;
   }
   
   /**
   Moves the Spaceship to the right
   */   
   public void moveShipR()
   {
      myShip.moveR();
   }
   
   /**
   Moves the Spaceship to the left
   */ 
   public void moveShipL()
   {
      myShip.moveL();
   }
   
   /**
   Resets the Spaceship lives back to three
   */ 
   public void restoreShip()
   {
      myShip.setLives(myShip.LIVES);
   }
   
   /**
   Indicates the projectile from the spaceship
   to be shot
   */ 
   public void shoot()
   {
      myShots = new Projectile(myShip.getX() + SHIP_CEN, myShip.getY());
      myShots.move();
   }
   
   /**
   Selects an alien by random to generate the 
   first projectile to shoot towards the 
   spaceship
   */
   public void alienShoot()
   {
      int randAliens = (int)(Math.random()*ALIEN_RANGE); 
      
      if(randAliens < myAliens.size() && 
         myAliens.get(randAliens) != null)
      {
         double alienX = myAliens.get(randAliens).getX();
         double alienY = myAliens.get(randAliens).getY();
      
         myAlienShots = new AlienProj(alienX, alienY);
         myAlienShots.move(); 
      }
   }
   
   /**
   Selects an alien by random to generate the 
   second projectile to shoot towards the 
   spaceship
   */
   public void alienShoot2()
   {
      int randAliens = (int)((Math.random()*ALIEN_RANGE) + ALIEN_SELECT1); 
      
      if(randAliens < myAliens.size() && 
         myAliens.get(randAliens) != null)
      {
         double alienX = myAliens.get(randAliens).getX();
         double alienY = myAliens.get(randAliens).getY();
         
         myAlienShots2 = new AlienProj(alienX, alienY);
         myAlienShots2.move(); 
      }
   }
   
   /**
   Selects an alien by random to generate the 
   third projectile to shoot towards the 
   spaceship
   */
   public void alienShoot3()
   {
      int randAliens = (int)((Math.random()*ALIEN_RANGE) + ALIEN_SELECT1); 
      
      if(randAliens < myAliens.size() && 
         myAliens.get(randAliens) != null)
      {
         double alienX = myAliens.get(randAliens).getX();
         double alienY = myAliens.get(randAliens).getY();
         
         myAlienShots3 = new AlienProj(alienX, alienY);
         myAlienShots3.move(); 
      }
   }
   
   /**
   Selects an alien by random to generate the 
   fourth projectile to shoot towards the 
   spaceship
   */
   public void alienShoot4()
   {
      int randAliens = (int)((Math.random()*ALIEN_RANGE) + ALIEN_SELECT2); 
      
      if(randAliens < myAliens.size() && 
         myAliens.get(randAliens) != null)
      {
         double alienX = myAliens.get(randAliens).getX();
         double alienY = myAliens.get(randAliens).getY();
         
         myAlienShots4 = new AlienProj(alienX, alienY);
         myAlienShots4.move(); 
      }
   }
   
   /**
   Selects an alien by random to generate the 
   fifth projectile to shoot towards the 
   spaceship
   */
   public void alienShoot5()
   {
      int randAliens = (int)((Math.random()*ALIEN_RANGE) + ALIEN_SELECT3); 
      
      if(randAliens < myAliens.size() && 
         myAliens.get(randAliens) != null)
      {
         double alienX = myAliens.get(randAliens).getX();
         double alienY = myAliens.get(randAliens).getY();
         
         myAlienShots5 = new AlienProj(alienX, alienY);
         myAlienShots5.move(); 
      }
   }
   
   /**
   Selects an alien by random to generate the 
   sixth projectile to shoot towards the 
   spaceship
   */
   public void alienShoot6()
   {
      int randAliens = (int)((Math.random()*ALIEN_RANGE) + ALIEN_SELECT3); 
      
      if(randAliens < myAliens.size() && 
         myAliens.get(randAliens) != null)
      {
         double alienX = myAliens.get(randAliens).getX();
         double alienY = myAliens.get(randAliens).getY();
         
         myAlienShots6 = new AlienProj(alienX, alienY);
         myAlienShots6.move(); 
      }
   }
   
   /**
   Indicates if projectile is ready to be reshot
   @return boolean of the shots generated
   */
   public boolean reshoot()
   {
      if(myShots != null)
      {
         return myShots.isGenerated();
      }
      else
      {
         return false;
      }
   }
   
   /**
   Indicates how many aliens are left
   @return remianing aliens
   */
   public int aliensLeft()
   {
      return myAliens.size();
   }
   
   /**
   Draws the explosion
   @param g2 the graphics handler
   */
   public void drawBoom(Graphics g2)
   {
      boomX = (int)myShip.getX() - BOOM_MID;
      boomY = (int)myShip.getY() - BOOM_MID;
      
      if(boomTime == 0)
      {
         g2.drawImage(explosion[0], boomX, boomY, null);
      }
      else if(boomTime == 1)
      {
         g2.drawImage(explosion[1], boomX, boomY, null);
      }
      else if(boomTime == 2)
      {
         g2.drawImage(explosion[2], boomX, boomY, null);
      }
      else if(boomTime == 3)
      {
         g2.drawImage(explosion[3], boomX, boomY, null);
      }
      else if(boomTime == 4)
      {
         g2.drawImage(explosion[4], boomX, boomY, null);
      }
      else if(boomTime == 5)
      {
         g2.drawImage(explosion[5], boomX, boomY, null);
      }
      else if(boomTime == 6)
      {
         g2.drawImage(explosion[6], boomX, boomY, null);
      }
   }
   
   /**
   TimerTask class to run the frames of the explosion
   */ 
   private class goBoom extends TimerTask
   {
      /** Runs the timer class*/
      public void run()
      {
         if(hit == true)
         {
            boomTime++;
            repaint();
                        
            if(boomTime > BOOM_TIME)
            {
               boomTime = -1;
               hit = false;
            }
         }
      }
   }
   
   /** 
   Collision with the projectiles coming from the spaceship
   */
   public void shipProjHit()
   {
      for(int i = 0; i < myAliens.size(); i++)
      {  
         if(myShots.getY() + myShots.HEIGHT > myAliens.get(i).getY() && 
               myShots.getY() < myAliens.get(i).getY() + 20 &&
               myShots.getX() + myShots.WIDTH > myAliens.get(i).getX() && 
               myShots.getX() < myAliens.get(i).getX() + 45)
         {
            myShots.collide();
            myAliens.get(i).hit();
         
            if(myAliens.get(i).getLives() == 0)
            {
               myAliens.remove(i);
            }
              
            if(aliensLeft() == 0)
            {
               if(waveNum > 4)
               {
                  myApp.switchScreen("win");
                  redraw(myApp);
                  restoreShip();   
               }
               else
               {  
                  redrawAlien(myApp);
                  System.out.println(waveNum);
               }
            }  
         }
      }   
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myShots.getY() + myShots.HEIGHT > myShield.get(i).getY() && 
               myShots.getY() < myShield.get(i).getY() + 10 &&
               myShots.getX() + myShots.WIDTH > myShield.get(i).getX() && 
               myShots.getX() < myShield.get(i).getX() + 20)
         {
            myShots.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }      
   }
   
   /** 
   Collision with the aliens
   @param g2 the graphics handler
   */
   public void alienHit(Graphics2D g2)
   {
      for(int i = 0; i < myAliens.size(); i++)
      {
         myAliens.get(i).drawMe(g2);   
      }
      
      
      for(int i = 0; i < myAliens.size(); i++)
      {
         for(int a = 0; a < myShield.size(); a++)
         {
            if(myAliens.get(i).getY() + 40 > myShield.get(a).getY() && 
               myAliens.get(i).getX() + 40 > myShield.get(a).getX() && 
               myAliens.get(i).getX() < myShield.get(a).getX() + myShield.get(a).SIZE)
            {
               myShield.get(a).destroy();
               
               if(myShield.get(a).getLives() == 0)
               {
                  myShield.remove(a);
               }
            }
         }
      }   
   
      for(int i = 0; i < myAliens.size(); i++)
      {
         if(myShip.getY() + myShip.SIZE > myAliens.get(i).getY() + 40 && 
               myShip.getY() < myAliens.get(i).getY() + 20 &&
               myShip.getX() + myShip.SIZE > myAliens.get(i).getX() && 
               myShip.getX() < myAliens.get(i).getX() + 45)
         {
            myApp.switchScreen("lose");
            redraw(myApp);
            restoreShip();
         }
      }   
   }
   
   /** 
   Collision with the first alien projectile
   */
   public void alienProj1Hit()
   {
      if(myAlienShots.getY() + myAlienShots.HEIGHT > myShip.getY() + 33 && 
               myAlienShots.getY() < myShip.getY() + 76 &&
               myAlienShots.getX() + myAlienShots.WIDTH > myShip.getX() && 
               myAlienShots.getX() < myShip.getX() + 76)
      {
         hit = true;
         myAlienShots.collide();
         myShip.hit();
      }
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myAlienShots.getY() + myAlienShots.HEIGHT > myShield.get(i).getY() && 
               myAlienShots.getY() < myShield.get(i).getY() + 10 &&
               myAlienShots.getX() + myAlienShots.WIDTH > myShield.get(i).getX() && 
               myAlienShots.getX() < myShield.get(i).getX() + 20)
         {
            myAlienShots.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }   
   }
   
   /** 
   Collision with the second alien projectile
   */
   public void alienProj2Hit()
   {
      if(myAlienShots2.getY() + myAlienShots2.HEIGHT > myShip.getY() + 30 && 
               myAlienShots2.getY() < myShip.getY() + 76 &&
               myAlienShots2.getX() + myAlienShots2.WIDTH > myShip.getX() && 
               myAlienShots2.getX() < myShip.getX() + 76)
      {
         hit = true;
         myAlienShots2.collide();
         myShip.hit();  
      }
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myAlienShots2.getY() + myAlienShots2.HEIGHT > myShield.get(i).getY() && 
               myAlienShots2.getY() < myShield.get(i).getY() + 10 &&
               myAlienShots2.getX() + myAlienShots2.WIDTH > myShield.get(i).getX() && 
               myAlienShots2.getX() < myShield.get(i).getX() + 20)
         {
            myAlienShots2.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }
   }
   
   /** 
   Collision with the third alien projectile
   */
   public void alienProj3Hit()
   {
      if(myAlienShots3.getY() + myAlienShots3.HEIGHT > myShip.getY() + 30 && 
               myAlienShots3.getY() < myShip.getY() + 76 &&
               myAlienShots3.getX() + myAlienShots3.WIDTH > myShip.getX() && 
               myAlienShots3.getX() < myShip.getX() + 76)
      {
         hit = true;
         myAlienShots3.collide();
         myShip.hit(); 
      }
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myAlienShots3.getY() + myAlienShots3.HEIGHT > myShield.get(i).getY() && 
               myAlienShots3.getY() < myShield.get(i).getY() + 10 &&
               myAlienShots3.getX() + myAlienShots3.WIDTH > myShield.get(i).getX() && 
               myAlienShots3.getX() < myShield.get(i).getX() + 20)
         {
            myAlienShots3.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }
   }
   
   /** 
   Collision with the fourth alien projectile
   */
   public void alienProj4Hit()
   {
      if(myAlienShots4.getY() + myAlienShots4.HEIGHT > myShip.getY() + 30 && 
               myAlienShots4.getY() < myShip.getY() + 76 &&
               myAlienShots4.getX() + myAlienShots4.WIDTH > myShip.getX() && 
               myAlienShots4.getX() < myShip.getX() + 76)
      {
         hit = true;
         myAlienShots4.collide();
         myShip.hit(); 
      }
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myAlienShots4.getY() + myAlienShots4.HEIGHT > myShield.get(i).getY() && 
               myAlienShots4.getY() < myShield.get(i).getY() + 10 &&
               myAlienShots4.getX() + myAlienShots4.WIDTH > myShield.get(i).getX() && 
               myAlienShots4.getX() < myShield.get(i).getX() + 20)
         {
            myAlienShots4.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }
   }
   
   /** 
   Collision with the fifth alien projectile
   */
   public void alienProj5Hit()
   {
      if(myAlienShots5.getY() + myAlienShots5.HEIGHT > myShip.getY() + 30 && 
               myAlienShots5.getY() < myShip.getY() + 76 &&
               myAlienShots5.getX() + myAlienShots5.WIDTH > myShip.getX() && 
               myAlienShots5.getX() < myShip.getX() + 76)
      {
         hit = true;
         myAlienShots5.collide();
         myShip.hit(); 
      }
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myAlienShots5.getY() + myAlienShots5.HEIGHT > myShield.get(i).getY() && 
               myAlienShots5.getY() < myShield.get(i).getY() + 10 &&
               myAlienShots5.getX() + myAlienShots5.WIDTH > myShield.get(i).getX() && 
               myAlienShots5.getX() < myShield.get(i).getX() + 20)
         {
            myAlienShots5.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }
   }
   
   /** 
   Collision with the sixth alien projectile
   */
   public void alienProj6Hit()
   {
      if(myAlienShots6.getY() + myAlienShots6.HEIGHT > myShip.getY() + 30 && 
               myAlienShots6.getY() < myShip.getY() + 76 &&
               myAlienShots6.getX() + myAlienShots6.WIDTH > myShip.getX() && 
               myAlienShots6.getX() < myShip.getX() + 76)
      {
         hit = true;
         myAlienShots6.collide();
         myShip.hit(); 
      }
   
      for(int i = 0; i < myShield.size(); i++)
      {
         if(myAlienShots6.getY() + myAlienShots6.HEIGHT > myShield.get(i).getY() && 
               myAlienShots6.getY() < myShield.get(i).getY() + 10 &&
               myAlienShots6.getX() + myAlienShots6.WIDTH > myShield.get(i).getX() && 
               myAlienShots6.getX() < myShield.get(i).getX() + 20)
         {
            myAlienShots6.collide();
            myShield.get(i).hit();
               
            if(myShield.get(i).getLives() == 0)
            {
               myShield.remove(i);
            }
         }   
      }
   }
   
   /** 
   Helper methods that indicates the hits of all projectiles 
   @param g2 the graphics handler
   */
   public void shotsFired(Graphics2D g2)
   {
      if(myShots != null) 
      {
         myShots.drawMe(g2);
         shipProjHit(); 
      }
      if(myAlienShots != null)
      {
         myAlienShots.drawMe(g2);
         alienProj1Hit();
      }
      if(myAlienShots2 != null)
      {
         myAlienShots2.drawMe(g2);
         alienProj2Hit();
      }
      if(myAlienShots3 != null)
      {
         myAlienShots3.drawMe(g2);
         alienProj3Hit();
      }
      if(myAlienShots4 != null)
      {
         myAlienShots4.drawMe(g2);
         alienProj4Hit();
      }
      if(waveNum > 1)
      {
         if(myAlienShots5 != null)
         {
            myAlienShots5.drawMe(g2);
            alienProj5Hit();   
         }
         if(myAlienShots6 != null)
         {
            myAlienShots6.drawMe(g2);
            alienProj6Hit();   
         }
      }      
   }
   
   /** 
   Draws the wave number title on the game panel 
   @param g2 the graphics handler
   */
   public void drawWaveNum(Graphics2D g2)
   {
      if(waveNum == 1)
      {
         g2.drawImage(waves[0], 470, 50, null);
      }
      else if(waveNum == 2)
      {
         g2.drawImage(waves[1], 470, 50, null);
      }
      else if(waveNum == 3)
      {
         g2.drawImage(waves[2], 470, 50, null);
      }
      else if(waveNum == 4)
      {
         g2.drawImage(waves[3], 470, 50, null);
      }
      else if(waveNum == 5)
      {
         g2.drawImage(waves[4], 470, 50, null);
      }
   }
   
   /** 
   Draws the remaining lives of the spaceship 
   @param g2 the graphics handler
   */
   public void drawLives(Graphics2D g2)
   {
      g2.drawImage(livesT, 30, 55, null); 
      
      if(myChar.getChoice().equals("one"))
      {
         for(int i = 0; i < myShip.getLives(); i++)
         {
            g2.drawImage(lives1, 130 + 60*i, 40, null);
         }   
         
      }
      else if(myChar.getChoice().equals("two"))
      {
         for(int i = 0; i < myShip.getLives(); i++)
         {
            g2.drawImage(lives2, 130 + 60*i, 40, null);
         }   
         
      }
      if(myChar.getChoice().equals("three"))
      {
         for(int i = 0; i < myShip.getLives(); i++)
         {
            g2.drawImage(lives3, 130 + 60*i, 40, null);
         }   
      }  
   }
   
   /** 
   Draws the pause options 
   @param g2 the graphics handler
   */
   public void drawPause(Graphics2D g2)
   {
      g2.drawImage(myPauseIcon, 1020, 40, null);
      g2.drawImage(myPauseText, 925, 55, null);
   }
   
   /** 
   Compiles the pause, lives, and wave number into a staturBar
   @param g2 the graphics handler
   */
   public void statusBar(Graphics2D g2)
   {
      drawWaveNum(g2);
      drawLives(g2);
      drawPause(g2);      
   }

   /** 
   Paints/creates the entire panel
   @param g the graphics handler
   */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(myBackground, -410, -280, null);
                         
      if(myChar.getChoice() != null)
      {
         myShip.drawMe(g2);
      }
      
      alienHit(g2);
      
      for(int i = 0; i < myShield.size(); i++)
      {
         myShield.get(i).drawMe(g2);
      }
      
      shotsFired(g2);
      
      if(hit == true)
      {
         drawBoom(g2);
      }
      
      statusBar(g2);
      
      if(myShip.getLives() == 0)
      {
         myApp.switchScreen("lose");
         redraw(myApp);
         restoreShip();
         myApp.setPaused(true);        
      }
   }
   
   /** TimerTask class for the first alien projectile's timer */
   private class Updater extends TimerTask
   {
      /** Runs the TimerTask */
      public void run()
      {
         if(!myApp.isPaused())
         {
            alienShoot();
         }
      }
   }
   
   /** TimerTask class for the second alien projectile's timer */
   private class Updater2 extends TimerTask
   {
      /** Runs the TimerTask */
      public void run()
      {
         if(!myApp.isPaused())
         {
            alienShoot2();
         }
      }
   }
   
   /** TimerTask class for the third alien projectile's timer */
   private class Updater3 extends TimerTask
   {
      /** Runs the TimerTask */
      public void run()
      {
         if(!myApp.isPaused())
         {
            alienShoot3();
         }
      }
   }
   
   /** TimerTask class for the fourth alien projectile's timer */
   private class Updater4 extends TimerTask
   {
      /** Runs the TimerTask */
      public void run()
      {
         if(!myApp.isPaused())
         {
            alienShoot4();
         }
      }
   }
   
   /** TimerTask class for the fifth alien projectile's timer */
   private class Updater5 extends TimerTask
   {
      /** Runs the TimerTask */
      public void run()
      {
         if(!myApp.isPaused())
         {
            alienShoot5();
         }
      }
   }
   
   /** TimerTask class for the sixth alien projectile's timer */
   private class Updater6 extends TimerTask
   {
      /** Runs the TimerTask */
      public void run()
      {
         if(!myApp.isPaused())
         {
            alienShoot6();
         }
      }
   }  
    
   /** Inner class that updates the entire panel */
   private class FieldUpdater extends Thread
   {
      /** Runs the thread class */
      public void run()
      {
         while(true)
         {
            if(!myApp.isPaused())
            {
               repaint();
            }
            
            try 
            {
               sleep(1);
            }
            catch(InterruptedException ie)
            {
               
            }
         }  
      }
   }       
}