package basicsyntax;

import java.util.HashMap;
import java.util.Scanner;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String word1 = input[0];
        String word2 = input[1];

        if (word1.length() >= word2.length()) {
            AreExchangeable(word1, word2);

        } else {
            AreExchangeable(word2, word1);
        }
    }

    static void AreExchangeable(String word1, String word2) {
        HashMap<Character, Character> book = new HashMap();
        boolean isTrue = true;

        for (int i = 0; i < word2.length(); i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            if (!book.containsKey(ch1)) {
                book.put(ch1, ch2);
            } else {
                if (book.get(ch1) != ch2) {
                    isTrue = false;
                    System.out.println(isTrue);
                    return;
                }
            }
        }
        for (int i = word2.length(); i < word1.length(); i++) {
            char ch1 = word1.charAt(i);

            if (!book.containsKey(ch1)) {
                isTrue = false;
                System.out.println(isTrue);
                return;
            }
        }
        System.out.println(isTrue);
        return;
    }
}
