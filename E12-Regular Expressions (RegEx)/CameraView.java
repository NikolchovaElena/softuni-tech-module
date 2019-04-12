package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CameraView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        String text = scanner.nextLine();
        String pattern = "\\|<\\w{" + num1 + "}(\\w{1," + num2 + "})";

        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group(1) + ", ");
        }
        m.reset();
        if (m.find()) {
            System.out.println(sb.substring(0, sb.length() - 2));
        }
    }
}