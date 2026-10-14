
import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    PartTime(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return 2000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee e;

            switch (type) {
                case "FULLTIME":
                    e = new FullTime(name, salary);
                    break;
                case "PARTTIME":
                    e = new PartTime(name, salary);
                    break;
                default:
                    e = new Intern(name, salary);
            }

            double amount = e.bonus();
            System.out.printf("%s: %.2f%n", e.name, amount);
            total += amount;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
