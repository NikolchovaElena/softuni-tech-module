package basicsyntax;

import java.util.Scanner;
//Score 90/100
public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("\\s+", " ");
        String[] word = input.split(" ");

        double result = 0;

        for (int i = 0; i < word.length; i++) {
            String currentWord = word[i];
            char before = currentWord.charAt(0);
            char after = currentWord.charAt(currentWord.length() - 1);
            int number = Integer.parseInt(currentWord.substring(1, currentWord.length() - 1));

            result += GetResult(before, after, number);
        }
        System.out.printf("%.2f", result);

    }

    static double GetResult(char before, char after, int number) {
        double result = 0;

        if ((int) before >= 65 && (int) before <= 90) {
            result =1.0* number / ((int) before - 64);
        } else {
            result = number * ((int) before - 96);
            // 65-90 // 97-122
        }

        if ((int) after >= 65 && (int) after <= 90) {
            result = result - ((int) after - 64);
        } else {
            result = result + ((int) after - 96);
            // 65-90 // 97-122
        }
        return result;
    }
}
