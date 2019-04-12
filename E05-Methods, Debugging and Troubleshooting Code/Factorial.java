package basicsyntax;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        CalculateFactorial(n);
    }

    static void CalculateFactorial(int num) {
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = num; i > 0; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        System.out.print(sum);
    }
}