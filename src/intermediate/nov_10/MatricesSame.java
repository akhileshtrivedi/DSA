package intermediate.nov_10;

import java.util.ArrayList;
import java.util.Arrays;

public class MatricesSame {
    private static int solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        if(A.size() != B.size()){
            return 0;
        }
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).size() != B.get(i).size()){
                return 0;
            }
            for (int j = 0; j < A.get(i).size(); j++) {
               if( A.get(i).get(j) != B.get(i).get(j)){
                   return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> val = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> val2 = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(7, 8, 9));

        val.add(A);
        val.add(B);
        val.add(C);
        val2.add(A);
        val2.add(C);
        val2.add(B);

        System.out.println("I am here" + solve(val, val2));
    }
}
