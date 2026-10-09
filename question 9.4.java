import java.util.*;

interface NightService {
    double nightFare(double fare);
}

abstract class Cab {
    abstract double rate();

    double fare(double km) {
        return Math.max(100, km * rate());
    }
}

class Mini extends Cab {
    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    double rate() {
        return 14;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    double rate() {
        return 18;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
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

            if (time.equals("NIGHT") &&
                !(cab instanceof NightService)) {
                System.out.println(
                    type + ": night service not available"
                );
                continue;
            }

            double fare = cab.fare(km);

            if (time.equals("NIGHT"))
                fare = ((NightService) cab).nightFare(fare);

            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}