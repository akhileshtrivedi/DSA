package intermediate.dec_9;

import java.util.Scanner;

public class MatrixAdditionDemo {
    static   int rowSize=0, colSize=0;
    static class Matrix {

        static void printMatrix() {
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++)
                   // System.out.print(A[i][j] + " ");

                System.out.println();
            }
        }

        static int[][] add(int A[][], int B[][], int row, int col) {
            int i, j;
            int C[][] = new int[row][col];

            for (i = 0; i < row; i++)
                for (j = 0; j < col; j++)
                    C[i][j] = A[i][j] + B[i][j];

            return C;
        }

        static int[][] subtract(int A[][], int B[][], int row, int col) {
            int i, j;
            int C[][] = new int[row][col];

            for (i = 0; i < row; i++)
                for (j = 0; j < col; j++)
                    C[i][j] = A[i][j] - B[i][j];

            return C;
        }

        static int[][] transpose(int A[][], int row, int col) {
            int i, j;
            int B[][] = new int[row][col];
            for (i = 0; i < row; i++)
                for (j = 0; j < col; j++)
                    B[i][j] = A[j][i];


            return B;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of rows : ");
        rowSize = sc.nextInt();
        System.out.println("Please enter number of columns : ");
        colSize = sc.nextInt();
        int[][] x = new int[rowSize][colSize];
        int[][] y = new int[rowSize][colSize];
        System.out.println("Please enter first matrix - ");
        for(int m = 0; m < rowSize; m++)
        {
            for(int n = 0; n < colSize; n++)
            {
                x[m][n] = sc.nextInt();
            }
        }
        System.out.println("Please enter second matrix - ");
        for(int m = 0; m < rowSize; m++)
        {
            for(int n = 0; n < colSize; n++)
            {
                y[m][n] = sc.nextInt();
            }
        }

        sc.close();
     //   Matrix.printMatrix(Matrix.add( x, y,rowSize, colSize ), rowSize, colSize);
      //  Matrix.printMatrix(Matrix.subtract( x, y,rowSize, colSize ), rowSize, colSize);
      //  Matrix.printMatrix(Matrix.transpose( x,rowSize, colSize ), rowSize, colSize);
        // matrix java
      /*  int[][] z = new int[row][col];
        for(int m = 0; m < row; m++)
        {
            for(int n = 0; n < col; n++)
            {
                // matrix addition in java
                z[m][n] = x[m][n] + y[m][n];
            }
        }
        System.out.println("The addition of two matrices is - ");
        for(int m = 0; m < row; m++)
        {
            for(int n = 0; n < col; n++)
            {
                System.out.print(z[m][n] + " ");
            }
            System.out.println();
        }*/

    }
}
