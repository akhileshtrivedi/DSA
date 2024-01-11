package advanced.april_7;

import java.util.Arrays;
import java.util.List;

class WordBreak {

  static int wordBreak(String s,List<String> dict) {
    int n = s.length();
    String ans = "";
    ans=wordBreakUtil(n, s, dict, ans);
    return ans.length() > 1 ? 1 : 0;
  }

  static String wordBreakUtil(int n, String s, List<String> dict, String ans) {

    for (int i = 1; i <= n; i++) {
      String prefix = s.substring(0, i);
      System.out.println(" Here"+prefix.length());
     // if(dict.get(i-1).length()<=20) {
        if (dict.contains(prefix)) {
          if (i == n) {
            ans += prefix;
            return ans;
          }
          ans = wordBreakUtil(n - i, s.substring(i, n), dict, ans + prefix + " ");
        }
    //  }
    }
    return ans;
  }

  public static void main(String args[]) {
   /* String str1 = "iloveicecreamandmango";
    String str2 = "ilovesamsungmobile";
    int n1 = str1.length();
    int n2 = str2.length();

    // List of strings in dictionary
    List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
        "man", "mango", "icecream", "and",
        "go", "i", "love", "ice", "cream");
    System.out.println("First Test:");
    wordBreak(n1, dict, str1);
    System.out.println("\nSecond Test:");

    wordBreak(n2, dict, str2);*/

    List<String> dic2 = Arrays.asList("trainer", "my", "interview");
    System.out.println("\nSecond Test:");
    String str3 = "myinterviewtrainer";

    System.out.println(" " + wordBreak(str3, dic2));

    List<String> dic3 = Arrays.asList("aaa");
    System.out.println("\nSecond Test:");
    String str4 = "a";
    int n4 = str4.length();
    System.out.println(" " + wordBreak(str4,dic3));
  }
}

