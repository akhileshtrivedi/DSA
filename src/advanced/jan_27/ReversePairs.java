package advanced.jan_27;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePairs {
  private static int solve(ArrayList<Integer> A) {
    int[] nums = A.stream().mapToInt(i -> i).toArray();
    int res = mergesort(nums, 0, nums.length - 1);
    return res;
  }
  private static  int mergesort(int[] nums, int start, int end) {
    if (start >= end) {
      return 0;
    }
    int mid = (end - start) / 2 + start;
    int res = mergesort(nums, start, mid) + mergesort(nums, mid + 1, end);
    for (int i = start, j = mid + 1; i <= mid; i ++) {
      while (j <= end && (double)nums[i] / 2.0 > nums[j]) {
        j ++;
      }
      res += j - mid - 1;
    }
    merge(nums, start, mid, mid + 1, end);
    return res;
  }
  private static  void merge(int[] nums, int s1, int e1, int s2, int e2) {
    int[] result = new int[e2 - s1 + 1];
    int i = s1, j = s2, k = 0;
    while (i <= e1 || j <= e2) {
      int a = Integer.MAX_VALUE;
      int b = Integer.MAX_VALUE;
      if (i <= e1) {
        a = nums[i];
      }
      if (j <= e2) {
        b = nums[j];
      }
      if (a < b) {
        result[k++] = a;
        i ++;
      }
      else if (a > b){
        result[k++] = b;
        j ++;
      }
      else {
        if (j == e2 + 1) {
          result[k++] = a;
          i ++;
        }
        else {
          result[k++] = b;
          j ++;
        }
      }
    }
    for (k = 0; k < result.length; k ++) {
      nums[s1 + k] = result[k];
    }
  }

  /*private static int solve(ArrayList<Integer> A) {
    int count=0;
    for(int i=0;i<A.size();i++){
      for(int j=i+1;j<A.size();j++){
          if(A.get(i)>2*(A.get(j))){
            count++;
          }
      }
    }

    return count;
  }*/

  public static void main(String[] args) {
  //  int [] num={ 2000000000, 2000000000, -2000000000};
 //   System.out.println(""+reversePairs(num));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 3, 2, 3, 1))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(4,1,2))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList( 2000000000, 2000000000, -2000000000))));
  }

}
