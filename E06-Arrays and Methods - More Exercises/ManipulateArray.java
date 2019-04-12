package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManipulateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {
            n--;
            String command = scanner.nextLine();

            if (command.equals("Distinct")) {
                text = Distinct(text);
            } else if (command.equals("Reverse")) {
                text = Reverse(text);
            } else {// Replace
                text = Replace(text, command);
            }
        }
        System.out.print(Arrays.toString(text).replaceAll("\\[|\\]",""));
    }

    static String[] Replace(String[] arr, String text) {
        String[] temp = text.split(" ");
        int num = Integer.parseInt(temp[1]);
        String replace = temp[2];

        arr[num] = replace;
        return arr;
    }

    static String[] Distinct(String[] array) {
        String[] clone = array.clone();

        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                if (clone[i].equals(clone[j - 1])) {
                    clone[i] = "";
                }
            }
        }

        List<String> cloneAsList = new ArrayList<String>();
        for (String data : clone) {
            if (data != "") {
                cloneAsList.add(data);
            }
        }

        String[] result = cloneAsList.toArray(new String[cloneAsList.size()]);
        return result;
    }

    static String[] Reverse(String[] array) {
        String[] temp = new String[array.length];
        for (int i = 0; i < array.length; i++) {

            temp[i] = array[array.length - 1 - i];
        }
        return temp;
    }
}
