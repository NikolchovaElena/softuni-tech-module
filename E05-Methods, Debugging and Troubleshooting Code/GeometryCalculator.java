package basicsyntax;

import java.util.Scanner;

public class GeometryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figureType = scanner.nextLine();
        double a = Double.parseDouble(scanner.nextLine());

        if (figureType.equals("rectangle") || figureType.equals("triangle")) {
            double b = Double.parseDouble(scanner.nextLine());
            GetAreaOfRectangleOrTriangle(figureType, a, b);
        }else {
            GetAreaOfSquareOrCircle(figureType, a);
        }

    }

    static void GetAreaOfSquareOrCircle(String figureType, double a) {
        double area = 0;

        if ("square".equals(figureType)) {
            area = a * a;
        } else if ("circle".equals(figureType)) {
            area = Math.PI * a * a;
        }
        System.out.printf("%.2f", area);
    }

    static void GetAreaOfRectangleOrTriangle(String figureType, double a, double b) {
        double area = 0;

        if ("rectangle".equals(figureType)) {
            area = a * b;
        } else if ("triangle".equals(figureType)) {
            area = a * b / 2;
        }
        System.out.printf("%.2f", area);
    }
}