import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Calculates and displays who wins a game
 */

public class GUITutorial_10 implements ActionListener{
    
    enum Choice{ROCK,PAPER,SCISSORS};
    
    Choice computerChoice = Choice.ROCK;
    Choice userChoice = Choice.ROCK;
    
    Random rand = new Random();
    
    JButton btnRock     = new JButton("Rock");
    JButton btnpaper    = new JButton("Paper");
    JButton btnScissors = new JButton("Scissors");
    
    Color fontColor = Color.WHITE;       //Allows changing the colour depending on who wins
    String verdict = "No Games Played";  //The text containing who wins
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,300,300);
            g.setColor(Color.WHITE);
            g.drawString("User Choice: " + userChoice,16,16);
            g.drawString("Computer Choice: " + computerChoice,16,32);
            
            g.setColor(fontColor);                              //sets the colour to represent who wins
            g.drawString(verdict,150-(verdict.length()*4),225); //displays who wins
        }
    };
    
    public GUITutorial_10(){
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
            userChoice = Choice.ROCK;
            endTurn();
        }
        else if(e.getSource()==btnpaper){
            userChoice = Choice.PAPER;
            endTurn();
        }
        else if(e.getSource()==btnScissors){
            userChoice = Choice.SCISSORS;
            endTurn();
        }
        
        p.repaint();
    }
    
    public void endTurn(){
        
        computerChoice = Choice.values()[rand.nextInt(3)];
        
        if(userChoice==computerChoice){  //If both choices are the same, it's a tie
            fontColor =Color.WHITE;      //Tie colour is white
            verdict = "Tie";             //Display Tie
        }
        else if((userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||  //|
                (userChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||     //|-If the user wins
                (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)){  //|
            fontColor =Color.YELLOW;     //User colour is yellow
            verdict = "User wins";       //Display User Wins
        }
        else{                            //If the user loses
            fontColor = Color.RED;       //Computer colour is red
            verdict = "Computer wins";   //Display Computer Wins
        }
    }
    
    public static void main(String[] args){
        new GUITutorial_10();
    }
}