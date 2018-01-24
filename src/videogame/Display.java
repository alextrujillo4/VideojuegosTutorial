/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;
import	java.awt.Canvas;
import java.awt.Dimension;
import	javax.swing.JFrame;


/**
 *
 * @author alextrujillo
 */
public class Display {
    private JFrame jframe;     //this is the app class
    private Canvas canvas;     //to display images
    private String title; //Tittle of the window
    private int width; // width of the window
    private int height; // height of the window
    
    /**
     * 
     * @param title to display the title of the window
     * @param width to set the with
     * @param height  to set the height
     */
  
    public Display(String title, int width, int height)	{
        this.title = title;
        this.width = width;
        this.height = height;								
        createDisplay();
    
    }
    
    /**
     * Creates the app and canvas and add the canvas to the windowapp
     */
    public void createDisplay(){
    jframe = new JFrame(title);
    		
    //set the size of the window
    jframe.setSize(width,height);

    //setting not resizable, visible and possible to close
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setResizable(false);
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);

    //creating the canvas t  paint & setting	size
    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setFocusable(false);

    //adding the canvas to the app window and packing to get the right dimensions
    jframe.add(canvas);
    jframe.pack();
    
    }
    
    /**
    * To get the canvas of the game
    *@return the canvas
    */
    public Canvas getCanvas(){
        return  canvas;
    }
    
    /**
     * To get the jFrame Game
     * @return jFrame
     */
    public JFrame  getJframe(){
        return jframe;
    }
}
