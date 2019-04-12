package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class EnduranceRally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");

        double[] zones = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        int[] checkPoints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (String person : names) {
            double fuel = person.charAt(0);
            int index = 0;

            for (int i = 0; i < zones.length; i++) {
                boolean isEqual = false;

                for (int k = 0; k < checkPoints.length; k++) {
                    if (i == checkPoints[k]) {
                        isEqual = true;
                        break;
                    }
                }
                if (isEqual) {
                    fuel += zones[i];
                } else {
                    fuel -= zones[i];
                }

                if (fuel > 0) {
                    index++;
                } else {
                    System.out.printf("%s - reached %d%n", person, index);
                    break;
                }
            }
            if (fuel > 0) {
                System.out.printf("%s - fuel left %.2f%n", person, fuel);
            }
        }
    }
}
