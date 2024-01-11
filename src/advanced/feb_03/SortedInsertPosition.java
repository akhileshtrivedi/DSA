package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {
  private static int searchInsert(ArrayList<Integer> A, int B) {
    int start = 0;
    int end = A.size() - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (A.get(mid) == B) {
        return mid;
      }
      else if (A.get(mid) < B) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return start;
  }
  public static void main(String[] args) {
    System.out.println(""+searchInsert(new ArrayList<>(Arrays.asList(1, 3, 5, 6)), 5) );
  }

}
