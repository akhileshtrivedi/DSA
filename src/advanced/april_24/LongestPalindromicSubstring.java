package advanced.april_24;

public class LongestPalindromicSubstring {

  public int solve(String A) {
    char[] s= A.toCharArray();

    if (s.length==0) {
      return 0;
    }
    if (s.length == 1) {
      return 1;
    }
    int min_start = 0, max_len = 1;
    for (int i = 0; i < s.length; ) {
      if (s.length - i <= max_len / 2) {
        break;
      }
      int j = i, k = i;
      while (k < s.length - 1 && s[k + 1] == s[k]) {
        ++k; // Skip duplicate characters.
      }
      i = k + 1;
      while (k < s.length - 1 && j > 0 && s[k + 1] == s[j - 1]) {
        ++k;
        --j;
      } // Expand.
      int new_len = k - j + 1;
      if (new_len > max_len) {
        min_start = j;
        max_len = new_len;
      }
    }
    return A.substring(min_start, max_len).length();
  }
}
