package advanced.jan_18;

public class DivisorGame {
  static int gcd(int b,int c){
    if(c==0)
      return b;
    return gcd(c, b%c);
  }
  static int solve(int A, int B, int C) {

    int lcm=(B*C)/gcd(B,C);
    return A/lcm;
  }

  public static void main(String[] args) {
    System.out.println(solve(12,3,2));
    System.out.println(solve(6,1,4));
  }
}
