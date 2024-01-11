package advanced.april_21;

public class InterleavinStrings {


  // Declare n,m for storing the size of the strings.
  static int n, m;

  // Declare dp array
  static int dp[][] = new int[100][100];

  // declaration of dfs function.
  // This function checks if there exist a valid path from
  // 0,0 to n,m
  public static int dfs(int i, int j, String A, String B,
      String C)
  {
    if (dp[i][j] != -1)
      return dp[i][j];

    if (i == n && j == m)
      return 1;

    if (i < n && A.charAt(i) == C.charAt(i + j) && j < m
        && B.charAt(j) == C.charAt(i + j)) {

      int x = dfs(i + 1, j, A, B, C),
          y = dfs(i, j + 1, A, B, C);
      return dp[i][j] = x | y;
    }

    if (i < n && A.charAt(i) == C.charAt(i + j)) {
      int x = dfs(i + 1, j, A, B, C);
      return dp[i][j] = x;
    }
    if (j < m && B.charAt(j) == C.charAt(i + j)) {
      int y = dfs(i, j + 1, A, B, C);
      return dp[i][j] = y;
    }
    return dp[i][j] = 0;
  }

  // The main function that
  // returns true if C is
  // an interleaving of A
  // and B, otherwise false.
  public static int isInterleave(String A, String B, String C)
  {
    n = A.length();
    m = B.length();
    if ((n + m) != C.length())
      return 0;
    for (int i = 0; i <= n; i++)
      for (int j = 0; j <= m; j++)
        dp[i][j] = -1;
    return dfs(0, 0, A, B, C);
  }

  // A function to run test cases
  public static void test(String A, String B, String C)
  {
    if (isInterleave(A, B, C) != 0)
      System.out.println(C + " is interleaved of " + A
          + " and " + B);
    else
      System.out.println(C + " is not interleaved of "
          + A + " and " + B);
  }

  // Driver program to test above functions
  public static void main(String[] args)
  {
    test("XXY", "XXZ", "XXZXXXY");
    test("XY", "WZ", "WZXY");
    test("XY", "X", "XXY");
    test("YX", "X", "XXY");
    test("XXY", "XXZ", "XXXXZY");
    test("ACA", "DAS", "DAACSA");
  }
}

// This code is contributed by Rohit Pradhan
