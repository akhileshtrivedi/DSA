package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayGivenSum {

  private static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    ArrayList<Integer> result = new ArrayList<>();
    int len = A.size();
    int currentSum = A.get(0), start = 0, i;
    for (i = 1; i <= len; i++) {

      while (currentSum > B && start < i - 1) {
        currentSum = currentSum - A.get(start);
        start++;
      }

      if (currentSum == B) {
        int p = i - 1;
        System.out.println("Sum found at index" + start + " And " + p);
        for(int k=start;k<=p;k++){
          result.add(A.get(k));
        }
        return result;
      }
      if (i < len) {
        currentSum = currentSum + A.get(i);
      }
    }
    result.add(-1);

    return result;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,};
    int sum = 14;
  //  subArraySum(arr, sum);
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 5));

  }

  private static int subArraySum(int[] arr, int sum) {
    int len = arr.length;
    int currentSum = arr[0], start = 0, i;
    for (i = 1; i <= len; i++) {

      while (currentSum > sum && start < i - 1) {
        currentSum = currentSum - arr[start];
        start++;
      }

      if (currentSum == sum) {
        int p = i - 1;
        System.out.println("Sum found at index" + start + " And " + p);
        return 1;
      }
      if (i < len) {
        currentSum = currentSum + arr[i];
      }
    }
    System.out.println("No array found ");
    return 0;
  }
}
