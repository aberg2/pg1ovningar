import javax.swing.*;

/**
 * Skapat oktober 2020-10-20 - 10:44
 * godsätning
 * Skriven av coolingen
 */
public class godsatning {
    public static void main(String[] args) {
        long antalGelenappar = Integer.parseInt(JOptionPane.showInputDialog("HUr många hnappar har du"));
        for (long i = antalGelenappar ; i > 0 ; i--) {
            System.out.println("Nu åt jag en napp!");
        }
        System.out.println("Nu är påsen tom!");
        }
    }

