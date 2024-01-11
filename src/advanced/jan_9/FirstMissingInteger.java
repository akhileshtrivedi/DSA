package advanced.jan_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class FirstMissingInteger {

  static int firstMissingPositiveOLD(int arr[]) {
    int n = arr.length;
    // Check if 1 is present in array or not
    for (int i = 0; i < n; i++) {

      // Loop to check boundary
      // condition and for swapping
      while (arr[i] >= 1 && arr[i] <= n
          && arr[i] != arr[arr[i] - 1]) {

        int temp = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = temp;
      }
    }

    // Finding which index has value less than n
    for (int i = 0; i < n; i++) {
      if (arr[i] != i + 1) {
        return (i + 1);
      }
    }

    // If array has values from 1 to n
    return (n + 1);
  }

  static int firstMissingPositiveJava(ArrayList<Integer> A) {
    int n = A.size();
    // Check if 1 is present in array or not
    System.out.println("Input data " + A);
    for (int i = 0; i < n; i++) {
      if (A.get(i) > 0 && A.get(i) <= n) {
        int pos = A.get(i) - 1;
        if (A.get(pos) != A.get(i)) {
          System.out.println(pos + "A.get(pos)" + A.get(pos));
          System.out.println(i + "A.get(i)" + A.get(i));
          Collections.swap(A, pos, i);
          i--;
        }
      }
    }
    System.out.println("Input processed data " + A);
    for (int i = 0; i < n; i++) {
      if (A.get(i) != i + 1) {
        return i + 1;
      }
    }

    return n + 1;
  }


  static int firstMissingPositive(ArrayList<Integer> A) {
    int n = A.size();
    // Check if 1 is present in array or not
    System.out.println("Input data " + A);
    for (int i = 0; i < n; i++) {
      if (A.get(i) <= 0) {
        A.set(i, n + 1);
      }
    }
    System.out.println("Input processed data " + A);
    for (int i = 0; i < n; i++) {
      if (Math.abs(A.get(i)) - 1 < n && A.get(Math.abs(A.get(i)) - 1) > 0) {
        A.set(Math.abs(A.get(i)) - 1, -Math.abs(A.get(i)) - 1);
      }
    }
    System.out.println("Input processed 2 data " + A);
    for (int i = 0; i < n; i++) {
      if (A.get(i) > 0) {
        return i + 1;
      }

    }
    return n + 1;
  }

  // Driver Code
  public static void main(String[] args) {
    //int arr[] = { 0, 10, 2, -10, -20 };
    int arr[] = {1, 2, 0};
    int arr2[] = {3, 4, -1, 1};
    int arr3[] = {-8, -7, -6};

//    int ans = firstMissingPositive(arr);
//    int ans2 = firstMissingPositive(arr2);
//    int ans3 = firstMissingPositive(arr3);
    // int ans = firstMissingPositive(new ArrayList<Integer>(Arrays.asList(1, 2, 0)));
    int ans2 = firstMissingPositive(new ArrayList<Integer>(Arrays.asList(3, 4, -1, 1)));
    // int ans3 = firstMissingPositive(new ArrayList<Integer>(Arrays.asList(-8, -7, -6 )));

    // System.out.println(ans);
    System.out.println(ans2);
    // System.out.println(ans3);
  }
}

// This code is contributed by mohit kumar 29.
