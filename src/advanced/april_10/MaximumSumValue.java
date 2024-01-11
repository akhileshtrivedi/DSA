package advanced.april_10;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumValue {

  static int maximizeExpr(int a[], int x, int y, int z) {
    int n = a.length;
    int L[] = new int[n];
    L[0] = x * a[0];
    for (int i = 1; i < n; i++) {
      L[i] = Math.max(L[i - 1], x * a[i]);
    }

    int R[] = new int[n];
    R[n - 1] = z * a[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      R[i] = Math.max(R[i + 1], z * a[i]);
    }

    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, L[i] + y * a[i] +
          R[i]);
    }
    return ans;
  }
  static int solve(ArrayList<Integer> A, int B, int C, int D) {
    int [] a= A.stream().mapToInt(i->i).toArray();
    int n = A.size();
    int L[] = new int[n];
    L[0] = B * a[0];
    for (int i = 1; i < n; i++) {
      L[i] = Math.max(L[i - 1], B * a[i]);
    }

    int R[] = new int[n];
    R[n - 1] = D * a[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      R[i] = Math.max(R[i + 1], D * a[i]);
    }

    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, L[i] + C * a[i] +
          R[i]);
    }
    return ans;
  }
  public static void main(String[] args) {
  //  int a[] = {-1, -2, -3, -4, -5};
   int a[] = {1, 5, -3, 4, -2};
    int x = 2, y = 1, z = -1;
    /* int a[] = {3, 2, 1};
    int x = 1, y = -10, z = 3;*/
    System.out.println(solve(new ArrayList<>(Arrays.asList(1, 5, -3, 4, -2)), x, y, z));
  }
}
