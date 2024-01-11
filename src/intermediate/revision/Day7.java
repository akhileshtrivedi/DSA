package intermediate.revision;

import java.util.ArrayList;
import java.util.Arrays;

public class Day7 {
  // Assignments
  private static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
    ArrayList<Long> prefixSum = new ArrayList<>(A.size());
    prefixSum.add(Long.valueOf(A.get(0)));

    for (int i = 1; i < A.size(); i++) {
      prefixSum.add(Long.valueOf(prefixSum.get(i-1) + A.get(i)));
    }

    ArrayList<Long> rangSum = new ArrayList<>();
    for (int i = 0; i < B.size(); i++) {
      ArrayList<Integer> range = B.get(i);
      int left = range.get(0) -1 ;
      int right = range.get(1) -1 ;
      long count = 0;
      if (left == 0) {
        count = prefixSum.get(right);
      } else {
        count = prefixSum.get(right) - prefixSum.get(left-1);
      }
      rangSum.add(count);
    }
    return rangSum;
  }
  private static ArrayList<Integer> inPlacePrefixSum(ArrayList<Integer> A) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < A.size(); i++) {
      if (i == 0) {
        al.add(A.get(i));
      } else {
        al.add(al.get(i - 1) + A.get(i));
      }
    }
    return al;
  }

  private static int getEquilibriumIndex(ArrayList<Integer> A) {
    int pSumArr[] = new int[A.size()];

    for (int i = 0; i < A.size(); i++) {
      if (i == 0) {
        pSumArr[i] = A.get(i);
      } else {
        pSumArr[i] = pSumArr[i - 1] + A.get(i);
      }
    }

    for (int j = 0; j < pSumArr.length; j++) {
      int size = pSumArr.length;
      int leftSum = 0;
      int rightSum = 0;
      if (j != 0) {
        leftSum = pSumArr[j - 1];
        rightSum = pSumArr[size - 1] - pSumArr[j];

      }  else if (j == 0) {
        leftSum = 0;
        rightSum = pSumArr[size - 1] - pSumArr[j];
      }

      if (leftSum == rightSum) {
        return j;
      }
    }
    return -1;
  }

  private static ArrayList<Integer> getEvenNumbersInARange(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
    ArrayList<Integer> al = new ArrayList<Integer>();
    int count = 0;
    int pfArr[] = new int[A.size()];
    for (int i = 1; i < A.size(); i++) {
      if (A.get(0) % 2 == 0) {
        pfArr[0] = 1;
      } else {
        pfArr[0] = 0;
      }

      if (A.get(i) % 2 == 0) {
        pfArr[i] = pfArr[i - 1] + 1;
      } else {
        pfArr[i] = pfArr[i - 1] + 0;
      }
    }

    for (int i = 0; i < B.size(); i++) {
      ArrayList<Integer> col = B.get(i);
      int L = col.get(0);
      int R = col.get(1);

      if (L == 0) {
        count = pfArr[R];

      } else {
        count = pfArr[R] - pfArr[L - 1];
      }
      al.add(count);
    }
    return al;
  }
  // Homework
  private static ArrayList<Integer> getProductArrayPuzzle(ArrayList<Integer> A) {
    ArrayList<Integer> result = new ArrayList<>(0);
    int n = A.size();
    Integer[] arr = new Integer[A.size()];
    arr = A.toArray(arr);

    if (n == 1) {
      result.add(0);
      return result;
    }

    int left[] = new int[n];
    int right[] = new int[n];
    int prod[] = new int[n];

    int i, j;
    left[0] = 1;
    right[n - 1] = 1;

    for (i = 1; i < n; i++)
      left[i] = arr[i - 1] * left[i - 1];

    for (j = n - 2; j >= 0; j--)
      right[j] = arr[j + 1] * right[j + 1];

    for (i = 0; i < n; i++)
      result.add(left[i] * right[i]);

    return result;
  }

  public static void main(String[] args) {
    ArrayList al= new ArrayList<>();
    al.add(new ArrayList<Integer>(Arrays.asList(0,2)));
    al.add(new ArrayList<Integer>(Arrays.asList(1,4)));


   // System.out.println("Total count-->"+rangeSum(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)),al));
   // System.out.println("Total count-->"+inPlacePrefixSum(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))));
   // System.out.println("Total count-->"+getEquilibriumIndex(new ArrayList<Integer>(Arrays.asList(7, 2, 3, 4, 5))));
   // System.out.println("Total count-->"+getEvenNumbersInARange(new ArrayList<Integer>(Arrays.asList(7, 2, 3, 4, 5)), al));
   // System.out.println("Total count-->"+getProductArrayPuzzle(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))));
    System.out.println("Total count-->"+getProductArrayPuzzle(new ArrayList<Integer>(Arrays.asList(1))));

  }

}
