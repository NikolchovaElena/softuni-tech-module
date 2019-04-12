package basicsyntax;

import java.util.Scanner;

public class PrimesInGivenRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        try {System.out.print(PrintListOfPrimes(num1,num2));

        } catch (Exception e) {
            System.out.print("(empty list)");
        }
    }

    static String PrintListOfPrimes(int startNum, int endNum) {
        String text = "";
        for (int i = startNum; i <= endNum; i++) {
            if (IsPrime(i)) {
                text += String.valueOf(i) + ", ";
            }
        }
        text = text.substring(0,text.length() - 2);
        return text;
    }

    static boolean IsPrime(int num) {
        boolean isTrue = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isTrue = false;
            }
        }
        if (num == 0 || num == 1) {
            isTrue = false;
        }
        return isTrue;
    }
}