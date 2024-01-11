package advanced.april_17;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapSackProblem {


  static int knapSack(int wt[], int val[],int W)
  {
    int n = val.length;
    // Making and initializing dp array
    int[] dp = new int[W + 1];

    for (int i = 1; i < n + 1; i++) {
      for (int w = W; w >= 0; w--) {

        if (wt[i - 1] <= w)

          // Finding the maximum value
          dp[w]
              = Math.max(dp[w], dp[w - wt[i - 1]]
              + val[i - 1]);
      }
    }
    return dp[W];
  }
  static int solve(ArrayList<Integer> B, ArrayList<Integer> A, int C) {
    int[] wt = A.stream().mapToInt(i -> i).toArray();
    int[] val = B.stream().mapToInt(i -> i).toArray();
    int n = val.length;

    int[] dp = new int[C + 1];

    for (int i = 1; i < n + 1; i++) {
      for (int w = C; w >= 0; w--) {

        if (wt[i - 1] <= w) {
          dp[w]
              = Math.max(dp[w], dp[w - wt[i - 1]]
              + val[i - 1]);
        }
      }
    }
    return dp[C];
  }
  // Driver code
  public static void main(String[] args)
  {
    int profit[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int C = 50;

   // System.out.print(knapSack(weight, profit, W));
    System.out.print(solve(new ArrayList<>(Arrays.asList(359, 963, 465, 706, 146, 282, 828, 962, 492)),
        new ArrayList<>(Arrays.asList(96, 43, 28, 37, 92, 5, 3, 54, 93)), 383));
  }
}

// This code is contributed by gauravrajput1
