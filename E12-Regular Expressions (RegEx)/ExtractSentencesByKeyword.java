package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractSentencesByKeyword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String[] input = scanner.nextLine().split("\\.|\\?|\\!");
        String pattern = ("\\b(" + word + ")\\b");
        Pattern regex = Pattern.compile(pattern);

        for (int i = 0; i < input.length; i++) {

            Matcher matcher = regex.matcher(input[i]);
            if (matcher.find()) {
                System.out.println(input[i].trim());
            }
        }
    }
}