package basicsyntax;

import java.util.ArrayList;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }
        String result1 = result.toString().replaceAll("\\[|\\]", "");
        result1 = result1.replaceAll(",", "");
        System.out.println(result1);
    }
}