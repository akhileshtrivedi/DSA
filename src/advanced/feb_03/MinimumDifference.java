package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;

class MinimumDifference {

  static final int R = 3;
  static final int C = 2;

  static int bsearch(int low, int high, int n, int arr[]) {
    int mid = (low + high) / 2;

    if (low <= high) {
      if (arr[mid] < n) {
        return bsearch(mid + 1, high, n, arr);
      }
      return bsearch(low, mid - 1, n, arr);
    }

    return low;
  }

  static int mindiff(int A, int B, ArrayList<ArrayList<Integer>> C) {
    int n = A, m = B;
    int[][] arr = C.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    for (int i = 0; i < n; i++) {
      Arrays.sort(arr[i]);
    }

    int ans = +2147483647;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m; j++) {
        int p = bsearch(0, m - 1, arr[i][j], arr[i + 1]);
        System.out.println("P-->"+p);
        ans = Math.min(ans, Math.abs(arr[i + 1][p] - arr[i][j]));
        System.out.println("ans-->"+ans);
        if (p - 1 >= 0) {
          ans = Math.min(ans,
              Math.abs(arr[i + 1][p - 1] - arr[i][j]));
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int m[][] = {{8, 5},
        {6, 8}};

    int m2[][] = {{7, 3},
        {2, 1},
        {4, 9}};

    //  System.out.println(mindiff(m2, R, C));
    ArrayList<ArrayList<Integer>> input = new ArrayList<>();
//    input.add(new ArrayList<>(Arrays.asList(7, 3)));
//    input.add(new ArrayList<>(Arrays.asList(2, 1)));
//    input.add(new ArrayList<>(Arrays.asList(4, 9)));
    input.add(new ArrayList<>(Arrays.asList(1,2, 3)));
    input.add(new ArrayList<>(Arrays.asList(4,5, 6)));
    input.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

    // System.out.println(" here-->"+findRow(a, n, m, k));
    System.out.println(" here-->" + mindiff(input.size(), input.get(0).size(), input));
  }
}
