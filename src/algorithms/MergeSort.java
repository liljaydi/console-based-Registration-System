package algorithms;
import datastructures.Node;

public class MergeSort {
    public static Node sortNodes(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node sortedHead = mergeSortHelper(head);
        return sortedHead;
    }

    private static Node mergeSortHelper(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node secondHalf = slow.getNext();
        slow.setNext(null);

        Node left = mergeSortHelper(head);
        Node right = mergeSortHelper(secondHalf);

        return merge(left, right);
    }

    private static Node merge(Node left, Node right) {
        Node mergedHead = null;
        Node mergedTail = null;

        while (left != null && right != null) {
            Node nextNode;
            
            if (left.getData().getFullName().compareToIgnoreCase(right.getData().getFullName()) <= 0) {
                nextNode = left;
                left = left.getNext();
            } else {
                nextNode = right;
                right = right.getNext();
            }

            if (mergedHead == null) {
                mergedHead = nextNode;
                mergedTail = nextNode;
            } else {
                mergedTail.setNext(nextNode);
                mergedTail = nextNode;
            }
        }

        if (left != null) {
            if (mergedHead == null) {
                mergedHead = left;
            } else {
                mergedTail.setNext(left);
            }
        } else if (right != null) {
            if (mergedHead == null) {
                mergedHead = right;
            } else {
                mergedTail.setNext(right);
            }
        }

        return mergedHead;
    }
}
