package intermediate.nov_10;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixScalarProduct {
    private static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row;
        for (int i = 0; i < A.size(); i++) {
            row = new ArrayList<Integer>(0);
            for (int j = 0; j < A.get(i).size(); j++) {
                row.add(A.get(i).get(j) * B);
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> val = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        val.add(A);
        val.add(B);
        val.add(C);
        System.out.println("I am here" + solve(val, 2));
    }
}
