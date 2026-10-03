import java.util.*;

interface NightService {
    double NIGHT_CHARGE = 0.20;

    default double applyNightCharge(double fare) {
        return fare + fare * NIGHT_CHARGE;
    }
}

abstract class Cab {
    abstract double getRate();

    double calculateFare(double km) {
        double fare = km * getRate();
        return Math.max(fare, 100);
    }
}

class Mini extends Cab {
    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    double getRate() {
        return 14;
    }
}

class SUV extends Cab implements NightService {
    double getRate() {
        return 18;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI"))
                cab = new Mini();
            else if (type.equals("SEDAN"))
                cab = new Sedan();
            else
                cab = new SUV();

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}