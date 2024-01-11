package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElement {
   private static int solveOLD(ArrayList<Integer> A) {
    int l=0, r=A.size(), m;
    while(l<=r){
      m=(l+r)/2;
      if(A.get(m)>A.get(m+1)){
        r=m;
      }else{
        l=m+1;
      }
      if(l==r)
        return A.get(l);
    }
   return A.get(l);
  }
  private static int solve(ArrayList<Integer> A) {
    int[] arr = A.stream().mapToInt(i -> i).toArray();
    int n = A.size();
    int l = 0;
    int r = n - 1;
    int mid = 0;

    while (l <= r) {
      mid = (l + r) >> 1;
      if ((mid == 0
          || arr[mid - 1] <= arr[mid])
          && (mid == n - 1
          || arr[mid + 1] <= arr[mid])) {
        break;
      }

      if (mid > 0 && arr[mid - 1] > arr[mid]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return A.get(mid);
  }
  public static void main(String[] args) {
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
  }

}
