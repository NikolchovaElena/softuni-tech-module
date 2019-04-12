package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchForANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int take = command[0];
        int delete = command[1];
        int specialNumber = command[2];

        for (int i = 0; i < take; i++) {
            result.add(numbers.get(i));
        }
        for (int i = 0; i < delete; i++) {
            result.remove(numbers.get(i));
        }
        boolean isThere = false;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == specialNumber) {
                isThere = true;
            }
        }
        if (isThere) {
            System.out.print("YES!");
        } else {
            System.out.print("NO!");
        }
    }
}
