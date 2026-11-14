
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    // Insert at beginning
    static Node addFirst(Node head, String name) {

        Node newNode = new Node(name);

        newNode.next = head;
        head = newNode;

        return head;
    }

    // Insert at end
    static Node addLast(Node head, String name) {

        Node newNode = new Node(name);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    // Print linked list
    static void printList(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node("Asha");
        head.next = new Node("Ravi");

        head = addFirst(head, "Neha");
        head = addLast(head, "Kiran");
        head = addFirst(head, "Mohan");

        printList(head);
    }
}
