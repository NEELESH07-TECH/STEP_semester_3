class MessWallet {
    private double balance;

    public MessWallet(double balance) {
        if (balance < 0) {
            this.balance = 0;
            System.out.println("Warning: Invalid opening balance");
        } else {
            this.balance = balance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid top-up amount");
        } else {
            balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deduction amount");
        } else if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());

        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}