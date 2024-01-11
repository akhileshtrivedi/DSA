package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblemZeroOne {

  static int solve(List<Integer> weight, List<Integer> value, int index, int capacity) {
// Base Case
    // If only one item to steal, then just compare with its weight with the knapsack capacity
    if (index == 0) {
      if (weight.get(0) <= capacity) {
        return value.get(0);
      } else {
        return 0;
      }
    }
    int include = 0;
    if (weight.get(index) <= capacity) {
      include = value.get(index) + solve(weight, value, index - 1, capacity - weight.get(index));
    }
    int exclude = 0 + solve(weight, value, index - 1, capacity);
    return Math.max(include, exclude);
  }

  static int knapsack(List<Integer> weight, List<Integer> value, int n, int maxWeight) {
    return solve(weight, value, n - 1, maxWeight);
  }

  static int solveMem(List<Integer> weight, List<Integer> value, int index, int capacity,
      List<List<Integer>> dp) {
// Base Case
    // If only one item to steal, then just compare with its weight with the knapsack capacity
    if (index == 0) {
      if (weight.get(0) <= capacity) {
        return value.get(0);
      } else {
        return 0;
      }
    }
    if (dp.get(index).get(capacity) != -1) {
      return dp.get(index).get(capacity);
    }
    int include = 0;
    if (weight.get(index) <= capacity) {
      include =
          value.get(index) + solveMem(weight, value, index - 1, capacity - weight.get(index), dp);
    }
    int exclude = 0 + solveMem(weight, value, index - 1, capacity, dp);
    dp.get(index).add(Math.max(include, exclude));
    return dp.get(index).get(capacity);
  }

  static int knapsackMem(List<Integer> weight, List<Integer> value, int n, int maxWeight) {
    List<List<Integer>> dp = new ArrayList<>();
    Collections.nCopies(maxWeight, -1);
    return solveMem(weight, value, n-1, maxWeight, dp);
  }

  static int solveTab(List<Integer> weight, List<Integer> value, int n, int capacity) {
    //Step-1:
    List<List<Integer>> dp = new ArrayList<>();
    Collections.nCopies(capacity, -1);
// Step2: Analiyse base case
    for (int w = weight.get(0); w < capacity; w++) {
      if (weight.get(0) <= capacity) {
        dp.get(0).add(value.get(0));
      } else {
        dp.get(0).add(0);
      }
    }
// Step-3: take care of remaining recursive calls
    for(int index=1;index<n;index++){

      for(int w=0;w<=capacity;w++){

        int include = 0;
        if (weight.get(index) <= w) {
          include =
              value.get(index) + dp.get(index - 1).get( capacity - weight.get(index) );
        }
        int exclude = dp.get(index - 1).get(capacity);
        dp.get(index).add(Math.max(include, exclude));

      }
    }

    return dp.get(n-1).get(capacity);
  }
  static int solveSO(List<Integer> weight, List<Integer> value, int n, int capacity) {
    //Step-1:
 int[] pre = new int[capacity+1];
 int[] curr = new int[capacity+1];
    Arrays.fill(pre,0);
    Arrays.fill(curr,0);
// Step2: Analiyse base case
    for (int w = weight.get(0); w < capacity; w++) {
      if (weight.get(0) <= capacity) {
        pre[w]=value.get(0);
      } else {
        pre[w]=0;
      }
    }
// Step-3: take care of remaining recursive calls
    for(int index=1;index<n;index++){

      for(int w=0;w<=capacity;w++){

        int include = 0;
        if (weight.get(index) <= w) {
          include =
              value.get(index) + pre[capacity - weight.get(index)];
        }
        int exclude = pre[capacity];
        curr[w]=Math.max(include, exclude);

      }
      pre=curr;
    }

    return pre[capacity];
  }

  static int solveSO1(List<Integer> weight, List<Integer> value, int n, int W)
  {
    int i, w;
    int[][] dp = new int[2][W + 1];

    for (i = 0; i <= n; i++) {
      for (w = 0; w <= W; w++) {
        if (i == 0 || w == 0)
          dp[i % 2][w] = 0;
        else if (weight.get(i - 1) <= w)
          dp[i % 2][w] = Math.max(
              value.get(i - 1)
                  + dp[(i - 1) % 2][w - weight.get(i - 1)],
              dp[(i - 1) % 2][w]);
        else
          dp[i % 2][w] = dp[(i - 1) % 2][w];
      }
    }
    return dp[n % 2][W];
  }
  static int solveSO2(List<Integer> weight, List<Integer> value, int n, int capacity) {
    //Step-1:

    int[] curr = new int[capacity+1];
    Arrays.fill(curr,0);
// Step2: Analiyse base case
    for (int w = weight.get(0); w < capacity; w++) {
      if (weight.get(0) <= capacity) {
        curr[w]=value.get(0);
      } else {
        curr[w]=0;
      }
    }
// Step-3: take care of remaining recursive calls
    for(int index=1;index<n;index++){

      for(int w=capacity;w>=0;w--){

        int include = 0;
        if (weight.get(index) <= w) {
          include =
              value.get(index) + curr[capacity - weight.get(index)];
        }
        int exclude = curr[capacity];
        curr[w]=Math.max(include, exclude);

      }

    }

    return curr[capacity];
  }

  static int solveSO3(List<Integer> weight, List<Integer> value, int n, int W)
  {
    //Step-1: Making and initializing dp array
    int[] dp = new int[W + 1];
    //Step-2: Analiyse base case
    for (int i = 1; i < n + 1; i++) {
      for (int w = W; w >= 0; w--) {

        if (weight.get(i - 1) <= w)

          // Getting  the maximum value
          dp[w]
              = Math.max(dp[w], dp[w - weight.get(i - 1)]
              + value.get(i - 1));
      }
    }
    // Finally  we are returning the maximum here
    return dp[W];
  }
  static int knapsackTab(List<Integer> weight, List<Integer> value, int n, int maxWeight) {

    return solveTab(weight, value, n - 1, maxWeight);
  }

  public static void main(String[] args) {
    int profit[] = new int[] { 60, 100, 120 };
    int weight[] = new int[] { 10, 20, 30 };
    int W = 50;
    int n = profit.length;
   // System.out.println(knapSack(W, weight, profit, n));
   System.out.println("Recursion-->"+knapsack(Arrays.asList( 10, 20, 30), Arrays.asList( 60, 100, 120), n, W));
   System.out.println("knapsackMem-->"+knapsackMem(Arrays.asList( 10, 20, 30), Arrays.asList( 60, 100, 120), n, W));
   System.out.println(solveSO(Arrays.asList( 10, 20, 30), Arrays.asList( 60, 100, 120), n, W));
   System.out.println("2-D "+solveSO1(Arrays.asList( 10, 20, 30), Arrays.asList( 60, 100, 120), n, W));
   System.out.println(solveSO2(Arrays.asList( 10, 20, 30), Arrays.asList( 60, 100, 120), n, W));
   System.out.println("1-D "+solveSO3(Arrays.asList( 10, 20, 30), Arrays.asList( 60, 100, 120), n, W));// Space(W)
  }

}
