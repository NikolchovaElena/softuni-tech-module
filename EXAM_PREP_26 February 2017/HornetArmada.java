package basicsyntax;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetArmada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> legionsActivity = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> legionsArmy = new LinkedHashMap<>();
        Pattern regex = Pattern.compile("([0-9]+) = ([^=\\-\\>: ]+) -> ([^=\\-\\>: ]+):([0-9]+)");

        for (int i = 0; i < n; i++) {
            Matcher m = regex.matcher(scanner.nextLine());

            String name = "";
            String type = "";
            int activity = 0;
            long count = 0L;

            while (m.find()) {
                name = m.group(2);
                type = m.group(3);
                activity = Integer.parseInt(m.group(1));
                count = Long.parseLong(m.group(4));
            }
            // ENTER ACTIVITY, ONLY IF THE CURRENT ONE IS BIGGER
            if (!legionsActivity.containsKey(name)) {
                legionsActivity.put(name, activity);
            } else {
                if (activity > legionsActivity.get(name)) {
                    legionsActivity.put(name, activity);
                }
            }

            // ENTER LEGION, IF COUNT EXISTS SUM IT
            if (!legionsArmy.containsKey(name)) {
                legionsArmy.put(name, new LinkedHashMap<String, Long>());
            }
            if (!legionsArmy.get(name).containsKey(type)) {
                legionsArmy.get(name).put(type, count);
            } else {
                long newCount = legionsArmy.get(name).get(type) + count;
                legionsArmy.get(name).put(type, newCount);
            }
        }

        String[] command = scanner.nextLine().split("\\\\");
        if (command.length > 1) {
            int activity = Integer.parseInt(command[0]);
            String type = command[1];

            legionsArmy.entrySet().stream()
                    .filter(legion -> legion.getValue().containsKey(type))
                    .sorted((x1, x2) -> Long.compare(x2.getValue().get(type), x1.getValue().get(type)))
                    .forEach(legion -> {

                        String name = legion.getKey();
                        if(legionsActivity.get(name)<activity) {
                            System.out.println(legion.getKey() + " -> " + legion.getValue().get(type));
                        }
                    });
        } else {
            String type = command[0];
            legionsActivity.entrySet().stream()
                    .sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                    .forEach(activity -> {
                        String name =activity.getKey();
                        if(legionsArmy.get(name).containsKey(type)) {
                            System.out.println(activity.getValue() + " : " + activity.getKey());
                        }

                    });
        }
    }
}