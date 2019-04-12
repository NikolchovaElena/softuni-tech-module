package basicsyntax;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        if (IsPrime(n)) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }

    static boolean IsPrime(long num) {
        boolean isTrue = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isTrue = false;
            }
        }
        if (num == 0 || num == 1) {
            isTrue = false;
        }
        return isTrue;
    }
}