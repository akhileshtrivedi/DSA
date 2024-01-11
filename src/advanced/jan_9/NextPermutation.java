package advanced.jan_9;

// Java program to implement
// the next_permutation method

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

  static void nextPermutation(int[] arr) {
    int n = arr.length, i, j;
    for (i = n - 2; i >= 0; i--) {
      if (arr[i] < arr[i + 1]) {
        break;
      }
    }

    if (i < 0) {
      reverse(arr, 0, arr.length - 1);
    } else {

      for (j = n - 1; j > i; j--) {
        if (arr[j] > arr[i]) {
          break;
        }
      }
      swap(arr, i, j);
      reverse(arr, i + 1, arr.length - 1);
    }
  }

  static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      swap(arr, start, end);
      start++;
      end--;
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  static void reverseA(ArrayList<Integer> A, int start, int end) {
    while (start < end) {
      swapA(A, start, end);
      start++;
      end--;
    }
  }

  static void swapA(ArrayList<Integer> A, int i, int j) {
    int temp = A.get(i);
    A.set(i, A.get(j));
    A.set(j, temp);
  }

  public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
    int n = A.size(), i, j;
    for (i = n - 2; i >= 0; i--) {
      if (A.get(i) < A.get(i+1)) {
        break;
      }
    }
    if (i < 0) {

     reverseA(A, 0, A.size() - 1);
    } else {

      for (j = n - 1; j > i; j--) {
        if (A.get(j) > A.get(i)) {
          break;
        }
      }
      swapA(A, i, j);
      reverseA(A, i + 1, A.size() - 1);
    }

    return A;
  }


  public static void main(String[] args) {

    // Given input array
    // int[] arr = new int[] { 1, 2, 3, 6, 5, 4 };
    int[] arr = new int[]{3, 2, 1};

    // Function call
   // nextPermutation(arr);
    System.out.println(""+nextPermutation(new ArrayList(Arrays.asList(1,2,3))));
    System.out.println(""+nextPermutation(new ArrayList(Arrays.asList(3,2,1))));

    // Printing the answer
//    for (int i : arr) {
//      System.out.print(i + " ");
//    }
  }
}
