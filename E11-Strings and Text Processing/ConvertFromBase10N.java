package basicsyntax;

import java.math.BigInteger;
import java.util.Scanner;

public class ConvertFromBase10N {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        int n = Integer.parseInt(numbers[0]);

        BigInteger number = new BigInteger(numbers[1]);
        BigInteger temp = new BigInteger("0");

        StringBuilder sb = new StringBuilder();

        while (number.compareTo(BigInteger.valueOf(0))==1) {

            temp = number.mod(BigInteger.valueOf(n));
            number = number.divide(BigInteger.valueOf(n));
            sb = sb.append(temp);
        }
        System.out.print(sb.reverse());
    }
}