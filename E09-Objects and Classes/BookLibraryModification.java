package basicsyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TreeMap;

public class BookLibraryModification {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, LocalDate> library = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            Book book = new Book(input[0], input[1], input[2],
                    LocalDate.parse(input[3], formatter), input[4],
                    Double.parseDouble(input[5]));

            library.put(book.getTitle(), book.getReleaseDate());
        }

        LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);

        library.entrySet().stream().filter(s->s.getValue().isAfter(date))
                .sorted((a,b)->a.getValue().compareTo(b.getValue()))
                .forEach(s->{
                    System.out.println(s.getKey()+" -> "+s.getValue().format(formatter));
                });
    }

    static class Book {
        private String title;
        private String author;
        private String publisher;
        private LocalDate releaseDate;
        private String isbn;
        private double price;

        public Book(String title, String author, String publisher, LocalDate releaseDate, String isbn, double price) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.releaseDate = releaseDate;
            this.isbn = isbn;
            this.price = price;

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public LocalDate getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }
}