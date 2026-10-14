
import java.util.*;

class BookInventory {
    String title, author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory[] books = new BookInventory[4];

        for (int i = 0; i < 4; i++) {
            String[] data = sc.nextLine().split(",", 3);
            books[i] = new BookInventory(
                data[0].trim(),
                data[1].trim(),
                Integer.parseInt(data[2].trim())
            );
        }

        for (BookInventory b : books) {
            b.printEntry();
        }
    }
}
