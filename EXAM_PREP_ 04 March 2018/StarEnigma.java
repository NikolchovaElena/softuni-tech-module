package basicsyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();

            long count = message.chars().filter(num -> num == 's' || num == 't' || num == 'a' || num == 'r'
                    || num == 'S' || num == 'T' || num == 'A' || num == 'R').count();
            StringBuilder decrypted = new StringBuilder();

            for (int j = 0; j < message.length(); j++) {
                decrypted.append((char) ((int) message.charAt(j) - count));
            }

            Pattern regex = Pattern.compile("@([A-Za-z]*)[^@\\-!:>]*:[0-9]+[^@\\-!:>]*!(A|D)![^@\\-!:>]*->[0-9]+");
            Matcher m = regex.matcher(decrypted);

            while (m.find()) {
                String planetName = m.group(1);
                String attackType = m.group(2);

                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        if (attackedPlanets.size() != 0) {
            attackedPlanets.stream().sorted().forEach(planet->{
                System.out.printf("-> %s%n", planet);
            });
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        if (destroyedPlanets.size() != 0) {
            destroyedPlanets.stream().sorted().forEach(planet->{
                System.out.printf("-> %s%n", planet);
            });
        }
    }
}