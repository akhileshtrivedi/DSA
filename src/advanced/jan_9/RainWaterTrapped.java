package advanced.jan_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
  private static int trap(final List<Integer> A) {
    int n = A.size();

    int left = 0;
    int right = n - 1;
    int l_max = 0;
    int r_max = 0;

    int result = 0;
    while (left <= right) {

      if (r_max <= l_max) {
        result += Math.max(0, r_max - A.get(right));
        r_max = Math.max(r_max, A.get(right));
        right -= 1;
      }
      else {
        result += Math.max(0, l_max - A.get(left));
        l_max = Math.max(l_max, A.get(left));
        left += 1;
      }
    }
    return result;
  }



  // Method for maximum amount of water
  static int findWater(int[] arr)
  {
    int n = arr.length;
    int left[] = new int[n];
    int right[] = new int[n];
    int water = 0;
    left[0] = arr[0];

    for (int i = 1; i < n; i++)
      left[i] = Math.max(left[i - 1], arr[i]);

    right[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--)
      right[i] = Math.max(right[i + 1], arr[i]);

    for (int i = 0; i < n; i++)
      water += Math.min(left[i], right[i]) - arr[i];

    return water;
  }



  static int maxWater(int[] arr)
  {
    int n = arr.length;
    int left = 0;
    int right = n - 1;
    int l_max = 0;
    int r_max = 0;

    int result = 0;
    while (left <= right) {

      if (r_max <= l_max) {
        result += Math.max(0, r_max - arr[right]);
        r_max = Math.max(r_max, arr[right]);
        right -= 1;
      }
      else {
        result += Math.max(0, l_max - arr[left]);
        l_max = Math.max(l_max, arr[left]);
        left += 1;
      }
    }
    return result;
  }

  // Driver method to test the above function
  public static void main(String[] args)
  {

     int arr[]
        = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
     int [] arr2= new int[]{0, 1, 0, 2};
     int [] arr3= new int[]{1, 2};
//    System.out.println(maxWater(arr));
//    System.out.println(maxWater(arr2));
//    System.out.println(maxWater(arr3));
   System.out.println(trap(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 2))));
   System.out.println(trap(new ArrayList<Integer>(Arrays.asList( 1, 2))));
  }
}
