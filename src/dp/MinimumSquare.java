package dp;

import java.util.Arrays;

public class MinimumSquare {

  static int solve(int n) {
    if (n == 0) {
      return 0;
    }
    int ans = n;

    for (int i = 1; i * i <= n; i++) {
      int temp = i * i;
      ans = Math.min(ans, 1 + solve(n - temp));
    }
    return ans;
  }

  static int solveMemo(int n, int[] dp) {
    if (n == 0) {
      return 0;
    }
    int ans = n;
    if (dp[n] != -1) {
      return dp[n];
    }
    for (int i = 1; i * i <= n; i++) {
      int temp = i * i;
      ans = Math.min(ans, 1 + solveMemo(n - temp, dp));
    }
    dp[n] = ans;
    return dp[n];
  }

  static int solveTab(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    int ans = n;

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j * j <= n; j++) {
        int temp = j * j;
        if ((i - temp) == 0) {
          dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 6;

    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    // System.out.println(""+solve(10));
   // System.out.println("" + solveMemo(n, dp));
    System.out.println("" + solveTab(5));
  }
}
