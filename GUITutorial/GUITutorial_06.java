import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * Removes the layout manager from the panel, allowing custom placement
 */

public class GUITutorial_06{
    
    JButton btnRock     = new JButton("Rock");
    JButton btnpaper    = new JButton("Paper");
    JButton btnScissors = new JButton("Scissors");
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,300,300);
        }
    };
    
    public GUITutorial_06(){
        f.setTitle("RPS Tutorial");
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        
        setUpButtons();
        
        p.setLayout(null); //Removes the layout manager so we can position components where we want to
        p.setPreferredSize(new Dimension(300,300));
        
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
    
    public void setUpButtons(){
        btnRock.setBounds(0,250,100,50);
        btnpaper.setBounds(100,250,100,50);
        btnScissors.setBounds(200,250,100,50);
        
        p.add(btnRock);
        p.add(btnpaper);
        p.add(btnScissors);
    }
    
    public static void main(String[] args){
        new GUITutorial_06();
    }
}