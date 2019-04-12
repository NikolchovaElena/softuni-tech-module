package basicsyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> health = new TreeMap<>();
        TreeMap<String, Double> damage = new TreeMap<>();

        String[] demons = scanner.nextLine().split("\\s*,\\s*");
        Pattern regexHealth = Pattern.compile("[^0-9+*\\/.-]");
        Pattern regexDemage = Pattern.compile("(-)?\\d+(\\.\\d+)*");

        for (int i = 0; i < demons.length; i++) {
            //TAKE HEALTH
            Matcher m = regexHealth.matcher(demons[i]);

            int sum = 0;
            while (m.find()) {
                sum += m.group(0).charAt(0);
            }
            health.put(demons[i], sum);

            //TAKE DAMAGE
            Matcher m1 = regexDemage.matcher(demons[i]);

            double sum2 = 0;
            while (m1.find()) {
                sum2 += Double.parseDouble(m1.group(0));
            }

            char[] ch = demons[i].toCharArray();

            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '*') {
                    sum2 *= 2;
                }
                if (ch[j] == '/') {
                    sum2 /= 2;
                }
            }
            damage.put(demons[i], sum2);
        }
        health.entrySet().stream().forEach(s -> {
            System.out.printf("%s - %d health, %.2f damage%n", s.getKey(), s.getValue(), damage.get(s.getKey()));
        });
    }
}
