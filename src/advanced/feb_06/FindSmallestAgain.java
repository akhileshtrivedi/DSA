package advanced.feb_06;

// Java program to find a triplet using Hashing
import java.util.*;

class FindSmallestAgain {

  static boolean find3Numbers(int A[],
      int arr_size, int sum)
  {

    for (int i = 0; i < arr_size - 2; i++) {
      HashSet<Integer> s = new HashSet<>();
      int curr_sum = sum - A[i];
      for (int j = i + 1; j < arr_size; j++)
      {
        if (s.contains(curr_sum - A[j]))
        {
          System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + (curr_sum - A[j]));
          return true;
        }
        s.add(A[j]);
        System.out.println("   "+s);
      }
    }
    return false;
  }

  /* Driver code */
  public static void main(String[] args)
  {
    int A[] = {2, 4, 3, 2};
    int sum = 3;
    int arr_size = A.length;

    find3Numbers(A, arr_size, sum);
  }
}

