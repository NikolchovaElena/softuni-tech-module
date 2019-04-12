package basicsyntax;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class CharityMarathon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long days = Long.parseLong(scanner.nextLine());
        long runners = Long.parseLong(scanner.nextLine());
        int averageNumOfLabs = Integer.parseInt(scanner.nextLine());
        long trackLength = Long.parseLong(scanner.nextLine());
        long trackCapacity = Long.parseLong(scanner.nextLine());
        BigDecimal meneyPerKm = new BigDecimal(scanner.nextLine());

        if ((trackCapacity * days) < runners) {
            runners = trackCapacity*days;
        }

        BigInteger m = BigInteger.valueOf(runners * averageNumOfLabs);
        m = m.multiply(BigInteger.valueOf(trackLength));

        BigInteger km = m.divide(BigInteger.valueOf(1000));

        BigDecimal money = new BigDecimal(km);
        money = money.multiply(meneyPerKm);

        System.out.printf("Money raised: %.2f", money);

    }
}