package dp;

import java.util.Arrays;
import java.util.List;


public class CombinationSum {

  static int solve(List<Integer> num, int target) {
    if (target < 0) {
      return 0;
    }
    if (target == 0) {
      return 1;
    }
    int ans = 0;
    for (int i = 0; i < num.size(); i++) {
      ans = ans + solve(num, target - num.get(i));
    }
    return ans;
  }

  static int findWays(List<Integer> num, int target) {
    //Write your code here
    return solve(num, target);
  }

  static int solveMem(List<Integer> num, int target, int[] dp) {
    if (target < 0) {
      return 0;
    }
    if (target == 0) {
      return 1;
    }
    if (dp[target] != -1) {
      return dp[target];
    }
    int ans = 0;
    for (int i = 0; i < num.size(); i++) {
      ans = ans + solveMem(num, target - num.get(i), dp);
      dp[target] = ans;
    }
    return ans;
  }

  static int findWaysMem(List<Integer> num, int target) {
    //Write your code here
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    return solveMem(num, target, dp);
  }

  static int solveTab(List<Integer> num, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;

    //Traversing from target 1 to  target target
    for (int i = 1; i <= target; i++) {
      //Traversing on num vector
      for (int j = 0; j < num.size(); j++) {
        if(i - num.get(j)>=0) {
          dp[i] += dp[i - num.get(j)];
        }
      }
    }
    return dp[target];
  }

  static int findWaysTab(List<Integer> num, int target) {
    //Write your code here
    return solveTab(num, target);
  }

  public static void main(String[] args) {
    //Recursion
    // System.out.println(""+findWays(Arrays.asList(1,2), 5));
    //Recursion+Memoization
    // System.out.println("" + findWaysMem(Arrays.asList(1, 2), 5));
    //Tabulation
    System.out.println("" + findWaysTab(Arrays.asList(1, 2), 5));
  }

}
