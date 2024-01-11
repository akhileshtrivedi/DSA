package advanced.feb_01;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {
  private static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
    int start = -1;
    int end = -1;
    int i = 0;
    int n = A.size();
    ArrayList<Integer> arr = new ArrayList<>();

    while (i < n-1) {
      if (A.get(i) > A.get(i+1)) {
        start = i;
        end = n-1;

        while (end > start) {
          if (A.get(end) < A.get(end-1)) {
            while (end < n-1) {
              if (!A.get(end).equals(A.get(end + 1))) break;
              end++;
            }
            break;
          }
          end--;
        }
        break;
      }
      i++;
    }

    if (start == -1 && end == -1) {
      arr.add(-1);
      return arr;
    }

    int min = A.get(start);
    int max = A.get(end);
    int minIdx = start;

    while (minIdx <= end) {
      min = Math.min(min, A.get(minIdx));
      max = Math.max(max, A.get(minIdx));
      minIdx++;
    }

    for (i=0;i<start; i++) {
      if (A.get(i) > min) {
        start = i;
        break;
      }
    }

    for (i=n-1; i > end; i--) {
      if (A.get(i) < max) {
        end = i;
        break;
      }
    }

    arr.add(start);
    arr.add(end);
    return arr;
  }
  private static ArrayList<Integer> solve(ArrayList<Integer> A) {
    ArrayList<Integer> result = new ArrayList<>();
    int[] nums= A.stream().mapToInt(i->i).toArray();
    int[] snums = nums.clone();
    Arrays.sort(snums);
    int start = snums.length, end = 0;
    for (int i = 0; i < snums.length; i++) {
      if (snums[i] != nums[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    if(end>0) {
      result.add(start);
      result.add(end);
    }else {
      result.add(-1);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(""+subUnsort(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
  }
}
