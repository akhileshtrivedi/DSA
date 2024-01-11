package dp;

public class ClimbStairs {

  //public static int MOD = 1000000007;
  private static int MOD =1000000007;

 /* private int countDistinctWayToClimpStair() {

  }*/

  public static void main(String[] args) {
    System.out.println("" + solve(5,0));
  }

  private static int solve(long nStairs, int i) {
    //Base case
    if(i==nStairs){
      return 1;
    }
    if(i>nStairs){
      return 0;
    }
    return solve(nStairs,i+1)+solve(nStairs,i+2)%MOD;
  }
}
