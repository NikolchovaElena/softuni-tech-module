package basicsyntax;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> collection = new LinkedHashMap<>();

        while (true) {

            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk")) {

                collection.put(name, email);
            }
        }
        for (Map.Entry<String, String> pair : collection.entrySet()) {
            System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
    }
}
