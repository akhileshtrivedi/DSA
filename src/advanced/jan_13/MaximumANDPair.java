package advanced.jan_13;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumANDPair {

  private static int solveOLD(ArrayList<Integer> A) {
    int result = 0;
    int n = A.size();
    for (int b = 30; b >= 0; b++) {

      int count = 0;
      for (int i = 0; i < n; i++) {
        if (((A.get(i) >> b) & 1) == 1) {
          count++;
        }
      }
      if (count >= 2) {
        result = result | (1 << b);
        for (int i = 0; i < n; i++) {
          if (((A.get(i) >> b) & 1) == 0) {
            A.set(i, 0);
          }
        }
      }
    }
    return result;
  }
  static int checkBit(int pattern, ArrayList<Integer> A )
  {
    int count = 0;
    for (int i = 0; i < A.size(); i++)
      if ((pattern & A.get(i)) == pattern)
        count++;
    return count;
  }
  static int solve(ArrayList<Integer> A)
  {
//    Integer[] arr = new Integer[A.size()];
//    arr = A.toArray(arr);
//    int n= arr.length;
 //   int res = 0;
//    for (int i = 0; i < n; i++)
//      for (int j = i + 1; j < n; j++)
//        res = res > (arr[i] & arr[j])
//            ? res
//            : (arr[i] & arr[j]);
//
    int res = 0, count;
    for (int bit = 31; bit >= 0; bit--) {
      count = checkBit(res | (1 << bit), A);

      if (count >= 2)
        res |= (1 << bit);
    }
    return res;
  }


  public static void main(String[] args) {
    System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(53, 39, 88))));
    System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(38, 44, 84, 12))));
  }

}
