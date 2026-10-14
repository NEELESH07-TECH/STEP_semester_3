
import java.util.*;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double salary) {
        if (salary < 0) {
            System.out.println("Invalid salary");
            basicSalary = 0;
        } else {
            basicSalary = salary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax");
        } else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + 
                (int)percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double salary = sc.nextDouble();
        double bonus = sc.nextDouble();
        double tax = sc.nextDouble();

        PayrollAccount p = new PayrollAccount(salary);
        p.creditBonus(bonus);
        p.deductTax(tax);

        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}
