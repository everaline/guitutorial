import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Enables Rock Paper Scissors inputs, and enables computer choice
 */

public class GUITutorial_08 implements ActionListener{
    
    enum Choice{ROCK,PAPER,SCISSORS};    //The choices available 
    
    Choice computerChoice = Choice.ROCK; //The computers choice
    Choice userChoice = Choice.ROCK;     //The users choice
    
    Random rand = new Random();          //To generate the computers choice
    
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
            g.setColor(Color.WHITE);                                  //Sets the colour to white so we can see it
            g.drawString("User Choice: " + userChoice,16,16);         //Draws user choice
            g.drawString("Computer Choice: " + computerChoice,16,32); //Draws computer choice
            
        }
    };
    
    public GUITutorial_08(){
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
        
        btnRock.addActionListener(this);
        btnpaper.addActionListener(this);
        btnScissors.addActionListener(this);
        
        p.add(btnRock);
        p.add(btnpaper);
        p.add(btnScissors);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnRock){
            userChoice = Choice.ROCK;         //set user choice to rock
            endTurn();                        //do computer logic
        }
        else if(e.getSource()==btnpaper){
            userChoice = Choice.PAPER;        //set user choice to paper
            endTurn();                        //do computer logic
        }
        else if(e.getSource()==btnScissors){
            userChoice = Choice.SCISSORS;    //set user choice to scissors
            endTurn();                       //do computer logic
        }
    }
    
    public void endTurn(){
        
        computerChoice = Choice.values()[rand.nextInt(3)];   //Make the computer choose one of the choices at random
    }
    
    public static void main(String[] args){
        new GUITutorial_08();
    }
}