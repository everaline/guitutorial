import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Adds a panel,sets its size and packs the frame around it
 */

public class GUITutorial_02{
    
    JFrame f = new JFrame();
    
    JPanel p = new JPanel(); //Instantiate a panel
        
    public GUITutorial_02(){
        
        p.setPreferredSize(new Dimension(300,300));  //decide on the size you want your display area to be
        f.add(p);                                    //add the panel to the frame
        f.setVisible(true);
        f.pack();                                    //Let the the layout manager set the frame to the correct size
    }
  
    public static void main(String[] args){
        new GUITutorial_02();
    }
}