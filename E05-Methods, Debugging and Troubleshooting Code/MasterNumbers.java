package basicsyntax;

import java.util.Scanner;

public class MasterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String val = String.valueOf(i);
            if (IsPalindrome(val) && SumOfDigits(val) && ContainsEvenDigit(val)) {
                System.out.println(i);
            }
        }
    }

    static boolean IsPalindrome(String val) {
        boolean PalindromeTrue = true;
        for (int i = (val.length() - 1) / 2; i >= 0; i--) {
            char original = val.charAt(i);
            char reverse = val.charAt(val.length() - 1 - i);
            if (original != reverse) {
                PalindromeTrue = false;
                break;
            }
        }
        if (PalindromeTrue) {
            return true;
        } else {
            return false;
        }
    }

    static boolean SumOfDigits(String val) {
        int num = Integer.parseInt(val);
        int num1 = 0;
        int sum = 0;
        for (int i = 0; i < val.length(); i++) {
            num1 = num % 10;
            num = num / 10;
            sum += num1;
        }
        if (sum % 7 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean ContainsEvenDigit(String val) {
        boolean isTrue = false;
        for (int i = 0; i < val.length(); i++) {
            // int currentDigit = int.Parse(str[i].ToString());
            char a = val.charAt(i);
            switch (a) {
                case '0':
                case '2':
                case '4':
                case '6':
                case '8':
                    isTrue = true;
                    break;
            }
            if (isTrue) {
                break;
            }
        }
        if (isTrue) {
            return true;
        } else {
            return false;
        }

    }
}