package basicsyntax;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class PokemonEvolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> pokemons = new LinkedHashMap();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("wubbalubbadubdub")) {
                break;
            }

            if (input.contains("->")) {

                String[] current = input.split(" -> ");

                String name = current[0];
                String evolution = current[1] + " <-> " + current[2];

                if (!pokemons.containsKey(name)) {
                    pokemons.put(name, new ArrayList<>());
                }
                pokemons.get(name).add(evolution);

            } else {
                if (pokemons.containsKey(input)) {
                    PrintThisPokemon(input, pokemons);
                }
            }
        }
        for (String name : pokemons.keySet()) {
            PrintAllPokemon(name, pokemons);
        }

    }
    static void PrintThisPokemon(String name, LinkedHashMap<String, List<String>> pokemons) {
        if (pokemons.containsKey(name)) {
            System.out.printf("# %s%n", name);

            pokemons.get(name).stream().forEach(a -> {
                String[] evolution = a.split(" <-> ");
                String type = evolution[0];
                int index = Integer.parseInt(evolution[1]);

                System.out.printf("%s <-> %d%n", type, index);
            });
        }
    }

    static void PrintAllPokemon(String name, LinkedHashMap<String, List<String>> pokemons) {
        if (pokemons.containsKey(name)) {
            System.out.printf("# %s%n", name);

            pokemons.get(name).stream().sorted((x1, x2) -> {

                String[] evolution1 = x1.split(" <-> ");
                int index1 = Integer.parseInt(evolution1[1]);

                String[] evolution2 = x2.split(" <-> ");
                int index2 = Integer.parseInt(evolution2[1]);

                int result = Integer.compare(index2, index1);
                return result;

            }).forEach(a -> {
                String[] evolution = a.split(" <-> ");
                String type = evolution[0];
                int index = Integer.parseInt(evolution[1]);

                System.out.printf("%s <-> %d%n", type, index);

            });
        }
    }
}
