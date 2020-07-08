import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Implementing a frame
 */

public class GUITutorial_01{
    
    JFrame f = new JFrame(); //Instantiate a frame

    public GUITutorial_01(){
        f.setVisible(true);  //make it visible
    }
  
    public static void main(String[] args){
        new GUITutorial_01();
    }
}