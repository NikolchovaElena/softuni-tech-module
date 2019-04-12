package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MemoryView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lst = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();

        while (true) {

            String input = scanner.nextLine();
            if (input.equals("Visual Studio crash")) {
                break;
            }
            lst.addAll(Arrays.asList(input.split(" ")));
            // sb.append(input);
        }
        // Pattern pattern = Pattern.compile("");

        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).equals("32763")) {

                int count = Integer.parseInt(lst.get(i + 2));
                StringBuilder name = new StringBuilder();

                for (int j = 0; j < count; j++) {
                    int temp =Integer.parseInt(lst.get(i + 4 + j));
                    name.append((char) temp);
                    // name.append((char) lst.get(i + 2 + j).charAt(0));
                }
                System.out.println(name.toString());

            }
        }
    }
}