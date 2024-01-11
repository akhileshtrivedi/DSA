package advanced.jan_25;
// Java program to print all the combinations of balanced
// parenthesis.
import java.util.*;

class GenerateAllParentheses {
    static void generateParenthesis(int left, int right,
        String s,
        List<String> answer)
    {
      if (left == 0 && right == 0) {
        answer.add(s);
      }

      if (left > right || left < 0 || right < 0) {
        return;
      }

      s += "(";
      generateParenthesis(left - 1, right, s, answer);
      s = s.substring(0, s.length() - 1);

      s += ")";
      generateParenthesis(left, right - 1, s, answer);
      s = s.substring(0, s.length() - 1);
    }
  private static ArrayList<String> generateParenthesis(int A) {
    ArrayList<String> ans = new ArrayList<>();
    String s = "";
    generateParenthesis(A, A, s, ans);
    return ans;
  }
    public static void main(String[] args)
    {
      int n = 3;
      System.out.println(""+generateParenthesis(n));

      // vector ans is created to store all the possible
      // valid combinations of the parentheses.
    //  List<String> ans = new ArrayList<>();
     // String s = "";

      // initially we are passing the counts of open and
      // close as 0, and the string s as an empty string.
      //generateParenthesis(n, n, s, ans);

      // Now, here we print out all the combinations.
     // for (String k : ans) {
     //   System.out.println(k);
     // }
    }
  }



