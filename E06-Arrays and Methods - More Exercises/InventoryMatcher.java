package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class InventoryMatcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesOfProducts = scanner.nextLine().split(" ");

        long[] quantities = Arrays.stream(scanner.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        String[] pricesAsString = scanner.nextLine().split(" ");
        int length = namesOfProducts.length;

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("done")) {
                break;
            }
            for (int i = 0; i < length; i++) {
                if (name.equals(namesOfProducts[i])) {
                    System.out.println(
                            namesOfProducts[i] + " costs: " + pricesAsString[i] + "; Available quantity: " + quantities[i]);
                }
            }
        }
    }
}