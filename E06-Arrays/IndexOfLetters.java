package basicsyntax;

import java.util.Scanner;

public class IndexOfLetters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int[] charAsNumber = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            charAsNumber[i] = input[i] - 97;
            System.out.println(input[i] + " -> " + charAsNumber[i]);
        }
    }
}
