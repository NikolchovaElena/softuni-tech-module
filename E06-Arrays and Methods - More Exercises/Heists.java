package basicsyntax;

import java.util.Scanner;

public class Heists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int priceJewels = Integer.parseInt(input[0]);
        int priceGold = Integer.parseInt(input[1]);

        long expences = 0;
        long earnings = 0;

        while (true) {
            String heistInfo = scanner.nextLine();
            if (heistInfo.equals("Jail Time")) {
                break;
            }

            String[] arrayHeistInfo = heistInfo.split(" ");
            expences += Long.parseLong(arrayHeistInfo[1]);

            char[] data = arrayHeistInfo[0].toCharArray();
            for (int i = 0; i < data.length; i++) {
                if (data[i] == '%') {
                    earnings += priceJewels;
                } else if (data[i] == '$') {
                    earnings += priceGold;
                }
            }
        }
        long total = Math.abs(earnings - expences);
        if (earnings >= expences) {
            System.out.print("Heists will continue. Total earnings: " + total + ".");
        }else {
            System.out.print("Have to find another job. Lost: "+ total+".");
        }
    }
}
