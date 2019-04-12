package basicsyntax;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double  pricePerSaber = Double.parseDouble(scanner.nextLine());
        double pricePerRobe = Double.parseDouble(scanner.nextLine());
        double pricePerBelt = Double.parseDouble(scanner.nextLine());

        double priceOfSabers = (students+Math.ceil(0.1*students)) * pricePerSaber;
        int discount = students / 6;

        double priceOfBelts = (students - discount) * pricePerBelt;

        double priceOfRobes = students * pricePerRobe;

        double price = priceOfSabers + priceOfBelts + priceOfRobes;
        if (price > money) {
            System.out.printf("Ivan Cho will need %.2flv more.", price - money);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", price);
        }
    }
}