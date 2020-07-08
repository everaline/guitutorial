import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Extends a JFrame then sets it to visible
 */

public class GUITutorial_01_ALT extends JFrame{ //Inherit all methods from Frame

    public GUITutorial_01_ALT(){
        setVisible(true);       //call the inherited setVisible method
    }
  
    public static void main(String[] args){
        new GUITutorial_01_ALT();
    }
}