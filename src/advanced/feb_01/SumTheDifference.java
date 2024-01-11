package advanced.feb_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumTheDifference {

  public static int MOD = 1000000007;

  // function for sum of max min difference
  public static long maxMin(int arr[], int n) {
    Arrays.sort(arr);
    long min_sum = 0, max_sum = 0;
    for (int i = 0; i < n; i++) {
      max_sum = 2 * max_sum + arr[n - 1 - i];
      max_sum %= MOD;
      min_sum = 2 * min_sum + arr[i];
      min_sum %= MOD;
    }

    return (max_sum - min_sum + MOD) % MOD;
  }

  private static int solve(ArrayList<Integer> A) {
      Collections.sort(A);
      int n = A.size();
      long min_sum = 0, max_sum = 0;
      for (int i = 0; i < n; i++) {
        max_sum = 2 * max_sum + A.get(n - 1 - i);
        max_sum %= MOD;
        min_sum = 2 * min_sum + A.get(i);
        min_sum %= MOD;
      }
      return (int) (max_sum - min_sum + MOD) % MOD;
    }
    public static void main (String[]args){

      int arr[] = {1};
      int n = arr.length;
     // System.out.println(maxMin(arr, n));
      System.out.println(""+solve(new ArrayList<>(Arrays.asList(1,2))));

    }

  }
