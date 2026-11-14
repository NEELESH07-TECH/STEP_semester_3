
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static Node removeFirst(Node head, int booking) {

        // If list is empty
        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        // If booking is at head
        if (head.data == booking) {
            return head.next;
        }

        Node current = head;

        // Search for booking
        while (current.next != null &&
               current.next.data != booking) {
            current = current.next;
        }

        // If booking not found
        if (current.next == null) {
            System.out.println(booking + " not found");
        } else {
            current.next = current.next.next;
        }

        return head;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(104);
        head.next = new Node(101);
        head.next.next = new Node(107);
        head.next.next.next = new Node(101);

        int booking = 101;

        head = removeFirst(head, booking);

        printList(head);
    }
}
