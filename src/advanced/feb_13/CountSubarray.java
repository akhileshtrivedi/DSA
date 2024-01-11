package advanced.feb_13;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountSubarray {


  private static int solve(ArrayList<Integer> A) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int l = 0, r = 0, mod = 1000 * 1000 * 1000 + 7;
    long ans = 0;
    for (Integer x : A) {
      if (hm.get(x) != null) {
        while (hm.get(x) != 0) {
          hm.put(A.get(l), 0);
          l++;
        }
      }
      hm.put(x, 1);
      ans += r - l + 1;
      ans = ans % mod;
      r++;
    }

    return (int) ans;
  }

  static int solve2(ArrayList<Integer> A) {
    int[] arr = A.stream().mapToInt(i -> i).toArray();
    Arrays.sort(arr);
    int n = arr.length;
    HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>() {
      @Override
      public Integer get(Object key) {
        if (!containsKey(key)) {
          return 0;
        }
        return super.get(key);
      }
    };

    for (int i = 0; i < n; ++i) {
      vis.put(arr[i], 1);
    }
    int k = vis.size();

    vis.clear();
    int ans = 0, right = 0, window = 0;
    for (int left = 0; left < n; ++left) {
      while (right < n && window < k) {
        vis.put(arr[right], vis.get(arr[right]) + 1);

        if (vis.get(arr[right]) == 1) {
          ++window;
        }

        ++right;
      }

      if (window == k) {
        ans += (n - right + 1);
      }
      vis.put(arr[left], vis.get(arr[left]) - 1);
      if (vis.get(arr[left]) == 0) {
        --window;
      }
    }
    return ans;
  }

  public static int solve3(ArrayList<Integer> A) {
    int[] arr = A.stream().mapToInt(i -> i).toArray();
    int n = arr.length;
    Set<Integer> s = new HashSet<>();

    int j = 0, ans = 0;

    for (int i = 0; i < n; i++) {
      while (j < n && !s.contains(arr[j])) {
        s.add(arr[j]);
        j++;
      }

      ans += ((j - i) * (j - i + 1)) / 2;
      s.remove(arr[i]);
    }

    return ans - 1;
  }

  public static int getLength(int[] arr) {
    int n = arr.length;
    Set<Integer> SET = new HashSet<>();
    int j = 0, output = 0;
    for (int i = 0; i < n; i++) {
      while (j < n && !SET.contains(arr[j])) {
        SET.add(arr[j]);
        j++;
      }
      output += ((j - i) * (j - i + 1)) / 2;
      SET.remove(arr[i]);
    }

    return output - 1;
  }

  // Driver code


  public static void printSubarray(int[] A, int i, int j, int n) {
    if (i < 0 || i > j || j >= n) { // invalid input
      return;
    }

    for (int index = i; index < j; index++) {
      System.out.print(A[index] + ", ");
    }

    System.out.println(A[j]);
  }

  // Function to print all subarrays having distinct elements
  public static void calculate(int[] A) {
    int n = A.length;

    // create a map to mark elements as visited in the current window
    Map<Integer, Boolean> visited = new HashMap<>();

    // put all elements on a map
    for (int val : A) {
      visited.put(val, false);
    }

    // points to the left and right boundary of the current window,
    // i.e., the current window is formed by `A[left, right]`
    int right = 0, left = 0;

    // loop until the right index of the current window is less
    // than the maximum index
    while (right < n) {
      // keep increasing the window size if all elements in the
      // current window are distinct
      while (right < n && !visited.get(A[right])) {
        visited.put(A[right], true);
        right++;
      }

      printSubarray(A, left, right - 1, n);

      // As soon as a duplicate is found (`A[right]`),
      // terminate the above loop, and reduce the window's size
      // from its left to remove the duplicate

      while (right < n && visited.get(A[right])) {
        visited.put(A[left], false);
        left++;
      }
    }
  }

  static int arr[] = new int[]{1, 1, 3};

  static void printSubsequences(int n) {
    /* Number of subsequences is (2**n -1)*/
    int opsize = (int) Math.pow(2, n);

    /* Run from counter 000..1 to 111..1*/
    for (int counter = 1; counter < n; counter++) {
      for (int j = 0; j < n; j++) {
                /* Check if jth bit in the counter is set
                    If set then print jth element from arr[] */

        if (BigInteger.valueOf(counter).testBit(j)) {
          System.out.print(arr[j] + " ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 3};
    int n = arr.length;
    int[] arr2 = {2, 1, 2};
    System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1, 3))));
//    System.out.println(solve2(new ArrayList<>(Arrays.asList(1, 1,3))));
//    System.out.println(solve3(new ArrayList<>(Arrays.asList(1, 1,3))));
    System.out.println(solve(new ArrayList<>(Arrays.asList(2, 1, 2))));

    // System.out.println(getLength(arr));
    // System.out.println(getLength(arr2));
    // calculate(arr);
    //System.out.println(getLength(arr2));
    //System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1,3))));
    //System.out.println(solve(new ArrayList<>(Arrays.asList(2, 1, 2))));
    //System.out.println(countDistictSubarray(arr, n));
    //  System.out.println(solve3(new ArrayList<>(Arrays.asList( 93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63))));
  }
}
