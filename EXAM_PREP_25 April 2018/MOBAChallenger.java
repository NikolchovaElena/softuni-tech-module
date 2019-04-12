package basicsyntax;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> register = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Season end")) {
                PrintAll(register);
                break;
            }

            String[] case1 = input.split(" -> ");
            String[] case2 = input.split(" vs ");

            if (case1.length > 1) {
                PlacePlayer(case1, register);

            } else {
                duel(case2, register);
            }
        }
    }

    static void duel(String[] case2, TreeMap<String, TreeMap<String, Integer>> register) {
        String player1 = case2[0];
        String player2 = case2[1];

        if (player1.equals(player2)) {
            return;
        }
        if (!register.containsKey(player1) || !register.containsKey(player2)) {
            return;
        }
        boolean yesItContains = false;

        for (Map.Entry<String, Integer> item1 : register.get(player1).entrySet()) {
            String position1 = item1.getKey();

            for (Map.Entry<String, Integer> item2 : register.get(player2).entrySet()) {
                String position2 = item2.getKey();

                if (position1.equals(position2)) {
                    yesItContains = true;
                    break;
                }
            }
        }
        if (yesItContains == false) {
            return;
        } else {
            int sum1 = 0;
            int sum2 = 0;

            for (Map.Entry<String, Integer> item1 : register.get(player1).entrySet()) {
                sum1 += item1.getValue();
            }
            for (Map.Entry<String, Integer> item2 : register.get(player2).entrySet()) {
                sum2 += item2.getValue();
            }
            if (sum1 > sum2) {
                register.remove(player2);
                return;
            } else if (sum2 > sum1) {
                register.remove(player1);
                return;
            } else {
                return;
            }
        }
    }

    static void PlacePlayer(String[] case1, TreeMap<String, TreeMap<String, Integer>> register) {

        String player = case1[0];
        String position = case1[1];
        int skill = Integer.parseInt(case1[2]);

        if (!register.containsKey(player)) {
            register.put(player, new TreeMap<>());
            register.get(player).put(position, skill);
        } else {
            if (register.get(player).containsKey(position)) {

                int currentSkill = register.get(player).get(position);
                if (currentSkill < skill) {
                    register.get(player).put(position, skill);
                }
            }else {
                register.get(player).put(position, skill);
            }
        }
    }

    static void PrintAll(TreeMap<String, TreeMap<String, Integer>> register) {

        register.entrySet().stream().sorted((x1, x2) -> {
            int result = 0;
            int sum1 = 0;
            int sum2 = 0;

            for (Map.Entry<String, Integer> item1 : x1.getValue().entrySet()) {
                sum1 += item1.getValue();
            }
            for (Map.Entry<String, Integer> item2 : x2.getValue().entrySet()) {
                sum2 += item2.getValue();
            }
            if (sum1 > sum2) {
                result = -1;
            } else if (sum2 > sum1) {
                result = 1;
            }
            return result;
        }).forEach(player -> {
            int sum = 0;

            for (Map.Entry<String, Integer> item : player.getValue().entrySet()) {
                sum += item.getValue();
            }
            System.out.printf("%s: %d skill%n", player.getKey(), sum);

            player.getValue().entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                    .forEach(s -> {
                        System.out.printf("- %s <::> %d%n", s.getKey(), s.getValue());
                    });
        });
    }
}