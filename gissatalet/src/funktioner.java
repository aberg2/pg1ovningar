/**
 * Skapat november 2020-11-20 - 10:22
 * funktioner
 * Skriven av coolingen
 */
public class funktioner {
    static double medelvärde(double x, double y) {
        return (x+y)/2;
    }
    public static boolean isPalindrom(String text) {
        int index = 0;
        while (index<=text.length()/2){
            if (text.charAt(index)!=text.charAt(text.length()-1-index)){
                return false;
            }
            index++;
        }

        return true;
    }
}
