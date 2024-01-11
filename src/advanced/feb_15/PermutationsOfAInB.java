package advanced.feb_15;

import java.util.HashSet;
import java.util.Set;

// Java program to search all anagrams
// of a pattern in a text
public class PermutationsOfAInB {

  private static Set<String> permutationFinder(String str) {
    Set<String> perm = new HashSet<String>();
    if (str == null) {
      return null;
    } else if (str.length() == 0) {
      perm.add("");
      return perm;
    }
    char initial = str.charAt(0); // first character
    String rem = str.substring(1); // Full string without first character
    Set<String> words = permutationFinder(rem);
    for (String strNew : words) {
      for (int i = 0; i <= strNew.length(); i++) {
        perm.add(charInsert(strNew, initial, i));
      }
    }
    return perm;
  }

  private static String charInsert(String str, char c, int j) {
    String begin = str.substring(0, j);
    String end = str.substring(j);
    return begin + c + end;
  }

  private static int solve(String A, String B) {
    Set set = permutationFinder(A);
    System.out.println("set-->"+set);
    int count = 0;
    for (Object str : set) {
      if (B.contains((CharSequence) str)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String args[]) {
    String A = "abc";
    String B = "abcbacabc";

    System.out.println(""+solve(A,B));
  }
}

