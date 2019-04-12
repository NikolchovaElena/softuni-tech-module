package basicsyntax;

import java.util.Scanner;

public class PizzaIngredients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int wantedLength = Integer.parseInt(scanner.nextLine());

        String ingredient = "";
        int count = 0;
        String finalSentance = "The ingredients are: ";

        for (int i = 0; i < input.length; i++) {
            ingredient = input[i];
            if (ingredient.length() == wantedLength) {
                System.out.println("Adding " + ingredient + ".");
                count++;
                finalSentance += ingredient + ", ";
            }
            if (count == 10) {
                break;
            }
        }
        System.out.println("Made pizza with total of " + count + " ingredients.");
        finalSentance = finalSentance.substring(0, finalSentance.length() - 2);
        System.out.println(finalSentance+".");
    }
}