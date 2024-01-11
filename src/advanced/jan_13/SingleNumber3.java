package advanced.jan_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SingleNumber3 {

  private static ArrayList<Integer> solve(ArrayList<Integer> A) {
    int xor = 0;
    int n = A.size();
    for (int i = 0; i < n; i++) {
      xor = xor ^ A.get(i);
    }
    int b = 0;
    for (int i = 0; i <= 31; i++) {
      if (((xor >> i) & 1) == 1) {
        b = i;
        break;
      }
    }
    int ans = 0;
    int ans2 = 0;
    for (int i = 0; i < n; i++) {
      if (((A.get(i) >> b) & 1) == 1) {
        ans = ans ^ A.get(i);
      } else {
        ans2 = ans2 ^ A.get(i);
      }

    }
    ArrayList<Integer> result = new ArrayList<>();
    result.add(ans);
    result.add(ans2);
    Collections.sort(result);
    return result;
  }


  public static void main(String[] args) {
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 4))));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 2))));
  }
}
