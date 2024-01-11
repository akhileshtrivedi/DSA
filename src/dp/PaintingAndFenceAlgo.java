package dp;

import java.util.Arrays;

public class PaintingAndFenceAlgo {

  private static int MOD = 1000000007;

  static int add(int a, int b) {
    return (a % MOD + b % MOD) % MOD;
  }

  static int mul(int a, int b) {
    return (a % MOD * b % MOD) % MOD;
  }

  static int solve(int n, int k) {
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return add(k, mul(k, k - 1));
    }
    int ans = add(mul(solve(n - 2, k), k - 1), mul(solve(n - 1, k), k - 1));
    return ans;
  }
  static int solveMemo(int n, int k, int[] dp) {
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return add(k, mul(k, k - 1));
    }
    if(dp[n]!=-1){
      return dp[n];
    }
    dp[n] = add(mul(solveMemo(n - 2, k, dp), k - 1), mul(solveMemo(n - 1, k, dp), k - 1));
    return dp[n];
  }
  static int solveTab(int n, int k) {
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    dp[1]=k;
    dp[2]=add(k, mul(k, k - 1));
    for(int i=3;i<=n;i++) {
      dp[i] = add(mul(dp[i - 2], k - 1), mul(dp[i - 1], k - 1));
    }
    return dp[n];
  }
  static int solveSO(int n, int k) {
    int pre2=k;
    int pre1=add(k, mul(k, k - 1));
    for(int i=3;i<=n;i++) {
      int ans = add(mul(pre2, k - 1), mul(pre1, k - 1));
      pre2=pre1;
      pre1=ans;
    }
    return pre1;
  }
  static int noOfWays(int n, int k) {
    //Recursion
   // return solve(n, k);
    //Recursion+Memo
//    int[] dp = new int[n+1];
//    Arrays.fill(dp, -1);
//    return solveMemo(n, k,dp);
    // Tabulation
//    return solveTab(n, k);
    //Space Optimization
    return solveSO(n, k);
  }

  public static void main(String[] args) {
     System.out.println("" + noOfWays(5, 3));
  }

}
