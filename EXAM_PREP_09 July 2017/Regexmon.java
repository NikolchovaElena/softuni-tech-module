package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexmon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern regex1 = Pattern.compile("[^A-Za-z-]+");
        Pattern regex2 = Pattern.compile("[A-Za-z]+-[A-Za-z]+");

        while (true) {

            Matcher m1 = regex1.matcher(text);

            if (m1.find()) {
                System.out.println(m1.group(0));
                text=text.substring(text.indexOf(m1.group(0)) + m1.group(0).length());

            } else {

                break;
            }

            Matcher m2 = regex2.matcher(text);

            if (m2.find()) {
                System.out.println(m2.group(0));
                text=text.substring(text.indexOf(m2.group(0)) + m2.group(0).length());
            } else {
                break;
            }
        }
    }
}
