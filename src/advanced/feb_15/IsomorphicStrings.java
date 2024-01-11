package advanced.feb_15;


import java.util.*;

class IsomorphicStrings {

  static boolean areIsomorphic(String A, String B)
  {
    if(A.length()!=B.length()){
      return false;
    }
    HashMap<Character, Character> charCount
        = new HashMap();
    char c = 'a';
    for (int i = 0; i < A.length(); i++) {
      if (charCount.containsKey(A.charAt(i))) {
        c = charCount.get(A.charAt(i));
        if (c != B.charAt(i))
          return false;
      }
      else if (!charCount.containsValue(
          B.charAt(i))) {
        charCount.put(A.charAt(i),
            B.charAt(i));
      }
      else {
        return false;
      }
    }
    return true;
  }

  /* Driver code*/
  public static void main(String[] args)
  {

    String str1 = "aac";
    String str2 = "xxy";

    // Function Call
    if (str1.length() == str2.length()
        && areIsomorphic(str1, str2))
      System.out.println("True");
    else
      System.out.println("False");
  }
}

// This code is contributed by phasing17
