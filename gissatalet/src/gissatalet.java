import javax.swing.*;

/**
 * Skapat november 2020-11-17 - 10:06
 * gissatalet
 * Skriven av coolingen
 */
public class gissatalet {
    public static void main(String[] args) {
        int gissning = Integer.parseInt(JOptionPane.showInputDialog("Gissa ett tal mellan 1-100"));
        int ratt = (int)(Math.random()*100);
        if (gissning == ratt) {
            System.out.println("Grattis, du gissade rätt");
        }
        else{
            System.out.println("Tyvärr, du gissade fel, talet var " + ratt);
        }
        /** while (gissning != ratt) {
            if (gissning > ratt) {
                System.out.println("Lägre");
            } else {
                System.out.println("Högre");
         */
    }
}


