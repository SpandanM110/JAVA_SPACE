import java.util.Scanner;

public class sortdll{
    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node sort(Node head) {
        // Bubble Sort Algorithm for sorting the doubly linked list
        if (head == null || head.next == null)
            return head;

        Node temp;
        Node current = head;
        boolean swapped;
        
        do {
            swapped = false;
            current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    // Swap data
                    int t = current.data;
                    current.data = current.next.data;
                    current.next.data = t;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        return head;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        new_node.prev = null;
        if (head_ref != null)
            head_ref.prev = new_node;
        head_ref = new_node;
        return head_ref;
    }

    static void printlist(Node head) {
        if (head == null) {
            System.out.println("Doubly linked list empty");
            return;
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(); // Print a newline after printing the list
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            head = push(head, m);
        }
        head = sort(head);
        System.out.println("Doubly linked list after sorting");
        printlist(head);
    }
}
