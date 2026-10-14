
import java.util.*;

abstract class Vehicle {
    abstract double charge(int hours);
}

class Bike extends Vehicle {
    double charge(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {
    double charge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    double charge(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v;

            switch (type) {
                case "BIKE":
                    v = new Bike();
                    break;
                case "CAR":
                    v = new Car();
                    break;
                default:
                    v = new Truck();
            }

            double amount = v.charge(hours);
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
