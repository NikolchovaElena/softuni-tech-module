package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern regex = Pattern.compile(
                "%([A-Z][a-z]+)%[^\\|\\$\\%\\.]*<([\\w]+)>[^\\|\\$\\%\\.]*\\|([0-9]+)\\|[^\\|\\$\\%\\.0-9]*([0-9]+\\.*[0-9]*)\\$");

        double total = 0;

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end of shift")) {
                break;
            }

            Matcher m = regex.matcher(line);

            if (m.find()) {
                double totalPrice = Integer.parseInt(m.group(3)) * Double.parseDouble(m.group(4));
                System.out.printf("%s: %s - %.2f%n", m.group(1), m.group(2), totalPrice);
                total+=totalPrice;
            } else {
                continue;
            }
        }
        System.out.printf("Total income: %.2f", total);
    }
}