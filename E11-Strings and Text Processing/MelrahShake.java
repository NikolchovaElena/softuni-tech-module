package basicsyntax;

import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String pattern = scanner.nextLine();

        while(true) {
            int firstIndex = text.indexOf(pattern);
            int lastIndex = text.lastIndexOf(pattern);

            if (firstIndex > -1 && lastIndex > -1 && pattern.length() > 0){
                StringBuilder sb = new StringBuilder(text);

                sb.replace(firstIndex,pattern.length() + firstIndex,"");
                sb.replace(lastIndex - pattern.length(),pattern.length() + (lastIndex - pattern.length()),"");
                text = sb.toString();
                System.out.println("Shaked it.");
                sb = new StringBuilder(pattern);

                if (pattern.length() > 0){
                    sb.deleteCharAt(pattern.length() / 2);
                    pattern = sb.toString();
                }
            } else {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
        }
    }
}
