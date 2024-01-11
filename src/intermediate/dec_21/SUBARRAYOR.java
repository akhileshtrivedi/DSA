package intermediate.dec_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

class SUBARRAYOR {

  static int givesumTest(ArrayList<Integer> A) {

    Integer maxBit = Collections.max(A);
    int n = A.size();

    int totalSubarrays = n * (n + 1) / 2;

    int result = 0;

    for (int i = 0; i < maxBit; i++) {
      int c1 = 0;

      Vector<Integer> vec = new Vector<>();

      int sum = 0;

      for (int j = 0; j < n; j++) {

        int a = A.get(j) >> i;
        if (!(a % 2 == 1)) {
          vec.add(j);
        }
      }

      int cntSubarrNotSet = 0;

      int cnt = 1;

      for (int j = 1; j < vec.size(); j++) {
        if (vec.get(j) - vec.get(j - 1) == 1) {
          cnt++;
        } else {
          cntSubarrNotSet += cnt * (cnt + 1) / 2;

          cnt = 1;
        }
      }

      cntSubarrNotSet += cnt * (cnt + 1) / 2;

      if (vec.size() == 0) {
        cntSubarrNotSet = 0;
      }

      int cntSubarrIthSet = totalSubarrays - cntSubarrNotSet;

      result += cntSubarrIthSet * Math.pow(2, i);
    }
    return result;
  }

  private static int solve(ArrayList<Integer> Al) {
    Integer[] A = new Integer[Al.size()];
    A = Al.toArray(A);
    int n = A.length;
    int MOD = 1000000007;
    int[] idx = new int[32];
    long result = 0;
    for (int i = 1; i <= n; ++i) {
      long temp = A[i - 1];
      for (int j = 0; j < 32; j++) {
        long pw = 1 << j;
        if ((temp & pw) != 0) {
          result = (result+(pw * i))%MOD;
          idx[j] = i;
        } else if (idx[j] != 0) {
          result = (result + (pw * idx[j]))%MOD;
        }
      }

    }
    return (int) result % MOD;
  }

  public static void main(String[] args) {
    int A[] = {1, 2, 3, 4, 5};
    int n = A.length;
    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))));
  }
}

