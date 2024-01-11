package intermediate.nov_10;

public class RotateMatrixNew {
    static int n = 4;

    static void print(int mat[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    static void rotate90clockwise(int mat[][]) {

        // Transpose of matrix
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }

        // Reverse individual rows
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                int t = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = t;
                low++;
                high--;
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate90clockwise(mat);
        print(mat);
    }
}



