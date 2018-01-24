/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author alextrujillo
 */
public class KeyManager implements KeyListener {
   
    private static boolean up;
    private static boolean down;
    private static boolean left;
    private  static boolean right;
    private boolean keys[];

    /**
     * 
     * @return up To verify the up KEY state 
     */
    public static boolean isUp() {
        return up;
    }

     /**
     * 
     *@param up To set the up KEY state 
     */
    public static void setUp(boolean up) {
        KeyManager.up = up;
    }

     /**
     * 
     * @return up To verify the down KEY state 
     */
    public static boolean isDown() {
        return down;
    }

     /**
     * 
     *@param down To set the up KEY state 
     */
    public static void setDown(boolean down) {
        KeyManager.down = down;
    }

     /**
     *
     * @return up  To verify the left KEY state 
     */
    public static boolean isLeft() {
        return left;
    }

     /**
     *  
     * @param left To set the left KEY state
     */
    public static void setLeft(boolean left) {
        KeyManager.left = left;
    }

     /**
     * 
     * @return up To verify the right KEY state 
     */
    public static boolean isRight() {
        return right;
    }

     /**
     * 
     *@param right  set the right KEY state 
     */
    public static void setRight(boolean right) {
        KeyManager.right = right;
    }

     /**
      * To verify the key ASCII  
      */
    public KeyManager(){
        keys = new boolean [256];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //keyPressed - when the key goes down
    @Override
    public void keyPressed(KeyEvent e) {
     keys[e.getKeyCode()] = true;
    }

    //keyReleased - when the key comes up
    @Override
    public void keyReleased(KeyEvent e) {
     keys[e.getKeyCode()] = false;
    }
    
    /**
     * To enable and disable moves on every tick
     */
    public void tick(){
    up = keys[KeyEvent.VK_UP];
    down = keys[KeyEvent.VK_DOWN];
    left = keys[KeyEvent.VK_LEFT];
    right = keys[KeyEvent.VK_RIGHT];
    }
    
}
