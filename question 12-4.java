
interface PaymentMode {
    double processPayment(double amount);
}

class CashPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount;
    }

    public String toString() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount + (amount * 0.02);
    }

    public String toString() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount;
    }

    public String toString() {
        return "UPI";
    }
}

public class Main {

    public static void main(String[] args) {

        double[] amounts = {1000, 2000, 1500, 3000};

        PaymentMode[] payments = {
            new CashPayment(),
            new CardPayment(),
            new UpiPayment(),
            new CardPayment()
        };

        double total = 0;

        for (int i = 0; i < payments.length; i++) {

            double amount = amounts[i];

            double processed =
                payments[i].processPayment(amount);

            double fee = processed - amount;

            System.out.println(
                payments[i] + ": amount " + amount +
                ", fee " + fee +
                ", processed " + processed
            );

            total += processed;
        }

        System.out.println("Total Amount Processed: " + total);
    }
}
