package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingRectangles {

  private static int solve(ArrayList<Integer> A, int B) {
    long mod = 1000000007, ans = 0;

    int l = 0, r = A.size() - 1;

    while (l < A.size() && r >= 0) {
      if (1l * A.get(l) * A.get(r) >= B) {
        r--;
      } else {
        ans = (ans % mod + (r + 1) % mod) % mod;
        l++;
      }
    }
    return (int) ((int) ans % mod);
  }

  public static void main(String[] args) {
    System.out.println("" + solve(new ArrayList<>(Arrays.asList(1, 2)), 5));
  }

}
