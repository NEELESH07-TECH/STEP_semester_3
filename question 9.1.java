import java.util.*;

abstract class Ticket {
    static final double FEE = 20;

    abstract double price();

    double calculate(int count) {
        return count * (price() + FEE);
    }
}

class Regular extends Ticket {
    double price() {
        return 150;
    }
}

class Premium extends Ticket {
    double price() {
        return 250;
    }
}

class Recliner extends Ticket {
    double price() {
        return 400;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Ticket t;

            if (type.equals("REGULAR"))
                t = new Regular();
            else if (type.equals("PREMIUM"))
                t = new Premium();
            else
                t = new Recliner();

            double amount = t.calculate(count);
            total += amount;

            System.out.printf("%s: %.2f%n", type, amount);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}