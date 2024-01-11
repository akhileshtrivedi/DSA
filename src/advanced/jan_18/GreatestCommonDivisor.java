package advanced.jan_18;

public class GreatestCommonDivisor {
  private static int gcd(int A, int B) {
    while(B!=0)
    {
      int r = A%B;
      A = B;
      B = r;
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println(gcd(4,6));
    System.out.println(gcd(6,7));
  }
}
