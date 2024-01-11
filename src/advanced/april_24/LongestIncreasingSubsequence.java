package advanced.april_24;

import static java.lang.Math.max;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
    import java.util.TreeSet;

public class LongestIncreasingSubsequence {

    static int lis(int arr[], int n)
  {
    SortedSet<Integer> hs = new TreeSet<Integer>();

    for (int i = 0; i < n; i++)
      hs.add(arr[i]);
    int lis[] = new int[hs.size()];
    int k = 0;

    for (int val : hs) {
      lis[k] = val;
      k++;
    }
    int m = k, i, j;
    int dp[][] = new int[m + 1][n + 1];

    for (i = 0; i < m + 1; i++) {
      for (j = 0; j < n + 1; j++) {
        dp[i][j] = -1;
      }
    }

    for (i = 0; i < m + 1; i++) {
      for (j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
        else if (arr[j - 1] == lis[i - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        }
        else {
          dp[i][j]
              = max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }
  static int lis2(final List<Integer> A) {
    int arr[] = A.stream().mapToInt(i->i).toArray();
    int n = arr.length;
    SortedSet<Integer> hs = new TreeSet<Integer>();

    for (int i = 0; i < n; i++)
      hs.add(arr[i]);
    int lis[] = new int[hs.size()];
    int k = 0;

    for (int val : hs) {
      lis[k] = val;
      k++;
    }
    int m = k, i, j;
    int dp[][] = new int[m + 1][n + 1];

    for (i = 0; i < m + 1; i++) {
      for (j = 0; j < n + 1; j++) {
        dp[i][j] = -1;
      }
    }

    for (i = 0; i < m + 1; i++) {
      for (j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
        else if (arr[j - 1] == lis[i - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        }
        else {
          dp[i][j]
              = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }
  public static void main(String[] args)
  {
    int arr[] = { 1, 3, 5 };
    int n = arr.length;
    List A= Arrays.asList(1, 3, 5);
    int arra[] = A.stream().mapToInt(i->1).toArray();
    // Function call
    System.out.println("Length of lis is "
        + lis2(Arrays.asList(1, 3, 5)));
  }
}

