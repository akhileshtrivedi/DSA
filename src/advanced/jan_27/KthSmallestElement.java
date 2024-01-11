package advanced.jan_27;


import java.util.ArrayList;
import java.util.Arrays;
    import java.util.Collections;
import java.util.List;

class KthSmallestElement {
  static int count(List<Integer> nums, int mid)
  {
    int cnt = 0;
    for (int i = 0; i < nums.size(); i++)
      if (nums.get(i) <= mid)
        cnt++;
    return cnt;
  }

  static int kthSmallest(int[] nums, int k)
  {
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      low = Math.min(low, nums[i]);
      high = Math.max(high, nums[i]);
    }
    while (low < high) {
      int mid = low + (high - low) / 2;
     // if (count(nums, mid) < k)
        low = mid + 1;
   //   else
        high = mid;
    }
    return low;
  }

       private static int kthsmallest(final List<Integer> A, int B)
  {
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    for (int i = 0; i < A.size(); i++) {
      low = Math.min(low, A.get(i));
      high = Math.max(high, A.get(i));
    }
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (count(A, mid) < B)
        low = mid + 1;
      else
        high = mid;
    }
    return low;
  }
  public static void main(String[] args)
  {
    int arr[] = { 1, 4, 5, 3, 19, 3 };
    int k = 3;

    // Function call
    System.out.print("Kth smallest element is "
        + kthsmallest(new ArrayList<>(Arrays.asList(3, 2,1 )), k));
  }
}

