import javax.swing.*;

public class boka {
    public static void main(String[] arg) {

        int knappNr = JOptionPane.showConfirmDialog(null, "Vill åka bort på en trevlig resa med din käraste");

        String dagar = "Hur många dagar vill ni vara bortrest";
        if (knappNr == 0) {
            String antal = JOptionPane.showInputDialog(null, dagar);
            int pris = 1150;
            int antal1 = Integer.parseInt((antal));
            JOptionPane.showMessageDialog(null, "Då blir eran totala kostnad " + pris * antal1);

        } else if (knappNr == 1) {
            String anledning = JOptionPane.showInputDialog(null, "Varför inte? :(");
            JOptionPane.showMessageDialog(null, "Ditt svar = " + anledning + "\nOkej, vi ska tänka på det tills nästa gång");

        } else {
            JOptionPane.showMessageDialog(null, "Bokning avbruten");
            System.exit(0);
        }
    }
}
