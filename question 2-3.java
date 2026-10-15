import java.util.Scanner;

public class Main {
    static String validateFileExtension(String filename) {
        int index = filename.lastIndexOf('.');

        if (index == -1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(index + 1);

        if (ext.equalsIgnoreCase("pdf")
                || ext.equalsIgnoreCase("docx")
                || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();

        System.out.println(validateFileExtension(filename));
    }
}