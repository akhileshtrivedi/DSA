package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PairsWithGivenSumII {
  static int pairs_count(ArrayList<Integer> A, int B)
  {
    int ans = 0;
    int n=A.size();
    Collections.sort(A);
    int i = 0, j = n - 1;

    while (i < j)
    {
      if (A.get(i) + A.get(j) < B)
        i++;
      else if (A.get(i) + A.get(j) > B)
        j--;
      else
      {
        int x = A.get(i), xx = i;
        while ((i < j ) && (A.get(i) == x))
          i++;
        int y = A.get(j), yy = j;
        while ((j >= i )&& (A.get(j) == y))
          j--;

        if (x == y)
        {
          int temp = i - xx + yy - j - 1;
          ans += (temp * (temp + 1)) / 2;
        }
        else
          ans += (i - xx) * (yy - j);
      }
    }
    return ans;
  }

  // Driver code
  public static void main (String[] args)
  {
    int arr[] = { 1, 5, 7, 5, -1 };
    int n = arr.length;
    int sum = 6;

    System.out.println (pairs_count(new ArrayList<>(Arrays.asList( 1, 5, 7, 5, -1)), 6));
   // System.out.println (pairs_count(arr, n, sum));
  }
}
