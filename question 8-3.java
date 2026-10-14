
import java.util.*;

abstract class Room {
    abstract double bill(int units);
}

class Single extends Room {
    double bill(int units) {
        return units * 8;
    }
}

class Shared extends Room {
    int occupants;

    Shared(int occupants) {
        this.occupants = occupants;
    }

    double bill(int units) {
        return units * 6.0 / occupants;
    }
}

class AC extends Room {
    double bill(int units) {
        return units * 10 + 200;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            switch (type) {
                case "SINGLE":
                    r = new Single();
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    r = new Shared(occupants);
                    break;
                default:
                    r = new AC();
            }

            double amount = r.bill(units);
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
