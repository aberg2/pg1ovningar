import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


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
        walk painting = new walk();
        painting.start();
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


    public walk() { //fönstret
        JFrame frame = new JFrame("Walking Simulator");
        this.setSize(width, height);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void rita() { // vad som ska ritas
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(4);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        golv(g,0,0);
        gubbe(g,222,222);

        g.dispose();
        bs.show();
    }

    private void golv(Graphics g, int x, int y) {
        g.setColor(new Color(0x000000));
        g.fillRect(0, 450, 800, 150);

    }
    private void gubbe(Graphics g, int x, int y){
        g.setColor(new Color(0xFFB856));
        g.fillOval(200+x,200+y,25,25);
        g.fillRect(208+x,220+y,9,35);
    }
}
