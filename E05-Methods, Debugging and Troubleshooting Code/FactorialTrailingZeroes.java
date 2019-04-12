package basicsyntax;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger fact = CalculateFactorial(n);
        System.out.print(GetTrailingZeroes(fact));
    }

    static BigInteger CalculateFactorial(int num) {
        int zeroCounter = 0;
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = num; i > 0; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }

    static int GetTrailingZeroes(BigInteger num) {
        String numAsString = num.toString();
        int counter = 0;

        while (numAsString.endsWith("0")) {
            counter++;
            numAsString=numAsString.substring(0,numAsString.length()-1);
        }
        return counter;
    }
}
