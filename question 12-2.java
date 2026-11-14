
import java.util.Scanner;

class Student {
    private String name;
    private int m1, m2, m3;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {

        if (a < 0 || a > 100 ||
            b < 0 || b > 100 ||
            c < 0 || c > 100) {
            return false;
        }

        m1 = a;
        m2 = b;
        m3 = c;

        return true;
    }

    int getTotal() {
        return m1 + m2 + m3;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getGrade() {

        double avg = getAverage();

        if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 40)
            return "D";
        else
            return "F";
    }

    public String toString() {
        return name + " total=" + getTotal()
            + " avg=" + String.format("%.2f", getAverage())
            + " grade=" + getGrade();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] s = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student temp = new Student(name);

            if (temp.setMarks(a, b, c)) {
                s[count++] = temp;
            } else {
                System.out.println(name +
                    " skipped: marks must be 0 to 100");
            }
        }

        // Bubble Sort in descending order
        int passes = 0;

        for (int i = 0; i < count - 1; i++) {

            boolean swapped = false;

            for (int j = count - 1; j > i; j--) {

                if (s[j].getTotal() >
                    s[j - 1].getTotal()) {

                    Student temp = s[j];
                    s[j] = s[j - 1];
                    s[j - 1] = temp;

                    swapped = true;
                }
            }

            passes++;

            if (!swapped)
                break;
        }

        // Print ranked students
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + s[i]);
        }

        System.out.println("Sorted in " + passes + " passes");

        sc.close();
    }
}
