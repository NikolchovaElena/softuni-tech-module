package basicsyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> register = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Lumpawaroo")) {
                break;
            }

            String[] case1 = input.split(" \\| ");
            String[] case2 = input.split(" -> ");

            if (case1.length > 1) {
                forceBookAddMember(case1, register);
            } else {
                forceBookCheckMember(case2, register);
            }
        }
        register.entrySet().stream().sorted((x1, x2) -> {

            int result = Integer.compare(x2.getValue().size(), x1.getValue().size());
            if (result == 0) {
                result = x1.getKey().compareTo(x2.getKey());
            }
            return result;

        }).forEach(side -> {
            if (side.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", side.getKey(), side.getValue().size());
            }
            Collections.sort(side.getValue());

            for (String user : side.getValue()) {

                System.out.printf("! %s%n", user);
            }
        });
    }

    static void forceBookAddMember(String[] case1, HashMap<String, List<String>> register) {

        String user = case1[1];
        String side = case1[0];

        if (!register.containsKey(side)) {
            register.put(side, new ArrayList<>());
        }

        if (!register.get(side).contains(user)&&DoYouContainValue(user, register) == false) {
            register.get(side).add(user);
        }
    }

    static void forceBookCheckMember(String[] case1, HashMap<String, List<String>> register) {

        String user = case1[0];
        String side = case1[1];

        if (DoYouContainValue(user, register) == false) {
            if (!register.containsKey(side)) {
                register.put(side, new ArrayList<>());
            }
            register.get(side).add(user);
            System.out.printf("%s joins the %s side!%n", user, side);

        } else {
            for (List<String> s : register.values()) {
                if (s.contains(user)) {
                    s.remove(user);
                }
            }

            if (!register.containsKey(side)) {
                register.put(side, new ArrayList<>());
            }
            register.get(side).add(user);
            System.out.printf("%s joins the %s side!%n", user, side);
        }
    }

    static boolean DoYouContainValue(String user, HashMap<String, List<String>> register) {

        for (Map.Entry<String, List<String>> item : register.entrySet()) {
            if (item.getValue().contains(user)) {
                return true;
            }
        }
        return false;
    }
}