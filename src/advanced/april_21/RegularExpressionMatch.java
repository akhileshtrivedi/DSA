package advanced.april_21;

import java.util.Arrays;

class RegularExpressionMatch {

  public static int strmatch(String ss, String pp) {
    char[] s=ss.toCharArray();
    char[] p=pp.toCharArray();
    int pat = pp.length();
    int str = ss.length();

    int i = 0, j = 0;
    int iIndex = -1, jIndex = -1;

    while(i < str){
      if(s[i] == p[j] || (j < pat && p[j] == '?')){
        i++;
        j++;
      }
      else if(p[j] == '*' && j < pat){
        jIndex = j;
        iIndex = i;
        j++;
      }
      else if(jIndex != -1){
        j = jIndex + 1;
        i = iIndex + 1;
        iIndex++;
      }
      else{
        return 0;
      }

    }

    while(j < pat && p[j] == '*'){
      j++;
    }

    if(j == pat){
      return 1;
    }

    return 0;
   /* int m = S.length();
    int n = R.length();
    if(S.length()==1 && R=="?"){
      return 1;
    }
    boolean[][] dp = new boolean[m+1][n+1];
    dp[0][0] = true;
    for(int i = 1; i<=m; i++)
    {
      for(int j = 1; j<=n; j++)
      {
        if(S.charAt(i-1) == R.charAt(j-1))
        {
          dp[i][j] = dp[i-1][j-1];
        }
        else if(R.charAt(j-1) =='.')
        {
          dp[i][j] = dp[i-1][j-1];
        }
        else if(R.charAt(j-1) == '*')
        {
          dp[i][j] = dp[i-1][j] || dp[i][j-1];

        }
      }
    }

    return dp[m][n]?1:0;*/
   /* boolean[] prev = new boolean[str.length() + 1];
    boolean[] curr = new boolean[str.length() + 1];

    prev[0] = true;

    for (int i = 1; i <= pattern.length(); i++) {
      boolean flag = true;
      for (int ii = 1; ii < i; ii++) {
        if (pattern.charAt(ii - 1) != '*') {
          flag = false;
          break;
        }
      }
      curr[0] = flag;
      for (int j = 1; j <= str.length(); j++) {

        if (pattern.charAt(i - 1) == '*')
          curr[j] = curr[j - 1] || prev[j];

        else if (pattern.charAt(i - 1) == '?'
            || str.charAt(j - 1) == pattern.charAt(i - 1))
          curr[j] = prev[j - 1];

        else
          curr[j] = false;
      }
      prev = Arrays.copyOf(curr, curr.length);
    }

    return prev[str.length()]?1:0;*/
  }

  public static void main(String[] args) {
    String str = "baaabab";
    String pattern = "*****ba*****ab";
    // char pattern[] = "ba*****ab";
    // char pattern[] = "ba*ab";
    // char pattern[] = "a*ab";
    // char pattern[] = "a*****ab";
    // char pattern[] = "*a*****ab";
    // char pattern[] = "ba*ab****";
    // char pattern[] = "****";
    // char pattern[] = "*";
    // char pattern[] = "aa?ab";
    // char pattern[] = "b*b";
    // char pattern[] = "a*a";
    // char pattern[] = "baaabab";
    // char pattern[] = "?baaabab";
    // char pattern[] = "*baaaba*";

      //System.out.println("Yes"+strmatch(str, pattern));
      System.out.println("    "+strmatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "*"));
     // System.out.println("    "+strmatch("aaa", "a*"));
     // System.out.println("Yes"+strmatch("acz", "a?a"));
     // System.out.println("Yes"+strmatch("bcaccbabaa", "bb*c?c*?"));

  }
}
// This code is contributed by divyansh2212
