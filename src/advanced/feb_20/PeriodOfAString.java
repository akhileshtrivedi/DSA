package advanced.feb_20;

import java.util.ArrayList;

class PeriodOfAString {

  private static int solve(String A) {
    ArrayList<Integer> Z = getZarr(A);
    int n = A.length();
    for (int i = 1; i < n; i++) {
      if (i + Z.get(i) == n) {
        return i;
      }
    }
    return n;
  }

  private static ArrayList<Integer> getZarr(String str) {
    int n = str.length();
    // Z array
    ArrayList<Integer> Z = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      Z.add(0);
    }
    int L, R, k;
    // [L, R] make a window which matches with prefix of str
    L = R = 0;
    for (int i = 1; i < n; ++i) {
      // if i > R nothing matches so we will calculate Z[i] using naive way
      if (i > R) {
        L = R = i;
        // R - L = 0 in starting, so it will start checking from 0'th index
        while (R < n && str.charAt(R - L) == str.charAt(R)) {
          R++;
        }
        Z.set(i, R - L);
        R--;
      } else {
        // k = i - L so k corresponds to number which matches in [L,R] interval
        k = i - L;
        // if Z[k] is less than remaining interval then Z[i] will be equal to Z[k].
        if (Z.get(k) < R - i + 1) {
          Z.set(i, Z.get(k));
        } else {
          // else start from R and check manually
          L = i;
          while (R < n && str.charAt(R - L) == str.charAt(R)) {
            R++;
          }
          Z.set(i, R - L);
          R--;
        }
      }
    }
    return Z;
  }

  public static void main(String[] args) {
    String[] testStrings
        //  = { 	 "aaaa", "abababab", "abcaabcaab"};
        = {"abababababb", "abababab", "aaaa", "abcaabcaab",
        "zzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzzzzzzzzbzzzzzzzz"};
    //   = { "abababababb","abababab",	 "aaaa" };
    int n = testStrings.length;
    for (int i = 0; i < n; i++) {
      System.out.println("    " + solve(testStrings[i]));

    }
  }
}

