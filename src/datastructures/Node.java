package datastructures;
import model.Attendee;

public class Node {
    Attendee data;
    Node next;

    public Node(Attendee data) {
        this.data = data;
    }

    public Attendee getData() {
        return data;
    }

    // methods below is for sort access
    // since next property is package-private

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
