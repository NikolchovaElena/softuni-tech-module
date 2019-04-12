package basicsyntax;

import java.util.Scanner;

public class HornetWings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double m = Double.parseDouble(scanner.nextLine()); // distance per 1000n
        int p = Integer.parseInt(scanner.nextLine()); // how many n before rest, 5 sec

        double distance = n / 1000 * m;
        double secunds = n / 100;
        double rests = n / p * 5;
        double time = secunds + rests;

        System.out.printf("%.2f m.%n",distance);
        System.out.printf("%.0f s.",time);
    }
}