import javax.swing.*;

/**
 * Skapat november 2020-11-13 - 10:22
 * inputvalidering
 * Skriven av coolingen
 */
public class inputvalidering {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("Skriv in dina tal");
        String[] allatal = s.split(",");
        System.out.println(allatal.length);
        System.out.println(allatal[0] + " är ditt första tal");

        for (int i = 0 ; i < allatal.length-1 ; i++) {
            System.out.println(allatal[i]);
            System.out.println(allatal[i+1]);
            if (Integer.parseInt(allatal[i])>Integer.parseInt(allatal[i+1])) {
                System.out.println("Talen är inte sorterade");
            }
        }
        int a = Integer.parseInt(s);

    }
}
