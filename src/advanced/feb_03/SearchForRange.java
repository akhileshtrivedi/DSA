package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {
  private static int first(int arr[], int low, int high,
      int x, int n)
  {
    if (high >= low) {
      int mid = low + (high - low) / 2;
      if ((mid == 0 || x > arr[mid - 1])
          && arr[mid] == x)
        return mid;
      else if (x > arr[mid])
        return first(arr, (mid + 1), high, x, n);
      else
        return first(arr, low, (mid - 1), x, n);
    }
    return -1;
  }

  private static int last(int arr[], int low, int high,
      int x, int n)
  {
    if (high >= low) {
      int mid = low + (high - low) / 2;
      if ((mid == n - 1 || x < arr[mid + 1])
          && arr[mid] == x)
        return mid;
      else if (x < arr[mid])
        return last(arr, low, (mid - 1), x, n);
      else
        return last(arr, (mid + 1), high, x, n);
    }
    return -1;
  }
  private static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
    ArrayList<Integer> ans= new ArrayList<>();
    int [] arr = A.stream().mapToInt(i->i).toArray();
    int n=A.size();

    if(A.size()>1) {
       ans.add(  first(arr, 0, n - 1, B, n));
       ans.add(last(arr, 0, n - 1, B, n));
    }else{
      ans.add(0);
      ans.add(0);
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(""+searchRange(new ArrayList<>(Arrays.asList(5, 17, 100, 111)),1));
  }
}
