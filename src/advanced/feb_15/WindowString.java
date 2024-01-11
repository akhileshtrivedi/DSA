package advanced.feb_15;


import java.util.Arrays;
import java.util.HashMap;

public class WindowString {


  private static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int[] s1map = new int[26];
    int[] s2map = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1map[s1.charAt(i) - 'a']++;
      s2map[s2.charAt(i) - 'a']++;
    }
    System.out.println("" + Arrays.toString(s1map));
    System.out.println("" + Arrays.toString(s2map));
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (s1map[i] == s2map[i]) {
        count++;
      }
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
      int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
      if (count == 26) {
        return true;
      }
      s2map[r]++;
      if (s2map[r] == s1map[r]) {
        count++;
      } else if (s2map[r] == s1map[r] + 1) {
        count--;
      }
      s2map[l]--;
      if (s2map[l] == s1map[l]) {
        count++;
      } else if (s2map[l] == s1map[l] - 1) {
        count--;
      }
    }
    return count == 26;
  }

  private static boolean checkInclusion1(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    HashMap<Character, Integer> s1map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);
    }

    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      HashMap<Character, Integer> s2map = new HashMap<>();
      for (int j = 0; j < s1.length(); j++) {
        s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
      }
      if (matches(s1map, s2map)) {
        return true;
      }
    }
    return false;
  }

  private static boolean matches(HashMap<Character, Integer> s1map,
      HashMap<Character, Integer> s2map) {
    for (char key : s1map.keySet()) {
      if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0) {
        return false;
      }
    }
    return true;
  }

  static final int MAX = 256;
  static boolean compare(char arr1[], char arr2[]) {
    for (int i = 0; i < MAX; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }

  // This function search for all permutations
  // of pat[] in txt[]
  static int search(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();
    int count=0;
    char[] countP = new char[MAX];
    char[] countTW = new char[MAX];

    for (int i = 0; i < M; i++) {
      (countP[pat.charAt(i)])++;
      (countTW[txt.charAt(i)])++;
    }

    for (int i = M; i < N; i++) {

      if (compare(countP, countTW)) {
        count++;
      }
      (countTW[txt.charAt(i)])++;
      countTW[txt.charAt(i - M)]--;
    }

    if (compare(countP, countTW)) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    String S = "aca";
    String T = "acaa";
    // System.out.println(""+checkInclusion1(S, T));
    String txt = "BACDGABCDA";
    String pat = "ABCD";
    System.out.println("search-->"+ search(S, T));
  }

}



