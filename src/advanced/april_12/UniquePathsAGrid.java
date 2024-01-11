package advanced.april_12;

import java.util.ArrayList;

public class UniquePathsAGrid {

  static int n, m;

  static int path(int[][] dp, int[][] grid, int i, int j)
  {
    if (i < n && j < m && grid[i][j] == 1)
      return 0;
    if (i == n - 1 && j == m - 1)
      return 1;
    if (i >= n || j >= m)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];
    int left = path(dp, grid, i + 1, j);
    int right = path(dp, grid, i, j + 1);
    return dp[i][j] = left + right;
  }

  static int uniquePathsWithObstacles(int[][] grid)
  {
    n = grid.length;
    m = grid[0].length;
    if (n == 1 && m == 1 && grid[0][0] == 0)
      return 1;
    if (n == 1 && m == 1 && grid[0][0] == 1)
      return 0;
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dp[i][j] = -1;
      }
    }
    path(dp, grid, 0, 0);
    if (dp[0][0] == -1)
      return 0;
    return dp[0][0];
  }
  static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
   // int[][] grid = new int[][];
   // int[][] grid =A.stream().mapToInt(i->i)
    int[][] grid = A.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    n = grid.length;
    m = grid[0].length;
    if (n == 1 && m == 1 && grid[0][0] == 0)
      return 1;
    if (n == 1 && m == 1 && grid[0][0] == 1)
      return 0;
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dp[i][j] = -1;
      }
    }
    path(dp, grid, 0, 0);
    if (dp[0][0] == -1)
      return 0;
    return dp[0][0];
  }
  public static void main(String[] args)
  {
    int[][] v
        = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
    System.out.println(uniquePathsWithObstacles(v));
  }
}

