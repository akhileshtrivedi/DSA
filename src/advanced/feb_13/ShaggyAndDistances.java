package advanced.feb_13;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class ShaggyAndDistances {

  static int minimumDistance(int[] a) {
    HashMap<Integer, Integer> hmap
        = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    int previousIndex = 0, currentIndex = 0;

    for (int i = 0; i < a.length; i++) {
      if (hmap.containsKey(a[i])) {
        currentIndex = i;

        previousIndex = hmap.get(a[i]);

        minDistance
            = Math.min(
            (currentIndex - previousIndex),
            minDistance);
      }
      hmap.put(a[i], i);
    }

    return (
        minDistance == Integer.MAX_VALUE
            ? -1
            : minDistance);
  }

  private static int solve(ArrayList<Integer> A) {
    HashMap<Integer, Integer> hmap
        = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    int previousIndex = 0, currentIndex = 0;

    for (int i = 0; i < A.size(); i++) {
      if (hmap.containsKey(A.get(i))) {
        currentIndex = i;

        previousIndex = hmap.get(A.get(i));

        minDistance
            = Math.min(
            (currentIndex - previousIndex),
            minDistance);
      }
      hmap.put(A.get(i), i);
    }

    return (
        minDistance == Integer.MAX_VALUE
            ? -1
            : minDistance);
  }


  public static void main(String args[]) {
    System.out.println(solve(new ArrayList<>(Arrays.asList(7, 1, 3, 4, 1, 7))));
    System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1))));
    // Test Case 1:
    int a1[] = {7, 1, 3, 4, 1, 7};
  //  System.out.println(minimumDistance(a1));

    // Test Case 2:
    int a2[] = {1, 1};
    //System.out.println(minimumDistance(a2));

    // Test Case 3:
    int a3[] = {1, 2, 1, 4, 1};
   //
    // System.out.println(minimumDistance(a3));
  }
}
