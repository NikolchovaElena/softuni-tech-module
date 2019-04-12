package basicsyntax;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> book = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("course start")) {
                break;
            }

            String[] line = input.split(":");
            String command = line[0];

            if (command.equals("Add")) {
                if (!book.contains(line[1])) {
                    book.add(line[1]);
                }

            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(line[2]);
                if (!book.contains(line[1]) && (index >= 0 && index < book.size())) {
                    book.add(index, line[1]);
                }

            } else if (command.equals("Exercise")) {
                String title = line[1];
                if (book.contains(title) && !book.contains(title + "-Exercise")) {
                    int index = book.indexOf(title);
                    book.add(index + 1, title + "-Exercise");
                } else if (!book.contains(title)) {
                    book.add(title);
                    book.add(title + "-Exercise");
                }

            } else if (command.equals("Remove")) {
                if (book.contains(line[1])) {
                    int index = book.indexOf(line[1]);
                    book.remove(index);
                }
                if (book.contains(line[1] + "-Exercise")) {
                    int index = book.indexOf(line[1] + "-Exercise");
                    book.remove(index);
                }
            } else if (command.equals("Swap")) {

                if (book.contains(line[1]) && book.contains(line[2])) {
                    int index1 = book.indexOf(line[1]);
                    int index2 = book.indexOf(line[2]);

                    book.set(index1, line[2]);
                    book.set(index2, line[1]);

                    if (book.contains(line[1] + "-Exercise")) {
                        book.remove(line[1] + "-Exercise");
                        int index11 = book.indexOf(line[1]);
                        book.set(index11 + 1, line[1] + "-Exercise");
                    }
                    if (book.contains(line[2] + "-Exercise")) {
                        book.remove(line[2] + "-Exercise");
                        int index11 = book.indexOf(line[2]);
                        book.add(index11 + 1, line[2] + "-Exercise");
                    }
                }
            }
        }

        for (int i = 0; i < book.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, book.get(i));
        }
    }
}