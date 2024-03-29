import java.util.LinkedList;
import java.util.Scanner;

public class merge {

    public static void printList(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        int middle = list.size() / 2;
        LinkedList<Integer> left = new LinkedList<>(list.subList(0, middle));
        LinkedList<Integer> right = new LinkedList<>(list.subList(middle, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> merged = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst() <= right.getFirst()) {
                merged.add(left.removeFirst());
            } else {
                merged.add(right.removeFirst());
            }
        }
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            list.add(m);
        }

        LinkedList<Integer> sortedList = mergeSort(list);
        System.out.println("Sorted List: ");
        printList(sortedList);
    }
}
