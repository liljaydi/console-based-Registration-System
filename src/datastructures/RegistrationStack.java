package datastructures;
import model.Attendee;

public class RegistrationStack {
    private Node top;

    public RegistrationStack() {
        top = null;
    }

    // Add on top - O(1)
    public void push(Attendee student) {
        if (student == null) {
            System.out.println("Cannot push a null attendee.\n");
            return;
        }
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    // Remove from top - O(1)
    public Attendee pop() {
        if (isEmpty()) {
            return null;
        }
        Attendee removed = top.data;
        top = top.next;
        return removed;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // code below is only for testing and checking data
    // Print top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.\n");
            return;
        }
        Node current = top;
        int position = 1;
        System.out.println("Checking stack data...");
        while (current != null) {
            System.out.println(position + ". " + current.data.getFullName());
            current = current.next;
            position++;
        }
        System.out.println();
    }
}
