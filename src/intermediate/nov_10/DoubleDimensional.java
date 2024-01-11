package intermediate.nov_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleDimensional {
    private static ArrayList<Integer> getRowSum(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> rowSum = new ArrayList();
        for (int i = 0; i < A.size(); i++) {
            System.out.println("I am here-->" + A.get(i));

            int sum = 0;
            for (int j = 0; j < A.get(i).size(); j++) {
                sum = sum + A.get(i).get(j);

            }
            rowSum.add(sum);
        }
        return rowSum;
    }

    private static ArrayList<Integer> getColumnSum(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> colSum = new ArrayList();
        for (int i = 0; i < A.get(0).size(); i++) {
            int sum = 0;
            for (int j = 0; j < A.size(); j++) {
                sum = sum + A.get(j).get(i);
            }
            colSum.add(sum);
        }
        return colSum;
    }

    public static int getDiagonalSum(int[][] A) {
        int diagonalSum = 0;
        for (int i = 0; i < A.length; i++) {
            diagonalSum = diagonalSum + A[i][i];
        }
        return diagonalSum;
    }

    private static int getMinorDiagonalSum(List<ArrayList<Integer>> A) {
        int sum = 0;
        int len = A.size() - 1;
        for (int i = 0; i <= len; i++) {
            System.out.println(A.get(i).get(len - i));
            sum = sum + A.get(i).get(len - 1);

        }
        return sum;
    }

    private static ArrayList<ArrayList<Integer>> getMatrixTranspose(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transposeMatrix = new ArrayList<>();
        for (int i = 0; i < A.get(0).size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A.size(); j++) {
                row.add(A.get(j).get(i));
            }
            transposeMatrix.add(row);
        }
        return transposeMatrix;
    }


    private static void get90RotateMatrix(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transposeMatrix = new ArrayList<>();
        for (int i = 0; i < A.get(0).size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A.size(); j++) {
                row.add(A.get(j).get(i));
            }
            transposeMatrix.add(row);
        }

        // Reverse individual rows
        for (int i = 0; i < transposeMatrix.size(); i++) {
            int low = 0, high = transposeMatrix.size() - 1;
            while (low < high) {
                int temp = transposeMatrix.get(i).get(low);
                transposeMatrix.get(i).set(low, transposeMatrix.get(i).get(high));
                transposeMatrix.get(i).set(high, temp);
//                transposeMatrix.get(i).get(low) = transposeMatrix.get(i).get(high);
//                transposeMatrix.get(i).get(high) = temp;
                low++;
                high--;
            }
        }
        System.out.println("transposeMatrix--->" + transposeMatrix);

    }

    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        int N = 2 * n - 1;
        System.out.println(n + "---" + N);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            result.add(new ArrayList<>());
        }
        // Push each element in the result vector
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "--" + j);
                System.out.println(A.get(i).get(j));
                result.get(i + j).add(A.get(i).get(j));

                System.out.println(result);
                if (i == n-1 && i < n - 1) {

                    for (int k = 0; k < n; k++) {

                        result.get(i + j).add(0);
                    }

                }


            }
        }

        return result;
        // Print the diagonals
//    for(int i = 0; i < result.size(); i++)
//    {
//        System.out.println();
//        for(int j = 0; j < result.get(i).size(); j++)
//            System.out.print(result.get(i).get(j) + " ");
//    }
    }

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        ArrayList<Integer> all5 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> all6 = new ArrayList<>(Arrays.asList(3, 4));

        all.add(all5);
        all.add(all6);

      /*  ArrayList<Integer> all1 = new ArrayList<>(Arrays.asList(21, 62, 16, 44, 55, 100, 16, 86, 29));
        ArrayList<Integer> all2 = new ArrayList<>(Arrays.asList(62, 72, 85, 35, 14, 1, 89, 15, 73));
        ArrayList<Integer> all3 = new ArrayList<>(Arrays.asList(42, 44, 30, 56, 25, 52, 61, 23, 54));
        ArrayList<Integer> all4 = new ArrayList<>(Arrays.asList(5, 35, 12, 35, 55, 74, 50, 50, 80));
        ArrayList<Integer> all5 = new ArrayList<>(Arrays.asList(2, 65, 65, 82, 26, 36, 66, 60, 1));
        ArrayList<Integer> all6 = new ArrayList<>(Arrays.asList(18, 1, 16, 91, 42, 11, 72, 97, 35));
        ArrayList<Integer> all7 = new ArrayList<>(Arrays.asList(23, 57, 9, 28, 13, 44, 40, 47, 98));

        all.add(all1);
        all.add(all2);
        all.add(all3);
        all.add(all4);
        all.add(all5);
        all.add(all6);
        all.add(all7); */
        //get90RotateMatrix(all);
        // System.out.println("getMatrixTranspose " + getMatrixTranspose(all));

        int A[][] = {{47, -59, 20, 33, 20, -47, -87, -59, 85},
                {8, -67, 48, -10, -23, -68, -28, 62, -94},
                {-50, 77, -39, -57, 15, 71, 44, 13, -53},
                {-30, 43, -92, -94, 42, 37, 95, 7, 19},
                {-1, 92, -85, 20, -53, -16, 31, -95, 4},
                {-62, 49, 0, 53, -93, -61, -49, 86, 97},
                {
                        62, -26, -1, -38, 59, -93, -93, 12, -90
                },
                {
                        78, 85, 90, 89, -65, 5, 48, 40, -86
                },
                {
                        -79, -68, -89, 90, -40, 47, 68, -25, 92
                },

        };

        // System.out.println("getDiagonalSum-->"+getDiagonalSum(A));
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        ArrayList<Integer> al3 = new ArrayList<>();
        al1.add(1);
        al1.add(2);
        al1.add(3);
        al2.add(4); // 1, 3
        al2.add(5);
        al2.add(6);
        al3.add(7);
        al3.add(8);
        al3.add(9);
//        al3.add(2);
//        al3.add(3);
//        al3.add(4);

        al.add(al1);
        al.add(al2);
        al.add(al3);
        System.out.println("" + diagonal(al));


    }
}
