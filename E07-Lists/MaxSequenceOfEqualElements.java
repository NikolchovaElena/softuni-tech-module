package basicsyntax;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int count = 1;
        int maxCount = 1;
        int index = 1;

        if (numbers.size() == 1) {
            System.out.print(numbers.get(0));
            return;
        }
        for (int i = 0; i < numbers.size() - 1; i++) {

            if (numbers.get(i).equals(numbers.get(i + 1))) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                    index = numbers.get(i);
                }
            } else {
                count = 1;
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(index + " ");
        }
    }
}