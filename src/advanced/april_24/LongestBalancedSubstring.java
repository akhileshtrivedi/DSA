package advanced.april_24;

import java.util.Stack;

public class LongestBalancedSubstring {


  static int findMaxLen1(String s) {
    if (s.length() <= 1) {
      return 0;
    }

    // Initialize curMax to zero
    int curMax = 0;
    int[] longest = new int[s.length()];

    // Iterate over the String starting from second index
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0
          && s.charAt(i - longest[i - 1] - 1) == '(') {
        longest[i]
            = longest[i - 1] + 2
            + ((i - longest[i - 1] - 2 >= 0)
            ? longest[i - longest[i - 1] - 2]
            : 0);
        curMax = Math.max(longest[i], curMax);
      }
    }
    return curMax;
  }

  public static int findMaxLen(String str) {
    // base case
    if (str == null || str.length() == 1) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int len = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        stack.push(i);
      } else if (str.charAt(i) == '{') {
        stack.push(i);
      } else if (str.charAt(i) == '[') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.empty()) {
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

  static int maxbalancedprefix(String str) {
    int n = str.length();
    int sum = 0;
    int maxi = 0;

    // Traversing the string.
    for (int i = 0; i < n; i++) {

      // If open bracket add 1 to sum.
      if (str.charAt(i) == '[') {
        sum += 1;
      }else       if (str.charAt(i) == '{') {
        sum += 1;
      } else       if (str.charAt(i) == '(') {
        sum += 1;
      }

      // If closed bracket subtract 1
      // from sum
      else {
        sum -= 1;
      }

      // if first bracket is closing bracket
      // then this condition would help
      if (sum < 0) {
        break;
      }

      // If sum is 0, store the index
      // value.
      if (sum == 0) {
        maxi = i + 1;
      }
    }

    return maxi;
  }

  // Driver code
  public static void main(String[] args) {
    String str = "([[]]()}[";

    // Function call
    System.out.print(maxbalancedprefix(str) + "\n");

    // str = "[]]";

    // Function call
    //  System.out.print(findMaxLen(str) +"\n");

  }
}

// This code is contributed by aashish1995
