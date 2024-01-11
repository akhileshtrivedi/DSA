package dp;

import java.util.Arrays;

public class CountDerangments {

  private static int MOD = 100000007;

  static int getCountDerangments(int n) {
    // Base Case
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    int ans = (((n - 1) % MOD) * ((getCountDerangments(n - 1) % MOD) +
        (getCountDerangments(n - 2) % MOD)) % MOD);
    return ans;
  }

  static int solveMem(int n, int[] dp) {
    // Base Case
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    dp[n] = (((n - 1) % MOD) * ((solveMem(n - 1, dp) % MOD) +
        (solveMem(n - 2, dp) % MOD)) % MOD);
    return dp[n];


  }

  static int solveTab(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[1] = 0;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      // dp[i] = (((i - 1) % MOD) * ((dp[i - 1] % MOD) + (dp[i - 2] % MOD)) % MOD);
      //OR
      int first = dp[i - 1] % MOD;
      int second = dp[i - 2] % MOD;
      int sum = (first + second) % MOD;
      int ans = ((i - 1) * sum) % MOD;
      dp[i] = ans;

    }
    return dp[n];
  }

  static int solveSO(int n) {
// Only we take two variables here
    int pre2 = 0;
    int pre1 = 1;
    for (int i = 3; i <= n; i++) {
      int first = pre1 % MOD;
      int second = pre2 % MOD;
      int sum = (first + second) % MOD;
      int ans = ((i - 1) * sum) % MOD;
      //Swap the variables
      pre2 = pre1;
      pre1 = ans;
    }
    return pre1;
  }

  public static void main(String[] args) {
//  Recursion--->TC- expo+SC-N
    //   System.out.println(""+getCountDerangments(9));

    //  Recursion+Memoization TC-O(N)--SC-->O(N)+O(N)
   /* int n = 6;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println("" + solveMem(n, dp));*/

    //Tabulation        TC-O(N)--SC-->O(N)
    // System.out.println(""+solveTab(6));
    //Space Optimization---TC-O(N)--SC-->O(1)
    System.out.println("" + solveSO(6));
  }

}
