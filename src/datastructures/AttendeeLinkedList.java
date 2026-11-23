package datastructures;
import algorithms.*;
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
        // create new Node for linkedlist
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

        System.out.println(student.getFullName() + " registered!");
    }

    // display registered student
    public void display() {
        // sort linkedlist first before displaying
        sort();

        // display sorted linkedlist
        System.out.println("Attendee List:");

        Node current = head;
        int count = 1;
        while (current != null) {
            String fullName = current.data.getFullName();
            String courseSection = current.data.getCourseSection();

            // display student information
            System.out.println(count++ + ". Name: " + fullName);
            System.out.println("   Course/Section: " + courseSection);

            current = current.next;
        }
        System.out.println();
    }

    // helper method
    // calls sortNodes() method from 'algorithms' package
    private void sort() {
        // returns the sorted head
        head = MergeSort.sortNodes(head);
        tail = head;

        // update tail after sorting
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
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

    // call search method here 
    // since we want to encapsulate head property
    // we will not add a getter/setters for LinearSearch.java
    public Attendee search(String name) {
        return LinearSearch.search(head, name);
    }
}
