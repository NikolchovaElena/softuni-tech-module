package basicsyntax;

import java.util.Scanner;

public class HelloName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Getname(name);
    }

    static void Getname(String input) {
        System.out.print("Hello, " + input + "!");
    }
}
