
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] rain = new double[7];

        double total = 0;
        double max = 0;

        int wettestDay = 1;
        int dryDays = 0;

        // Read rainfall values
        for (int i = 0; i < 7; i++) {
            rain[i] = sc.nextDouble();
        }

        // Calculate total, maximum and dry days
        max = rain[0];

        for (int i = 0; i < 7; i++) {

            total += rain[i];

            if (rain[i] > max) {
                max = rain[i];
                wettestDay = i + 1;
            }

            if (rain[i] == 0) {
                dryDays++;
            }
        }

        double average = total / 7;

        // Print rainfall values
        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.print(rain[i] + " ");
        }

        System.out.println();

        System.out.println("Total Rainfall: " + total + " mm");

        System.out.printf("Average Rainfall: %.2f mm%n",
                          average);

        System.out.println("Wettest Day: Day " +
            wettestDay + " (" + max + " mm)");

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}
