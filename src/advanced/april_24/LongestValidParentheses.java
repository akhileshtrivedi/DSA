package advanced.april_24;

import java.util.Stack;

public class LongestValidParentheses {
  public static int findMaxLen(String str)
  {
    if (str == null) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int len = 0;
    for (int i = 0; i < str.length(); i++)
    {
      if (str.charAt(i) == '(') {
        stack.push(i);
      }
      else
      {
        stack.pop();
        if (stack.empty())
        {
          stack.push(i);
          continue;
        }
        int curr_len = i - stack.peek();
        if (len < curr_len) {
          len = curr_len;
        }
      }
    }
    return len;
  }

  public static void main(String[] args)
  {
    System.out.println(findMaxLen("((()()"));       // prints 4
    System.out.println(findMaxLen("(((()"));        // prints 2
    System.out.println(findMaxLen("(((("));         // prints 0
    System.out.println(findMaxLen("()()"));         // prints 4
    System.out.println(findMaxLen("(()())(()"));    // prints 6
  }
}
