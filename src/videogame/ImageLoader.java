/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alextrujillo
 */
public class ImageLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
    To get an image from the file path
    @param path it is the path of the file
    @return the <code> BufferedImage </code> object
    */
    public static BufferedImage loadImage(String path) { 
         System.out.println("Iniciando...");
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(ImageLoader.class.getResource(path));
            //System.out.println(bi);
        } catch (IOException ioe) {
            System.out.println("Error loading image " + path + ioe.toString()); 
            System.exit(1);
        }
        return bi;
        }
    
}
