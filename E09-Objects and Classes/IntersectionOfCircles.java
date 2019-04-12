package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfCircles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Circle c1 = readCircle(scanner);
        Circle c2 = readCircle(scanner);
        if (Intersect(c1, c2)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    static boolean Intersect(Circle c1, Circle c2) {

        int d = Math.abs((c1.center.getX() - c2.center.getX()) * (c1.center.getY() - c2.center.getY()));
        if (d <= c1.getR() + c2.getR()) {
            return true;
        } else {
            return false;
        }
    }

    private static Circle readCircle(Scanner scanner) {
        int[] inputValues = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int x = inputValues[0];
        int y = inputValues[1];
        int r = inputValues[2];

        Point point = new Point(x, y);
        Circle circle = new Circle(point, r);
        return circle;
    }

    static class Circle {
        private Point center;
        private int r;

        public Circle(Point center, int r) {
            this.r = r;
            this.center = center;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getR() {
            return r;
        }

        public void setCenter(Point center) {
            this.center = center;
        }

        public Point getCenter() {
            return center;
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}