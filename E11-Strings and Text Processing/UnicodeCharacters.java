package basicsyntax;

import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        for (char c : input) {
            String hex = String.format("%04x", (int) c);
            System.out.printf("\\u%s", hex);
        }
    }
}
