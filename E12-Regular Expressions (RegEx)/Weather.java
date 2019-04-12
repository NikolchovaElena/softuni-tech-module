package basicsyntax;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weather {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = "([A-Z]{2})([0-9.]+)([A-Za-z]+)\\|";
        Pattern regex = Pattern.compile(pattern);

        LinkedHashMap<String, Weather2> data = new LinkedHashMap<>();
        // List<Weather2> data = new ArrayList<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }

            Matcher m = regex.matcher(command);
            if (m.find()) {
                String city = m.group(1);
                String temperature = m.group(2);
                String weather = m.group(3);

                Weather2 currentWeather = new Weather2(city, temperature, weather);

                if (!data.containsKey(city)) {
                    data.put(city, currentWeather);
                } else {
                    data.put(city, currentWeather);
                }
            }
            m.reset();
        }
        data.entrySet().stream().sorted((x1, x2) -> x1.getValue().getNumber().compareTo(x2.getValue().getNumber()))
                .forEach(s -> System.out.printf("%s => %s => %s%n", s.getValue().getCode(), s.getValue().getNumber(),
                        s.getValue().getType()));
    }
}

class Weather2 {

    private String code;
    private String number;
    private String type;

    public Weather2(String code, String number, String type) {
        this.code = code;
        this.number = number;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}