package basicsyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("END")) {
                break;
            } else if (input[0].equals("A")) {
                phonebook.put(input[1], input[2]);
            } else if (input[0].equals("S")) {
                if (phonebook.containsKey(input[1])) {
                    System.out.println(input[1] + " -> " + phonebook.get(input[1]));
                } else {
                    System.out.println("Contact " + input[1] + " does not exist.");
                }
            }
            else if (input[0].equals("ListAll")) {
                for (Map.Entry<String, String> pair : phonebook.entrySet()) {

                    System.out.println(pair.getKey() + " -> " + pair.getValue());
                }
            }
        }
    }
}