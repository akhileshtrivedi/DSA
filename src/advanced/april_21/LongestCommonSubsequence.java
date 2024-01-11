package advanced.april_21;

public class LongestCommonSubsequence {

  // Returns length of LCS for A[0..m-1], B[0..n-1]
  int lcs(String A, String B)
  {
    int m = A.length();
    int n = B.length();
    int L[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
          L[i][j] = 0;
        else if (A.charAt(i - 1) == B.charAt(j - 1))
          L[i][j] = L[i - 1][j - 1] + 1;
        else
          L[i][j] = max(L[i - 1][j], L[i][j - 1]);
      }
    }
    return L[m][n];
  }

  int max(int a, int b) { return (a > b) ? a : b; }

  public static void main(String[] args)
  {
    LongestCommonSubsequence lcs
        = new LongestCommonSubsequence();
    String S1 = "AGGTAB";
    String S2 = "GXTXAYB";
    int m = S1.length();
    int n = S2.length();

    System.out.println("Length of LCS is" + " " + lcs.lcs(S1, S2));
  }
}

// This Code is Contributed by Saket Kumar
