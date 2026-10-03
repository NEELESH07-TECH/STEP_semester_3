import java.util.*;

abstract class Ticket {
    protected int count;
    protected static final double FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getAmount() {
        return count * (getPrice() + FEE);
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
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

            Ticket ticket;

            if (type.equals("REGULAR"))
                ticket = new Regular(count);
            else if (type.equals("PREMIUM"))
                ticket = new Premium(count);
            else
                ticket = new Recliner(count);

            double amount = ticket.getAmount();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}