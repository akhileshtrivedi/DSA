package advanced.mar_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

class AllSubarrays {

  static int findMaxXOR(Vector<Long> arr) {
    int n = arr.size();
    Vector<Long> stack = new Vector<>();
    long res = 0, l = 0;
    int i;
    for (i = 0; i < n; i++) {
      while (!stack.isEmpty() &&
          stack.get(stack.size() - 1) < arr.get(i)) {
        stack.remove(stack.size() - 1);
        l--;
      }
      stack.add(arr.get(i));
      l++;
      if (l > 1) {
        res = Math.max(res,
            stack.get((int) (l - 1)) ^ stack.get((int) (l - 2)));
      }
    }
    return (int)res;
  }
  private static int findMaxXOR(ArrayList<Integer> A) {
    Vector<Long> arr = new Vector<>();
    for (int i=0;i<A.size();++i) {
      arr.add(A.get(i).longValue());
    }
    int n = arr.size();
    Vector<Long> stack = new Vector<>();
    long res = 0, l = 0;
    int i;
    for (i = 0; i < n; i++) {
      while (!stack.isEmpty() &&
          stack.get(stack.size() - 1) < arr.get(i)) {
        stack.remove(stack.size() - 1);
        l--;
      }
      stack.add(arr.get(i));
      l++;
      if (l > 1) {
        res = Math.max(res,
            stack.get((int) (l - 1)) ^ stack.get((int) (l - 2)));
      }
    }
    return (int)res;
  }
  private static int solve(ArrayList<Integer> A) {
    int res = findMaxXOR(A);
    Collections.reverse(A);
    int res2 = findMaxXOR(A);
    return Math.max(res, res2);
  }


  public static void main(String[] args) {
   // Integer[] temp = {9, 8, 3, 5, 7};
  //  Integer[] temp = {2, 3, 1, 4};
  /*  Long[] temp = {7569780L, 6509094L, 9066928L, 9978215L, 9990289L, 500953L, 5829073L, 2862108L, 2983492L, 8356802L};
    Long[] temp2 = {1L,3L};
    Vector<Long> arr = new Vector<>(Arrays.asList(temp));
    Vector<Long> arr2 = new Vector<>(Arrays.asList(temp2));
    int result1 = findMaxXOR(arr);
    int result2 = findMaxXOR(arr2);
    Collections.reverse(arr);
    Collections.reverse(arr2);
    int result11 = findMaxXOR(arr);
    int result22 = findMaxXOR(arr2);*/
   // System.out.print("First-->"+Math.max(result1, result11));
   // System.out.print("Second-->"+Math.max(result2, result22));
    Integer[] temps = {7569780, 6509094, 9066928, 9978215, 9990289, 500953, 5829073, 2862108, 2983492, 8356802};
    ArrayList<Integer> list= new ArrayList<Integer>(Arrays.asList(temps));
//    int res = solve(list);
//    Collections.reverse(list);
//    int res2 = solve(list);
    System.out.println(" Second-->"+solve(list));
   // System.out.println("Second-->"+Math.max(res, res2));
  }
}
