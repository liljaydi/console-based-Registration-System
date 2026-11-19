package datastructures;
import model.Attendee;

public class AttendeeLinkedList {
    private Node head;
    private Node tail;

    public AttendeeLinkedList() {
        head = null;
        tail = null;
    }

    // add registered student inside linkedlist
    public void append(Attendee student) {
        if (student == null) {
            System.out.println("Cannot append a null attendee");
            return;
        }
        Node newNode = new Node(student);

        System.out.print("Processing... ");

        // updates head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println(student.getFullName() + " registered!\n");
    }

    // display registered student
    public void display() {
        System.out.println("Atendee List:");

        Node current = head;
        int count = 1;
        while (current != null) {
            String fullName = current.data.getFullName();
            String courseSection = current.data.getCourseSection();

            // display student information
            System.out.println(count++ + ". Name: " + fullName);
            System.out.println("   Course & Section: " + courseSection);

            current = current.next;
        }
        System.out.println();
    }

    // removes registered student
    public void remove(Attendee student) {
        if (student == null) {
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == student) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

                if (current == tail) {
                    tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    // setters and getters below is used for Linear Search
    // since Linear Search is outside the package 'datastructures'
    // head and tail are not directly accessible by 'algorithms' package

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
