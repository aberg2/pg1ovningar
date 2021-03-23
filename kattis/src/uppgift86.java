/**
 * Skapat november 2020-11-24 - 10:11
 * uppgift86
 * Skriven av coolingen
 */
public class uppgift86 {
    public static void main(String[] args) {
        double svar = nfak(1);
        System.out.println("200! är lika med " + svar);

        double binomial = binomialKoeff(5,3);
        System.out.println(binomial);
    }

    private static double binomialKoeff(int n, int k) {
        return nfak(n)/(nfak(k)*(n-k));
    }

    private static double nfak(int n) {
        double result = 1;
        for (int i = 2 ; i <=n ; i++){
            result *= i;

        }
        return result;
    }
}
