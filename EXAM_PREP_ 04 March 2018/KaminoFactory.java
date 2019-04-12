package basicsyntax;

import java.util.Arrays;
import java.util.Scanner;

//Score 90/100
public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.println("0");
        }

        int[] topSample = new int[n];
        int topLength = 1;
        int topIndex = 0;
        int topSum = 0;
        int bestSequence = 0;
        int count = 0;

        while (true) {

            String command = scanner.nextLine();

            if (command.equals("Clone them!")) {
                break;
            }
            count++;
            int bestLength = 1;
            int currentLength = 1;
            int startIndex = 0;
            int maxIndex = 0;
            int sum = 0;

            int[] sample = Arrays.stream(command.split("!+")).mapToInt(Integer::parseInt).toArray();
            if (sample[0] == 1) {
                sum = 1;
            }

            for (int i = 1; i < sample.length; i++) {
                if (sample[i] == 1) {
                    sum++;
                }

                if (sample[i] == 1 && sample[i - 1] == 1) {
                    currentLength++;
                    if (currentLength > bestLength) {
                        bestLength = currentLength;
                        maxIndex = startIndex;
                    }
                } else {
                    currentLength = 1;
                    startIndex = i;
                }
            }

            if (bestLength > topLength) {
                topLength = bestLength;
                topIndex = maxIndex;
                topSum = sum;
                bestSequence = count;
                topSample = sample;

            } else if (bestLength == topLength) {

                if (maxIndex < topIndex) {
                    topSample = sample;
                    topIndex = maxIndex;
                    topSum = sum;
                    bestSequence = count;

                } else if (maxIndex == topIndex) {

                    if (sum > topSum) {
                        topSample = sample;
                        topSum = sum;
                        bestSequence = count;
                    }
                }
            }
        }

        System.out.printf("Best DNA sample %d with sum: %s.%n", bestSequence, topSum);
        for (int i : topSample) {
            System.out.print(i + " ");
        }
    }
}
