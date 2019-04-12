package basicsyntax;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = "";
        int quantity = 0;

        LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();

        while (true) {

            resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceMap.containsKey(resource)) {
                resourceMap.put(resource, quantity);
            } else {
                int previousQuantity = resourceMap.get(resource);
                resourceMap.put(resource, previousQuantity + quantity);
            }
        }
        for (Map.Entry<String, Integer> pair : resourceMap.entrySet()) {
            System.out.printf("%s -> %d%n", pair.getKey(), pair.getValue());
        }
    }
}