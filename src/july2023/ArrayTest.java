package july2023;

import java.util.HashSet;
import java.util.Set;

class ArrayTest1 {

  int a = 0;
}

class ArrayTest2 extends ArrayTest1 {

  int a = 2;
}

public class ArrayTest extends ArrayTest1 {

  int a = 2;

  // Function Call
  static int maxSubArraySum(int a[]) {
    int size = a.length;
    int max_so_far = Integer.MIN_VALUE, max_ending_here
        = 0;

    for (int i = 0; i < size; i++) {
      max_ending_here = max_ending_here + a[i];
      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
      }
      if (max_ending_here < 0) {
        max_ending_here = 0;
      }
    }
    return max_so_far;
  }

  static void maxSubArraySum2(int a[]) {

    int size = a.length;
    int max_so_far = Integer.MIN_VALUE,
        max_ending_here = 0, start = 0, end = 0, s = 0;
    for (int i = 0; i < size; i++) {
      max_ending_here += a[i];
      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
        start = s;
        end = i;
      }
      if (max_ending_here < 0) {
        max_ending_here = 0;
        s = i + 1;
      }
    }
    System.out.println("Maximum contiguous sum is "
        + max_so_far);
    System.out.println("Starting index " + start);
    System.out.println("Ending index " + end);
  }

  static void trivedisAlgo(int a[]) {
    int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0, end = 0, start = 0, s = 0;
    for (int i = 0; i < a.length; i++) {
      maxEndingHere += a[i];
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
        start = s;
        end = i;
      }
      if (maxEndingHere < 0) {
        maxEndingHere = 0;
        s = i + 1;
      }
    }
    System.out.println("Maximum contiguous sum is "
        + maxSoFar);
    System.out.println("Starting index " + start);
    System.out.println("Ending index " + end);
  }

  static void smallestPositiveNumber(int a[]) {
    Set set = new HashSet<>();
    for (int i = 1; i < a.length + 1; i++) {
      set.add(i);

    }
    System.out.println(set);
    for (int i = 0; i < a.length; i++) {

      System.out.println();
    }
  }

  //Max sum of contiguous elements in Array
  public static void main(String[] args) {

    int arr[] = {3, 2, -1, 5};
    int size = arr.length;
    int supersum = 0;
    for (int i = 0; i < size; i++) {
      int sum = 0;
      for (int j = i; j < size; j++) {
        sum = sum + arr[j];


      }
      supersum = supersum + sum;


    }
    System.out.println("supersum--->"+supersum);
    System.out.println("I am here");
    int cores = Runtime.getRuntime().availableProcessors();
    System.out.println("cores-->" + cores);
    int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
    int[] arry = {-1, 2, 3, -4, 5, 6, 7, -8,};
    int n = arry.length;
    int ans = 0;
    for (int s = 0; s < arry.length; s++) {
      int sum = 0;
      for (int e = s; e < arry.length; e++) {
        sum += arry[e];
        ans = Math.max(ans, sum);
      }

    }
    int sum[] = new int[a.length];
    for (int i = 1; i < a.length; i++) {
      sum[i] = a[i] + Math.max(0, sum[i - 1]);
    }
    //System.out.println(Arrays.toString(sum));
    // System.out.println("ans-->"+ans);
    // System.out.println("maxSubArraySum-->"+maxSubArraySum(a));
    // maxSubArraySum2(a);
    // trivedisAlgo(a);
    smallestPositiveNumber(a);
  }


}
