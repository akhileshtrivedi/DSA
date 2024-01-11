package advanced.jan_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {
  private static ArrayList<Integer> wave(ArrayList<Integer> A) {
    Collections.sort(A);
    for (int i = 0; i < A.size() - 1; i += 2) {
      int temp = A.get(i);
      A.set(i, A.get(i + 1));
      A.set(i + 1, temp);
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println(""+wave(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
    System.out.println(""+wave(new ArrayList<>(Arrays.asList(1, 2))));
  }
}
