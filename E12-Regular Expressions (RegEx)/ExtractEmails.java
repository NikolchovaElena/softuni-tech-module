package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = "(?<=\\s)([a-zA-Z0-9]+)([\\.\\-_]?)([A-Za-z0-9]+)*@([a-zA-Z]+([\\.\\-_][A-Za-z]+)+)(\\b|(?=\\s))";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            System.out.println();
        }
    }
}