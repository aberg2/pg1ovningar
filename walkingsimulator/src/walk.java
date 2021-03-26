import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Skapat mars 2021-03-23 - 11:14
 * walk
 * Skriven av coolingen
 */
public class walk extends Canvas implements Runnable {
    private int width = 800;
    private int height = 600;

    private BufferStrategy bs;

    public static void main(String[] args) {
        walk spel = new walk();
        spel.start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double deltaT = 1000.0 / fps;
        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long now = System.currentTimeMillis();
            if (now - lastTime > deltaT) {
                rita();
                lastTime = now;
            }

        }
        stop();
    }

    private Thread thread;
    int fps = 60;
    private boolean isRunning;
    private boolean isFinished;

    public walk() { //fönstret
        JFrame frame = new JFrame("Walking Simulator");
        this.setSize(width, height);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.addKeyListener(new KL());

        gubbex = 200;
        gubbey = 370;
        gubbed = 0;
        gubbew = 0;
        pelarex = 600;
        pelarey = 370;

        isFinished = false;
        try {
            gubbe = ImageIO.read(new File("RUN_003.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //sprittar
    private BufferedImage gubbe;
    private int gubbex, gubbey,gubbed,gubbew;

    private int pelarex,pelarey;

    public void rita() { // vad som ska ritas
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(4);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //

        g.setColor(Color.blue);
        g.fillRect(0,0,width, height);
        golv(g,0,0);
        g.drawImage(gubbe,gubbex,gubbey,80,80,null);
        pelare(g, 200,200);


        //
        collisions(g);
        g.dispose();
        bs.show();
            }

    public void collisions(Graphics g){
        if (gubbex == pelarex) {

            isFinished = true;
            gubbex += gubbed;
            gubbey += gubbew;
        }
        if (isFinished){
            JOptionPane.showMessageDialog(null,"Du klarade banan");
        }
    }
    private void golv(Graphics g, int x, int y) {
        g.setColor(new Color(0xFF45FF33, true));
        g.fillRect(0, 450, 800, 150);

    }
    private void pelare(Graphics g, int x, int y){
        g.setColor(new Color(0xFF2C2C));
        g.fillRect(pelarex,pelarey,10,80);
    }
    private void gubbe(Graphics g, int x, int y){
        g.setColor(new Color(0xFFB856));


        g.fillOval(200+x,200+y,25,25);
        g.fillRect(208+x,220+y,9,35);
        g.fillRect(208+x,230+y,35,9);
        g.fillRect(185+x,230+y,35,9);

    }

    private class KL implements KeyListener {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar()=='d'){
                gubbed = 5;
            }
            if (keyEvent.getKeyChar()=='a'){
                gubbed = -5;
            }
            if (keyEvent.getKeyChar()=='w'){
                gubbew = -5;
            }
            if (keyEvent.getKeyChar()=='s'){
                gubbew = 5;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar()=='d'){
                gubbed = 0;
            }
            if (keyEvent.getKeyChar()=='a'){
                gubbed = -0;
            }
            if (keyEvent.getKeyChar()=='w'){
                gubbew = 0;
            }
            if (keyEvent.getKeyChar()=='s'){
                gubbew = -0;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }
}
