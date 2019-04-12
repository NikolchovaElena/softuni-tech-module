package basicsyntax;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] secondArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int specialNumber = secondArray[0];
        int power = secondArray[1];

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == specialNumber) {

                // left
                for (int j = 0; j < power; j++) {
                    if (i > 0) {
                        numbers.remove(i - 1);
                        i--;
                    }
                }
                for (int k = 0; k < power; k++) {
                    if (i < numbers.size() - 1) {
                        numbers.remove(i + 1);
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) != specialNumber) {
                sum+=numbers.get(i);
            }
        }
        System.out.print(sum);
    }
}
