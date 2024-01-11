package advanced.april_19;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack2 {

  static int knapSack(int W, int wt[], int val[])
  {
    int n = wt.length;
    // Making and initializing dp array
    int[] dp = new int[W + 1];

    for (int i = 1; i < n + 1; i++) {
      for (int w = W; w >= 0; w--) {
        if (wt[i - 1] <= w)
          dp[w]
              = Math.max(dp[w], dp[w - wt[i - 1]]
              + val[i - 1]);
      }
    }
    return dp[W];
  }
  static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
    int[] val=A.stream().mapToInt(i->i).toArray();
    int[] wt = B.stream().mapToInt(i->i).toArray();
    int n = wt.length;
    // Making and initializing dp array
    int[] dp = new int[C + 1];
    System.out.println(""+Arrays.toString(dp));
    for (int i = 1; i < n + 1; i++) {
      for (int w = C; w >= 0; w--) {
        if (wt[i - 1] <= w)
          dp[w]
              = Math.max(dp[w], dp[w - wt[i - 1]]
              + val[i - 1]);
      }
    }
    System.out.println(""+Arrays.toString(dp));
    return dp[C] ;
  }
  public static void main(String[] args)
  {
    int profit[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int W = 50;

   // System.out.print(knapSack(W, weight, profit));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(60, 100, 120)),new ArrayList<>(Arrays.asList(10, 20, 30)),50));
  }
}

// This code is contributed by gauravrajput1
