package advanced.feb_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BClosestPointsToOrigin {

  static void pClosest(int[][] pts, int k) {
    int n = pts.length;
    int[] distance = new int[n];
    for (int i = 0; i < n; i++) {
      int x = pts[i][0], y = pts[i][1];
      distance[i] = (x * x) + (y * y);
    }

    Arrays.sort(distance);

    // Find the k-th distance
    int distk = distance[k - 1];

    // Print all distances which are
    // smaller than k-th distance
    for (int i = 0; i < n; i++) {
      int x = pts[i][0], y = pts[i][1];
      int dist = (x * x) + (y * y);

      if (dist <= distk) {
        System.out.println("[" + x + ", " + y + "]");
      }
    }
  }

  private static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int n = A.size();
    ArrayList<Integer> distance = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = A.get(i).get(0), y = A.get(i).get(1);
      distance.add((x * x) + (y * y));
    }
    Collections.sort(distance);

    int distk = distance.get(B - 1);

    for (int i = 0; i < n; i++) {
      int x = A.get(i).get(0), y = A.get(i).get(1);
      int dist = (x * x) + (y * y);
      ArrayList<Integer> pair = new ArrayList<>();
      if (dist <= distk) {
        pair.add(x);
        pair.add(y);
      }

      if (pair.size() > 0) {
        result.add(pair);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int points[][] = {{3, 3},
        {5, -1},
        {-2, 4}};

    int K = 2;

    // pClosest(points, K);
    ArrayList<ArrayList<Integer>> data = new ArrayList<>();
    ArrayList<Integer> f = new ArrayList<>();
    f.add(3);
    f.add(3);
    data.add(f);
    ArrayList<Integer> s = new ArrayList<>();
    s.add(5);
    s.add(-1);
    data.add(s);
    ArrayList<Integer> t = new ArrayList<>();
    t.add(-2);
    t.add(4);
    data.add(t);
    System.out.println(" data-->" + data);
    System.out.println("" + solve(data, 2));
  }
}
