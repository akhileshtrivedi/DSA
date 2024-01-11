package intermediate.nov_10;

import java.util.ArrayList;
import java.util.Arrays;

public class RowToColumnZero {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row;

       return result;
    }
    static void setZeroes(int [][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int dummy1[]=new int[rows];
        int dummy2[]=new int[cols];
        Arrays.fill(dummy1,-1);
        Arrays.fill(dummy2,-1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i] == 0 || dummy2[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    static ArrayList<ArrayList<Integer>> setZeroesArrayList(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row;
        int[][] matrix = A.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        int rows = matrix.length, cols = matrix[0].length;
        int dummy1[] = new int[rows];
        int dummy2[] = new int[cols];
        Arrays.fill(dummy1, -1);
        Arrays.fill(dummy2, -1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i] == 0 || dummy2[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            row = new ArrayList<Integer>(0);
            for (int j = 0; j < matrix[0].length; j++) {
                row.add(matrix[i][j]);
            }
            result.add(row);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> val = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 0));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(9, 2, 0, 4));

        val.add(A);
        val.add(B);
        val.add(C);

       // setZeroesArrayList(val);
        System.out.println("I am here" + setZeroesArrayList(val));


//        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        setZeroes(arr);
//        System.out.println("The Final Matrix is ");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
