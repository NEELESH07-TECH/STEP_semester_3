
class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    double getTotal() {
        return baseSalary + getBonus();
    }

    String getType() {
        return "Staff";
    }
}

class Teacher extends Staff {

    Teacher(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {

    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class Main {
    public static void main(String[] args) {

        Staff[] s = {
            new Teacher("Rahul", 30000),
            new LabAssistant("Priya", 20000),
            new Staff("Amit", 25000),
            new Teacher("Sneha", 35000),
            new LabAssistant("Karan", 18000)
        };

        double grandTotal = 0;

        for (Staff x : s) {

            System.out.println(
                x.name + " (" + x.getType() +
                "): base " + x.baseSalary +
                ", bonus " + x.getBonus() +
                ", total " + x.getTotal()
            );

            grandTotal += x.getTotal();
        }

        System.out.println("Grand Total Salary: " + grandTotal);
    }
}
