package basicsyntax;

import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);

        }
        int start = 0;
        int currentLength = 1;
        int maxLength = 1;
        int maxStart = 0;

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] > numbers[i-1]) {
                currentLength++;

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = start;
                }
            } else {
                currentLength = 1;
                start = i;
            }
        }
        for (int i = maxStart; i < maxStart + maxLength; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
