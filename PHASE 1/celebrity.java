import java.util.*;

public class celebrity {
    public static int celebritySolution(int[][] mat) {
        Stack<Integer> stk = new Stack<>();
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            stk.push(i);
        }
        while (stk.size() > 1) {
            int col = stk.pop();
            int row = stk.pop();
            if (mat[row][col] == 1) {
                stk.push(col);
            } else {
                stk.push(row);
            }
        }
        int potentialCelebrity = stk.pop();
        for (int i = 0; i < n; i++) {
            if (i == potentialCelebrity) continue;
            if (mat[potentialCelebrity][i] == 1 || mat[i][potentialCelebrity] == 0) {
                return -1;
            }
        }
        return potentialCelebrity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = celebritySolution(matrix);
        if (res == -1) {
            System.out.println("No celebrity");
        } else {
            System.out.println("Celebrity is: " + res);
        }
    }
}
