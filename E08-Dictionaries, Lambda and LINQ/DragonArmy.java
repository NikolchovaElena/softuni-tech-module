package basicsyntax;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Dragons>> register = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String color = input[0];
            String name = input[1];
            int damage = 45;
            int health = 250;
            int armor = 10;

            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }

            Dragons current = new Dragons(name, damage, health, armor);

            if (!register.containsKey(color)) {
                register.put(color, new ArrayList<>());
                register.get(color).add(current);
            } else {
                boolean hasName = register.get(color).stream().anyMatch(s -> s.getName().equals(name));

                if (register.containsKey(color) & hasName) {
                    for (Dragons dragon : register.get(color)) {
                        if (dragon.getName().equals(name)) {
                            register.get(color).remove(dragon);
                            break;
                        }
                    }
                }
                register.get(color).add(current);
            }
        }
        // PRINT RESULTS
        register.entrySet().stream().forEach(type -> {
            int size = type.getValue().size();

            final double[] averageDamage = { 0 };
            type.getValue().stream().forEach(dragon -> {
                averageDamage[0] += dragon.getDamage();
            });
            averageDamage[0] /= size;

            final double[] averageHealth = { 0 };
            type.getValue().stream().forEach(dragon -> {
                averageHealth[0] += dragon.getHealth();
            });
            averageHealth[0] /= size;

            final double[] averageArmor = { 0 };
            type.getValue().stream().forEach(dragon -> {
                averageArmor[0] += dragon.getArmor();
            });
            averageArmor[0] /= size;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), averageDamage[0], averageHealth[0],
                    averageArmor[0]);

            // PRINT EACH DRAGON
            type.getValue().stream().sorted((x1, x2) -> x1.getName().compareTo(x2.getName())).forEach(dragon -> {

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getName(), dragon.getDamage(),
                        dragon.getHealth(), dragon.getArmor());
            });
        });
    }
}

class Dragons {
    private String name;
    private int damage;
    private int health;
    private int armor;

    // public static final Customer DEFAULT = null;

    public Dragons(String name, int damage, int health, int armor) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
