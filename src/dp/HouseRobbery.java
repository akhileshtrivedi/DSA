package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobbery {

  static int solveOS(List<Integer> nums) {
    int n = nums.size();
    int pre2 = nums.get(0);
    int pre = nums.get(1);
    int ans = 0;
    for (int i = 2; i < n; i++) {
      int incl = pre2 + nums.get(i);
      int excl = pre + 0;
      ans = Math.max(incl, excl);
      pre2 = pre;
      pre = ans;
    }
    return ans;
  }

  static int houseRobbery(List<Integer> list) {
    int n = list.size();
    ArrayList<Integer> first = new ArrayList<>();
    ArrayList<Integer> second = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      System.out.println("i-->"+i);
      if (i < (n - 2)) {
        first.add(list.get(i));
      }
      if (i > 0) {
        second.add(list.get(i));
      }
    }
    return Math.max(solveOS(first), solveOS(second));

  }

  public static void main(String[] args) {
    System.out.println(""+houseRobbery(Arrays.asList(1,2,3,4,5,6,7)));
  }

}
