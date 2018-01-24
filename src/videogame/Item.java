/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;



/**
 * 
 * @author alextrujillo
 */
public abstract class Item {

    /**
     *X Item position Variable
     */
    protected int x;
 
    /**
     * Y Item position Variable
     */
    protected int y; 

    /**
     *
     * @param x  init position 
     * @param y  init position 
     */
    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * To get the item position on X 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     *To get the item position on Y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @param x  To set the item position on X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @param y To set the item position on Y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * To update the positions of the item for every tick
     */
    public abstract void tick ();
    
    /**
     * To paint the item
     * @param g <b> Graphics </b> object to pain the item
     */
    public abstract void render (Graphics g);
   
   
}
