package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class UpgradedMatcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOfProducts = scanner.nextLine().split(" ");

        long[] quantities = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        double[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            String productName = command[0];

            if (productName.equals("done")) {
                break;
            }
            long productQuantity = Long.parseLong(command[1]);

            for (int i = 0; i < arrayOfProducts.length; i++) {

                if (productName.equals(arrayOfProducts[i])) {
                    if (quantities.length > i && quantities[i] >= productQuantity) {
                        System.out.printf("%s x %s costs %.2f%n", productName, productQuantity,
                                productQuantity * prices[i]);
                        quantities[i] -= productQuantity;
                        break;
                    } else {
                        System.out.printf("We do not have enough %s%n", productName);
                    }
                }
            }
        }
    }
}
