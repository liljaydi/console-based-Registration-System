package datastructures;
import model.Attendee;

public class Node {
    Attendee data;
    Node next;

    public Node(Attendee data) {
        this.data = data;
    }

    // methods below is for search and sort access
    // since data and next properties are package-private

    public Attendee getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
