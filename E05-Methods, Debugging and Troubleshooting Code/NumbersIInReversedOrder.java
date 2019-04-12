package basicsyntax;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumbersIInReversedOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double numberFromConsole = Double.parseDouble(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.##");
        String numberAsText = df.format(numberFromConsole);

        ReverseString(numberAsText, numberFromConsole);
    }

    static void ReverseString(String input, double number) {
        StringBuilder input1 = new StringBuilder();
        String minusSymbol = "";
        if (number < 0) {
            input = input.substring(1);
            minusSymbol = "-";
        }

        input1.append(input);
        input1 = input1.reverse();
        System.out.print(minusSymbol + input1);
    }
}