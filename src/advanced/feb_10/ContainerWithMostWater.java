package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
  private static int maxArea(ArrayList<Integer> height) {
    int res = 0;
    int left = 0;
    int right = height.size() - 1;
    while(left <= right){
      int temp = (right - left) * Math.min(height.get(left), height.get(right));
      res = Math.max(res, temp);
      if(height.get(left) <= height.get(right))
        left++;
      else
        right--;
    }
    return res;
  }
  public static void main(String[] args) {
    System.out.println(""+maxArea(new ArrayList<Integer>(Arrays.asList(1, 5, 4, 3))));
  }

}
