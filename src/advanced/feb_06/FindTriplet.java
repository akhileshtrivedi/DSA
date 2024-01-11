package advanced.feb_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//public class FindTriplet {
//
//}
// Java program to find a triplet
class FindTriplet {

  // returns true if there is triplet with sum equal
  // to 'sum' present in A[]. Also, prints the triplet
  boolean find3Numbers(int A[], int arr_size, int sum)
  {
    int l, r;

    // Fix the first element as A[i]
    for (int i = 0; i < arr_size - 2; i++) {

      // Fix the second element as A[j]
      for (int j = i + 1; j < arr_size - 1; j++) {

        // Now look for the third number
        for (int k = j + 1; k < arr_size; k++) {
          if (A[i] + A[j] + A[k] == sum) {
            System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
            return true;
          }
        }
      }
    }

    // If we reach here, then no triplet was found
    return false;
  }
  public static void findAllTriplets(int[] A)
  {
    if (A.length < 3) {
      return;
    }

    // consider `A[j]` as the middle element of AP
    for (int j = 1; j < A.length - 1; j++)
    {
      // start with the left and right index of `j`
      int i = j - 1, k = j + 1;

      // Find all `i` and `k` such that `(i, j, k)` form an AP triplet
      while (i >= 0 && k < A.length)
      {
        // if `(A[i], A[j], A[k])` forms a triplet
        if (A[i] + A[k] == 2 * A[j])
        {
          // print the triplet
          System.out.println(A[i] + " " + A[j] + " " + A[k]);

          // Since the array is sorted and elements are distinct
          k++; i--;
        }
        // otherwise, if `(A[i] + A[k])` is less than `2×A[j]` then
        // try next `k`. Else, try the previous `i`.
        else if (A[i] + A[k] < 2 * A[j]) {
          k++;
        }
        else {
          i--;
        }
      }
    }
  }

  private static int solve(int[]arr, int B) {
    int sum=0;
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          sum=arr[i]+arr[j]+arr[k];
          System.out.println("{ "+i+", "+j+", "+k+" }");
          System.out.println("{ "+arr[i]+", "+arr[j]+", "+arr[k]+" } ==="+sum);
          result.add(sum);

          //if ((arr[i]== B || arr[j]== B || arr[k] == B) && (i<j && j<k)) {

          //  System.out.println(" final { "+arr[i]+", "+arr[j]+", "+arr[k]+" }");

         // }
        }
      }
    }
    Collections.sort(result);
    System.out.println(""+result);
    return result.get(B-1);
  }
  // Driver program to test above functions
  public static void main(String[] args)
  {
    FindTriplet triplet = new FindTriplet();
   // int A[] = { 1, 4, 45, 6, 10, 8 };
    //int sum = 22;
   // int arr_size = A.length;
    int A[] = {2, 4, 3, 2};
    int AA[] = {1, 5, 7, 3, 2};
    int AAA[] = {22, 10, 5, 11, 16, 2, 11, 7, 16, 2, 17, 6, 15, 3, 9, 6};
    int sum = 3;
    int arr_size = A.length;
    System.out.println(" "+solve(A,3));
    System.out.println(" "+solve(AA,9));
   // System.out.println(" "+solve(AAA,183));
  //  triplet.find3Numbers(A, arr_size, sum);
 //   findAllTriplets(A);
  }
}
