/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author alextrujillo
 */
public class Assets {

    /**
     *  background Image
     */
    public static BufferedImage background; // to store background image 

    /**
     * Normal player image
     */
    public static BufferedImage player;	// to store the player image

    /**
     *
     * crash player
     */
    public static BufferedImage crashedPlayer;

    
    /**
    initializing the game images
    */
    public static void init() {
    background = ImageLoader.loadImage("/images/fondo.png"); 
    player = ImageLoader.loadImage("/images/auto.png");
    crashedPlayer = ImageLoader.loadImage("/images/auto_crashed.png");

    }
 

   
}
