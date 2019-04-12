package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Odd")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 1) {
                        result.add(numbers.get(i));
                    }
                }
                break;
            } else if (input.equals("Even")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        result.add(numbers.get(i));
                    }
                }
                break;
            }
            String[] commandArray = input.split(" ");

            String command = commandArray[0];
            int element = Integer.parseInt(commandArray[1]);

            if (command.equals("Delete")) {
                DeleteElement(numbers, element);
            }
            if (command.equals("Insert")) {
                int position = Integer.parseInt(commandArray[2]);
                IncertElement(numbers, element, position);
            }
        }
        for (Integer index : result) {
            System.out.print(index + " ");
        }
    }

    private static void DeleteElement(List<Integer> array, int element) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == element) {
                array.remove(i);
                i--;
            }
        }
    }

    private static void IncertElement(List<Integer> array, int element, int position) {
        array.add(position, element);
    }
}
