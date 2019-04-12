package basicsyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = "(\\b[A-Za-z][A-Za-z0-9_]{2,24}\\b)";

        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(input);

        List<String> usernames = new ArrayList<>();

        while (m.find()) {
            usernames.add(m.group(1));
        }

        int sum = 0;
        String firstMatch = "";
        String secondMatch = "";

        for (int i = 0; i < usernames.size()- 1; i++) {
            int currentSum = usernames.get(i).length() + usernames.get(i + 1).length();

            if (currentSum > sum) {
                sum = currentSum;
                firstMatch = usernames.get(i);
                secondMatch = usernames.get(i + 1);
            }
        }
        System.out.println(firstMatch);
        System.out.println(secondMatch);
    }
}