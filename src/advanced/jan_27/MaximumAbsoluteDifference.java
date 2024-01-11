package advanced.jan_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumAbsoluteDifference {



  static int sumOfMinAbsDifferences(
      int arr[] ,int n)
  {
    Arrays.sort(arr);
      int currentMin=0, preMin=0;

    for (int i = 1; i < n - 1; i++) {
      currentMin =
          Math.min(Math.abs(arr[i] - arr[i - 1]),
              Math.abs(arr[i] - arr[i + 1]));
      if(currentMin<preMin || i==1){
        preMin=currentMin;
      }

    }
    return preMin;
  }
  private static int solve(ArrayList<Integer> A) {
    Collections.sort(A);
    int currentMin=0, preMin=0;

    for (int i = 1; i < A.size() - 1; i++) {
      currentMin =
          Math.min(Math.abs(A.get(i) - A.get(i-1)),
              Math.abs(A.get(i) - A.get(i+1)));
      if(currentMin<preMin || i==1){
        preMin=currentMin;
      }

    }
    return preMin;
  }
  public static void main(String[] args) {
    int arr[] = {5, 10, 1, 4, 8, 7};
    int n = arr.length;

  //  System.out.println( "Sum = "
    //    + sumOfMinAbsDifferences(arr, n));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(5, 17, 100, 11))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1,2,3,4,5))));
  }
}
