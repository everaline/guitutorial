import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Uses the enums ordinal to draw the correct image to the screen.
 */

public class GUITutorial_13 implements ActionListener{
    
    enum Choice{ROCK,PAPER,SCISSORS}; 
    
    Choice computerChoice = Choice.ROCK;
    Choice userChoice = Choice.ROCK;
    
    Random rand = new Random();
    
    JButton btnRock     = new JButton("Rock");
    JButton btnpaper    = new JButton("Paper");
    JButton btnScissors = new JButton("Scissors");
    
    int userWins = 0;
    int computerWins = 0;
    
    Color fontColor = Color.WHITE;
    String verdict = "No Games Played";
    
    BufferedImage[] userImages;
    BufferedImage[] computerImages;
    
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
            
            g.drawImage(userImages[userChoice.ordinal()],0,0,150,200,null);           //Display the correct image
            g.drawImage(computerImages[computerChoice.ordinal()],150,0,150,200,null); //Display the correct image
            
            g.setColor(fontColor);
            g.drawString(verdict,150-(verdict.length()*4),225);
            g.setColor(Color.YELLOW);
            g.drawString("" + userWins,25,225);
            g.setColor(Color.RED);
            g.drawString("" + computerWins,250,225);
        }
    };
    
    public GUITutorial_13(){
        f.setTitle("RPS Tutorial");
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        
        setUpImages();
        setUpButtons();
        
        p.setLayout(null);
        p.setPreferredSize(new Dimension(300,300));
        
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
    
    public void setUpImages(){
        
        try{
            userImages = new BufferedImage[3];
            userImages[0] = ImageIO.read(new File("playerRock.png"));
            userImages[1] = ImageIO.read(new File("playerPaper.png"));
            userImages[2] = ImageIO.read(new File("playerScissors.png"));
            
            computerImages = new BufferedImage[3];
            computerImages[0] = ImageIO.read(new File("computerRock.png"));
            computerImages[1] = ImageIO.read(new File("computerPaper.png"));
            computerImages[2] = ImageIO.read(new File("computerScissors.png"));
        }catch (Exception e){}
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
            userWins++;
        }
        else{
            fontColor = Color.RED;
            verdict = "Computer wins";
            computerWins++;
        }
    }
    
    public static void main(String[] args){
        new GUITutorial_13();
    }
}