package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class JumpAround {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < arr.length;) {

            int steps = arr[i];
            sum += arr[i];

            if (i + steps < arr.length) {
                i = i + steps;

            } else if (i - steps >= 0) {
                i = i - steps;
            } else {
                break;
            }
        }
        System.out.print(sum);
    }
}
