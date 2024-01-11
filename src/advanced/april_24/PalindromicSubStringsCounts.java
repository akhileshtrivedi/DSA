package advanced.april_24;

public class PalindromicSubStringsCounts {
  static int CountPS(char str[], int n)
  {

    int dp[][] = new int[n][n];

    boolean P[][] = new boolean[n][n];

    // palindrome of single length
    for (int i = 0; i < n; i++)
      P[i][i] = true;

    // palindrome of length 2
    for (int i = 0; i < n - 1; i++) {
      if (str[i] == str[i + 1]) {
        P[i][i + 1] = true;
        dp[i][i + 1] = 1;
      }
    }

    for (int gap = 2; gap < n; gap++) {
      // Pick starting point for current gap
      for (int i = 0; i < n - gap; i++) {
        // Set ending point
        int j = gap + i;

        if (str[i] == str[j] && P[i + 1][j - 1])
          P[i][j] = true;

        if (P[i][j] == true)
          dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
              + 1 - dp[i + 1][j - 1];
        else
          dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
              - dp[i + 1][j - 1];
      }
    }

    // return total palindromic substrings
    return dp[0][n - 1];
  }
  static int solve(String s) {
    int count = 0;
    if (s == null || s.length() == 0) {
      return count;
    }
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
      count++;
    }
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        dp[i - 1][i] = true;
        count++;
      }
    }
    for (int j = 2; j < s.length(); j++) {
      for (int i = 0; i < j; i++) {
        if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
          dp[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }

  // Driver code
  public static void main(String[] args)
  {

   // System.out.println(CountPS(str.toCharArray(), str.length()));
    System.out.println(solve("ababa"));
  }
}
