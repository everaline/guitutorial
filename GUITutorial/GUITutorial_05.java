import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * Adds buttons to the screen
 */

public class GUITutorial_05{
    
    JButton btnRock     = new JButton("Rock");     //A Rock button     |
    JButton btnpaper    = new JButton("Paper");    //A Paper button    |-Paramater appears on the button
    JButton btnScissors = new JButton("Scissors"); //A Scissors button |
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,300,300);
        }
    };
        
    public GUITutorial_05(){
        f.setTitle("RPS Tutorial");
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        
        setUpButtons(); //Sets up the buttons in a new method, as its a lengthy process
        
        p.setPreferredSize(new Dimension(300,300));
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
    
    public void setUpButtons(){
        btnRock.setBounds(0,250,100,50);      //|
        btnpaper.setBounds(100,250,100,50);   //|-sets the location, then size of each button
        btnScissors.setBounds(200,250,100,50);//|
        
        p.add(btnRock);     //|
        p.add(btnpaper);    //|-Add each button to the panel (not the frame!)
        p.add(btnScissors); //|
    }
  
    public static void main(String[] args){
        new GUITutorial_05();
    }
}