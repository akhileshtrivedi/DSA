package advanced.jan_6;

import java.util.*;
class LittlePonnyAnd2Subsequence
{
  static void smallestSubsequence(char []S, int K)
  {
    int N = S.length;
    Stack<Character> answer = new Stack<>();
    for (int i = 0; i < N; ++i) {
      if (answer.isEmpty()) {
        answer.add(S[i]);
      }
      else {
        while ((!answer.isEmpty())
            && (S[i] < answer.peek())
            && (answer.size() - 1 + N - i >= K)) {
          answer.pop();
        }
        if (answer.isEmpty() || answer.size() < K) {
          answer.add(S[i]);
        }
      }
    }
    String ret="";

    while (!answer.isEmpty()) {
      ret+=(answer.peek());
      answer.pop();
    }
    ret = reverse(ret);
    System.out.print(ret);
  }
  static String reverse(String input) {
    char[] a = input.toCharArray();
    int l, r = a.length - 1;
    for (l = 0; l < r; l++, r--) {
      char temp = a[l];
      a[l] = a[r];
      a[r] = temp;
    }
    return String.valueOf(a);
  }
  private static String solve(String A) {
    int K=2;
    char []S=A.toCharArray();
    int N = S.length;
    Stack<Character> answer = new Stack<>();
    for (int i = 0; i < N; ++i) {
      if (answer.isEmpty()) {
        answer.add(S[i]);
      }
      else {
        while ((!answer.isEmpty())
            && (S[i] < answer.peek())
            && (answer.size() - 1 + N - i >= K)) {
          answer.pop();
        }
        if (answer.isEmpty() || answer.size() < K) {
          answer.add(S[i]);
        }
      }
    }
    String ret="";

    while (!answer.isEmpty()) {
      ret+=(answer.peek());
      answer.pop();
    }
    ret = reverse(ret);
   return ret;
  }
  // Driver Code
  public static void main(String[] args)
  {
    String S = "aabdaabc";
    int K = 3;
   // smallestSubsequence("abcdsfhjagj".toCharArray(), 2);
    //smallestSubsequence("ksdjgha".toCharArray(), 2);

    System.out.println(""+solve("abcdsfhjagj"));
    System.out.println(""+solve("ksdjgha"));
  }
}

