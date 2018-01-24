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
public class Player extends Item{

    private int width; // image player width
    private int direction; // image player direcion
    private int height; // image player height
    private Game game;
    private int playerX ; //player position on X
    private int playerY; //player position on Y
    private int cont ; // counter (fps)
    private boolean colision; // collision verifica si la imagen está fuera un rango preterminado
    


/**
 * PLAYER Constructor 
 * @param x
 * @param y
 * @param direction
 * @param width
 * @param height
 * @param game 
 */
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.game = game;
        this.width = width;
        this.colision = false;
        this.height = height;
        this.playerX = 0;
        this.playerY = 0;

    }
 
    /**
     * 
     * @return  cont variable (fps)
     */
    public int getCont() {
        return cont;
    }

    /**
     *
     * @param cont Setter
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    /**
     *
     * @return player height (image)
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return player width (image)
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return  player direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     *
     * @param direction Setter
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     *
     * @param height player (image)
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @param width Setter
     */ 
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     *
     * @return true/false if  colision
     */
    public boolean isColision() {
        return colision;
    }

    /**
     *
     * @param colision Setter T/F 
     */
    public void setColision(boolean colision) {
        this.colision = colision;
    }
    
    /**
     *
     * @return  image player (car) X position 
     */
    public int getplayerX() {
        return playerX;
    }

    /**
     *
     * @param playerX  set image player (car) X posicion  
     */
    public void setplayerX(int playerX) {
        this.playerX = playerX;
    }

    /**
     *
     * @return image player (car) Y position 
     */
    public int getplayerY() {
        return playerY;
    }

    /**
     *
     * @param playerY image player (car) Y position 
     */
    public void setplayerY(int playerY) {
        this.playerY = playerY;
    }


    @Override
    public void tick() {
        //Veirify if  Left Key is pressed
        if(game.getKeyManager().isLeft()){
             if(getplayerX()> -9)   
                setplayerX(getplayerX()-1);
        }
        //Veirify if Right Key  is pressed
        if(game.getKeyManager().isRight()){
            if(getplayerX()<9)
                setplayerX(getplayerX()+1);  
        }
              
        //Veirify if   left/right Key was  pressed 
        if(getplayerX() > 1){
           setX(getX() + getplayerX());
           
        }else if(getplayerX() < -1){
           setX(getX() + getplayerX());
        }
        
        
        //Veirify if  Up Key is pressed
        if(game.getKeyManager().isUp()){
            if(getplayerY() <7)   
                setplayerY(getplayerY()+1);
        }
        //Veirify if  Down Key is pressed
        if(game.getKeyManager().isDown()){
            if(getplayerY() > -7)
                setplayerY(getplayerY()-1);
        }
        //Veirify if   up/down Key was  pressed 
        if(getplayerY() > 1){
            setY(getY() - getplayerY());
        }else if(getplayerY() < -1){
            setY(getY() - getplayerY());
        }

        /**
         * reset Xposition if collision
         */
        if(getX() + 100 >= game.getWidht()){
            setX(game.getWidht() - 120);
            setDirection(-1);
            colision = true;
            setX(getX()-4);
            playerX = -2;
        }else if(getX() <= -10){
            //back
            setX(-10);
          colision = true;
          setX(getX()+4);
          playerX = 2;
        }
        
         /**
         * reset Y position if collision
         */
         
        if(getY() + 130 >= game.getHeight()){
            setDirection(-1);
            colision = true;
             setY(getY()-2);
             playerY = +2;
        }else if(getY() <= +220){
            setY(+220); 
            colision = true;
            setY(getY()+2);
            playerY = -2;
        }
        
          
           
    }
    
        @Override
    public void render(Graphics g) {
        //Verifiies if exist any colision 
        if(colision){
            g.drawImage(Assets.crashedPlayer,getX() ,getY(), getWidth(), getHeight(), null);
            if(cont==25){
                cont = 0;
                colision = false;
            }else{
                cont++;
            }
        }else{
        g.drawImage(Assets.player,getX() ,getY(), getWidth(), getHeight(), null);
        }
        
    }

  
}
