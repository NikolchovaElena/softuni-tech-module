package basicsyntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String IP = input[0];
            String user = input[1];
            Integer counter = Integer.parseInt(input[2]);

            if (!logs.containsKey(user)) {
                logs.put(user, new TreeMap<>());
            }

            if (!logs.get(user).containsKey(IP)) {
                logs.get(user).put(IP, counter);
            } else {
                logs.get(user).put(IP, logs.get(user).get(IP) + counter);
            }
        }
        logs.entrySet().stream().forEach(user -> {
            System.out.printf("%s: ", user.getKey());
            List<String> helper = new ArrayList<>();
            List<Integer> helper2 = new ArrayList<>();

            user.getValue().entrySet().stream().forEach(adress -> {
                helper.add(adress.getKey());
                helper2.add(adress.getValue());
            });
            int sum = helper2.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d %s%n", sum, helper);
        });
    }
}