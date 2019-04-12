package basicsyntax;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TseamAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> games = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Play!")) {
                break;
            }

            String[] line = input.split(" ");
            String command = line[0];
            String game = line[1];

            if (command.equals("Install")) {
                if (!games.contains(game)) {
                    games.add(game);
                }
            } else if (command.equals("Uninstall")) {
                if (games.contains(game)) {
                    games.remove(game);
                }
            } else if (command.equals("Update")) {
                if (games.contains(game)) {
                    games.remove(game);
                    games.add(game);
                }
            } else if (command.equals("Expansion")) {
                String[] expanshionToSplit = game.split("-");
                String game2 = expanshionToSplit[0];
                String expanshion = game.replaceAll("-", ":");

                if (games.contains(game2)) {
                    int place = games.indexOf(game2)+1;
                    games.add(place, expanshion);
                }
            }
        }
        for (String token : games) {
            System.out.print(token + " ");
        }
    }
}