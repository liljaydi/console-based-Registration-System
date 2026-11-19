package service;
import datastructures.*;
import algorithms.*;
import model.Attendee;
import java.util.Scanner;

public class RegistrationHandler {
    Scanner sc;
    // records of registration line
    RegistrationQueue queue = new RegistrationQueue();
    // records for registered student
    AttendeeLinkedList list = new AttendeeLinkedList();
    // records for undo registration
    RegistrationStack stack = new RegistrationStack();
    
    public RegistrationHandler(Scanner sc) {
        this.sc = sc;
    }

    // add student in registration queue
    public void registerAttendee() {
        System.out.print("Enter name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter course and section: ");
        String courseSection = sc.nextLine();

        Attendee student = new Attendee(fullName, courseSection);

        queue.enqueue(student);

        queue.display(); // this code is for data checking
    }

    // process registration
    public void processRegistration() {
        // checks if queue is empty
        if (queue.isEmpty()) {
            System.out.println("No pending registrations.\n");
            return;
        }
        
        // get the first data in queue
        Attendee student = queue.dequeue();
        
        list.append(student); // add inside linkedlist
        queue.display(); // this code is for data checking
        stack.push(student); // add inside stack

        stack.display(); // this code is for data checking
    }

    // handles displaying attendee
    public void viewAttendees() {
        // checks if list is empty
        if (list.isEmpty()) {
            System.out.println("No registered attendees found.\n");
            return;
        }

        MergeSort.sort(list);
        list.display();
    }
    
    public void searchAttendee() {
        // checks if list is empty
        if (list.isEmpty()) {
            System.out.println("No attendees available to search.\n");
            return;
        }

        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        Attendee student = LinearSearch.search(list, name);

        if (student == null) {
            System.out.println("No attendee found with that name.\n");
        } else {
            System.out.println("Attendee found!");
            System.out.println("Name: " + student.getFullName());
            System.out.println("Course & Section: " + student.getCourseSection() + "\n");
        }
    }

    public void undoLastRegistration() {
        // checks if stack is empty
        if (stack.isEmpty()) {
            System.out.println("No registrations available to undo.\n");
            return;
        }
        
        Attendee student = stack.pop();

        list.remove(student);

        System.out.println("Undo " + student.getFullName() + " registration\n");

        stack.display(); // this code is for data checking
    }
}
