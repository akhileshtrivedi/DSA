package intermediate.nov_10;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {
//Assignment Day-10  Q6 // It is working fine.
    private ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
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
    private static ArrayList<ArrayList<Integer>> diagonal_Done(ArrayList<ArrayList<Integer>> A) {

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
                if (i == n - 1 && i < n - 1) {
                    System.out.println("inside if ");
                    for (int k = 0; k < n; k++) {

                        result.get(i + j).add(0);
                    }

                }


            }
        }

        return result;
    }
    private static void diagonal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int N = 2 * n - 1;
        System.out.println(n + "---" + N);
        System.out.println(A);
        // Push each element in the result vector
        for (int i = 0; i <N ; i++) {
            for (int j = 0,x=n-1; j < n; j++,x--) {
                for (int k = 0; k < n; k++) {
                  if(j+k==i){
                      System.out.print(A.get(j).get(k)+" ");
                  }

                }
                if(x>0) {
                    System.out.print("0" + " ");
                }
            }
            System.out.println("");
        }
    }
    private static void getRotateMatrix(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transposeMatrix = new ArrayList<>();
        for (int i = 0; i < A.get(0).size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A.size(); j++) {
                row.add(A.get(j).get(i));
            }
            transposeMatrix.add(row);
        }
        System.out.println(transposeMatrix);
        for (int i = 0; i < transposeMatrix.size(); i++) {
            int low = 0, high = transposeMatrix.size() - 1;
            while (low < high) {
                int temp = transposeMatrix.get(i).get(low);
                transposeMatrix.get(i).set(low, transposeMatrix.get(i).get(high));
                transposeMatrix.get(i).set(high, temp);
                low++;
                high--;
            }
        }
        System.out.println(transposeMatrix);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        ArrayList<Integer> all5 = new ArrayList<>(Arrays.asList(1, 2)); // 3,1
        ArrayList<Integer> all6 = new ArrayList<>(Arrays.asList(3, 4)); // 4, 2

        all.add(all5);
        all.add(all6);
       // getRotateMatrix(all);

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


        al.add(al1);
        al.add(al2);
        al.add(al3);
       // System.out.println("" + diagonal(al));
        diagonal(al);
    }
}
