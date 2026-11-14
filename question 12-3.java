
class Library {

    String[] stack = new String[3];
    int top = -1;

    String[] queue = new String[3];
    int front = 0, rear = 0, size = 0;

    // Add book to stack
    void RETURN(String book) {

        if (top == 2) {
            System.out.println(book +
                " rejected: pile is full");
            return;
        }

        stack[++top] = book;

        System.out.println(book + " placed on pile");
    }

    // Remove top book
    void SHELVE() {

        if (top == -1) {
            System.out.println("pile is empty");
            return;
        }

        System.out.println("shelved " + stack[top]);
        top--;
    }

    // Add student to circular queue
    void WAIT(String name) {

        if (size == 3) {
            System.out.println("line is full");
            return;
        }

        queue[rear] = name;
        rear = (rear + 1) % 3;
        size++;

        System.out.println(name + " joined the line");
    }

    // Remove student from queue
    void SERVE() {

        if (size == 0) {
            System.out.println("no one waiting");
            return;
        }

        System.out.println("served " + queue[front]);

        front = (front + 1) % 3;
        size--;
    }
}

public class Main {

    public static void main(String[] args) {

        Library l = new Library();

        l.RETURN("B1");
        l.RETURN("B2");
        l.RETURN("B3");
        l.RETURN("B4");

        l.WAIT("Asha");
        l.WAIT("Ravi");

        l.SHELVE();
        l.SERVE();

        l.SHELVE();
        l.SHELVE();
        l.SHELVE();

        l.SERVE();
        l.SERVE();
    }
}
