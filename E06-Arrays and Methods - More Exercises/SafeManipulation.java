package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class SafeManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");

        while (true) {
            String command = scanner.nextLine();
            String[] temp = command.split(" ");

            if (command.equals("END")) {
                break;
            }
            if (command.equals("Distinct")) {
                text = Arrays.stream(text).distinct().toArray(String[]::new);
            } else if (command.equals("Reverse")) {
                text = Reverse(text);
            } else if(temp[0].equals("Replace")) {
                int num = Integer.parseInt(temp[1]);
                String replace = temp[2];
                if ((num < text.length && num > 0) || num == 0) {
                    text[num] = replace;
                } else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }
        }
        System.out.print(Arrays.toString(text).replaceAll("\\[|\\]", ""));
    }

    static String[] Reverse(String[] array) {
        String[] temp = new String[array.length];
        for (int i = 0; i < array.length; i++) {

            temp[i] = array[array.length - 1 - i];
        }
        return temp;
    }
}
