package advanced.april_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray {

  public static int solve(int[] A)
  {
    int n = A.length;
    int[][] dp = new int[2000][2000];

    // boolean variable used for
    // toggling between maps
    int flag = 1;

    // Calculate the sum of all
    // elements of the array
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += A[i];

    // Initializing first map(dp[0])
    // with INT_MAX because for i=0,
    // there are no elements in the
    // array to flip
    for (int i = -sum; i <= sum; i++) {
      try {
        dp[0][i] = Integer.MAX_VALUE;
      }
      catch (Exception e) {
      }
    }

    // Base Case
    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        try {
          dp[flag][j] = Integer.MAX_VALUE;
          if (j - A[i - 1] <= sum
              && j - A[i - 1] >= -sum)
            dp[flag][j]
                = dp[flag ^ 1][j - A[i - 1]];
          if (j + A[i - 1] <= sum
              && j + A[i - 1] >= -sum
              && dp[flag ^ 1][j + A[i - 1]]
              != Integer.MAX_VALUE)
            dp[flag][j] = Math.min(
                dp[flag][j],
                dp[flag ^ 1][j + A[i - 1]] + 1);
        }
        catch (Exception e) {
        }
      }

      // For toggling
      flag = flag ^ 1;
    }

    // Required sum is minimum non-negative
    // So, we iterate from i=0 to sum and find
    // the first i where dp[flag ^ 1][i] != INT_MAX
    for (int i = 0; i <= sum; i++) {
      if (dp[flag ^ 1][i] != Integer.MAX_VALUE)
        return dp[flag ^ 1][i];
    }

    // In worst case we will flip max n-1 elements
    return n - 1;
  }

  static int solve(List<Integer> A) {
    int n = A.size();
    int[][] dp = new int[101][101];
    int flag = 1;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += A.get(i);
    }

    for (int i = -sum; i <= sum; i++) {
      try {
        dp[0][i] = Integer.MAX_VALUE;
      } catch (Exception e) {
      }
    }

    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        try {
          dp[flag][j] = Integer.MAX_VALUE;
          if (j - A.get(i - 1) <= sum
              && j - A.get(i - 1) >= -sum) {
            dp[flag][j]
                = dp[flag ^ 1][j - A.get(i - 1)];
          }
          if (j + A.get(i - 1) <= sum
              && j + A.get(i - 1) >= -sum
              && dp[flag ^ 1][j + A.get(i - 1)]
              != Integer.MAX_VALUE) {
            dp[flag][j] = Math.min(
                dp[flag][j],
                dp[flag ^ 1][j + A.get(i - 1)] + 1);
          }
        } catch (Exception e) {
        }
      }

      flag = flag ^ 1;
    }

    for (int i = 0; i <= sum; i++) {
      if (dp[flag ^ 1][i] != Integer.MAX_VALUE) {
        return dp[flag ^ 1][i];
      }
    }
    return n - 1;
  }
  // Driver code
  public static void main(String[] args)
  {
    int[] arr = {9,6 };

    System.out.println(solve(arr));
    //System.out.println(solve(new ArrayList(Arrays.asList(9, 6 ))));
  }
}

// This code is contributed by sanjeev2552
