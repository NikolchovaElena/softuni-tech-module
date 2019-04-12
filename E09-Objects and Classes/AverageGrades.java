package basicsyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            students.add(readStudent(scanner));
        }

        students.stream().filter(s -> s.getAverage() >= 5.00).sorted((a, b) -> {
            int result = a.GetName().compareTo(b.GetName());
            if (result == 0) {
                result = Double.compare(b.getAverage(), a.getAverage());
            }
            return result;
        }).forEach(s -> {
            System.out.printf("%s -> %.2f%n", s.GetName(), s.getAverage());
        });
    }

    private static Student readStudent(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        String name = input[0];

        List<Double> grades = new ArrayList<>();

        for (int i = 1; i < input.length; i++) {

            grades.add(Double.parseDouble(input[i]));
        }
        Student stud = new Student(name, grades);
        return stud;
    }

    static class Student {
        private String name;
        private List<Double> grades = new ArrayList<>();
        private Double average;

        public Student(String name, List<Double> grades) {
            this.name = name;
            this.grades = grades;

            Double total = 0.0;
            for (Double grade : grades) {
                total += grade;
            }
            this.average = total / grades.size();
        }

        public void SetName(String name) {
            this.name = name;
        }

        public String GetName() {
            return name;
        }

        public void SetGrades(List<Double> grades) {
            this.grades = grades;
        }

        public List<Double> GetGrades() {
            return grades;
        }

        public Double getAverage() {
            return average;
        }
    }
}
