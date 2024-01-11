package lb_recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class DateTen {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    ArrayList<Integer> r1 = new ArrayList<>();
    r1.add(1);
    r1.add(0);
    r1.add(0);
    r1.add(0);
    ArrayList<Integer> r2 = new ArrayList<>();
    r2.add(1);
    r2.add(1);
    r2.add(0);
    r2.add(1);
    ArrayList<Integer> r3 = new ArrayList<>();
    r3.add(1);
    r3.add(1);
    r3.add(0);
    r3.add(0);
    ArrayList<Integer> r4 = new ArrayList<>();
    r4.add(0);
    r4.add(1);
    r4.add(1);
    r4.add(1);
    input.add(r1);
    input.add(r2);
    input.add(r3);
    input.add(r4);
    System.out.println("" + findPath(input));
  }

  private static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> input) {
    int n = input.size();
    ArrayList<String> ans = new ArrayList<>();
    if (input.get(0).get(0) == 0) {
      return ans;
    }
    int srcx = 0;
    int srcy = 0;
    ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
    for (int i = 0; i < input.size(); i++) {
      visited.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
    }
    System.out.println(input);
    System.out.println(visited);
    String path = "";
    solve(input, n, ans, srcx, srcy, visited, path);
    return ans;
  }

  private static void solve(ArrayList<ArrayList<Integer>> input, int n, ArrayList<String> ans,
      int x, int y, ArrayList<ArrayList<Integer>> visited, String path) {
    // Now you have reached x,y here.
    //Base case
    if (x == n - 1 && y == n - 1) {
      System.out.println("here--?"+path);
      ans.add(path);
      return;
    }
    visited.get(x).set(y, 1);
// We have four choices here i.e. D,L,R,U
    //Down
    int newx = x + 1;
    int newy = y;
    if (isSafe(newx, newy, n, visited, input)) {
      path = path + 'D';
      solve(input, n, ans, newx, newy, visited, path);
      path = path.substring(0, path.length() - 1);
    }

    //Left
    newx = x;
    newy = y - 1;
    if (isSafe(newx, newy, n, visited, input)) {
      path = path + 'L';
      solve(input, n, ans, newx, newy, visited, path);
      path = path.substring(0, path.length() - 1);
    }
    //Right
    newx = x;
    newy = y + 1;
    if (isSafe(newx, newy, n, visited, input)) {
      path = path + 'R';
      solve(input, n, ans, newx, newy, visited, path);
      path = path.substring(0, path.length() - 1);
    }
    //UP
    newx = x - 1;
    newy = y;
    if (isSafe(newx, newy, n, visited, input)) {
      path = path + 'U';
      solve(input, n, ans, newx, newy, visited, path);
     // path = path.substring(0, path.length() - 1);
    }

    visited.get(x).set(y, 0);
  }












  private static boolean isSafe(int x, int y, int n, ArrayList<ArrayList<Integer>> visited,
      ArrayList<ArrayList<Integer>> input) {
    //System.out.println("isSafe called");
    return ((x >= 0 && x < n) && (y >= 0 && y < n) && visited.get(x).get(y) == 0
        && input.get(x).get(y) == 1);

  }
}
