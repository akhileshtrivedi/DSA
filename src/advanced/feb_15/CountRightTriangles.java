package advanced.feb_15;

// Java program for the above approach

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class CountRightTriangles {

  static int RightAngled(int a[][]) {
    int n = a.length;

    HashMap<Integer, Integer> xpoints = new HashMap<>();
    HashMap<Integer, Integer> ypoints = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (xpoints.containsKey(a[i][0])) {
        xpoints.put(a[i][0], xpoints.get(a[i][0]) + 1);
      } else {
        xpoints.put(a[i][0], 1);
      }
      if (ypoints.containsKey(a[i][1])) {
        ypoints.put(a[i][1], ypoints.get(a[i][1]) + 1);
      } else {
        ypoints.put(a[i][1], 1);
      }
    }

    // Store the total count of triangle
    int count = 0;

    // Iterate to check for total number
    // of possible triangle
    for (int i = 0; i < n; i++) {
      if (xpoints.get(a[i][0]) >= 1 && ypoints.get(a[i][1]) >= 1) {

        // Add the count of triangles
        // formed
        count += (xpoints.get(a[i][0]) - 1) * (ypoints.get(a[i][1]) - 1);
      }
    }

    // Total possible triangle
    return count;
  }

  private static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n = A.size();

    HashMap<Integer, Integer> xpoints = new HashMap<>();
    HashMap<Integer, Integer> ypoints = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (xpoints.containsKey(A.get(i))) {
        xpoints.put(A.get(i), xpoints.get(A.get(i)) + 1);
      } else {
        xpoints.put(A.get(i), 1);
      }
      if (ypoints.containsKey(B.get(i))) {
        ypoints.put(B.get(i), ypoints.get(B.get(i)) + 1);
      } else {
        ypoints.put(B.get(i), 1);
      }
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (xpoints.get(A.get(i)) >= 1 && ypoints.get(B.get(i)) >= 1) {
        count += (xpoints.get(A.get(i)) - 1) * (ypoints.get(B.get(i)) - 1);
      }
    }
    return count;
  }

  // Driver Code
  public static void main(String[] args) {

    // Given N points
    int arr[][] = {{1, 2}, {2, 1},
        {2, 2}, {2, 3},
        {3, 2}};

    // Function Call
    System.out.println(RightAngled(arr));

    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1, 1, 2)),
        new ArrayList<Integer>(Arrays.asList(1, 2, 1))));
    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3)),
        new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 1))));
  }
}

