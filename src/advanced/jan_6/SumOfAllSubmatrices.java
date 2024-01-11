package advanced.jan_6;

import java.util.ArrayList;

public class SumOfAllSubmatrices {

  private static int solve(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    int sum = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int top_left = (i + 1) * (j + 1);
        int bottom_right = (n - i) * (n - j);
        sum += (top_left * bottom_right * A.get(i).get(j));
      }
    }

    return sum;

  }
  //static final int n = 3;

  // Function to find the sum of all
  // possible submatrices of a given Matrix
  static int matrixSum(int arr[][]) {
    int n = arr.length;

    int sum = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int top_left = (i + 1) * (j + 1);
        int bottom_right = (n - i) * (n - j);
        sum += (top_left * bottom_right * arr[i][j]);
      }
    }

    return sum;
  }

  // Driver Code
  public static void main(String[] args) {
    int arr[][] = {{1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}};
    int arr2[][] = {{1, 1},
        {1, 1}};

    System.out.println(matrixSum(arr2));


  }
}
