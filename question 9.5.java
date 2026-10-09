import java.util.*;

interface SaverMode {
    double saveEnergy(double units);
}

abstract class Appliance {
    abstract double power();

    double units(double hours) {
        return power() * hours / 1000;
    }
}

class Fridge extends Appliance {
    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    double power() {
        return 1500;
    }

    public double saveEnergy(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    double power() {
        return 500;
    }

    public double saveEnergy(double units) {
        return units * 0.75;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length == 3 &&
                            input[2].equals("SAVER");

            Appliance a;

            if (type.equals("FRIDGE"))
                a = new Fridge();
            else if (type.equals("AC"))
                a = new AC();
            else if (type.equals("TV"))
                a = new TV();
            else
                a = new Washer();

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(
                    type + ": saver mode not supported"
                );
                continue;
            }

            double units = a.units(hours);

            if (saver)
                units = ((SaverMode) a).saveEnergy(units);

            double cost = units * 8;
            total += cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", total);
    }
}   