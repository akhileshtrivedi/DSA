package advanced.jan_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber2 {

  private static int singleNumber(final List<Integer> A) {
    System.out.println(A);
    int ans = 0;
    for (int b = 0; b < 32; b++) {
      int cnt = 0;
      for (int i = 0; i < A.size(); i++) {
        if ((A.get(i) >> b & 1) == 1) {
          cnt++;
        }
      }
      if (cnt % 3 != 0) {
        ans = ans | (1 << b);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(
        "I did" + singleNumber(new ArrayList<>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1))));
    System.out.println("I did" + singleNumber(new ArrayList<>(Arrays.asList(0, 0, 0, 1))));
  }

}
