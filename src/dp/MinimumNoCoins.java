package dp;

import java.util.Arrays;
import java.util.List;

public class MinimumNoCoins {

  ////1-Recursion approch
  private static int minimumNumberOfCoins(List<Integer> coins, int amount){
  if(amount==0){
    return 0;
  }
  if(amount<0){
    return Integer.MAX_VALUE;
  }
    int mini=Integer.MAX_VALUE;
  for(int i=0;i<coins.size();i++){
 int ans=minimumNumberOfCoins(coins, amount-coins.get(i));
    if(ans!=Integer.MAX_VALUE){
      mini=Math.min(mini, 1+ans);
    }
  }
  return mini;
  }
//2-Recursion approch + Memoization
 private static int solve(List<Integer> coins, int amount, int dp[]) {
   // STEP-1 BASE CASE
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return Integer.MAX_VALUE;
    }
    // STEP-2 Check in DP first
    if (dp[amount] != -1) {
      return dp[amount];
    }

    int mini = Integer.MAX_VALUE;
    for (int i = 0; i < coins.size(); i++) {
      int ans = solve(coins, amount - coins.get(i), dp);
      if (ans != Integer.MAX_VALUE) {
        mini = Math.min(mini, 1 + ans);
      }
    }
    dp[amount] = mini;
    return dp[amount];
  }

  // Tabulation Technique (Bottom-Up approach)
  private static int solveTab(List<Integer> coins, int amount) {
    int dp[] = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.size(); j++) {

        if (i - coins.get(j) >= 0 && dp[i - coins.get(j)] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins.get(j)]);
        }
      }
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      return -1;
    } else {
      return dp[amount];
    }
  }

  private static int minimumNumberOfCoins2(List<Integer> coins, int amount) {
    int dp[] = new int[amount + 1];
    Arrays.fill(dp, -1);
    int ans = solve(coins, amount, dp);
    if (ans == Integer.MAX_VALUE) {
      return -1;
    } else {
      return ans;
    }
  }

  public static void main(String[] args) {
   // System.out.println("No. of coins -->" + minimumNumberOfCoins(Arrays.asList(1, 2, 5), 7)); //TC- expo
   // System.out.println("No. of coins -->" + minimumNumberOfCoins2(Arrays.asList(1, 2, 5), 7));  //TC-(x*n), SC-(x)
    System.out.println("No. of coins -->" + solveTab(Arrays.asList(1, 2, 5), 7));   //TC-(x*n), SC-(x)
  }

}
