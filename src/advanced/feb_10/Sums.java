package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sums {
  static int solution(ArrayList<Integer> arr, int x)
  {
    Collections.sort(arr);
    long closestSum = Integer.MAX_VALUE;
    for (int i = 0; i < arr.size() - 2; i++)
    {
      int ptr1 = i + 1, ptr2 = arr.size() - 1;
      while (ptr1 < ptr2)
      {
        int sum = arr.get(i) + arr.get(ptr1) + arr.get(ptr2);

        if (Math.abs(x - sum) < Math.abs(x - closestSum))
        {
          closestSum = sum;
        }
        if (sum > x)
        {
          ptr2--;
        }

        else
        {
          ptr1++;
        }
      }
    }
    return (int)closestSum;
  }

  // Driver code
  public static void main(String[] args)
  {      //-1, 2, 1, -4
    ArrayList arr = new ArrayList(Arrays.asList( 1, 2, 3 ));
    int x = 1;
    System.out.println(solution(arr, 6));
  }


}
