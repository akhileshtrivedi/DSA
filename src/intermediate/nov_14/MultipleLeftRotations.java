package intermediate.nov_14;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleLeftRotations {
    private static   ArrayList<Integer> leftRotate(int[] A, int k) {
        ArrayList<Integer> row = new ArrayList<>(0);
        int a = A.length;
        int c = k % a;
        int[] D = A.clone();

        rotateArray(D, 0, c - 1);
        rotateArray(D, c, a - 1);
        rotateArray(D, 0, a - 1);

        for (int i = 0; i < D.length; i++)
            row.add((Integer)D[i]);
        return row;
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(0);
        int[] arr = A.stream().mapToInt(i -> i).toArray();
        for (int i = 0; i < B.size(); i++) {
            result.add(leftRotate(arr, B.get(i)));
        }
        return result;
    }

    public static int[] rotateArray(int[] A, int start,
                                    int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }

    // Driver Code
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(0);
        result.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        result.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));

        System.out.println(result);
        int A[] = {1, 2, 3, 4, 5};
        int n = A.length;
        int k = 2;
        leftRotate(A, k);

        k = 3;
        leftRotate(A, k);

        System.out.println(" Through solve-->" + solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<>(Arrays.asList(2, 3))));
//        int k = 2;
//        leftRotate(A, n, k);
//
//        k = 3;
//        leftRotate(A, n, k);
//
//        k = 4;
//        leftRotate(A, n, k);
    }
}
