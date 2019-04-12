package basicsyntax;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("END")) {
                break;
            }
            if (input[0].equals("A")) {
                phonebook.put(input[1], input[2]);
            } else if (input[0].equals("S")) {
                if (phonebook.containsKey(input[1])) {
                    System.out.println(input[1] + " -> " + phonebook.get(input[1]));
                } else {
                    System.out.println("Contact " + input[1] + " does not exist.");
                }
            }
        }
    }
}