package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementSortedArray {
  private static int search(int[] arr, int low, int high, int ans)
  {
    if (low >= high) {
      ans=arr[low];
      return ans;
    }

    int mid = (low + high) / 2;

    if (mid % 2 == 0) {
      if (arr[mid] == arr[mid + 1])
     ans  = search(arr, mid + 2, high, ans);
      else
        ans  =  search(arr, low, mid, ans);
    }

    else if (mid % 2 == 1) {
      if (arr[mid] == arr[mid - 1])
        ans  = search(arr, mid + 1, high, ans);
      else
        ans  =  search(arr, low, mid - 1, ans );
    }
    return ans;
  }

  private static int solve(ArrayList<Integer> A) {
    int [] arr = A.stream().mapToInt(i->i).toArray();
int ans = 0;
    return  search(arr, 0, arr.length - 1, ans);
  }
  public static void main(String[] args) {
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 1, 7))));
  }

}
