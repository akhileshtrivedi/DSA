package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {

  static int findRow(int[][] a, int n, int m, int k) {
    int ans = 0;
    int l = 0, r = n - 1, mid;

    while (l <= r) {
      mid = (l + r) / 2;

      if (k == a[mid][0]) {
        ans = 1;
        System.out.println("Found at 1 (" + mid + ","
            + "0)");
        return ans;
      }

      if (k == a[mid][m - 1]) {
        int t = m - 1;
        ans = 1;
        System.out.println("Found at 2 (" + mid + ","
            + t + ")");
        return ans;
      }

      if (k > a[mid][0]
          && k < a[mid]
          [m - 1]) {
        ans = binarySearch(a, n, m, k,
            mid);
        return ans;
      }

      if (k < a[mid][0]) {
        r = mid - 1;
      }
      if (k > a[mid][m - 1]) {
        l = mid + 1;
      }
    }
    return ans;
  }

  static int binarySearch(int[][] a, int n, int m, int k,
      int x) {
    System.out.println("Found  at  binarySearch");
    int l = 0, r = m - 1, mid;
    while (l <= r) {
      mid = (l + r) / 2;

      if (a[x][mid] == k) {
        System.out.println("Found  at  binarySearch(" + x + ","
            + mid + ")");
        return 1;
      }

      if (a[x][mid] > k) {
        r = mid - 1;
      }
      if (a[x][mid] < k) {
        l = mid + 1;
      }
    }
    System.out.println("Element not found");
    return 0;
  }


  private static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
    int[][] arr = A.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    int ans = findRow(arr, A.size(), A.get(0).size(), B);

    return ans;
  }

  public static void main(String args[]) {
    int n = 4;
    int m = 5;

    int a[][] = {{0, 6, 8, 9, 11},
        {20, 22, 28, 29, 31},
        {36, 38, 50, 61, 63},
        {64, 66, 100, 122, 128}};

    int k = 61;
    ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    input.add(new ArrayList<>(Arrays.asList(0, 6, 8, 9, 11)));
    input.add(new ArrayList<>(Arrays.asList(20, 22, 28, 29, 31)));
    input.add(new ArrayList<>(Arrays.asList(36, 38, 50, 61, 63)));
    input.add(new ArrayList<>(Arrays.asList(64, 66, 100, 122, 128)));

    // System.out.println(" here-->"+findRow(a, n, m, k));
    System.out.println(" here-->" + searchMatrix(input, k));
  }
}
