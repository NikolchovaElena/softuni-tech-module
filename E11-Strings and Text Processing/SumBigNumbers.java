package basicsyntax;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        BigInteger sum = new BigInteger(input1).add(new BigInteger(input2));

        System.out.print(sum);
    }
}
