package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;

public class FindClosestPairFromTwoSortedArrays {

  private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
    int diff = Integer.MAX_VALUE;
    int m = A.size();
    int n = B.size();
    int res_l = 0, res_r = 0;

    int l = 0, r = n - 1;
    while (l < m && r >= 0) {
      if (Math.abs(A.get(l) + B.get(r) - C) < diff) {
        res_l = l;
        res_r = r;
        diff = Math.abs(A.get(l) + B.get(r) - C);
      } else if (Math.abs(A.get(l) + B.get(r) - C) == diff) {

        if (l < res_l) {
          res_l = l;
          res_r = r;
          diff = Math.abs(A.get(l) + B.get(r) - C);
        } else if (l == res_l) {

          if (r < res_r) {
            res_l = l;
            res_r = r;
            diff = Math.abs(A.get(l) + B.get(r) - C);
          }
        }
      }
      if (A.get(l) + B.get(r) > C) {
        r--;
      } else
      {
        l++;
      }
    }
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ans.add(A.get(res_l));
    ans.add(B.get(res_r));
    return ans;
  }

  public static void main(String[] args) {
    ArrayList A = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList B = new ArrayList(Arrays.asList(2, 4, 6, 8));
    System.out.println("" + solve(A, B, 9));
  }
}