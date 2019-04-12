package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String text = scanner.nextLine();

        String keyPattern = "\\b(\\w+)[\\|\\<\\\\].*[\\|\\<\\\\](\\w+)";
        Pattern regex = Pattern.compile(keyPattern);
        Matcher m = regex.matcher(keyString);
        boolean isTrue = m.find();

        String start = m.group(1);
        String end = m.group(2);

        String textPattern = start + "(.*?)" + end;
        Pattern regex2 = Pattern.compile(textPattern);
        Matcher m2 = regex2.matcher(text);

        StringBuilder sb = new StringBuilder();

        while (m2.find()) {
            sb.append(m2.group(1));
        }
        if (sb.length() != 0) {
            System.out.print(sb);
        } else {
            System.out.print("Empty result");
        }
    }
}