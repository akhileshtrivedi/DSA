package advanced.jan_6;

// An efficient Java program to find maximum sum
// sub-square matrix

import java.util.ArrayList;

// Class to store the position of start of
// maximum sum in matrix
class Position {
  int x;
  int y;

  // Constructor
  Position(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  // Updates the position if new maximum sum
  // is found
  void updatePosition(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  // returns the current value of X
  int getXPosition() { return this.x; }

  // returns the current value of y
  int getYPosition() { return this.y; }
}

class MaximumSumSquareSubMatrix {
  // Size of given matrix
  static int N;

  // A O(n^2) function to the maximum sum sub-
  // squares of size k x k in a given square
  // matrix of size n x n
  static void printMaxSumSub(int[][] mat, int k)
  {

    // k must be smaller than or equal to n
    if (k > N)
      return;

    // 1: PREPROCESSING
    // To store sums of all strips of size k x 1
    int[][] stripSum = new int[N][N];

    // Go column by column
    for (int j = 0; j < N; j++) {

      // Calculate sum of first k x 1 rectangle
      // in this column
      int sum = 0;
      for (int i = 0; i < k; i++)
        sum += mat[i][j];
      stripSum[0][j] = sum;

      // Calculate sum of remaining rectangles
      for (int i = 1; i < N - k + 1; i++) {
        sum += (mat[i + k - 1][j] - mat[i - 1][j]);
        stripSum[i][j] = sum;
      }
    }

    // max_sum stores maximum sum and its
    // position in matrix
    int max_sum = Integer.MIN_VALUE;
    Position pos = new Position(-1, -1);

    // 2: CALCULATE SUM of Sub-Squares using
    // stripSum[][]
    for (int i = 0; i < N - k + 1; i++) {

      // Calculate and print sum of first subsquare
      // in this row
      int sum = 0;
      for (int j = 0; j < k; j++)
        sum += stripSum[i][j];

      // Update max_sum and position of result
      if (sum > max_sum) {
        max_sum = sum;
        pos.updatePosition(i, 0);
      }

      // Calculate sum of remaining squares in
      // current row by removing the leftmost
      // strip of previous sub-square and adding
      // a new strip
      for (int j = 1; j < N - k + 1; j++) {
        sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);

        // Update max_sum and position of result
        if (sum > max_sum) {
          max_sum = sum;
          pos.updatePosition(i, j);
        }
      }
    }
int sum=0;
    // Print the result matrix
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k; j++)
        sum=sum+mat[i + pos.getXPosition()][j + pos.getYPosition()];
       // System.out.print(mat[i + pos.getXPosition()][j + pos.getYPosition()]
        //    + " ");

    }
    System.out.println(""+sum);
  }
  public int solve(ArrayList<ArrayList<Integer>> A, int B) {
    int N=A.size();
    if (B > N)
      return 0;

    int[][] stripSum = new int[N][N];

    for (int j = 0; j < N; j++) {

      int sum = 0;
      for (int i = 0; i < B; i++)
        sum += A.get(i).get(j);
      stripSum[0][j] = sum;

      for (int i = 1; i < N - B + 1; i++) {
        sum += (A.get(i+B-1).get(j) - A.get(i-1).get(j));
        stripSum[i][j] = sum;
      }
    }

    int max_sum = Integer.MIN_VALUE;
    Position pos = new Position(-1, -1);

    for (int i = 0; i < N - B + 1; i++) {
      int sum = 0;
      for (int j = 0; j < B; j++)
        sum += stripSum[i][j];

      if (sum > max_sum) {
        max_sum = sum;
        pos.updatePosition(i, 0);
      }
      for (int j = 1; j < N - B + 1; j++) {
        sum += (stripSum[i][j + B - 1] - stripSum[i][j - 1]);

        if (sum > max_sum) {
          max_sum = sum;
          pos.updatePosition(i, j);
        }
      }
    }
    int sum=0;
    for (int i = 0; i < B; i++) {
      for (int j = 0; j < B; j++)
        sum=sum+A.get(i + pos.getXPosition()).get(j + pos.getYPosition());
    }
    return sum;
  }
  // Driver program to test above function
  public static void main(String[] args)
  {
    N = 5;
    int[][] mat = { { 1, 1, 1, 1, 1 },
        { 2, 2, 2, 2, 2 },
        { 3, 8, 6, 7, 3 },
        { 4, 4, 4, 4, 4 },
        { 5, 5, 5, 5, 5 } };
    int k = 3;

    System.out.println("Maximum sum 3 x 3 matrix is");
    printMaxSumSub(mat, k);
  }
}

// This code is contributed by Aditya Kumar (adityakumar129)
