import java.util.*;

interface Insurable {
    double getInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double getCharge();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance() {
        return value * 0.02;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD"))
                parcel = new Standard(weight, value);
            else if (type.equals("EXPRESS"))
                parcel = new Express(weight, value);
            else
                parcel = new Fragile(weight, value);

            double charge = parcel.getCharge();
            double insurance = 0;

            if (parcel instanceof Insurable)
                insurance = ((Insurable) parcel).getInsurance();

            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}