package advanced.jan_6;

// Java code for the above approach

import java.io.*;
import java.util.ArrayList;

class MinimumSwaps {

  // Function for finding the minimum number of swaps
  // required to bring all the numbers less
  // than or equal to k together.
  static int minSwap(int arr[],int k)
  {
    int n = arr.length;
    // Initially snowBallsize is 0
    int snowBallSize = 0;

    for (int i = 0; i < n; i++) {

      // Calculating the size of window required
      if (arr[i] <= k) {
        snowBallSize++;
      }
    }

    int swap = 0, ans_swaps = Integer.MAX_VALUE;

    for (int i = 0; i < snowBallSize; i++) {
      if (arr[i] > k)
        swap++;
    }

    ans_swaps = Math.min(ans_swaps, swap);

    for (int i = snowBallSize; i < n; i++) {

      // Checking in every window no. of swaps
      // required and storing its minimum
      if (arr[i - snowBallSize] <= k && arr[i] > k)
        swap++;
      else if (arr[i - snowBallSize] > k
          && arr[i] <= k)
        swap--;
      ans_swaps = Math.min(ans_swaps, swap);
    }
    return ans_swaps;
  }
  public int solve(ArrayList<Integer> A, int B) {
    int n = A.size();
    int snowBallSize = 0;

    for (int i = 0; i < n; i++) {
      if (A.get(i) <= B) {
        snowBallSize++;
      }
    }

    int swap = 0, ans_swaps = Integer.MAX_VALUE;

    for (int i = 0; i < snowBallSize; i++) {
      if (A.get(i) > B)
        swap++;
    }
    ans_swaps = Math.min(ans_swaps, swap);
    for (int i = snowBallSize; i < n; i++) {
      if (A.get(i - snowBallSize) <= B && A.get(i)> B)
        swap++;
      else if (A.get(i- snowBallSize) > B
          && A.get(i) <= B)
        swap--;
      ans_swaps = Math.min(ans_swaps, swap);
    }
    return ans_swaps;
  }
  public static void main(String[] args)
  {
    int arr1[] = { 1, 12, 10, 3, 14, 10, 5};
    int arr2[] = {5, 17, 100, 11};
    System.out.println(minSwap(arr1,  8));
    System.out.println(minSwap(arr2, 20));
  }
}

// This code is contributed by lokeshmvs21.
