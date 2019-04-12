package basicsyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> broadcasts = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        String broadcastRecipient = "";
        String broadcastMessage = "";
        String messageFriquency = "";
        String messageMessage = "";

        Pattern patMessage = Pattern.compile("^([0-9]+) <-> ([0-9A-Za-z]+)$");
        Pattern patBroadcast = Pattern.compile("^(\\D+) <-> ([0-9A-Za-z]+)$");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Hornet is Green")) {
                break;
            }
            Matcher mMessage = patMessage.matcher(input);
            Matcher mBroadcast = patBroadcast.matcher(input);

            if (mMessage.matches()) {
                StringBuilder recipient = new StringBuilder(mMessage.group(1));
                broadcastRecipient = recipient.reverse().toString();
                broadcastMessage = mMessage.group(2);

                String temp = broadcastRecipient + " -> " + broadcastMessage;
                broadcasts.add(temp);

            } else if (mBroadcast.matches()) {
                String oldFriquency = mBroadcast.group(2);
                StringBuilder friquency = new StringBuilder();
                messageMessage = mBroadcast.group(1);

                for (int i = 0; i < oldFriquency.length(); i++) {
                    char ch = oldFriquency.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        ch = Character.toLowerCase(ch);
                        friquency.append(ch);
                    } else {
                        ch = Character.toUpperCase(ch);
                        friquency.append(ch);
                    }
                }
                messageFriquency = friquency.toString();
                String temp = messageFriquency + " -> " + messageMessage;
                messages.add(temp);
            }
        }
        System.out.println("Broadcasts:");
        if (messages.isEmpty()) {
            System.out.println("None");
        } else {
            messages.stream().forEach(s -> {
                System.out.println(s);
            });
        }

        System.out.println("Messages:");

        if (broadcasts.isEmpty()) {
            System.out.println("None");
        } else {
            broadcasts.stream().forEach(s -> {
                System.out.println(s);
            });
        }
    }
}