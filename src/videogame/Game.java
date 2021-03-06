/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author alextrujillo
 */
public class Game  implements Runnable{
    
    private BufferStrategy bs;  // to have several buffers when displaying 
    private Graphics g; // to paint objects
    private Display display;    // to display in the game 
    String title;   // title of the window
    private int width;  // width of the window 
    private int height; // height of the window
    private Thread thread;  // thread to create the game
    private boolean running;    // to set the game  
    private int x; // to move the image
    private int direction; // player direction
    private Player player; // to use a player
    private KeyManager keyManager; // to manage the keyboard
    
    
   /**
    to create title, width and height and set the game is still not running
    @param title to set the title of the window
    @param width to set the width of the window
    @param height to set the height of the window
    */
    public Game(String title, int width, int height) { 
        this.title = title;
        this.width = width; 
        this.height = height; 
        running = false;
        keyManager = new KeyManager();
    }

    
    @Override
    public void run() { 
        //Throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        init();
        //Frames per second
        int fps = 50;
        //Time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define how to use inside the loop
        long now;
        //initializing last time to the computer tine in nanosecs
        long lastTime = System.nanoTime();
        while (running) { 
            //Setting the time now to the actual time
            now = System.nanoTime();
            //acumulating to delta the difference betwen times in timeTick units
            delta += (now - lastTime) / timeTick;
            //updating the last time
            lastTime = now;
            
            //if delta is possitive we tick the game
            
            if(delta >= 1){
            tick();
            render();
            delta --;
            }
        }
        stop();
    }
    
    //Game Update  50 times per second
    private void tick(){
        keyManager.tick();
        //advance player with colision 
        player.tick();
    
     
    }
  
    /**
    initializing the display window of the game
    */
    private void init() {
        display = new Display(title, width, height);
        Assets.init();
        player = new Player(0, getHeight() -180, 1, 150, 150, this);
        display.getJframe().addKeyListener(keyManager);
        
    }
    
 
    
    private void render() {
        // get the buffer strategy from the display 
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of the game, if not null,
        then we display every image of the game but after clearing the Rectanlge, getting the graphic
        object from the buffer strategy element.
        show the graphic and dispose it to the trash system
        */
        if (bs == null) { 
            display.getCanvas().createBufferStrategy(3);
        }else{
            g = bs.getDrawGraphics();;
            g.drawImage(Assets.background, 0, 0, width, height, null);
            player.render(g);
            bs.show();
            g.dispose();   
        }
    }
    
    /**
    setting the thead for the game
    */
    public synchronized void start() {
        if (!running) {
        running = true;
        thread = new Thread(this); 
        thread.start();
        }
    }
    
    /**
    stopping the thread
    */
    public synchronized void stop() { 
        if (running) {
            running = false; 
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }   
    }
    
    /**
     *To get the window width
     * @return width
     */
    public int getWidht(){
        return width;
    }
    
    /**
     *To get the window height
     * @return height
     */
    public int getHeight(){
    return height;
    }

    /**
     *To get the system keyManager
     * @return height
     */
    KeyManager getKeyManager() {
        return keyManager;
    }
    
 
}
