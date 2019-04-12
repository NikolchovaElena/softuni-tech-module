package basicsyntax;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Fib(num);
    }

    static void Fib(int n) {
        int f1 = 1;
        int f2 = 1;
        int sum;

        for (int i = 1; i < n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        System.out.print(f2);
    }
}