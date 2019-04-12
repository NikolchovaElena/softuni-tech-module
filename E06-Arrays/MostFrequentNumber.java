package basicsyntax;

import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int result = 0;
        int maxCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            int count = 0;

            for (int j = i; j < numbers.length; j++) {

                if (currentNumber == numbers[j]) {
                    count++;

                    if (count > maxCount) {
                        maxCount = count;
                        result = currentNumber;
                    }
                }
            }
        }
        System.out.print(result);
    }
}