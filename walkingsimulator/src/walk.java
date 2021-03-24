import javax.swing.*;
import java.awt.*;


/**
 * Skapat mars 2021-03-23 - 11:14
 * walk
 * Skriven av coolingen
 */
public class walk extends Canvas implements Runnable{
    private int width = 800;
    private int height = 600;


    public walk() {
        JFrame frame = new JFrame("Walking Simulator");
        this.setSize(width, height);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void ritning(){
        Graphics g = bs.getDrawGraphics();

    }
    @Override
    public void run() {

    }
}
