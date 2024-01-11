package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClimbStairsWithCost {

  private static int MOD = 1000000007;

  public static void main(String[] args) {
    System.out.println("" + minCostClimbingStairs(Arrays.asList(10, 15, 20)));
  }

  static int minCostClimbingStairs(List<Integer> cost) {

    int n = cost.size();
   /* // Recursion
    int ans = Math.min(solve(cost, n - 1), solve(cost, n - 2));
    return ans;*/

    /* // Recursion + Memoization
    //STEP-1
    List list = Collections.nCopies(n + 1, "-1");
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    int ans = Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
    return ans; */
    return solve3(cost, cost.size());
  }
  //Optimize code
  private static int solve3(List<Integer> cost, int n) {
   int pre2 = cost.get(0);
   int pre  = cost.get(1);

    //STEP-3
    for (int i = 2; i < n; i++) {
      int curr = cost.get(i) + Math.min(pre, pre2);
      pre2 = pre;
      pre = curr;
    }
    return Math.min(pre, pre2);

  }
  //Tabulation-Bottom-up
  private static int solve2(List<Integer> cost, int n) {

    //Step-1: Creation of dp array
    int[] dp = new int[n + 1];

    //Step-2: Base case
    dp[0] = cost.get(0);
    dp[1] = cost.get(1);

    //STEP-3
    for (int i = 2; i < n; i++) {
      dp[i] = cost.get(i) + Math.min(dp[i - 1], dp[i - 2]);
    }
    return Math.min(dp[n - 1], dp[n - 2]);

  }

  // Recursion + Memoization
  private static int solve(List<Integer> cost, int n, int[] dp) {
    //Base case

    if (n == 0 || n == 1) {
      return cost.get(n);
    }
    //STEP-3
    if (dp[n] != -1) {
      return dp[n];
    }
    //STEP-2
    dp[n] = solve(cost, n - 1, dp) + solve(cost, n - 2, dp) % MOD;
    return dp[n];

  }

  //Recursion
   /*  private static int solve(List<Integer> cost, int n) {
    //Base case

   //Recursion
  if (n == 0 || n == 1) {
      return cost.get(n);
    }
    return solve(cost, n - 1) + solve(cost, n - 2) % MOD;



  }*/
}
