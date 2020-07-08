import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Keeps track of victories, and displays them on the screen
 */

public class GUITutorial_11 implements ActionListener{
    
    enum Choice{ROCK,PAPER,SCISSORS};
    
    Choice computerChoice = Choice.ROCK;
    Choice userChoice = Choice.ROCK;
    
    Random rand = new Random();
    
    JButton btnRock     = new JButton("Rock");
    JButton btnpaper    = new JButton("Paper");
    JButton btnScissors = new JButton("Scissors");
    
    int userWins = 0;      //keeps track of user wins
    int computerWins = 0;  //keeps track of computer wins
    
    Color fontColor = Color.WHITE;
    String verdict = "No Games Played";
    
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
            
            g.setColor(fontColor);
            g.drawString(verdict,150-(verdict.length()*4),225);
            g.setColor(Color.YELLOW);                           //Sets font yellow for user win count
            g.drawString("" + userWins,25,225);                 //draws user wins left of the screen
            g.setColor(Color.RED);                              //Sets font red for computer win count
            g.drawString("" + computerWins,250,225);            //draws computer wins right of the screen
        }
    };
    
    public GUITutorial_11(){
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
        
        if(userChoice==computerChoice){
            fontColor =Color.WHITE;
            verdict = "Tie";
        }
        else if((userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                (userChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||
                (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)){
            fontColor =Color.YELLOW;
            verdict = "User wins";
            userWins++;                          //increases user wins
        }
        else{
            fontColor = Color.RED;
            verdict = "Computer wins";
            computerWins++;                      //increases computer wins
        }
    }
    
    public static void main(String[] args){
        new GUITutorial_11();
    }
}