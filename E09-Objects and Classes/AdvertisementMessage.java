package basicsyntax;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // {phrase} {event} {author} – {city}.
        String[] phrases = new String[] { "Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product." };

        String[] events = new String[] { "Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!" };

        String[] authors = new String[] { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };

        String[] city = new String[] { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            System.out.println(phrases[random.nextInt(phrases.length)] + " " + events[random.nextInt(events.length)]
                    + " " + authors[random.nextInt(authors.length)] + " - " + city[random.nextInt(city.length)]);
        }
    }
}
