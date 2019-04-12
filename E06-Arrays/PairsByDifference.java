package basicsyntax;

import java.util.Scanner;

public class PairsByDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int diff = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i; j < numbers.length; j++) {
                if (Math.abs(numbers[i] - numbers[j]) == diff) {
                    count++;
                }
            }
        }
        System.out.print(count);

    }
}
