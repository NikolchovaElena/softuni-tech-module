package basicsyntax;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumReversedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            String num = numbers.get(i);
            sum += GetReverse(num);
        }
        System.out.print(sum);
    }

    static int GetReverse(String num) {
        String result = "";
        for (int i = num.length()-1; i >= 0; i--) {

            result += num.charAt(i);
        }
        return Integer.parseInt(result);
    }
}
