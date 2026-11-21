package datastructures;
import model.Attendee;

public class RegistrationStack {
    private Node top;
    private int size;

    public RegistrationStack() {
        top = null;
        size = 0;
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
        size++;
    }

    // Remove from top - O(1)
    public Attendee pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.\n");
            return null;
        }
        Attendee removed = top.data;
        top = top.next;
        size--;
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
        System.out.println("Registration history:");
        while (current != null) {
            System.out.println(position + ". " 
                + current.data.getFullName() + " - " 
                + current.data.getCourseSection());
            current = current.next;
            position++;
        }
        System.out.println();
    }

    public Attendee peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.\n");
            return null;
        }
        return top.data;
    }

    public int getSize() {
        return size;
    }
}
