
import java.util.*;

abstract class Customer {
    abstract double calculate(double amount);
}

class Student extends Customer {
    double calculate(double amount) {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    double calculate(double amount) {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    double calculate(double amount) {
        return amount + 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer c;

            switch (type) {
                case "STUDENT":
                    c = new Student();
                    break;
                case "STAFF":
                    c = new Staff();
                    break;
                default:
                    c = new Guest();
            }

            double bill = c.calculate(amount);
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
