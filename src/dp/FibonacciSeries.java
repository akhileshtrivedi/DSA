package dp;

public class FibonacciSeries {


  public static void main(String[] args) {
    int n = 6;
    int dp[] = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i] = -1;
    }
    // System.out.println(printFib2(n,dp));
    // System.out.println(printFib3(n));
    System.out.println(printFib4(0));
    // System.out.println(printFib(6));
  }


  //Recursion way
  private static int printFib(int n) {

    if (n <= 1) {
      return n;
    }

    return printFib(n - 1) + printFib(n - 2);
  }

  //Top-Down approch (Recursion +Memoization way
// Remove overlapping subproblem
  private static int printFib2(int n, int[] dp) {

    if (n <= 1) {
      return n;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    return printFib2(n - 1, dp) + printFib2(n - 2, dp);
  }

  //Bottom-Up approch Tabulation
  private static int printFib3(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  private static int printFib4(int n) {

    if (n <= 1) {
      return n;
    }
    int prev2 = 0;
    int prev1 = 1;
    int current = 0;
    for (int i = 2; i <= n; i++) {
      current = prev1 + prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return current;
  }
}
