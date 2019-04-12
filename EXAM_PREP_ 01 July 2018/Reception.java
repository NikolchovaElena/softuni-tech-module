package basicsyntax;

import java.util.Scanner;

public class Reception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // PPL PER HOUR
        int count1 = Integer.parseInt(scanner.nextLine());
        int count2 = Integer.parseInt(scanner.nextLine());
        int count3 = Integer.parseInt(scanner.nextLine());

        int allStudents = Integer.parseInt(scanner.nextLine());

        // EVERY 4TH HOUR BREAK FOR N HOUR
        int totalCount = count1 + count2 + count3;

        int count = 0;

        for (int i = allStudents; i > 0; i -= totalCount) {

            count++;
            if (count != 0 && count % 4 == 0) {
                count++;
            }
        }

        System.out.printf("Time needed: %dh.", count);
    }
}
