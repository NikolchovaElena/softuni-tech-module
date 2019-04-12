package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class FoldAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] inputArray = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

        int[] middleArray = new int[inputArray.length / 2];
        int[] outsideArray = new int[inputArray.length / 2];

        for (int i = 0; i < middleArray.length; i++) {
            middleArray[i] = inputArray[(inputArray.length / 4) + i];
        }

        for (int i = 0; i < outsideArray.length; i++) {

            if (i < outsideArray.length / 2) {
                outsideArray[i] = inputArray[inputArray.length / 4 - 1 - i];
            } else {
                int j = i - outsideArray.length / 2;
                outsideArray[i] = inputArray[inputArray.length - 1 - j];
            }
        }

        int sum[] = new int[middleArray.length];
        for (int i = 0; i < middleArray.length; i++) {
            sum[i] = middleArray[i] + outsideArray[i];
        }

        String result = Arrays.toString(sum).replaceAll("\\[|\\]", "");
        result = result.replaceAll(",", "");
        System.out.print(result);
    }
}
