import java.util.*;

interface Transport {
    double transportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        double fee = tuition();

        if (this instanceof Transport)
            fee += ((Transport) this).transportFee();

        return fee;
    }
}

class DayScholar extends Student implements Transport {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }

    public double transportFee() {
        return 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements Transport {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }

    public double transportFee() {
        return 12000;
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

            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.totalFee();
            total += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}