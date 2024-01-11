package advanced.jan_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllGCDPair2 {

  static int gcd(int b, int c) {
    if (c == 0) {
      return b;
    }
    return gcd(c, b % c);
  }


  public static ArrayList<Integer> solve(ArrayList<Integer> A) {
    /* Sort the array in decreasing order.
       Highest element will always be one of the original numbers. Keep that number and remove it from the array.
Compute GCD of the element taken in the previous step with the current element starting from the greatest and discard the GCD value from the given array.*/
    //Sort the array in decreasing order.
    Collections.sort(A);
    Collections.reverse(A);
    int n = A.size();
    ArrayList<Integer> result = new ArrayList<>();
    int[] freq = new int[A.get(0) + 1];
    for (int i = 0; i < n; i++) {
      freq[A.get(i)]++;
    }

    int x, l = 0;
    for (int i = 0; i < n; i++) {
      if (freq[A.get(i)] > 0) {
        result.add(A.get(i));
        freq[result.get(l)]--;
        l++;
      }
      for (int j = 0; j < l; j++) {
        if (i != j) {
          x = gcd(A.get(i), result.get(j));
          freq[x] -= 2;
        }
      }
    }
    Collections.reverse(result);
    return result;
  }

  public static void main(String[] args) {

    System.out.println("first" + solve(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10))));
    System.out.println("second" + solve(new ArrayList<>(Arrays.asList(5, 5, 5, 15))));
    System.out.println("Third" + solve(new ArrayList<>(
        Arrays.asList(1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1,
            11))));

  }

}
