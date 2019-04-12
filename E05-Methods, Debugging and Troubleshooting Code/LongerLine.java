package basicsyntax;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        PrintLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    static double DistanceToCenter(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    }

    static void PrintClosesetLineFirst(double x1, double y1, double x2, double y2) {
        DecimalFormat df = new DecimalFormat("0.##############################################");
        if (DistanceToCenter(x1, y1) > DistanceToCenter(x2, y2)) {
            System.out.printf("(%s, %s)(%s, %s)", df.format(x2), df.format(y2), df.format(x1), df.format(y1));
        } else {
            System.out.printf("(%s, %s)(%s, %s)", df.format(x1), df.format(y1), df.format(x2), df.format(y2));
        }
    }

    static void PrintLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
                                double y4) {

        if (GetLineLength(x1, y1, x2, y2) >= GetLineLength(x3, y3, x4, y4)) {
            PrintClosesetLineFirst(x1, y1, x2, y2);
        } else {
            PrintClosesetLineFirst(x3, y3, x4, y4);
        }
    }

    static double GetLineLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
