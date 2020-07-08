import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * Adds listeners to the buttons, allowing user input
 */

public class GUITutorial_07 implements ActionListener{ //Allows us to start hearing user input Events
    
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
    
    public GUITutorial_07(){
        f.setTitle("RPS Tutorial");
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        
        setUpButtons();
        
        p.setLayout(null);
        p.setPreferredSize(new Dimension(300,300));
        
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
    
    public void setUpButtons(){
        btnRock.setBounds(0,250,100,50);
        btnpaper.setBounds(100,250,100,50);
        btnScissors.setBounds(200,250,100,50);
        
        btnRock.addActionListener(this);     //|   | Tells each button to call the actionPerformed
        btnpaper.addActionListener(this);    //|---| actionPerformed method in this class when pressed
        btnScissors.addActionListener(this); //|
        
        p.add(btnRock);
        p.add(btnpaper);
        p.add(btnScissors);
    }
    
    @Override  //Add for good measure
    public void actionPerformed(ActionEvent e){
        System.exit(0); //Quits the game when any button is pressed
    }
    
    public static void main(String[] args){
        new GUITutorial_07();
    }
}