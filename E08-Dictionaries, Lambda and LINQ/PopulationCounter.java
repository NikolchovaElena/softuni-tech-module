package basicsyntax;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, HashMap<String, Long>> register = new TreeMap<>();
        HashMap<String, Long> countryLog = new HashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("report")) {

            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            Long population = Long.parseLong(data[2]);

            if (!register.containsKey(country)) {
                register.put(country, new HashMap<String, Long>());
            }
            register.get(country).put(city, population);

            if (!countryLog.containsKey(country)) {
                countryLog.put(country, 0L);
            }
            countryLog.put(country, countryLog.get(country) + population);
        }

        register.entrySet().stream()
                .sorted((x1, x2) -> countryLog.get(x2.getKey()).compareTo(countryLog.get(x1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)%n", country.getKey(), countryLog.get(country.getKey()));
                    country.getValue().entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                            .forEach(city -> {
                                System.out.format("=>%s: %d\n", city.getKey(), city.getValue());
                            });
                });
    }
}
