
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static Node build(String[] stops) {
        Node head = new Node(stops[0]);
        Node current = head;

        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }

        return head;
    }

    static void printRoute(Node head) {
        Node current = head;
        int count = 0;
        String first = head.data;
        String last = "";

        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {

        String[] stops = {
            "Tambaram", "Guindy", "TNagar", "Central"
        };

        Node head = build(stops);
        printRoute(head);
    }
}
