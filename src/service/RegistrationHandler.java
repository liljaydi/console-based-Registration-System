package service;
import datastructures.*;
import model.Attendee;
import util.Validation;

import java.util.Scanner;

public class RegistrationHandler {
    private Scanner sc;
    
    // records of registration line
    private RegistrationQueue queue = new RegistrationQueue();
    // records for registered student
    private AttendeeLinkedList list = new AttendeeLinkedList();
    // records for undo registration
    private RegistrationStack stack = new RegistrationStack();
    
    public RegistrationHandler(Scanner sc) {
        this.sc = sc;
    }
    
    // add student in registration queue
    public void registerAttendee() {
        System.out.print("Enter name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter course/section: ");
        String courseSection = sc.nextLine();

        // create new attendee
        Attendee student = null;
        try {
            student = new Attendee(fullName.trim(), courseSection.trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // queue student in registration line
        queue.enqueue(student);
    }

    // process registration
    public void processRegistration() {
        // checks if queue is empty
        if (queue.isEmpty()) {
            System.out.println("No pending registrations.\n");
            return;
        }

        // if registration line only has one student
        // process the student directly
        int queueSize = queue.getSize();
        if (queueSize == 1) {
            processNextRegistration();
            System.out.println();
            return;
        }

        // else display queue line and processing option
        queue.display();
        System.out.println("[1] Process Next Registration");
        System.out.println("[2] Process All Registrations");
        System.out.println("[3] Return to Main Menu");
        int choice = Validation.readValidInteger(sc, 1, 3);
        System.out.println();

        // process next student
        if (choice == 1) {
            processNextRegistration();
            System.out.println();
        }

        // process all student
        if (choice == 2) {
            processAllRegistrations(queueSize);
            System.out.println();
        }
    }

    // helper method
    private void processAllRegistrations(int count) {
        for (int i = 0; i < count; i++) {
            processNextRegistration();
        }
    }

    // helper method
    private void processNextRegistration() {
        // get the first data in queue
        Attendee student = queue.dequeue();
        
        list.append(student); // add inside linkedlist
        stack.push(student); // add inside stack
    }

    // handles displaying attendee
    public void viewAttendees() {
        // checks if list is empty
        if (list.isEmpty()) {
            System.out.println("No registered attendees found.\n");
            return;
        }

        // display registered student
        list.display();
        System.out.print("Press Enter to return to menu...");
        sc.nextLine();
        System.out.println();
    }
    
    public void searchAttendee() {
        // checks if list is empty
        if (list.isEmpty()) {
            System.out.println("No attendees available to search.\n");
            return;
        }

        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        // search student from list
        Attendee student = list.search(name);

        if (student == null) {
            System.out.println("No attendee found with that name.\n");
        } else {
            System.out.println("Attendee found!\n");
            System.out.println("Name: " + student.getFullName());
            System.out.println("Course/Section: " + student.getCourseSection() + "\n");
            System.out.print("Press Enter to return to menu...");
            sc.nextLine();
            System.out.println();
        }
    }

    // display registration history
    public void displayStack() {
        // check if stack is empty
        if (stack.isEmpty()) {
            System.out.println("No registered attendees found.\n");
            return;
        }

        // display stack
        stack.display();
        System.out.print("Press Enter to return to menu...");
        sc.nextLine();
        System.out.println();
    }

    public void undoLastRegistration() {
        // checks if stack is empty
        if (stack.isEmpty()) {
            System.out.println("No registrations available to undo.\n");
            return;
        }

        // ask for undo confirmation
        Attendee student = stack.peek();
        System.out.println("Confirm undo registration for " + student.getFullName() +"?");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");
        int choice = Validation.readValidInteger(sc, 1, 2);
        System.out.println();

        // if confirmed, remove from list
        if (choice == 1) {
            stack.pop();
            list.remove(student);
            System.out.println("Undo registration successful\n");
            return;
        }

        System.out.println("Undo registration cancelled\n");
    }
}
