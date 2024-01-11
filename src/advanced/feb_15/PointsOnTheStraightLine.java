package advanced.feb_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PointsOnTheStraightLine {


  static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    if (a < 0) {
      return gcd(a * -1, b);
    }
    if (b < 0) {
      return gcd(a, b * -1);
    }
    if (a > b) {
      return gcd(b, a);
    }
    return gcd(b % a, a);
  }

  private static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int ans = 0;
    HashMap<String, Integer> M = new HashMap<>();

    for (int i = 0; i < A.size(); ++i) {
      M.clear();
      int same = 1, currMax = 0;
      for (int j = i + 1; j < A.size(); ++j) {
        int diffX = A.get(i) - A.get(j);
        int diffY = B.get(i) - B.get(j);

        if (diffX == 0 && diffY == 0) {
          ++same;
          continue;
        }

        if (diffX < 0) {
          diffX *= -1;
          diffY *= -1;
        }

        int g = gcd(diffX, diffY);
        diffY /= g;
        diffX /= g;
        String pair = (diffY) + " " + (diffX);
        if (!M.containsKey(pair)) {
          M.put(pair, 0);
        }

        M.put(pair,
            M.get(pair) + 1);
        currMax = Math.max(currMax,
            M.get(pair));

      }
      currMax += same;
      ans = Math.max(currMax, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 3, 3));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 0, 1, 2, 3, 4));
//
    ArrayList<Integer> AA = new ArrayList<>(Arrays.asList(3, 1, 4, 5, 7, -9, -8, 6));
    ArrayList<Integer> BB = new ArrayList<>(Arrays.asList(4, -8, -3, -2, -1, 5, 7, -4));
    System.out.println("" + solve(A, B));
    System.out.println("" + solve(AA, BB));
    int points[][] = {{-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 4}};

    int points2[][] = {{3, 4}, {1, 8}, {4, -3},
        {5, -2}, {7, -1}, {-9, 5}, {-8, 7}, {6, -4}};
    //  int points[][] = { { -1, 1 }, { 0, 0 }, { 1, 1 },
    //      { 2, 2 }, { 3, 3 }, { 3, 4 } };
    // System.out.println(maxPointOnSameLine(points));
    // System.out.println(maxPointOnSameLine(points2));
  }

}
