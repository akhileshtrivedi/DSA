package lb_recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class DayNine {
  private static void swap(int i, int j)
  {
    int temp = i;
    i = j;
    j = temp;
  }
  public static void main(String[] args) {
    System.out.println(""+permute(new ArrayList<Integer>(Arrays.asList(1,2,3))));
  }

  private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    int index=0;
    solve(nums,ans, index);
 return ans;
  }

  private static void solve(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans, int index) {
    if(index>=nums.size()) {
      ans.add(nums);
      return;
    }
      for(int j =index;j<nums.size();j++){
        swap(nums.get(index), nums.get(j));
        solve(nums,ans, index+1);
        swap(nums.get(index), nums.get(j));
    }

  }
}
