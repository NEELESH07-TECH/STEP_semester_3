import java.util.*;

interface SaverMode {
    default double applySaver(double units) {
        return units * 0.75;
    }
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] data = line.split("\\s+");

            String type = data[0];
            double hours = Double.parseDouble(data[1]);
            boolean saver = data.length == 3;

            Appliance appliance;

            if (type.equals("FRIDGE"))
                appliance = new Fridge(hours);
            else if (type.equals("AC"))
                appliance = new AC(hours);
            else if (type.equals("TV"))
                appliance = new TV(hours);
            else
                appliance = new Washer(hours);

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver)
                units = ((SaverMode) appliance).applySaver(units);

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}