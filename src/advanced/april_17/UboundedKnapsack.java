package advanced.april_17;

import java.util.ArrayList;
import java.util.Arrays;
// Java program to find maximum achievable
// value with a knapsack of weight W and
// multiple instances allowed.
public class UboundedKnapsack
{

  private static int max(int i, int j)
  {
    return (i > j) ? i : j;
  }

  // Returns the maximum value with knapsack
  // of W capacity
  private static int unboundedKnapsack(int W, int n,
      int[] val, int[] wt)
  {

    // dp[i] is going to store maximum value
    // with knapsack capacity i.
    int dp[] = new int[W + 1];

    // Fill dp[] using above recursive formula
    for(int i = 0; i <= W; i++){
      for(int j = 0; j < n; j++){
        if(wt[j] <= i){
          dp[i] = max(dp[i], dp[i - wt[j]] +
              val[j]);
        }
      }
    }
    return dp[W];
  }
  public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
    int[] val = B.stream().mapToInt(i -> i).toArray();
    int[] wt = C.stream().mapToInt(i -> i).toArray();

    int n = val.length;
    int dp[] = new int[A + 1];

    // Fill dp[] using above recursive formula
    for(int i = 0; i <= A; i++){
      for(int j = 0; j < n; j++){
        if(wt[j] <= i){
          dp[i] = max(dp[i], dp[i - wt[j]] +
              val[j]);
        }
      }
    }
    return dp[A];

  }
  // Driver program
  public static void main(String[] args)
  {
    int W = 10;
    int val[] = {6,7};
    int wt[] = {5,5};
    int n = val.length;
    System.out.println(unboundedKnapsack(W, n, val, wt));
  }
}
// This code is contributed by Aditya Kumar

  // Driver code
 /* public static void main(String[] args)
  {
    int profit[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int C = 50;

   // System.out.print(knapSack(weight, profit, W));
    System.out.print(solve(new ArrayList<>(Arrays.asList(359, 963, 465, 706, 146, 282, 828, 962, 492)),
        new ArrayList<>(Arrays.asList(96, 43, 28, 37, 92, 5, 3, 54, 93)), 383));
  }
}*/

// This code is contributed by gauravrajput1
