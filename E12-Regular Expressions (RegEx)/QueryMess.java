package basicsyntax;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<String>> book = new LinkedHashMap<>();

        String pattern = "([^&=?]*)=([^&=]*)";
        Pattern regex = Pattern.compile(pattern);
        String pattern2 = "((%20|\\+)+)";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }

            Matcher m = regex.matcher(input);
            while (m.find()) {

                String key = m.group(1);
                key = key.replaceAll(pattern2, " ").trim();
                String value = m.group(2);
                value = value.replaceAll(pattern2, " ").trim();

                if (!book.containsKey(key)) {
                    book.put(key, new ArrayList<>());
                }
                book.get(key).add(value);

            }
            for (Map.Entry<String, List<String>> data : book.entrySet()) {
                System.out.print(data.getKey() + "=[");
                String result = String.join(", ", data.getValue());
                System.out.print(result + "]");
            }
            System.out.println();
            book.clear();
        }
    }
}