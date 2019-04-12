package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<Integer>();
        for (String item : input) {
            numbers.add(Integer.parseInt(item));
        }

        while (true) {
            String[] command = scanner.nextLine().split(" ");

            if (command[0].equals("print")) {
                System.out.println(Arrays.toString(numbers.toArray()));
                return;
            }
            GetResult(numbers, command);
        }
    }

    static void GetResult(List<Integer> numbers, String[] command) {

        switch (command[0]) {
            case "add":
                numbers.add(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                break;
            case "addMany":
                AddManyNum(numbers, command);
                break;
            case "contains":
                ContainsNum(numbers, command);
                break;
            case "remove":
                numbers.remove(Integer.parseInt(command[1]));
                break;
            case "shift":
                ShiftNum(numbers, command);
                break;
            case "sumPairs":
                sumPairs(numbers);
                break;
        }
    }

    static void ShiftNum(List<Integer> numbers, String[] command) {// ok
        for (int i = 0; i < Integer.parseInt(command[1]); i++) {
            numbers.add(numbers.get(0));
            numbers.remove(0);
        }
    }

    static void AddManyNum(List<Integer> numbers, String[] command) {
        for (int i = command.length - 1; i >= 2; i--) {
            numbers.add(Integer.parseInt(command[1]), Integer.parseInt(command[i]));
        }
    }

    static void ContainsNum(List<Integer> numbers, String[] command) {
        int result = -1;
        if (numbers.contains(Integer.parseInt(command[1])))
            result = numbers.indexOf(Integer.parseInt(command[1]));
        System.out.println(result);
    }

    static void sumPairs(List<Integer> numbers) {
        int b = numbers.size() / 2;
        for (int i = 0; i < b; i++) {
            int sum = numbers.get(i) + numbers.get(i + 1);
            numbers.set(i, sum);
            numbers.remove(i + 1);
        }
    }
}
