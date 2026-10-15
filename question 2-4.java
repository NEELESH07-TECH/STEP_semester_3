import java.util.Scanner;

public class Main {
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            char ch = phone.charAt(i);

            if (ch < '0' || ch > '9') {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }
}