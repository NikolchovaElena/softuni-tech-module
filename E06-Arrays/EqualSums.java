package basicsyntax;

import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        if (numbers.length == 1) {
            System.out.print("0");
            return;
        }
        if (numbers.length == 2) {
            if (numbers[0] == numbers[1]) {
                System.out.print("1");
            } else {
                System.out.print("no");
            }
            return;
        }

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < numbers.length; i++) {

            for (int left = 0; left < i; left++) {
                leftSum += numbers[left];
            }
            for (int right = i + 1; right < numbers.length; right++) {
                rightSum += numbers[right];
            }
            if (leftSum == rightSum) {
                System.out.print(i);
                return;
            }
            leftSum = 0;
            rightSum = 0;
        }
        System.out.print("no");

    }
}