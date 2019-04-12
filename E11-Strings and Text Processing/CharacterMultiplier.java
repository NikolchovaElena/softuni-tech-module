package basicsyntax;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String str1 = input[0];
        String str2 = input[1];
        int sum = 0;

        int length = Math.min(str1.length(), str2.length());

        for (int i = 0; i < length; i++) {

            int sum1 = (int) str1.charAt(i);
            int sum2 = (int) str2.charAt(i);
            sum += sum1 * sum2;

        }
        int max = Math.max(str1.length(), str2.length());
        String maxNum = "";
        if (str1.length() > str2.length()) {
            maxNum = str1;
        } else {
            maxNum = str2;
        }

        if ((str1.length() - str2.length()) != 0) {
            for (int i = max; i > length; i--) {

                sum += (int) maxNum.charAt(i-1);
            }
        }
        System.out.println(sum);

    }
}
