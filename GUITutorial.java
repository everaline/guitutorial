import java.util.Random; //Allows getting random input for the computer AI
import javax.swing.*;    //Contains most of the GUI elements we will be using
import java.awt.*;       //Contains things such as the graphics object that we need
import java.awt.event.*; //Allows getting user input via buttons

import java.awt.image.BufferedImage; //Stores An Image to display
import javax.imageio.ImageIO;        //Has methods for getting images
import java.io.File;                 //The object that tells the ImageIO where to look

public class GUITutorial implements ActionListener{
    
    enum Choice{ROCK,PAPER,SCISSORS};
    
    Choice computerChoice = Choice.ROCK;
    Choice userChoice = Choice.ROCK;
    
    Random rand = new Random();
    
    JFrame f = new JFrame();
    
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
    
    JPanel p = new JPanel(){
        
        @Override
        public void paintComponent(Graphics g){
            
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
    
    public GUITutorial(){
        
        f.setTitle("RPS Tutorial");
        
        p.setLayout(null);
        p.setPreferredSize(new Dimension(300,300));
        
        f.add(p);
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        
        setUpImages();
        setUpMenu();
        setUpButtons();
        
        f.setVisible(true);
        f.pack();
    }
    
    public void setUpImages(){
        
        try{
            userImages = new BufferedImage[3];
            userImages[0] = ImageIO.read(new File("playerRock.png"));
            userImages[1] = ImageIO.read(new File("playerpaper.png"));
            userImages[2] = ImageIO.read(new File("playerScissors.png"));
            
            computerImages = new BufferedImage[3];
            computerImages[0] = ImageIO.read(new File("computerRock.png"));
            computerImages[1] = ImageIO.read(new File("computerpaper.png"));
            computerImages[2] = ImageIO.read(new File("computerScissors.png"));
        }catch (Exception e){}
    }
    
    public void setUpMenu(){
        f.setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuFile.add(btnReset);
        btnReset.addActionListener(this);
        menuFile.add(btnQuit);
        btnQuit.addActionListener(this);
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
        else if(e.getSource()==btnReset){
            userChoice = Choice.ROCK;
            computerChoice = Choice.ROCK;
            userWins = 0;
            computerWins = 0;
            verdict = "No Games Played";
        }
        else if(e.getSource()==btnQuit){
            System.exit(0);
        }
        
    
        p.repaint();
        f.revalidate();
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
        new GUITutorial();
    }
}