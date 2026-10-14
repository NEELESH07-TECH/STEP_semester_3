
import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    abstract int validity();

    LocalDate renew(LocalDate date) {
        return date.plusDays(validity());
    }
}

class Basic extends Plan {
    int validity() {
        return 30;
    }
}

class Standard extends Plan {
    int validity() {
        return 90;
    }
}

class Premium extends Plan {
    int validity() {
        return 365;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan p;

            switch (type) {
                case "BASIC":
                    p = new Basic();
                    break;
                case "STANDARD":
                    p = new Standard();
                    break;
                default:
                    p = new Premium();
            }

            System.out.println(name + ": " + p.renew(date));
        }
    }
}
