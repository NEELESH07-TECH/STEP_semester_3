
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int total = 0;
        int billed = 0;

        for (int i = 0; i < n; i++) {

            String room = sc.next();
            int units = sc.nextInt();

            if (units < 0) {

                System.out.println(
                    room + ": invalid reading"
                );

                continue;
            }

            int bill;

            if (units <= 100) {

                bill = units * 3 + 50;

            } else if (units <= 200) {

                bill = 100 * 3 +
                       (units - 100) * 5 + 50;

            } else {

                bill = 100 * 3 +
                       100 * 5 +
                       (units - 200) * 8 + 50;
            }

            System.out.println(
                room + ": " + units +
                " units, bill " + bill
            );

            total += bill;
            billed++;
        }

        System.out.println(
            "Rooms billed " + billed +
            ", total " + total
        );

        sc.close();
    }
}
