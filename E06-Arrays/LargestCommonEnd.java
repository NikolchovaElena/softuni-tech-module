package basicsyntax;

import java.util.Scanner;

public class LargestCommonEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text1 = scanner.nextLine().split(" ");
        String[] text2 = scanner.nextLine().split(" ");

        int counter = 0;
        for (int i = 0; i < Math.min(text2.length, text1.length); i++) {
            if (text1[i].equals(text2[i])) {
                counter++;
            } else if (text1[text1.length - 1 - i].equals(text2[text2.length - 1 - i])) {
                counter++;
            } else {
                break;
            }
        }
        System.out.print(counter);
    }
}
