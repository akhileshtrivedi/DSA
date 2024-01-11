package advanced.feb_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class SortedArray {

  static void sortAccording(int[] A1, int[] A2, int m,
      int n) {

    HashMap<Integer, Integer> index = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (!index.containsKey(A2[i])) {
        index.put(A2[i], i + 1);
      }
    }

    int[] tmp
        = Arrays.stream(A1)
        .boxed()
        .sorted((p1, p2) -> {
          int idx1 = index.getOrDefault(p1, 0);
          int idx2 = index.getOrDefault(p2, 0);

          if (idx1 == 0 && idx2 == 0) {
            return p1 - p2;
          }

          if (idx1 == 0) {
            return 1;
          }

          if (idx2 == 0) {
            return -1;
          }

          return idx1 - idx2;
        })
        .mapToInt(i -> i)
        .toArray();

    for (int i = 0; i < m; i++) {
      A1[i] = tmp[i];
    }
  }

  private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    ArrayList<Integer> result = new ArrayList<>();
    int m = A.size();
    int n = B.size();
    int[] A1 = A.stream().mapToInt(i -> i).toArray();
    int[] A2 = B.stream().mapToInt(i -> i).toArray();
    HashMap<Integer, Integer> index = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (!index.containsKey(A2[i])) {
        index.put(A2[i], i + 1);
      }
    }

    int[] tmp
        = Arrays.stream(A1)
        .boxed()
        .sorted((p1, p2) -> {
          int idx1 = index.getOrDefault(p1, 0);
          int idx2 = index.getOrDefault(p2, 0);

          if (idx1 == 0 && idx2 == 0) {
            return p1 - p2;
          }

          if (idx1 == 0) {
            return 1;
          }

          if (idx2 == 0) {
            return -1;
          }

          return idx1 - idx2;
        })
        .mapToInt(i -> i)
        .toArray();

    for (int i = 0; i < m; i++) {
      A1[i] = tmp[i];
      result.add(tmp[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int A1[] = {1, 2, 3, 4, 5};
    int A2[] = {5, 4, 2};
    int m = A1.length;
    int n = A2.length;
    //  sortAccording(A1, A2, m, n);
    //  System.out.println("Sorted array is ");
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 4, 2));
    System.out.println("Sorted array is " + solve(A, B));
    // System.out.println(Arrays.toString(A1));
  }
}

