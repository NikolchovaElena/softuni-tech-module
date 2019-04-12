package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] arr1 = scanner.nextLine().replaceAll(" ", "").toCharArray();
        char[] arr2 = scanner.nextLine().replaceAll(" ", "").toCharArray();

        boolean isFirst = false;

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {

            if (arr1[i] != arr2[i]) {
                if (arr1[i] < arr2[i]) {
                    isFirst = true;
                } else {
                    break;
                }
            }
        }

        if (isFirst || arr1.length < arr2.length) {
            System.out.print(Arrays.toString(arr1).replaceAll("\\[|\\]", "").replaceAll(",", "").replaceAll(" ", ""));
            System.out.println();
            System.out.print(Arrays.toString(arr2).replaceAll("\\[|\\]", "").replaceAll(",", "").replaceAll(" ", ""));
        } else {
            System.out.print(Arrays.toString(arr2).replaceAll("\\[|\\]", "").replaceAll(",", "").replaceAll(" ", ""));
            System.out.println();
            System.out.print(Arrays.toString(arr1).replaceAll("\\[|\\]", "").replaceAll(",", "").replaceAll(" ", ""));
        }
    }

}