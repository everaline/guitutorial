import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Performs some common frame functions
 */

public class GUITutorial_04{
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,300,300);
        }
    };
        
    public GUITutorial_04(){
        f.setTitle("RPS Tutorial"); //Sets the text for the title bar
        f.setResizable(false);      //Makes it so you cant drag to resize the window
        f.setAlwaysOnTop(true);     //makes it so no other window can be in front of it
        
        p.setPreferredSize(new Dimension(300,300));
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
    
    public static void main(String[] args){
        new GUITutorial_04();
    }
}