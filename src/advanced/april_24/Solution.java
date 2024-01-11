package advanced.april_24;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

  public int solve(ArrayList<ArrayList<Integer>> A) {
    int[][] envelopes = A.stream().map(u -> u.stream().mapToInt(i -> i).toArray())
        .toArray(int[][]::new);
    int len = envelopes.length;
    Pair p[] = new Pair[len];
    for (int i = 0; i < len; i++) {
      p[i] = new Pair(envelopes[i][0], envelopes[i][1]);
    }
    Arrays.sort(p);
    int max = 0;
    int dp[] = new int[len + 1];
    for (int i = 0; i < len; i++) {
      int ind = 0;
      int l = 0, r = max;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (dp[mid] < p[i].b) {
          ind = mid + 1;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      dp[ind] = p[i].b;
      if (ind == max + 1) {
        max++;
      }
    }
    return max;
  }

  public int maxEnvelopes(int[][] envelopes) {
    int len = envelopes.length;
    Pair p[] = new Pair[len];
    for (int i = 0; i < len; i++) {
      p[i] = new Pair(envelopes[i][0], envelopes[i][1]);
    }
    Arrays.sort(p);
    int max = 0;
    int dp[] = new int[len + 1];
    for (int i = 0; i < len; i++) {
      int ind = 0;
      int l = 0, r = max;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (dp[mid] < p[i].b) {
          ind = mid + 1;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      dp[ind] = p[i].b;
      if (ind == max + 1) {
        max++;
      }
    }
    return max;
  }

  public class Pair implements Comparable<Pair> {

    int a, b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public int compareTo(Pair p) {
      if (p.a == a) {
        return p.b - b;
      }
      return a - p.a;
    }
  }
}