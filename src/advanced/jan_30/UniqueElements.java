package advanced.jan_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueElements {
  private static int solve(ArrayList<Integer> nums) {
    int moves = 0, taken = 0;
    Collections.sort(nums);
    for (int i = 1; i < nums.size(); ++i) {
      if (nums.get(i-1) == nums.get(i)) {
        taken++;
        moves -= nums.get(i);
      } else {
        int give = Math.min(taken, nums.get(i) - nums.get(i-1) - 1);
        moves += give * (give + 1) / 2 + give * nums.get(i-1);
        taken -= give;
      }
    }
    System.out.println(moves+"  "+taken);
    if (nums.size() > 0)
      moves += taken * (taken + 1) / 2 + taken * nums.get(nums.size() - 1);

    return moves;
  }
 /* private static int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);
    int moves = 0, taken = 0;

    for (int i = 1; i < nums.length; ++i) {
      if (nums[i - 1] == nums[i]) {
        taken++;
        moves -= nums[i];
      } else {
        int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
        moves += give * (give + 1) / 2 + give * nums[i - 1];
        taken -= give;
      }
    }

    if (nums.length > 0)
      moves += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];

    return moves;
  } */

  public static void main(String[] args) {
    int arr[]={2, 4, 5};
    int arr2[]={1, 1, 1};
    //System.out.println(""+solve(new ArrayList<>(Arrays.asList(2, 4, 5))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 1, 2,2,2))));

  }
}
