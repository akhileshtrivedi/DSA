package advanced.april_19;

import java.util.Arrays;

public class DistinctSubsequences {


    static final int MAX_CHAR = 256;

    // Returns count of distinct subsequences of str.
    static int countSub(String str)
    {
      // Create an array to store index
      // of last
      int[] last = new int[MAX_CHAR];
      Arrays.fill(last, -1);

      // Length of input string
      int n = str.length();

      // dp[i] is going to store count of distinct
      // subsequences of length i.
      int[] dp = new int[n + 1];

      // Empty substring has only one subsequence
      dp[0] = 1;

      // Traverse through all lengths from 1 to n.
      for (int i = 1; i <= n; i++) {
        // Number of subsequences with substring
        // str[0..i-1]
        dp[i] = 2 * dp[i - 1];

        // If current character has appeared
        // before, then remove all subsequences
        // ending with previous occurrence.
        if (last[(int)str.charAt(i - 1)] != -1)
          dp[i] = dp[i] - dp[last[(int)str.charAt(i - 1)]];

        // Mark occurrence of current character
        last[(int)str.charAt(i - 1)] = (i - 1);
      }

      return dp[n];
    }
  static int prime =(int)(Math.pow(10,9)+7);

  static int subsequenceCounting(String s1, String s2) {
    int n=s1.length();
    int m=s2.length();
    int dp[][]=new int[n+1][m+1];

    for(int i=0;i<n+1;i++){
      dp[i][0]=1;
    }
    for(int i=1;i<m+1;i++){
      dp[0][i]=0;
    }

    for(int i=1;i<n+1;i++){
      for(int j=1;j<m+1;j++){

        if(s1.charAt(i-1)==s2.charAt(j-1))
          dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%prime;
        else
          dp[i][j] = dp[i-1][j];
      }
    }
    return dp[n][m];
  }
  // Driver code
    public static void main(String args[])
    {
      String s1 = "rabbbit";
      String s2 = "rabbit";

      System.out.println("The Count of Distinct Subsequences is "+
          subsequenceCounting(s1,s2));
    //  System.out.println(countSub("gfg"));
    }
  }
// This code is contributed by Sumit Ghosh

