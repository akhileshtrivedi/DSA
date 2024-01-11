package intermediate.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10 {

  // Assignment
  private static ArrayList<Integer> getColumnSum(ArrayList<ArrayList<Integer>> A) {
    ArrayList<Integer> colSum = new ArrayList();
    for (int i = 0; i < A.get(0).size(); i++) {
      int sum = 0;
      for (int j = 0; j < A.size(); j++) {
        System.out.println("A.get(j).get(i)-->" + A.get(j).get(i));
        sum = sum + A.get(j).get(i);
      }
      colSum.add(sum);
    }
    return colSum;
  }

  private static ArrayList<Integer> getRowSum(ArrayList<ArrayList<Integer>> A) {
    ArrayList<Integer> colSum = new ArrayList();
    for (int i = 0; i < A.size(); i++) {
      int sum = 0;
      for (int j = 0; j < A.get(i).size(); j++) {
        sum = sum + A.get(i).get(j);
      }
      colSum.add(sum);
    }
    return colSum;
  }

  private static int getDiagonalSum(final List<ArrayList<Integer>> A) {
    int diagonalSum = 0;
    for (int i = 0; i < A.size(); i++) {
      diagonalSum = diagonalSum + A.get(i).get(i);
    }
    return diagonalSum;
  }

  private static int getMinorDiagonalSum(final List<ArrayList<Integer>> A) {
    int sum = 0;
    int len = A.size() - 1;
    for (int i = 0; i <= len; i++) {
      sum = sum + A.get(i).get(len - i);

    }
    return sum;
  }

  private static ArrayList<ArrayList<Integer>> getAntiDiagonal(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    int N = 2 * n - 1;

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      result.add(new ArrayList<>(Arrays.asList()));
    }
    // Push each element in the result vector
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result.get(i + j).add(A.get(i).get(j));
      }
    }
    for (int i = 0; i < result.size(); i++) {
      int len = result.get(i).size();
      for (int j = len; j < n; j++) {
        result.get(i).add(0);
      }
    }
    return result;

  }

  public static void main(String[] args) {
    ArrayList al = new ArrayList<>();
    al.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
    al.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
    al.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

    //  System.out.println(""+getColumnSum(al));
    // System.out.println(""+getRowSum(al));
   // System.out.println("" + getMinorDiagonalSum(al));
    System.out.println("" + getAntiDiagonal(al));

  }

}
