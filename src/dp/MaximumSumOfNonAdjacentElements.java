package dp;

import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNonAdjacentElements {
/*
  static int solve(List nums, int n) {
    //Base case
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return (int) nums.get(0);
    }

    int inc = solve(nums, n - 2) + (int) nums.get(n);
    int excl = solve(nums, n - 1) + 0;
    return Math.max(inc, excl);
  }

  static int solveMem(List nums, int n, int[] dp) {
    //Base case
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return (int) nums.get(0);
    }

    if (dp[n] != -1) {
      return dp[n];
    }

    int inc = solveMem(nums, n - 2, dp) + (int) nums.get(n);
    int excl = solveMem(nums, n - 1, dp) + 0;
    dp[n] = Math.max(inc, excl);

    return dp[n];
  }*/

  static int solveTab(List<Integer> nums) {
    int n = nums.size();
    int[] dp = new int[n];
    Arrays.fill(dp, 0);
    dp[0] = nums.get(0);
    dp[1] = nums.get(1);
    for (int i = 2; i <n; i++) {
      int incl = dp[i - 2] + nums.get(i);
      int excl = dp[i - 1] + 0;
      dp[i] = Math.max(incl,excl);
    }
    return dp[n-1];
  }
  static int solveOS(List<Integer> nums) {
    int n = nums.size();
    int pre2 = nums.get(0);
    int pre = nums.get(1);
    int   ans=0;
    for (int i = 2; i <n; i++) {
      int incl =pre2 + nums.get(i);
      int excl = pre + 0;
      ans = Math.max(incl,excl);
      pre2=pre;
      pre=ans;
    }
    return ans;
  }
  static int maximumNonAdjacentSumTab(List<Integer> nums) {

   return solveOS(nums);
  }
/*
  static int maximumNonAdjacentSumMemo(List nums) {

    int n = nums.size();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return solveMem(nums, n - 1, dp);
  }

  static int maximumNonAdjacentSum(List nums) {
    int n = nums.size();
    return solve(nums, n - 1);
  }
*/
  public static void main(String[] args) {
    // Recursion
    //  System.out.println(""+maximumNonAdjacentSum(Arrays.asList(1,9,8,2)));
    // Recursion+Memoization
   // System.out.println("" + maximumNonAdjacentSumMemo(Arrays.asList(1, 9, 8, 2)));
    // Tabulation
    System.out.println("" + maximumNonAdjacentSumTab(Arrays.asList(1, 9, 8, 2)));
  }
}
