package basicsyntax;

import java.util.Scanner;

public class MaxMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();

        int max = GetMax(firstNumber, secondNumber);
        max= GetMax(max, thirdNumber);

        System.out.print(max);
    }

    static int GetMax(int a, int b) {

        int number = Math.max(a, b);
        return number;
    }
}