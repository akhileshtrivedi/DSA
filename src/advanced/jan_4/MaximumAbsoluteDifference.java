package advanced.jan_4;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAbsoluteDifference {

    // Function to return maximum absolute
    // difference in linear time.
    private static int maxDistance(int[] array)
    {
      // max and min variables as described
      // in algorithm.
      int max1 = Integer.MIN_VALUE;
      int min1 = Integer.MAX_VALUE;
      int max2 = Integer.MIN_VALUE;
      int min2 = Integer.MAX_VALUE;

      for (int i = 0; i < array.length; i++)
      {

        // Updating max and min variables
        // as described in algorithm.
        max1 = Math.max(max1, array[i] + i);
        min1 = Math.min(min1, array[i] + i);
        max2 = Math.max(max2, array[i] - i);
        min2 = Math.min(min2, array[i] - i);
      }

      // Calculating maximum absolute difference.
      return Math.max(max1 - min1, max2 - min2);
    }

  private static int maxArr(ArrayList<Integer> A)
  {
    // max and min variables as described
    // in algorithm.
    int max1 = Integer.MAX_VALUE;
    int max2 = Integer.MAX_VALUE;
    int min1 = Integer.MIN_VALUE;
    int min2 = Integer.MIN_VALUE;
    for (int i = 0; i < A.size(); i++) {
      max1 = Math.max(max1, A.get(i) + i);
      min1 = Math.min(min1, A.get(i) + i);
      max2 = Math.max(max2, A.get(i) - i);
      min2 = Math.min(min2, A.get(i) - i);
    }
    return Math.max(max1 - min1, max2 - min2);
  /*  int max1 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int max2 = Integer.MIN_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int i = 0; i < A.size(); i++)
    {

      // Updating max and min variables
      // as described in algorithm.
      max1 = Math.max(max1, A.get(i) + i);
      min1 = Math.min(min1, A.get(i) + i);
      max2 = Math.max(max2, A.get(i) - i);
      min2 = Math.min(min2, A.get(i) - i);
    }

    // Calculating maximum absolute difference.
    return Math.max(max1 - min1, max2 - min2);*/
  }

    // Driver program to test above function
    public static void main(String[] args)
    {
      int[] array = { -70, -64, -6, -56, 64,
          61, -57, 16, 48, -98 };
      //System.out.println(maxDistance(array));
      System.out.println("maxArr--->"+maxArr(new ArrayList<>(Arrays.asList( 1, 3, -1))));
    }
  }


