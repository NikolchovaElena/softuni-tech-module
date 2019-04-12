package basicsyntax;

import java.util.Scanner;

public class CubeProperties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side = Double.parseDouble(scanner.nextLine());
        String parameter = scanner.nextLine();

        CalculateCubeProperty(side,parameter);
    }

    static void CalculateCubeProperty(double s, String parameter) {
        double value = 0;

        switch (parameter) {
            case "face":
                value = Math.sqrt(2 * s * s);
                break;
            case "space":
                value = Math.sqrt(3 * s * s);
                break;
            case "volume":
                value = Math.pow(s, 3);
                break;
            case "area":
                value = 6 * s * s;
                break;
        }
        System.out.printf("%.2f",value);
    }
}
