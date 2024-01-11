package advanced.april_10;

public class Stairs {

  static int[][] mul(int[][] A, int[][] B,int MOD)
  {
    int K = A.length;
    int[][] C = new int[K][K];
    for (int i = 1; i < K; i++)
      for (int j = 1; j < K; j++)
        for (int k = 1; k < K; k++)
          C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
    return C;
  }

  static int[][] power(int[][] A, long n)
  {
    if (n == 1)
      return A;
    if (n % 2 != 0)
    {

      // n is odd
      // A^n = A * [ A^(n-1) ]
      A = mul(A, power(A, n - 1), 1000000007);
    }
    else {
      // n is even
      // A^n = [ A^(n/2) ] * [ A^(n/2) ]
      A = power(A, n / 2);
      A = mul(A, A, 1000000007);
    }
    return A;
  }

  static int[] initialize(int[] A)
  {
    // Initializes the base vector F(1)

    int K = A[A.length - 1]; // Assuming A is sorted
    int[] F = new int[K+1];
    int[] dp = new int[K+1];
    dp[0] = 0;
    dp[A[1]] = 1; // There is one and only one way to reach
    // first element
    F[A[1]] = 1;
    for (int i = 2; i < A.length; ++i)
    {

      // Loop through A[i-1] to A[i] and fill the dp array
      for (int j = A[i - 1] + 1; j <= A[i]; ++j) {

        // dp[j] = dp[j-A[0]] + .. + dp[j-A[i-1]]
        for (int k = 1; k < i; ++k) {
          dp[j] += dp[j - A[k]];
        }
      }

      dp[A[i]] += 1;
      F[A[i]] = dp[A[i]];
    }
    return F;
  }
  static int ways(int[] A, int n)
  {
    int K = A[A.length - 1];
    int[] F = initialize(A);
    int MOD = 1000000007;
    int[][] C = new int[K + 1][K + 1];


    for (int i = 1; i < K; ++i) {
      C[i][i + 1] = 1;
    }

    for (int i = 1; i < A.length; ++i) {
      C[K][K - A[i] + 1] = 1;
    }

    if (n <= K)
      return F[n];

    C = power(C, n - 1); // O(k^3Log(n))

    int result = 0;

    for (int i = 1; i <= K; ++i) {
      result = (result + C[1][i] * F[i]) % MOD;
    }
    return result;
  }
  public static int MOD = 1000000007;
  static int climbStairs(int A) {
    long prev = 1;
    long prev2 = 1;

    for (int i = 2; i <= A; i++) {
      long curr = prev + prev2;
      curr = curr % MOD;
      prev2 = prev;
      prev = curr;
    }
    prev = prev % MOD;
    return (int)prev;
  }
  public static void main(String[] args)
  {
    int n = 9;
    int[] A = {0, 2, 4, 5};

    // 0 is just because we are using 1 based indexing
   // System.out.print("Number of ways = " + ways(A, n) +"\n");
    System.out.print("Number of ways = " + climbStairs(5) +"\n");
  }
}

