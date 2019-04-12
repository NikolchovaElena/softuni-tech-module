package basicsyntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split(" *+, *");

        for (int i = 0; i < tickets.length; i++) {

            if (tickets[i].trim().length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            if (tickets[i].trim().equals("$$$$$$$$$$$$$$$$$$$$") || tickets[i].trim().equals("####################")
                    || tickets[i].trim().equals("@@@@@@@@@@@@@@@@@@@@")
                    || tickets[i].trim().equals("^^^^^^^^^^^^^^^^^^^^")) {

                System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", tickets[i].trim(), tickets[i].trim().charAt(0));
                continue;
            }

            String left = tickets[i].trim().substring(0, 10);
            String right = tickets[i].trim().substring(10);

            Pattern regex = Pattern.compile("([@]{6,10}|[\\^]{6,10}|[$]{6,10}|[#]{6,10})");
            Matcher ml = regex.matcher(left);
            Matcher mr = regex.matcher(right);

            if (ml.find() && mr.find()) {

                if (ml.group(0).charAt(0) == mr.group(0).charAt(0)) {
                    int size = Math.min(ml.group(0).length(), mr.group(0).length());
                    System.out.printf("ticket \"%s\" - %d%s%n", tickets[i].trim(), size, ml.group(0).charAt(0));
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", tickets[i].trim());
                }
            } else {
                System.out.printf("ticket \"%s\" - no match%n", tickets[i].trim());
            }
        }
    }
}