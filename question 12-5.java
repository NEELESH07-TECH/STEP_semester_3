
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;
    int size = 0;

    // Push operation
    void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate +
                " -> top " + top.data + ", size " + size);
    }

    // Pop operation
    void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }

        String plate = top.data;
        top = top.next;
        size--;

        if (top == null) {
            System.out.println("pop -> " + plate + ", size " + size);
        } else {
            System.out.println("pop -> " + plate +
                    ", size " + size);
        }
    }

    // Peek operation
    void peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
        } else {
            System.out.println("peek -> " + top.data);
        }
    }

    // Check empty
    boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {

        Stack s = new Stack();

        s.push("P1");
        s.push("P2");
        s.peek();
        s.pop();
        s.push("P3");
        s.pop();
        s.pop();
        s.pop();

        System.out.println("isEmpty -> " + s.isEmpty());
    }
}
