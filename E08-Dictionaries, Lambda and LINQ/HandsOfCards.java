package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();;
        LinkedHashMap<String, List<String>> dictionary = new LinkedHashMap<>();

        while (!line.equals("JOKER")) {

            String[] input = line.split(": ");
            String playersName = input[0];
            String[] cardsArray = input[1].split(", ");// 2C, 4H, 9H, AS, QS

            if (dictionary.containsKey(playersName)) {
                List<String> lst = new ArrayList<>();
                lst.addAll(dictionary.get(playersName));
                lst.addAll(Arrays.asList(cardsArray));
                dictionary.put(playersName, lst);
            } else {
                List<String> lst = new ArrayList<>();
                lst = Arrays.asList(cardsArray);
                dictionary.put(playersName, lst);

            }
            line = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> pair : dictionary.entrySet()) {
            String name = pair.getKey();
            String cardArray = pair.getValue().toString().replaceAll("\\[|\\]","");
            List<String> distinctCards = Arrays.stream(cardArray.split(", ")).distinct().collect(Collectors.toList());

            int sum = 0;
            for (String cardPair : distinctCards) {
                sum += PT(cardPair);
            }

            System.out.printf("%s: %d%n", pair.getKey(), sum);
        }
    }

    static int PT(String val) {

        String left = val.substring(0, val.length() - 1);
        String right = val.substring(val.length() - 1);

        HashMap<String, Integer> P = new HashMap<>();
        HashMap<String, Integer> T = new HashMap<>();

        for (Integer i = 2; i <= 10; i++) {
            P.put(i.toString(), i);
        }
        P.put("J", 11);
        P.put("Q", 12);
        P.put("K", 13);
        P.put("A", 14);

        T.put("S", 4);
        T.put("H", 3);
        T.put("D", 2);
        T.put("C", 1);
        int sum = P.get(left) * T.get(right);

        return sum;
    }
}
