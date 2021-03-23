import javax.swing.*;

/**
 * Skapat november 2020-11-24 - 10:52
 * moms
 * Skriven av coolingen
 */
public class moms {
    public static void main(String[] args) {
        double pris = Integer.parseInt(JOptionPane.showInputDialog("Hur mycket kostar varan?"));
        System.out.println("Din vara kostar inklusive moms" + totalpris);
        double totalpris = pris*1.25;

    }
}
