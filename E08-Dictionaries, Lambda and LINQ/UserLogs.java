package basicsyntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> userLog = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            String[] line = input.split(" ");
            String[] line2 = input.split("user=");

            String IP = line[0].substring(3);
            String user = line2[line2.length - 1];

            if (userLog.containsKey(user)) {
                if (userLog.get(user).containsKey(IP)) {
                    int count = userLog.get(user).get(IP);
                    userLog.get(user).put(IP, count + 1);
                } else {
                    userLog.get(user).put(IP, 1);
                }
            } else {
                userLog.put(user, new LinkedHashMap<String, Integer>());
                userLog.get(user).put(IP, 1);
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> pair : userLog.entrySet()) {
            String userName = pair.getKey();
            System.out.println(userName + ":");

            List<String> helper = new ArrayList<>();

            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()) {

                String userIP = pair2.getKey();
                int userEntryCount = pair2.getValue();
                helper.add(userIP + " => " + userEntryCount);
            }
            System.out.println(String.join(", ", helper + ".").replace("[", "").replaceAll("\\[|\\]",""));
        }
    }
}
