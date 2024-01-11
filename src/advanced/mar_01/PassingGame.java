package advanced.mar_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PassingGame {

  private static int solve(int A, int B, ArrayList<Integer> C) {
    Stack<Integer> st = new Stack<>();
    st.push(B);
    for (int i = 0; i < C.size(); i++) {
      if (C.get(i) == 0) {
        st.pop();
      } else {
        st.push(C.get(i));
      }
    }
    return st.peek();
  }

  public static void main(String[] args) {
int A=10;
int B=23;
ArrayList<Integer> list= new ArrayList<>(Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0));
    System.out.println(" "+solve(A, B, list));
  }

}
