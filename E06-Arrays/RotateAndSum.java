package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class RotateAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] originalArray = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        int[] sum = new int[originalArray.length];

        for (int r = 0; r < n; r++) {
            int lastDigit = originalArray[originalArray.length - 1];

            for (int i = originalArray.length - 1; i > 0; i--) {
                originalArray[i] = originalArray[i - 1];
                sum[i] += originalArray[i];
            }
            originalArray[0] = lastDigit;
            sum[0] += originalArray[0];

        }
        String result = Arrays.toString(sum).replaceAll("\\[|\\]", "");
        result = result.replaceAll(",", "");
        System.out.print(result);
    }
}
