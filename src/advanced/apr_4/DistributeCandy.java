package advanced.apr_4;

import java.util.ArrayList;
import java.util.Arrays;

class DistributeCandy {

  static int countCandies(int arr[]) {
    int n = arr.length;
    int sum = 0;
    int[] ans = new int[n];
    if (n == 1) {
      return 1;
    }
    for (int i = 0; i < n; i++) {
      ans[i] = 1;
    }
    for (int i = 0; i < n - 1; i++) {
      if (arr[i + 1] > arr[i]) {
        ans[i + 1] = ans[i] + 1;
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] > arr[i + 1] &&
          ans[i] <= ans[i + 1]) {
        ans[i] = ans[i + 1] + 1;
      }

      sum += ans[i];
    }

    sum += ans[n - 1];
    return sum;
  }

  static int candy(ArrayList<Integer> A) {
    int arr[] = A.stream().mapToInt(i -> i).toArray();
    return countCandies(arr);
  }

  // Driver Code
  public static void main(String[] args) {
    int arr[] = {1, 5, 2, 1};

    System.out.println(candy(new ArrayList<>(Arrays.asList(1, 5, 2, 1))));
  }
}

