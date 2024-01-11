package advanced.jan_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

  private static int maxSubArray(final List<Integer> A) {
    int size = A.size(), currentSum = Integer.MIN_VALUE, maxSum = A.get(0);
    // Kadane’s Algorithm
    for (int i = 0; i < size; i++) {
      currentSum = A.get(i) + Integer.max(currentSum, 0);
      maxSum = Integer.max(maxSum, currentSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println("" + maxSubArray(new ArrayList<>(Arrays.asList(-163, -20))));//  10
    // System.out.println(""+maxSubArray(new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10))));//  10
    //  System.out.println(""+maxSubArray(new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4))));//  6

  }

}
