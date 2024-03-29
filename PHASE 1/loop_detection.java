import java.util.*;

class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
}

public class loop_detection {

    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.num + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static void createCycle(Node head, int a) {
        int cnta = 0;
        Node p1 = head;
        Node p2 = head;
        while (cnta < a) {
            p1 = p1.next;
            cnta++;
        }
        while (p2.next != null) {
            p2 = p2.next;
        }
        p2.next = p1;
    }

    static boolean cycleDetect(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            head = insertNode(head, m);
        }
        display(head);
        int a = sc.nextInt();
        createCycle(head, a);
        if (cycleDetect(head)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}
