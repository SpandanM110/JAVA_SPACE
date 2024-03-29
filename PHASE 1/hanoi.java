import java.util.Scanner;

public class hanoi {

    static void towerOfHanoi(int numOfDisks, char source, char destination, char auxiliary) {
        if (numOfDisks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(numOfDisks - 1, source, auxiliary, destination);
        System.out.println("Move disk " + numOfDisks + " from " + source + " to " + destination);
        towerOfHanoi(numOfDisks - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numOfDisks = scanner.nextInt();
        scanner.close();
        towerOfHanoi(numOfDisks, 'A', 'C', 'B');
    }
}
