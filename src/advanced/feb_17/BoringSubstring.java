package advanced.feb_17;

import java.util.Arrays;

class BoringSubstring {

    static boolean check(String s) {
      boolean ok = true;
      for (int i = 0; i + 1 < s.length(); ++i) {
        ok &= (Math.abs(s.charAt(i) -
            s.charAt(i + 1)) != 1);
      }
      return ok;
    }

  static int monotonousString(String s) {
    String odd = "", even = "";

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c % 2 == 0) {
        odd += c;
      } else {
        even += c;
      }
    }

    char oddArray[] = odd.toCharArray();
    Arrays.sort(oddArray);
    odd = new String(oddArray);

    char evenArray[] = even.toCharArray();
    Arrays.sort(evenArray);
    even = new String(evenArray);

    if (check(odd + even)) {
      return 1;
    } else if (check(even + odd)) {
      return 1;
    }
    return 0;
  }

  // Driver Code
  public static void main(String[] args) {
    String str = "abcd";
    String ans;
    System.out.println("" + monotonousString(str));
    System.out.println("" + monotonousString("aab"));
  }
}

