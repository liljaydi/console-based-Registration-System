package algorithms;
import datastructures.Node;
import model.Attendee;

public class LinearSearch {
    public static Attendee search(Node head, String name) {
        if (head == null || name == null) {
            return null;
        }

        Node current = head;
        String searchName = name.trim();

        while (current != null) {
            Attendee student = current.getData();

            if (student.getFullName().equalsIgnoreCase(searchName)) {
                return student;
            }

            current = current.getNext();
        }

        return null;
    }
}
