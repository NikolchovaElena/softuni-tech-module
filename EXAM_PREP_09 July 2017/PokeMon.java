package basicsyntax;

import java.math.BigInteger;
import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = new BigInteger(scanner.nextLine());
        BigInteger m = new BigInteger(scanner.nextLine());
        BigInteger y = new BigInteger(scanner.nextLine());

        BigInteger original = n.divide(BigInteger.valueOf(2));
        BigInteger temp = original.multiply(BigInteger.valueOf(2));
        boolean isInt = false;

        if (temp.compareTo(n)==0) {
            isInt = true;
        }

        int count = 0;

        while (n.compareTo(m) == 1 || n.compareTo(m) == 0) {

            n = n.subtract(m);
            count++;

            if (isInt && n.compareTo(original)==0&&y.compareTo(BigInteger.ZERO)!=0) {
                n = n.divide(y);

            }

        }
        System.out.println(n);
        System.out.println(count);
    }
}
