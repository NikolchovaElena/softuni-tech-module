package basicsyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Karaoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> register = new TreeMap<>();
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        List<String> playlist = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("dawn")) {
                break;
            }
            String[] performance = command.split(", ");

            String name = performance[0];
            String song = performance[1];
            String award = performance[2];

            if (participants.contains(name) && playlist.contains(song)) {
                if (!register.containsKey(name)) {
                    register.put(name, new ArrayList<>());
                }
                if (!register.get(name).contains(award)) {
                    register.get(name).add(award);
                }
            }
        }
        if (register.isEmpty()) {
            System.out.print("No awards");
            return;
        }
        register.entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue().size(), x1.getValue().size()))
                .forEach(n -> {
                    System.out.printf("%s: %s awards%n", n.getKey(), n.getValue().size());
                    n.getValue().stream().sorted((x1, x2) -> x1.compareTo(x2)).forEach(s -> {
                        System.out.printf("--%s%n", s);
                    });
                });
    }
}
