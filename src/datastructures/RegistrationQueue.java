package datastructures;
import model.Attendee;

public class RegistrationQueue {
    private Node front;
    private Node rear;

    public RegistrationQueue() {
        front = null;
        rear = null;
    }

    // Add at the back - O(1)
    public void enqueue(Attendee student) {
        if (student == null) {
            System.out.println("Cannot enqueue a null attendee.\n");
            return;
        }
        Node newNode = new Node(student);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(student.getFullName() + " added to registration line.\n");
    }

    // Remove from the front - O(1)
    public Attendee dequeue() {
        if (isEmpty()) {
            return null;
        }
        Attendee removed = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // queue became empty
        }
        // size--;
        return removed;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // code below is only for testing and checking data
    // Print front to back
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.\n");
            return;
        }
        Node current = front;
        int position = 1;
        System.out.println("Checking queue data...");
        while (current != null) {
            System.out.println(position + ". " + current.data.getFullName());
            current = current.next;
            position++;
        }
        System.out.println();
    }
}
