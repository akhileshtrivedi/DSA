package advanced.mar_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXandMIN {
  int[] updatedArr;
  public void findNextGreaterElement(int[] Next_greater_element, int n){
    Stack< Integer > s = new Stack < Integer > ();
    for (int i = 0; i < n; i++) Next_greater_element[i + 1] = n + 1;
    for (int i = 1; i <= n; i++) {
      if (s.empty()) {
        s.push(i);
      } else {
        while (!s.empty() && updatedArr[s.peek()] <= updatedArr[i]) {
          Next_greater_element[s.peek()] = i;
          s.pop();
        }
        s.push(i);
      }
    }
  }
  public void findPreviousGreaterElement(int[] Previous_greater_element, int n){
    Stack < Integer > s = new Stack < Integer > ();
    for (int i = n; i > 0; i--) {
      if (s.empty()) {
        s.push(i);
      } else {
        while (!s.empty() && updatedArr[i] > updatedArr[s.peek()]) {
          Previous_greater_element[s.peek()] = i;
          s.pop();
        }
        s.push(i);
      }
    }
  }
  public void findPreviousSmallerElement(int[] Previous_smaller_element, int n){
    Stack < Integer > s = new Stack < Integer > ();
    for (int i = n; i > 0; i--) {
      if (s.empty()) {
        s.push(i);
      } else {
        while (!s.empty() && updatedArr[i] <= updatedArr[s.peek()]) {
          Previous_smaller_element[s.peek()] = i;
          s.pop();
        }
        s.push(i);
      }
    }
  }
  public void findNextSmallerElement(int[] Next_smaller_element, int n){
    Stack < Integer > s = new Stack < Integer > ();
    for (int i = 0; i < n; i++) Next_smaller_element[i + 1] = n + 1;
    for (int i = 1; i <= n; i++) {
      if (s.empty()) {
        s.push(i);
      } else {
        while (!s.empty() && updatedArr[i] < updatedArr[s.peek()]) {
          Next_smaller_element[s.peek()] = i;
          s.pop();
        }
        s.push(i);
      }
    }
  }

  //public int solve(int[] A) {
  public int solve(ArrayList<Integer> AA) {
    int A[] = AA.stream().mapToInt(i->i).toArray();
    int n = A.length, mod = 1000 * 1000 * 1000 + 7;
    updatedArr = new int[n + 1];
    int Next_greater_element[] = new int[n + 1];
    int Previous_greater_element[] = new int[n + 1];
    int Previous_smaller_element[] = new int[n + 1];
    int Next_smaller_element[] = new int[n + 1];
    for (int i = 0; i < n; i++) {
      updatedArr[i + 1] = A[i];
    }
    System.out.println("a--->"+Arrays.toString(updatedArr));
    findNextGreaterElement(Next_greater_element, n);
    findPreviousGreaterElement(Previous_greater_element, n);
    findPreviousSmallerElement(Previous_smaller_element, n);
    findNextSmallerElement(Next_smaller_element, n);

    long ans = 0;
    for (int i = 1; i <= n; i++) {
      long right = Next_greater_element[i] - i;
      long left = i - Previous_greater_element[i];
      ans += (((left * right) % mod) * updatedArr[i]) % mod;
      ans %= mod;
      left = i - Previous_smaller_element[i];
      right = Next_smaller_element[i] - i;
      ans -= (((left * right) % mod) * updatedArr[i]) % mod;
      ans += mod;
      ans %= mod;
    }
    return (int) ans;
  }

  public static void main(String args[])
  {
   ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1));
   ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(4, 7, 3, 8));
    MAXandMIN mm = new MAXandMIN();
    System.out.println(""+mm.solve(arrayList));
    System.out.println(""+mm.solve(arrayList2));
  }
}


