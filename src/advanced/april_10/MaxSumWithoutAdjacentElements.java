package advanced.april_10;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
  public static int findMaxSumSubsequence(int[] nums, int i, int n, int prev)
  {
    // base case: all elements are processed
    if (i == n) {
      return 0;
    }

    // recur by excluding the current element
    int excl = findMaxSumSubsequence(nums, i + 1, n, prev);

    int incl = 0;

    // include current element only if it's not adjacent to
    // the previous element
    if (prev + 1 != i) {
      incl = findMaxSumSubsequence(nums, i + 1, n, i) + nums[i];
    }

    // return maximum sum we get by including or excluding
    // current item
    return Integer.max(incl, excl);
  }
  public static int maxSum(int grid[][])
  {
    int n= grid[0].length;
    System.out.println("length--> "+n);
    int incl = Math.max(grid[0][0], grid[1][0]);
    int excl = 0, excl_new;
    for (int i = 1; i < n; i++ )
    {
      excl_new = Math.max(excl, incl);
      incl = excl + Math.max(grid[0][i], grid[1][i]);
      excl = excl_new;
    }
    return Math.max(excl, incl);
  }
  public static int adjacent(ArrayList<ArrayList<Integer>> A)
  {
    int n= A.get(0).size();
    System.out.println("length--> "+n);
    int incl = Math.max(A.get(0).get(0), A.get(1).get(0));
    int excl = 0, excl_new;
    for (int i = 1; i < n; i++ )
    {
      excl_new = Math.max(excl, incl);
      incl = excl + Math.max(A.get(0).get(i), A.get(1).get(i));
      excl = excl_new;
    }
    return Math.max(excl, incl);
  }
  public static void main(String[] args)
  {
    int grid[][] = {{ 1, 2, 3, 4, 5},
        { 6, 7, 8, 9, 10}};

    int n = 5;
    //System.out.println(maxSum(grid));
    ArrayList<ArrayList<Integer>> list= new ArrayList<>();
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
    list.add(new ArrayList<>(Arrays.asList(1, 3, 4,5)));
    System.out.println(adjacent(list));
   // int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
   // System.out.print("The maximum sum is "
     //   + findMaxSumSubsequence(nums, 0, nums.length, Integer.MIN_VALUE));
  }
}
