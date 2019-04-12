package basicsyntax;

import java.util.Scanner;

public class GrabAndGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numArray = new int[input.length];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(input[i]);
        }

        int specialNum = Integer.parseInt(scanner.nextLine());
        long sum = 0;
        int count = 0;
        boolean isThere = false;

        for (int i = numArray.length - 1; i > 0; i--) {
            count++;

            if (numArray[i] == specialNum) {
                isThere = true;

                for (int j = numArray.length - 1 - count; j >= 0; j--) {
                    sum += numArray[j];
                }
                break;
            }
        }

        if (isThere) {
            System.out.print(sum);
        } else {
            System.out.print("No occurrences were found!");
        }
    }
}
