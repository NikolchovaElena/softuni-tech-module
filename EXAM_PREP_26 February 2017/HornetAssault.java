package basicsyntax;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HornetAssault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] bees = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] hornets = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long power = Arrays.stream(hornets).sum();
        int count = 0;
        for (int i = 0; i < bees.length; i++) {
            long beehive = bees[i];

            if (beehive >= power) {
                bees[i] = beehive - power;
                hornets[count] = 0L;
                count++;
                power = Arrays.stream(hornets).sum();
            } else {
                bees[i] = 0L;
            }

            if (hornets.length == count) {
                break;
            }
        }

        if (Arrays.stream(bees).sum() != 0) {
            for (long token : bees) {
                if (token != 0L) {
                    System.out.print(token + " ");
                }
            }
        } else {
            for (long token : hornets) {
                if (token != 0L) {
                    System.out.print(token + " ");
                }
            }
        }
    }
}