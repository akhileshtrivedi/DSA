package dp;

import java.util.Arrays;
import java.util.List;

public class MinimumCostForTicket {

  static int solve(int n, List<Integer> days, List<Integer> cost, int index) {
    if (index >= n) {
      return 0;
    }
    // int option2=0, option3=0;
    //For 1 day pass is here
    int option1 = cost.get(0) + solve(n, days, cost, index + 1);
    //For 7 days pass is here
    int i;
    for (i = index; i < n && days.get(i) < days.get(index) + 7; i++)
      ;
    int option2 = cost.get(1) + solve(n, days, cost, i);

    //For 30 days pass is here
    for (i = index; i < n && days.get(i) < days.get(index) + 30; i++)
      ;
    int option3 = cost.get(2) + solve(n, days, cost, i);

    return Math.min(option1, Math.min(option2, option3));
  }


  static int minimumCoins(int n, List<Integer> days, List<Integer> cost) {
    return solve(n, days, cost, 0);
  }

  static int solveMem(int n, List<Integer> days, List<Integer> cost, int index, int[] dp) {
    if (index >= n) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    // int option2=0, option3=0;
    //For 1 day pass is here
    int option1 = cost.get(0) + solveMem(n, days, cost, index + 1, dp);
    //For 7 days pass is here
    int i;
    for (i = index; i < n && days.get(i) < days.get(index) + 7; i++)
      ;
    int option2 = cost.get(1) + solveMem(n, days, cost, i, dp);

    //For 30 days pass is here
    for (i = index; i < n && days.get(i) < days.get(index) + 30; i++)
      ;
    int option3 = cost.get(2) + solveMem(n, days, cost, i, dp);

    dp[index] = Math.min(option1, Math.min(option2, option3));

    return dp[index];
  }

  static int minimumCoinsMem(int n, List<Integer> days, List<Integer> cost) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return solveMem(n, days, cost, 0, dp);
  }

  static int solveTab(int n, List<Integer> days, List<Integer> cost, int index) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return 0;
  }

  static int minimumCoinsTab(int n, List<Integer> days, List<Integer> cost) {
    return solveTab(n, days, cost, 0);
  }
/*
  static int solve(int n, int[] days, int[] cost, int index) {
    if (index >= n) {
      return 0;
    }
    // int option2=0, option3=0;
    //For 1 day pass is here
    int option1 = cost[0] + solve(n, days, cost, index + 1);
    //For 7 days pass is here
    int i;
    for (i = index; i < n && days[i] < days[index] + 7; i++)
      ;
    int option2 = cost[1] + solve(n, days, cost, i);

    //For 30 days pass is here
    for (i = index; i < n && days[i] < days[index] + 30; i++)
      ;
    int option3 = cost[2] + solve(n, days, cost, i);

    return Math.min(option1, Math.min(option2, option3));
  }


  static int minimumCoins(int n, int[] days, int[] cost) {
    return solve(n, days, cost, 0);
  }*/

  public static void main(String[] args) {
// Recursion way
    int[] days = {1, 4, 6, 7, 8, 20};
    // int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
    int[] cost = {2, 7, 15};
//    System.out.println(
//        "" + minimumCoins(days.length, days, cost));
    // Recursion +Memo
//    System.out.println(
//        "" + minimumCoinsMem(12, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31),
//            Arrays.asList(2, 7, 15)));
//  }
  // Tabulation
    System.out.println("" + minimumCoinsTab(12, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31),Arrays.asList(2, 7, 15)));
}
}
