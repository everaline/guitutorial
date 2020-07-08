import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Adds functionality to the menu buttons, completing the game
 */

public class GUITutorial_15 implements ActionListener{
    
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
    
    JMenuBar  menuBar  = new JMenuBar();
    JMenu     menuFile = new JMenu("File");
    JMenuItem btnReset = new JMenuItem("Reset"); 
    JMenuItem btnQuit  = new JMenuItem("Quit");
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,300,300);
            
            g.drawImage(userImages[userChoice.ordinal()],0,0,150,200,null);
            g.drawImage(computerImages[computerChoice.ordinal()],150,0,150,200,null);
            
            g.setColor(fontColor);
            g.drawString(verdict,150-(verdict.length()*4),225);
            g.setColor(Color.YELLOW);
            g.drawString("" + userWins,25,225);
            g.setColor(Color.RED);
            g.drawString("" + computerWins,250,225);
        }
    };
    
    public GUITutorial_15(){
        f.setTitle("RPS Tutorial");
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        
        setUpImages();
        setUpButtons();
        setUpMenu();
        
        p.setLayout(null);
        p.setPreferredSize(new Dimension(300,300));
        
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
    
    public void setUpMenu(){
        f.setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuFile.add(btnReset);
        menuFile.add(btnQuit);
        
        btnReset.addActionListener(this);    //Allows listening to when the Reset button is pressed
        btnQuit.addActionListener(this);     //Allows listening to when the Quit button is pressed
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
        else if(e.getSource()==btnReset){   //When Reset is pressed
            userChoice = Choice.ROCK;       //|
            computerChoice = Choice.ROCK;   //|
            userWins = 0;                   //|-Set everything back to how it was at the start of the game
            computerWins = 0;               //|
            fontColor = Color.WHITE;        //|
            verdict = "No Games Played";    //|
        }
        else if(e.getSource()==btnQuit){ //When Quit is pressed
            System.exit(0);              //Quit the game
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
        new GUITutorial_15();
    }
}