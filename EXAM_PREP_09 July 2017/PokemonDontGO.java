package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> removed = new ArrayList<>();
        int element = 0;

        while (true) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                element = arr.get(0);
                removed.add(element);
                arr.set(0, arr.get(arr.size() - 1));
                IncreaseDecrease(element, arr);
            } else if (index > arr.size()-1) {
                element = arr.get(arr.size() - 1);
                removed.add(element);
                arr.set(arr.size() - 1, arr.get(0));
                IncreaseDecrease(element, arr);
            } else {
                element = arr.get(index);
                removed.add(element);
                arr.remove(index);
                IncreaseDecrease(element, arr);
            }
            if (arr.size() == 0) {

                int sum = removed.stream().mapToInt(Integer::intValue).sum();
                System.out.println(sum);
                return;
            }
        }

    }

    static void IncreaseDecrease(int element, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) <= element) {
                arr.set(i, arr.get(i) + element);

            } else {
                arr.set(i, arr.get(i) - element);
            }
        }
    }
}