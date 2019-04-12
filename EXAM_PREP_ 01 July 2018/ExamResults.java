package basicsyntax;

import java.util.Scanner;
import java.util.TreeMap;

public class ExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // NAME AND POINTS:
        TreeMap<String, Integer> register = new TreeMap<>();

        // LANGUAGE AND SUBMISSIONS:
        TreeMap<String, Integer> submissions = new TreeMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("exam finished")) {
                break;
            }

            String[] input = line.split("-");

            if (input.length == 3) {

                String name = input[0];
                String language = input[1];
                int points = Integer.parseInt(input[2]);

                // CHECK IF NAME EXISTS, PUT BETTER POINTS
                if (!register.containsKey(name)) {
                    register.put(name, points);
                } else {
                    int currentPoints = register.get(name);
                    register.put(name, Math.max(currentPoints, points));
                }

                // CHECK IF LANGUAGE EXISTS, ADD SUBMISSION
                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }
            }
            // CHECK FOR BANNED USERS
            if (input.length == 2) {
                String name = input[0];
                if (input[1].equals("banned")) {
                    register.remove(name);
                }
            }
        }
        System.out.println("Results:");
        register.entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                .forEach(person -> {
                    System.out.printf("%s | %d%n", person.getKey(), person.getValue());
                });

        System.out.println("Submissions:");
        submissions.entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                .forEach(sub -> {
                    System.out.printf("%s - %d%n", sub.getKey(), sub.getValue());
                });
    }
}