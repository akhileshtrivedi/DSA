package advanced.april_19;

public class LetsParty {
private static int MOD = 10003;
  static int findWaysToPair(int p)
  {
    if(p==1){ return 1;}
    int dp[] = new int[p + 1];

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= p; i++)
    {
      dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
      dp[i] = dp[i]%MOD;
    }

    return dp[p];
  }

  // Driver code
  public static void main(String args[])
  {
    int p = 17;
    System.out.println(findWaysToPair(p));
  }
}

// This code is contributed by Arnab Kundu
