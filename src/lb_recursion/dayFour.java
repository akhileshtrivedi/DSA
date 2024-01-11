package lb_recursion;


class dayFour {

  /* Function to print reverse of the passed string */
  static String reverse(String str, String revrseStr) {
    if ((str == null) || (str.length() <= 1)) {
      return revrseStr + str.charAt(str.length() - 1);
    } else {
      revrseStr = revrseStr + str.charAt(str.length() - 1);
      return revrseStr = reverse(str.substring(0, str.length() - 1), revrseStr);
    }
  }

  static boolean isPalRec(String str, int s, int e) {
    if (s == e) {
      return true;
    }
    if ((str.charAt(s)) != (str.charAt(e))) {
      return false;
    }

    if (s < e + 1) {
      return isPalRec(str, s + 1, e - 1);
    }

    return true;
  }

  static boolean isPalindrome(String str) {
    int n = str.length();
    if (n == 0) {
      return true;
    }

    return isPalRec(str, 0, n - 1);
  }

  private static int power(int a, int b) {

    if (b == 0) {
      return 1;
    }
    if (b == 1) {
      return a;
    }
    int ans = power(a, b / 2);
    if (b % 2 == 0) {

      return ans * ans;
    } else {
      return a * ans * ans;
    }
  }

  /* Driver program to test above function */
  public static void main(String[] args) {
    //String str = "Akhilesh";
    // System.out.println(" " + reverse(str, ""));
    // reverse(str);
    System.out.println(""+power(2,10));
    String str = "geieg";

    if (isPalindrome(str)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}


