import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Overrides the Panels graphics, allowing drawing to the screen
 */

public class GUITutorial_03{
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(){
        @Override                               //Indicates that paintComponent already exists in JPanel
        public void paintComponent(Graphics g){ //The method which allows us to draw to the screen
            super.paintComponent(g);            //Call's the original painComponent, not needed in this case
            g.setColor(Color.BLACK);            //Sets Colour to black
            g.fillRect(0,0,300,300);            //draws a rectangle background
        }
    };
        
    public GUITutorial_03(){
        p.setPreferredSize(new Dimension(300,300));
        f.add(p);
        f.setVisible(true);
        f.pack();     
    }
  
    public static void main(String[] args){
        new GUITutorial_03();
    }
}