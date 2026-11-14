
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static String find(Node head, String id) {

        int position = 1;
        int copies = 0;
        int firstPosition = -1;

        Node current = head;

        while (current != null) {

            if (current.data.equals(id)) {

                copies++;

                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }

            current = current.next;
            position++;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " +
               firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {

        Node head = new Node("B12");
        head.next = new Node("B07");
        head.next.next = new Node("B30");
        head.next.next.next = new Node("B07");
        head.next.next.next.next = new Node("B45");
        head.next.next.next.next.next = new Node("B07");

        System.out.println(find(head, "B07"));
    }
}
