package advanced.jan_23;

public class SortedPermutationRank {
  private static  int mod =1000003;

  private static int fact(int n)
  {
    if(n==0) return 1 ; else return (n*fact(n-1)) %mod;
  }
  private static int findRank(String A) {
    String s = A;

    int ans = 0;
    int n = s.length();
    for (int i = 0; i < n - 1; i++) {
      int c = 0;
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(j) < s.charAt(i))
          c++;
      }
      ans += ((c * fact(n - i - 1))) % mod;

    }
    return (ans + 1) % mod;
  }

  public static void main(String[] args) {
    System.out.println(" I am here-->"+findRank("acb"));
    System.out.println(" I am here-->"+findRank("a"));

  }

}
