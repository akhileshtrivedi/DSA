package advanced.april_19;

import java.util.HashMap;

public class LengthofLongestFibonacciSubsequence {


  // Function to return the max Length of
// Fibonacci subsequence
  static int LongestFibSubseq(int[] A)
  {
    int n = A.length;
    HashMap<Integer,Integer> m = new HashMap<>();
    int N = n, res = 0;
    int[][] dp = new int[N][N];

    for (int j = 0; j < N; ++j)
    {
      m.put(A[j], j);
      for (int i = 0; i < j; ++i)
      {
        int k = m.containsKey(A[j] - A[i])? m.get(A[j] - A[i]):-1;
        dp[i][j] = (A[j] - A[i] < A[i] && k >= 0)
            ? dp[k][i] + 1
            : 2;
        res = Math.max(res, dp[i][j]);
      }
    }
    return res > 2 ? res : 0;
  }

  // Drivers code
  public static void main(String args[]){

    int[] A = { 1, 2, 3, 4, 5, 6, 7, 8};

    System.out.println(LongestFibSubseq(A));

  }
}

// This code is contributed by shinjanpatra
